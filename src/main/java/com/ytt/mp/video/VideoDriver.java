package com.ytt.mp.video;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by ytt on 2018/12/22.
 */
public class VideoDriver implements Tool {

    private Configuration configuration;

    public void setConf(Configuration conf) {
        this.configuration = conf;
    }

    public Configuration getConf() {
        return this.configuration;
    }

    public int run(String[] args) throws Exception {
        configuration.set("inputPath", args[0]);
        configuration.set("outputPath", args[1]);

        // 1. 获取job 对象。
        Job job = Job.getInstance(configuration);
        job.setJarByClass(VideoDriver.class);

        job.setMapperClass(VideoMapper.class);

        // 没有 reduce 设置 reduce 个数是 0.
        job.setNumReduceTasks(0);
        job.setOutputValueClass(Text.class);
        job.setOutputKeyClass(NullWritable.class);

        //输入输出路径
        initInputFormat(job);
        initOutFormat(job);

        // 提交
        boolean b = job.waitForCompletion(true);
        return b == true ? 0 : 1;
    }

    private void initInputFormat(Job job) throws IOException, URISyntaxException {
        String inputS = configuration.get("inputPath");
        Path inPath = new Path(inputS);
        FileSystem fs = FileSystem.get(configuration);
        if (fs.exists(inPath)) {
            FileInputFormat.setInputPaths(job, inPath);
        } else {
            throw new RuntimeException(inputS + "不存在");
        }

    }

    private void initOutFormat(Job job) throws IOException {
        String outputStr = configuration.get("outputPath");
        Path outputPath = new Path(outputStr);
        FileSystem fs = FileSystem.get(configuration);
        if (fs.exists(outputPath)) {
            fs.delete(outputPath, true);
        }
        FileOutputFormat.setOutputPath(job, outputPath);
    }

    public static void main(String[] args) throws Exception {
        int run = ToolRunner.run(new VideoDriver(), args);
    }


}

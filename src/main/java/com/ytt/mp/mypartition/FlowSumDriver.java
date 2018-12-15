package com.ytt.mp.mypartition;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class FlowSumDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args= new String[]{"D:\\input\\partition","D:\\output\\partition"};
        Configuration conf =new Configuration();
        Job job = Job.getInstance(conf);


        //关联
        job.setJarByClass(FlowSumDriver.class);
        job.setMapperClass(FlowSumMap.class);
        job.setReducerClass(FlowSumReduce.class);

        //设置输入，输出类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        job.setPartitionerClass(MyPartitioner.class);
        job.setNumReduceTasks(5);

        job.setOutputValueClass(Text.class);
        job.setOutputKeyClass(FlowBean.class);


        // 输入路径,输出
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}

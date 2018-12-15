package com.ytt.mp.flowsumsort;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/11.
 */
public class MyDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args = new String[]{"D:\\input\\sort","D:\\output\\sort6"};
        Job job = Job.getInstance();

        job.setJarByClass(MyDriver.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReduce.class);

        TextInputFormat.setInputPaths(job,new Path(args[0]));

        job.setMapOutputKeyClass(FlowBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setPartitionerClass(MyPartition.class);
        job.setNumReduceTasks(5);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        job.waitForCompletion(true);
    }
}

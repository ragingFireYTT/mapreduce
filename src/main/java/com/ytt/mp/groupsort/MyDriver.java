package com.ytt.mp.groupsort;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 *
 * Created by ytt on 2018/12/12.
 */
public class MyDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args = new String[]{"D:\\input\\groupsort","D:\\output\\groupsort50"};

        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);

        job.setJarByClass(MyDriver.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReduce.class);

        FileInputFormat.setInputPaths(job,new Path(args[0]));
        job.setMapOutputKeyClass(OrderBean.class);
        job.setMapOutputValueClass(Text.class);

        job.setGroupingComparatorClass(GroupOrder.class);
        job.setOutputValueClass(Text.class);
        job.setOutputKeyClass(OrderBean.class);
        FileOutputFormat.setOutputPath(job,new Path(args[1]));


        job.waitForCompletion(true);

    }
}

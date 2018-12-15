package com.ytt.mp.friend;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.KeyValueLineRecordReader;
import org.apache.hadoop.mapreduce.lib.input.KeyValueTextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * Created by ytt on 2018/12/13.
 */
public class Driver {

    public static void main(String[] args) throws Exception {
        args = new String[]{"d:\\input\\friend2","d:\\output\\friend8"};

        Configuration conf = new Configuration();
        conf.set(KeyValueLineRecordReader.KEY_VALUE_SEPERATOR,":");
        Job job = Job.getInstance(conf);

        job.setJarByClass(Driver.class);
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReduce.class);

        job.setInputFormatClass(KeyValueTextInputFormat.class);
        KeyValueTextInputFormat.setInputPaths(job,new Path(args[0]));

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        FileOutputFormat.setOutputPath(job,new Path(args[1]));

        job.waitForCompletion(true);
    }

}

package com.ytt.mp.workcount;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineFileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/9.
 */
public class WordCountDriver2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        args = new String[]{"D:\\input\\wordcount","D:\\output\\wordcount"};
        //1.获取 job 对象。
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //2.设置 jar 路径。
        job.setJarByClass(WordCountDriver2.class);
        //3.关联 map 和 reduce。
        job.setMapperClass(WordCountMap.class);
        job.setReducerClass(WordCountReduce.class);

        //4.设置 map 阶段，输出数据类型。
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);
        //5.设置 最终 key value 类型。
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //设置切片 combineText
        job.setInputFormatClass(CombineTextInputFormat.class);
        CombineTextInputFormat.setMaxInputSplitSize(job,128*1024*1024);

        //6.设置输入，输出。
        FileInputFormat.setInputPaths(job,new Path(args[0]));
        FileOutputFormat.setOutputPath(job,new Path(args[1]));
        //7.提交 job。
        boolean b = job.waitForCompletion(true);
    }
}

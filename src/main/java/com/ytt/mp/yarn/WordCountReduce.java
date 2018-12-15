package com.ytt.mp.yarn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/9.
 */
public class WordCountReduce extends Reducer<Text,IntWritable,Text,IntWritable> {
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
            throws IOException, InterruptedException {
        //ss,1
        //ss,1
        int sum = 0;
        for (IntWritable value : values) {
            sum = sum +value.get();
        }
        context.write(key,new IntWritable(sum));
    }
}

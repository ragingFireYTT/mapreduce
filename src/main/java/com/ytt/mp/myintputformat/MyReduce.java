package com.ytt.mp.myintputformat;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class MyReduce extends Reducer<Text,BytesWritable,Text,BytesWritable> {
    @Override
    protected void reduce(Text key, Iterable<BytesWritable> values, Context context) throws IOException, InterruptedException {
        for (BytesWritable value : values) {
            context.write(key,value);
        }
    }
}

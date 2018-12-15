package com.ytt.mp.workcountkeyvalue;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class CountReduce extends Reducer<Text,LongWritable,Text,LongWritable> {
    @Override
    protected void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException, InterruptedException {

        long v = 0;
        for (LongWritable value : values) {
            v=v+value.get();
        }
        context.write(key,new LongWritable(v));
    }
}

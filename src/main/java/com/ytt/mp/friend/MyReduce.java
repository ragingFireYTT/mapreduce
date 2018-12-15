package com.ytt.mp.friend;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/13.
 */
public class MyReduce extends Reducer<Text,Text,Text,Text> {
    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        StringBuffer sb= new StringBuffer("");
        for (Text value : values) {
            sb.append(value+",");
        }
        context.write(key, new Text(sb.toString()));

    }
}

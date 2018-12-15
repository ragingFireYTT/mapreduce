package com.ytt.mp.friend;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/13.
 */
public class FriendMapper extends Mapper<Text,Text,Text,Text> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        String[] vs = value.toString().split(",");
        for (int i = 0; i < vs.length; i++) {
            context.write(new Text(vs[i]),key);
        }
    }
}

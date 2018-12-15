package com.ytt.mp.workcountkeyvalue;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class CountMapper extends Mapper<Text,Text,Text,LongWritable> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        //aa ----bb aa aa
        context.write(key,new LongWritable(1));
    }
}

package com.ytt.mp.workcountnline;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


/**
 * Created by ytt on 2018/12/10.
 */
public class CountMapper extends Mapper<LongWritable,Text,Text,LongWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String s = value.toString();
        String[] strings = s.split(" ");
        for (String string : strings) {
            Text k =new Text(string);
            LongWritable v = new LongWritable(1);
            context.write(k,v);
        }
    }
}

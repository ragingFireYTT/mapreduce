package com.ytt.mp.friend;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/13.
 */
public class MyMapper extends Mapper<Text,Text,Text,Text> {
    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {
        String[] vs = value.toString().split(",");
        for (String v : vs) {
            for (String s : vs) {
                if (v.toCharArray()[0] > s.toCharArray()[0]){
                    context.write(new Text(s+"-"+v),key);
                }else {
                    context.write(new Text(v+"-"+s),key);
                }

            }
        }
    }
}

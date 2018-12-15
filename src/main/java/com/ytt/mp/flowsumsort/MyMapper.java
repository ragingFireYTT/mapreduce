package com.ytt.mp.flowsumsort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/11.
 */
public class MyMapper extends Mapper<LongWritable,Text,FlowBean,Text> {
    private FlowBean k = new FlowBean();
    private Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("-----");
        String[] vals = value.toString().split("\t");
        long upFlow = Long.parseLong(vals[vals.length - 3]);
        long downFlow = Long.parseLong(vals[vals.length-2]);
        k.setAll(upFlow,downFlow);

        String telNum = vals[1];
        v.set(telNum);
        context.write(k,v);
    }
}

package com.ytt.mp.yarn;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/9.
 * 输入：key，偏移量
 * 输入value:
 *
 * keyout:(hadoop,1)
 *
 */
public class WordCountMap extends Mapper<LongWritable,Text,Text,IntWritable>{
    Text keyt = new Text();
    IntWritable v=new IntWritable(1);
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //ss ss
        String lineS = value.toString();
        String[] words = lineS.split(" ");
        for (String word : words) {
            keyt.set(word);
            context.write(keyt,v);
        }
    }
}

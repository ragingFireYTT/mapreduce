package com.ytt.mp.flowsum;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class FlowSumMap extends Mapper<LongWritable, Text, Text, FlowBean> {
    Text keyReturn = new Text();
    FlowBean valueReturn = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        //1	13736230513	192.196.100.1	www.atguigu.com	2481	24681	200
        //2	13846544121	192.196.100.2			264	0	200

        // 输入处理 1 行
        String valueS = value.toString();
        String[] valueSS = valueS.split("\t");


        // 构造写出

        keyReturn.set(valueSS[1]);
        valueReturn.setUpFlow(Long.parseLong(valueSS[valueSS.length-3]));
        valueReturn.setDownFlow(Long.parseLong(valueSS[valueSS.length-2]));

        //写出
        context.write(keyReturn,valueReturn);

    }
}

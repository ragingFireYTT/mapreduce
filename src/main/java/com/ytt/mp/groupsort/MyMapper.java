package com.ytt.mp.groupsort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/12.
 */
public class MyMapper extends Mapper<LongWritable, Text, OrderBean, Text> {
    OrderBean k = new OrderBean();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 订单号------商品号------价格
        // 0000001	Pdt_01	222.8
        String[] vs = value.toString().split("\t");

        long id = Long.parseLong(vs[0]);
        double price = Double.parseDouble(vs[2]);
        k.setAll(id, price);

        v.set(vs[1]);
        context.write(k, v);

    }
}

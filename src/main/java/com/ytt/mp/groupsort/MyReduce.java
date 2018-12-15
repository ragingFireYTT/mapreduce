package com.ytt.mp.groupsort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/12.
 */
public class MyReduce extends Reducer<OrderBean,Text,OrderBean,Text> {
    @Override
    protected void reduce(OrderBean key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        // 每 group 输出第一个
        //context.write(key,values.iterator().next());

        values.iterator().next();
        for (Text value : values) {
            System.out.println("--------------------------------------key"+key+"value"+value);
        }
    }
}

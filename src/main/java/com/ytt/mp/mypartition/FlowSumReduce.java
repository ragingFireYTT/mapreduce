package com.ytt.mp.mypartition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class FlowSumReduce extends Reducer<Text, FlowBean, Text, FlowBean> {
    FlowBean v= new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context)
            throws IOException, InterruptedException {
//        13568436656-----2481	24681	200
//        13568436656-----1116	954	200
        long sum =0 ;
        long sum_upFlow=0;
        long sum_downFlwo=0;
        for (FlowBean value : values) {
            sum_upFlow= sum_upFlow +value.getUpFlow();
            sum_downFlwo=sum_downFlwo+value.getDownFlow();
        }
        v.setUpFlow(sum_upFlow);
        v.setDownFlow(sum_downFlwo);
        v.setSumFlow(sum_upFlow+sum_downFlwo);

        // 写出
        context.write(key,v);
    }
}

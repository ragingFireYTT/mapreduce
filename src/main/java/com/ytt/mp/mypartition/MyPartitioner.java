package com.ytt.mp.mypartition;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by ytt on 2018/12/11.
 */
public class MyPartitioner extends Partitioner<Text,FlowBean> {
    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        String tel = text.toString();
        String p = tel.substring(0, 3);
        int parId= 4;
        if ("135".equals(p)) {
            parId=0;
        }else if ("136".equals(p)){
            parId=1;
        }else if ("137".equals(p)){
            parId=2;
        }else if ("138".equals(p)){
            parId=3;
        }
        return parId;
    }
}

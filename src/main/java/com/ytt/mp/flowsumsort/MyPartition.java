package com.ytt.mp.flowsumsort;

import com.sun.tools.javac.comp.Flow;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * Created by ytt on 2018/12/11.
 */
public class MyPartition extends Partitioner<FlowBean,Text> {
    @Override
    public int getPartition(FlowBean flowBean, Text text, int numPartitions) {

        String preNum = text.toString().substring(0, 3);
        int partition = 4;
        if ("136".equals(preNum)) {
            partition = 0;
        }else if ("137".equals(preNum)) {
            partition = 1;
        }else if ("138".equals(preNum)) {
            partition = 2;
        }else if ("139".equals(preNum)) {
            partition = 3;
        }

        return partition;
    }
}

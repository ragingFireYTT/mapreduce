package com.ytt.mp.flowsum;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by ytt on 2018/12/10.
 */
public class FlowBean implements Writable {
    private long upFlow;// 上行流量
    private long downFlow; // 下行流量
    private long sumFlow; // 总流量

    public FlowBean() {
        super();
    }

    public FlowBean(long upFlow, long downFlow) {
        super();
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = upFlow+downFlow;
    }

    // 序列化方法
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    // 反序列化方法
    @Override
    public void readFields(DataInput in) throws IOException {
        // 必须顺序和 write 方法一致。
        upFlow = in.readLong();
        downFlow = in.readLong();
        sumFlow = in.readLong();
    }


    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow(long sumFlow) {
        this.sumFlow = sumFlow;
    }
    @Override
    public String toString() {
        return   ":::::::::::"+upFlow +"\t"
                + downFlow  +"\t"
                + sumFlow ;
    }
}

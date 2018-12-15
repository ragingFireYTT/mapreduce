package com.ytt.mp.topn;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by ytt on 2018/12/13.
 */
public class Bean implements WritableComparable<Bean> {
    //13470253144	180	180	360
    private String telNum;
    private long upFlow;
    private long downFlow;
    private long sumFlow;

    public Bean(String telNum, long upFlow, long downFlow,long sumFlow) {
        this.telNum = telNum;
        this.upFlow = upFlow;
        this.downFlow = downFlow;
        this.sumFlow = sumFlow;
    }

    public Bean() {
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
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
        return  upFlow + "\t" + downFlow + "\t" +sumFlow;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(telNum);
        out.writeLong(upFlow);
        out.writeLong(downFlow);
        out.writeLong(sumFlow);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        this.telNum = in.readUTF();
        this.upFlow = in.readLong();
        this.downFlow = in.readLong();
        this.sumFlow = in.readLong();
    }

    @Override
    public int compareTo(Bean o) {
        if (this.sumFlow > o.sumFlow){
            return -1;
        }else if(this.sumFlow < o.sumFlow) {
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

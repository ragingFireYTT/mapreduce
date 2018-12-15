package com.ytt.mp.groupsort;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * Created by ytt on 2018/12/12.
 */
public class OrderBean implements WritableComparable<OrderBean> {
    private long id;
    private double price;

    @Override
    public int compareTo(OrderBean o) {
        // 根据 id 和 price 排序
        if (this.id > o.id) {
            return -1;
        } else if (this.id < o.id) {
            return 1;
        } else {

            if (this.price > o.price) {
                return -1;
            } else if (this.price < o.price) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    //序列化
    @Override
    public void write(DataOutput out) throws IOException {
        out.writeLong(id);
        out.writeDouble(price);
    }

    //反序列化
    @Override
    public void readFields(DataInput in) throws IOException {
        id = in.readLong();
        price = in.readDouble();
    }

    @Override
    public String toString() {
        return id + "\t" + price;
    }

    public void setAll(long id, double price) {
        this.id = id;
        this.price = price;
    }

    public OrderBean() {
    }

    public OrderBean(long id, double price) {
        this.id = id;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}

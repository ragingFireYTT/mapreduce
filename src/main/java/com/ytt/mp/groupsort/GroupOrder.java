package com.ytt.mp.groupsort;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

import java.io.DataInput;
import java.io.IOException;

/**
 * Created by ytt on 2018/12/12.
 */
public class GroupOrder extends WritableComparator {
    public GroupOrder() {
        super(OrderBean.class, true);
    }

//     GroupOrder() {
//        super(OrderBean.class, true);
//    }



    @Override
    public int compare (WritableComparable a, WritableComparable b) {
        OrderBean orderBeanA = (OrderBean) a;
        OrderBean orderBeanB = (OrderBean) b;

        if (orderBeanA.getId() == orderBeanB.getId()) {
            return 0;
        } else if (orderBeanA.getId() > orderBeanB.getId()) {
            return 1;
        } else {
            return -1;
        }
    }
}

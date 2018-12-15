package com.ytt.mp.topn;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by ytt on 2018/12/13.
 */
public class MyReduce extends Reducer<Text,Bean,Text,Bean> {
    TreeMap<Bean,Text> treeMap =new TreeMap<Bean,Text>();
    @Override
    protected void reduce(Text key, Iterable<Bean> values, Context context) throws IOException, InterruptedException {
        // key -----手机号 values----bean
        for (Bean value : values) {
            Bean b= new Bean(value.getTelNum(),value.getUpFlow(),value.getDownFlow(),value.getSumFlow());
            treeMap.put(b,key);
            if (treeMap.size()>10){
                treeMap.remove(treeMap.lastKey());
            }
        }
    }

    @Override
    protected void cleanup(Context context) throws IOException, InterruptedException {
        Iterator<Bean> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()) {
            Bean next = iterator.next();
            context.write(treeMap.get(next),next);
        }
        super.cleanup(context);
    }
}

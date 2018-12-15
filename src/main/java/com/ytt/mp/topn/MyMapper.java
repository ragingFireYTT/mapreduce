package com.ytt.mp.topn;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by ytt on 2018/12/13.
 */
public class MyMapper extends Mapper<LongWritable,Text,Text,Bean> {

    TreeMap<Bean,Text> treeMap;

    @Override
    protected void setup(Context context) throws IOException, InterruptedException {
        treeMap = new TreeMap<Bean,Text>();
    }

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {
        String[] vs = value.toString().split("\t");
        Bean bean =new Bean(vs[0].toString(),Long.parseLong(vs[1]),
                Long.parseLong(vs[2]),Long.parseLong(vs[3]));

        // treeMap 排序，保留10 个
        treeMap.put(bean,new Text(vs[0]));
        if (treeMap.size()>10) {
            treeMap.remove(treeMap.lastKey());
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

package com.ytt.mp.video;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


import java.io.IOException;

/**
 * Created by ytt on 2018/12/22.
 */
public class VideoMapper extends Mapper<LongWritable, Text, Text, NullWritable> {
    Text keyOut = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line = value.toString();
        String str = ETLUtil.strETL(line);
        if (StringUtils.isBlank(str)) {
            return;
        }
        keyOut.set(str);
        context.write(keyOut, NullWritable.get());
    }

}

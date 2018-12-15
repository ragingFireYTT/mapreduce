package com.ytt.mp.myoutputformat;

import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Created by ytt on 2018/12/12.
 */
public class MyOutPutFormat extends FileOutputFormat {
    @Override
    public RecordWriter getRecordWriter(TaskAttemptContext job) throws IOException, InterruptedException {
        MyRecordWriter myRecordWriter =new MyRecordWriter(job);
        return myRecordWriter;
    }
}

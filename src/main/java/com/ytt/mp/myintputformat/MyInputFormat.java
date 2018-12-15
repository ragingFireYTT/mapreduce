package com.ytt.mp.myintputformat;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import java.io.IOException;
import java.util.List;

/**
 * Created by ytt on 2018/12/10.
 */
public class MyInputFormat extends FileInputFormat {

    @Override
    protected boolean isSplitable(JobContext context, Path filename) {
        return false;
    }

    /**
     * 为 split 创建一个 recordReader
     * {@link RecordReader#initialize(InputSplit, TaskAttemptContext)} before
     * the split is used.
     * @param split the split to be read
     * @param context the information about the task
     * @return a new record reader
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public RecordReader createRecordReader(InputSplit split, TaskAttemptContext context) throws IOException, InterruptedException {
        MyRecordReader myRecordReader = new MyRecordReader();
        myRecordReader.initialize(split,context);
        return myRecordReader;
    }
}

package com.ytt.conf;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Map;

/**
 * 获取设置并且打印设置
 * Created by ytt on 2018/10/5.
 */
public class printConf extends Configured implements Tool{

    static {
        Configuration.addDefaultResource("hdfs-default.xml");
        Configuration.addDefaultResource("hdfs-site.xml");
        Configuration.addDefaultResource("yarn-default.xml");
        Configuration.addDefaultResource("yarn-site.xml");
        Configuration.addDefaultResource("mapred-default.xml");
        Configuration.addDefaultResource("mapred-site.xml");
    }

    public int run(String[] args) throws Exception {
        Configuration conf= getConf();
        for(Map.Entry<String,String> entry:conf){
            System.out.printf("%s=%s\n",entry.getKey(),entry.getKey());
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        int exitCode = ToolRunner.run(new printConf(),args);
        System.exit(exitCode);
    }
}

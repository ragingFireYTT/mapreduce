package com.ytt.conf;

import org.apache.hadoop.conf.Configuration;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by ytt on 2018/10/5.
 */
public class testConf {
    public static void main(String[] args){
        Configuration configuration=new Configuration();
        configuration.addResource("configuration-1.xml");
        configuration.addResource("configuration-2.xml");
        
        assertThat(configuration.get("color"),is("yellow"));
        System.out.println(configuration.get("color")); // 属性覆盖 final 的属性不会被覆盖
        System.out.println(configuration.get("name")); // 属性覆盖 final 的属性不会被覆盖

        System.setProperty("age","11");
        System.out.println(configuration.get("age")); //
    }
}

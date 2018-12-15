package com.ytt.mp;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by ytt on 2018/12/10.
 */
public class MyTest {


    /**
     * 生成测试文件
     *
     * @throws Exception
     */
    @Test
    public void createFile() throws Exception {
        String filePath = "d://3.txt";
        File file = new File(filePath);
        if (file.exists()) {
            //file.delete();
        } else {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(filePath, true);
        //20000000---18M
        for (int i = 0; i < 20000000; i++) {
            int v = (int) (Math.random() * 10);
            for (int i1 = 0; i1 < v; i1++) {
                fw.write(Util.getRand() + " ");
            }
            fw.write("\n");
        }

        fw.close();
    }

    /**
     * 分区计算测试
     * & 位与
     * % 取与
     *
     */
    @Test
    public void testYu(){
        for (int i = 0; i < 1000; i++) {
            System.out.println((i & Integer.MAX_VALUE) % 6);
        }
    }


    private static class Util {
        /*
            获得随机字符串
         */
        public static String getRand() {
            //用字符数组的方式随机
            String randomcode2 = "";
            String model = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            char[] m = model.toCharArray();

            for (int j = 0; j < 3; j++) {
                char c = m[(int) (Math.random() * 52)];
                randomcode2 = randomcode2 + c;
            }
            //System.out.println(Math.random()+"=="+randomcode2);
            return randomcode2;
        }
    }


}

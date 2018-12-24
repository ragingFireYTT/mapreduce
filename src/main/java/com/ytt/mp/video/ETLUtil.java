package com.ytt.mp.video;

import java.util.Arrays;

/**
 * Created by ytt on 2018/12/22.
 */
public class ETLUtil {
    /**
     * 1. 把长度小于 9 的数据过滤。
     * 2. 类别中空格去掉。
     * 3. 视频相关分隔符替换。
     */
    public static String strETL(String line) {

        //LKh7zAJ4nwo	TheReceptionist	653	Entertainment	424	13021	4.34	1305	744	DjdA-5oKYFQ	NxTDlnOuybo	c-8VuICzXtU	DH56yrIO5nI	W1Uo5DQTtzc	E-3zXq_r4w0	1TCeoRPg5dE	yAr26YhuYNY	2ZgXx72XmoE	-7ClGo-YgZ0	vmdPOOd6cxI	KRHfMQqSHpk	pIMpORZthYw	1tUDzOp10pk	heqocRij5P0	_XIuvoH6rUg	LGVU5DsezE0	uO2kj6_D8B4	xiDqywcDQRM	uX81lMev6_o
        //字段	备注	详细描述
        //video id	视频唯一id	11位字符串                       0
        //uploader	视频上传者	上传视频的用户名String             1
        //age	视频年龄	视频在平台上的整数天                        2
        //category	视频类别	上传视频指定的视频分类                   3
        //length	视频长度	整形数字标识的视频长度                   4
        //views	观看次数	视频被浏览的次数                            5
        //rate	视频评分	满分5分                                   6
        //Ratings	流量	视频的流量，整型数字                          7
        //conments	评论数	一个视频的整数评论数                      8
        //related ids	相关视频id	相关视频的id，最多20个           9 -----可有可无

        String[] fields = line.split("\t");
        if (fields.length < 9) {
            return null;
        }

        // People & Blogs
        fields[3] = fields[3].replace(" & ", "&");

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < fields.length; i++) {

            if (i == fields.length - 1) {
                buffer = buffer.append(fields[i]);
                continue;
            } else {
                if (i <= 8) {
                    buffer = buffer.append(fields[i] + "\t");
                    continue;
                }

                if (i > 8) {
                    buffer = buffer.append(fields[i] + "&");
                    continue;
                }
            }
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        //String s = "LKh7zAJ4nwo\tTheReceptionist\t653\tEntertainment\t424\t13021\t4.34\t1305\t744\tDjdA-5oKYFQ\tNxTDlnOuybo\tc-8VuICzXtU\tDH56yrIO5nI\tW1Uo5DQTtzc\tE-3zXq_r4w0\t1TCeoRPg5dE\tyAr26YhuYNY\t2ZgXx72XmoE\t-7ClGo-YgZ0\tvmdPOOd6cxI\tKRHfMQqSHpk\tpIMpORZthYw\t1tUDzOp10pk\theqocRij5P0\t_XIuvoH6rUg\tLGVU5DsezE0\tuO2kj6_D8B4\txiDqywcDQRM\tuX81lMev6_o\n";
        //String s = "SDNkMu8ZT68\tw00dy911\t630\tPeople & Blogs\t186\t10181\t3.49\t494\t257\trjnbgpPJUks";
        String s = "SDNkMu8ZT68\\tw00dy911\\t630\\tPeople & Blogs\\t186\\t10181\\t3.49\\t494\\t257";
        System.out.println(s);
        System.out.println(strETL(s));
        System.out.println(Arrays.toString(strETL(s).split("\t")));
    }
}

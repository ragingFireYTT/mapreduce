package com.ytt;

import javafx.scene.input.DataFormat;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ytt on 2018/12/17.
 */
public class xx {
    public static void main(String[] args) {
        File file = new File("E:\\Cache\\迅雷\\a");
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File f=files[i];

            String name = f.getName();
            System.out.println(name);

            long lastModified = f.lastModified();
            Date date = new Date(lastModified);
            SimpleDateFormat dataFormat= new SimpleDateFormat("YYYY");
            String year = dataFormat.format(date);
            System.out.println(year);

            String newName= year+"—"+
                    name.replace("更多精彩www.ady69.com@t11655025","")
                            .replace("www_ady69_com","");
            files[i].renameTo(new File("E:\\Document\\电影\\SexMovie\\"+newName));
        }
    }
}

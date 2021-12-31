package com.qcss.util;

import java.io.File;

public class DirDelete {
    public static void main(String[] args) {
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "软件工程";
        deleteDir(new File(realPath));
    }
    public static void deleteDir(File dir){
        if(dir.exists()){
            if(dir.isDirectory()){
                File[] files = dir.listFiles();
                for (File file:files) {
                    deleteDir(file);
                }
            }
            dir.delete();
        }else{
            System.out.println("不存在！");
        }
    }
}

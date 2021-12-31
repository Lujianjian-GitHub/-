package com.qcss.util;

import com.qcss.pojo.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InsertByExcel {
    public static void main(String[] args) {
        try {
            InsertByExcel.checkerExcel(new File("C:/Users/lujianjian/Desktop/数据表/审核人员注册表.xls"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Quality> qualityExcel(File file) throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(file);
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(fis);
        //获取整个excel
        HSSFWorkbook hb = new HSSFWorkbook(pSystem);
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        HSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstRow = sheet.getFirstRowNum();
        //获取最后一行
        int lastRow = sheet.getLastRowNum();

        List<Quality> qualityList = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstRow + 3; i < lastRow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstCell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastCell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstCell; j < lastCell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
//                System.out.println();
                Quality quality = new Quality();
                if (list.size() > 0) {
                    quality.setQualityId((int) Math.floor(Double.valueOf(list.get(0))));
                    quality.setOneClass((int) Math.floor(Double.valueOf(list.get(1))));
                    quality.setTwoClass(list.get(2));
                    quality.setThreeClass(list.get(3));
                    quality.setLevel((int) Math.floor(Double.valueOf(list.get(4))));
                    quality.setGrade((int) Math.floor(Double.valueOf(list.get(5))));
                    quality.setType((int) Math.floor(Double.valueOf(list.get(6))));
                    quality.setIsDescription((int) Math.floor(Double.valueOf(list.get(7))));
                    quality.setUploadType((int) Math.floor(Double.valueOf(list.get(8))));
                    quality.setMark((int) Math.floor(Double.valueOf(list.get(9))));
                }
                qualityList.add(quality);
            }
        }
        fis.close();
//        for (int i = 0; i < qualityList.size(); i++) {
//            System.out.println(qualityList.get(i).toString());
//        }
        return qualityList;
    }

    public static List<Admin> adminExcel(File file) throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(file);
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(fis);
        //获取整个excel
        HSSFWorkbook hb = new HSSFWorkbook(pSystem);
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        HSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstRow = sheet.getFirstRowNum();
        //获取最后一行
        int lastRow = sheet.getLastRowNum();

        List<Admin> adminList = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstRow + 2; i < lastRow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstCell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastCell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstCell; j < lastCell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
//                System.out.println();
                Admin admin = new Admin();
                if (list.size() > 0) {
                    try{
                        admin.setSeriesId(String.valueOf((int) Math.floor(Double.valueOf(list.get(0)))));
                    }catch (Exception e){
                        e.printStackTrace();
                        admin.setSeriesId(list.get(0));
                    }
                    try{
                        admin.setAdminId(String.valueOf((int) Math.floor(Double.valueOf(list.get(1)))));
                    }catch (Exception e){
                        e.printStackTrace();
                        admin.setAdminId(list.get(1));
                    }
                    admin.setName(list.get(2));
                    admin.setSex(list.get(3));
                    admin.setTel(new BigDecimal(list.get(4)).toPlainString());
                    admin.setAddTime(String.valueOf(System.currentTimeMillis()));
                }
                adminList.add(admin);
            }
        }
        fis.close();
//        for (int i = 0; i < adminList.size(); i++) {
//            System.out.println(adminList.get(i).toString());
//        }
        return adminList;
    }

    public static List<ClassInfo> classExcel(File file) throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(file);
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(fis);
        //获取整个excel
        HSSFWorkbook hb = new HSSFWorkbook(pSystem);
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        HSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstRow = sheet.getFirstRowNum();
        //获取最后一行
        int lastRow = sheet.getLastRowNum();

        List<ClassInfo> classInfoList = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstRow + 2; i < lastRow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstCell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastCell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstCell; j < lastCell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
//                System.out.println();
                ClassInfo classInfo = new ClassInfo();
                if (list.size() > 0) {
                    try{
                        classInfo.setSeriesId(String.valueOf((int) Math.floor(Double.valueOf(list.get(0)))));
                    }catch (Exception e){
                        e.printStackTrace();
                        classInfo.setSeriesId(list.get(0));
                    }
                    classInfo.setYear((int) Math.floor(Double.valueOf(list.get(1))));
                    classInfo.setClassId((int) Math.floor(Double.valueOf(list.get(2))));
//                    classInfo.setAdminId((int)Math.floor(Double.valueOf(list.get(3))));
                }
                classInfoList.add(classInfo);
            }
        }
        fis.close();
//        for (int i = 0; i < classInfoList.size(); i++) {
//            System.out.println(classInfoList.get(i).toString());
//        }
        return classInfoList;
    }

    public static List<ClassInfo> classExcel2(File file) throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(file);
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(fis);
        //获取整个excel
        HSSFWorkbook hb = new HSSFWorkbook(pSystem);
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        HSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstRow = sheet.getFirstRowNum();
        //获取最后一行
        int lastRow = sheet.getLastRowNum();

        List<ClassInfo> classInfoList = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstRow + 2; i < lastRow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstCell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastCell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstCell; j < lastCell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
//                System.out.println();
                ClassInfo classInfo = new ClassInfo();
                if (list.size() > 0) {
                    classInfo.setAdminId(String.valueOf((int) Math.floor(Double.valueOf(list.get(0)))));
                    classInfo.setYear((int) Math.floor(Double.valueOf(list.get(1))));
                    classInfo.setClassId((int) Math.floor(Double.valueOf(list.get(2))));
//                    classInfo.setAdminId((int)Math.floor(Double.valueOf(list.get(3))));
                }
                classInfoList.add(classInfo);
            }
        }
        fis.close();
//        for (int i = 0; i < classInfoList.size(); i++) {
//            System.out.println(classInfoList.get(i).toString());
//        }
        return classInfoList;
    }

    public static List<Student> studentExcel(File file) throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(file);
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(fis);
        //获取整个excel
        HSSFWorkbook hb = new HSSFWorkbook(pSystem);
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        HSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstRow = sheet.getFirstRowNum();
        //获取最后一行
        int lastRow = sheet.getLastRowNum();

        List<Student> studentList = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstRow + 2; i < lastRow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstCell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastCell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstCell; j < lastCell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
//                System.out.println();
                Student student = new Student();
                if (list.size() > 0) {
                    try{
                        student.setStudentId(String.valueOf((int) Math.floor(Double.valueOf(list.get(0)))));
                    }catch (Exception e){
                        e.printStackTrace();
                        student.setStudentId(list.get(0));
                    }
                    student.setYear((int) Math.floor(Double.valueOf(list.get(1))));
                    student.setClassId((int) Math.floor(Double.valueOf(list.get(2))));
                    student.setStudentName(list.get(3));
                    student.setSex(list.get(4));
                    student.setTel(new BigDecimal(list.get(5)).toPlainString());
                }
                studentList.add(student);
            }
        }
        fis.close();
//        for (int i = 0; i < studentList.size(); i++) {
//            System.out.println(studentList.get(i).toString());
//        }
        return studentList;
    }

    public static List<Checker> checkerExcel(File file) throws Exception {
        //用流的方式先读取到你想要的excel的文件
        FileInputStream fis = new FileInputStream(file);
        //解析excel
        POIFSFileSystem pSystem = new POIFSFileSystem(fis);
        //获取整个excel
        HSSFWorkbook hb = new HSSFWorkbook(pSystem);
        System.out.println(hb.getNumCellStyles());
        //获取第一个表单sheet
        HSSFSheet sheet = hb.getSheetAt(0);
        //获取第一行
        int firstRow = sheet.getFirstRowNum();
        //获取最后一行
        int lastRow = sheet.getLastRowNum();

        List<Checker> checkerList = new ArrayList<>();
        //循环行数依次获取列数
        for (int i = firstRow + 2; i < lastRow + 1; i++) {
            //获取哪一行i
            Row row = sheet.getRow(i);
            if (row != null) {
                //获取这一行的第一列
                int firstCell = row.getFirstCellNum();
                //获取这一行的最后一列
                int lastCell = row.getLastCellNum();
                //创建一个集合，用处将每一行的每一列数据都存入集合中
                List<String> list = new ArrayList<>();
                for (int j = firstCell; j < lastCell; j++) {
                    //获取第j列
                    Cell cell = row.getCell(j);
                    if (cell != null) {
//                        System.out.print(cell + "\t");
                        list.add(cell.toString());
                    }
                }
//                System.out.println();
                Checker checker = new Checker();
                if (list.size() > 0) {
                    try{
                        checker.setCheckerId(String.valueOf((int) Math.floor(Double.valueOf(list.get(0)))));
                    }catch (Exception e){
                        e.printStackTrace();
                        checker.setCheckerId(list.get(0));
                    }
                    checker.setCheckerName(list.get(1));
                    checker.setSex(list.get(2));
                    checker.setTel(new BigDecimal(list.get(3)).toPlainString());
                }
                checkerList.add(checker);
            }
        }
        fis.close();
//        for (int i = 0; i < checkerList.size(); i++) {
//            System.out.println(checkerList.get(i).toString());
//        }
        return checkerList;
    }

}

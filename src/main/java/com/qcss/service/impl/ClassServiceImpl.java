package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.AdminAndClassDao;
import com.qcss.dao.ClassDao;
import com.qcss.pojo.ClassInfo;
import com.qcss.service.ClassService;
import com.qcss.util.DirDelete;
import com.qcss.util.InsertByExcel;
import com.qcss.util.InsertExcelInfo;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassDao classDao;
    @Autowired
    AdminAndClassDao adminAndClassDao;
    /**
     *
     *班级信息的具体实现
     */
    @Override
    public Remassge classInfoInsert(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        try {
            classDao.insertClassInfo(classInfo);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge classInsertWithExcel(MultipartFile file) {
        Remassge remassge = new Remassge();
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "insertSpace";
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        List<ClassInfo> classInfoList;
        int flag = -1;
        //创建文件夹
        File fileDir = new File(realPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
            System.out.println("创建成功！");
        } else {
            System.out.println("已经存在");
        }
        try {
            file.transferTo(new File(realPath, newFilename));
            flag = 1;
            System.out.println("文件保存成功");
        } catch (IOException e) {
            e.printStackTrace();
            return remassge;
        }
        if (flag == 1) {
            try {
                classInfoList = InsertByExcel.classExcel(new File(realPath + File.separator + newFilename));
                System.out.println("获取信息成功");
                InsertExcelInfo insertExcelInfo = new InsertExcelInfo();
                insertExcelInfo.setAll(classInfoList.size());
                for (int i = 0; i < classInfoList.size(); i++) {
                    try {
                        classDao.insertClassInfo(classInfoList.get(i));
                        insertExcelInfo.setOk(insertExcelInfo.getOk() + 1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                remassge.setMsg(1);
                remassge.setData(insertExcelInfo);
            } catch (Exception e) {
                remassge.setMsg(3);
                e.printStackTrace();
            }finally {
                File deleteFile = new File(realPath + File.separator + newFilename);
                if(deleteFile.exists()){
                    //执行删除操作
                    deleteFile.delete();
                    System.out.println("已删除！");
                }else{
                    System.out.println("文件不存在");
                }
            }
        }
        return remassge;
    }
    @Override
    public Remassge classInsertWithExcel2(MultipartFile file) {
        Remassge remassge = new Remassge();
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "insertSpace";
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        List<ClassInfo> classInfoList;
        int flag = -1;
        //创建文件夹
        File fileDir = new File(realPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
            System.out.println("创建成功！");
        } else {
            System.out.println("已经存在");
        }
        try {
            file.transferTo(new File(realPath, newFilename));
            flag = 1;
            System.out.println("文件保存成功");
        } catch (IOException e) {
            e.printStackTrace();
            return remassge;
        }
        if (flag == 1) {
            try {
                classInfoList = InsertByExcel.classExcel2(new File(realPath + File.separator + newFilename));
                System.out.println("获取信息成功");
                InsertExcelInfo insertExcelInfo = new InsertExcelInfo();
                insertExcelInfo.setAll(classInfoList.size());
                adminAndClassDao.deleteAdminAndClass(null);
                for (int i = 0; i < classInfoList.size(); i++) {
                    try {
                        adminAndClassDao.insertAdminAndClass(classInfoList.get(i));
                        insertExcelInfo.setOk(insertExcelInfo.getOk() + 1);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                remassge.setMsg(1);
                remassge.setData(insertExcelInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                File deleteFile = new File(realPath + File.separator + newFilename);
                if(deleteFile.exists()){
                    //执行删除操作
                    deleteFile.delete();
                    System.out.println("已删除！");
                }else{
                    System.out.println("文件不存在");
                }
            }
        }
        return remassge;
    }
    @Override
    public Remassge classInfoSelect(Integer page, Integer limit, ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        try {
            List<ClassInfo> classInfoList = classDao.selectClassInfo(classInfo);
            PageHelper.startPage(page, limit);
            PageInfo<ClassInfo> pageInfo = new PageInfo<>(classInfoList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge classInfoSelectDistinctYear(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        try {
            remassge.setData(classDao.selectDistinctYearClassInfo(classInfo));
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
    @Override
    public Remassge classInfoSelectDistinctClassId(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        try {
            remassge.setData(classDao.selectDistinctClassIdClassInfo(classInfo));
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge classInfoDelete(List<ClassInfo> classInfoList) {
        Remassge remassge = new Remassge();
        try {
//            adminAndClassDao.deleteAdminAndClass(classInfoList);
            classDao.deleteClassInfo(classInfoList);
            for (int i = 0; i < classInfoList.size(); i++) {
                String realPath = "D:" + File.separator + "qcss" +
                        File.separator + classInfoList.get(i).getSeriesName() +
                        File.separator + classInfoList.get(i).getYear() +
                        File.separator + classInfoList.get(i).getClassId();
                String realPath2 = "D:" + File.separator + "qcss" +
                        File.separator + classInfoList.get(i).getSeriesName() +
                        File.separator + classInfoList.get(i).getYear();
                String realPath3 = "D:" + File.separator + "qcss" +
                        File.separator + classInfoList.get(i).getSeriesName();
                DirDelete.deleteDir(new File(realPath));
                try {
                    File dir = new File(realPath2);
                    if(dir.exists()){
                        /**
                         * 删除目录必须为空目录才可以
                         */
                        dir.delete();
                        System.out.println("删除成功！");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("该届次下还有班级");
                }
                try {
                    File dir = new File(realPath3);
                    if(dir.exists()){
                        dir.delete();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    System.out.println("该系下还有届次");
                }
            }
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
    @Override
    public Remassge classInfoUpdate(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        try {
            classDao.updateClassInfo(classInfo);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}

package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.QualityDataDao;
import com.qcss.dao.StudentDao;
import com.qcss.pojo.LoginInfo;
import com.qcss.pojo.QualityData;
import com.qcss.pojo.Student;
import com.qcss.service.QualityDataService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class QualityDataServiceImpl implements QualityDataService{
    @Autowired
    QualityDataDao qualityDataDao;
    @Autowired
    StudentDao studentDao;


    @Override
    public Remassge qualityDataInsert(QualityData qualityData) {
        Remassge remassge = new Remassge();
        try {
            qualityDataDao.insertQualityData(qualityData);
            remassge.setMsg(1);
            remassge.setData(qualityData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualityDataUpload(Integer id, MultipartFile file, LoginInfo loginInfo) {
        Remassge remassge = new Remassge();
        //获得用户的信息
        Student student = new Student();
        student.setStudentId(loginInfo.getName());
        List<Student> studentList = studentDao.selectStudent(student);
        student = studentList.get(0);
        System.out.println(student.toString());
        //拼接真实路径
        String realPath = "D:"+ File.separator + "qcss" +
                File.separator + student.getSeriesName() +
                File.separator + student.getYear() +
                File.separator + student.getClassId() +
                File.separator + student.getStudentId() + student.getStudentName();
        //创建文件夹
        File fileDir = new File(realPath);
        if(!fileDir.exists()){
            /**
             * mkdir()创建目录需要父目录存在
             * mkdirs()会将不存在的父目录一同创建出来
             */
            fileDir.mkdirs();
            System.out.println("创建成功！");
        }else{
            System.out.println("已经存在");
        }
        // 存储地址
        //映射路径存储qcss/院系编号/届次/班级/学生/time
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        System.out.println(newFilename);
        System.out.println(realPath + File.separator + newFilename);
//        // 上传图片
//        修改数据信息，添加真实路路径
        String mySQLPath = File.separator + student.getSeriesName() +
                File.separator + student.getYear() +
                File.separator + student.getClassId() +
                File.separator + student.getStudentId() + student.getStudentName() +
                File.separator + newFilename;
        QualityData qualityData = new QualityData();
        qualityData.setId(id);
        qualityData.setFilePath(mySQLPath);
        try {
            file.transferTo(new File(realPath,newFilename));
            qualityDataDao.updateQualityData(qualityData);
            remassge.setMsg(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualityDataSelect(Integer page, Integer limit, QualityData qualityData) {
        Remassge remassge = new Remassge();
        try {
            PageHelper.startPage(page, limit);
            List<QualityData> qualityDataList = qualityDataDao.selectQualityData(qualityData);
            PageInfo<QualityData> pageInfo = new PageInfo<>(qualityDataList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualityDataDelete(List<QualityData> qualityDataList) {
        Remassge remassge = new Remassge();
        //先删除文件
        QualityData qualityData;
        for (int i = 0; i < qualityDataList.size(); i++) {
            qualityData = qualityDataList.get(i);
            //文件路径
            String filePath = "D:"+ File.separator + "qcss" + qualityData.getFilePath();
            File file = new File(filePath);
            if(file.exists()){
                //执行删除操作
                file.delete();
                System.out.println("已删除！");
            }else{
                System.out.println("文件不存在");
            }
        }
        //删除数据库信息
        try {
            qualityDataDao.deleteQualityData(qualityDataList);
            remassge.setMsg(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge qualityDataUpdate(QualityData qualityData) {
        Remassge remassge = new Remassge();
        try {
            qualityDataDao.updateQualityData(qualityData);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}

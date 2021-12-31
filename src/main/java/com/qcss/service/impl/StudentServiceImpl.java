package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.LoginDao;
import com.qcss.dao.StudentDao;
import com.qcss.pojo.Student;
import com.qcss.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    LoginDao loginDao;
    @Override
    public Remassge studentInsert(Student student) {
        Remassge remassge = new Remassge();
        try {
            studentDao.insertStudent(student);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge studentInsertWithExcel(MultipartFile file) {
        Remassge remassge = new Remassge();
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "insertSpace";
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        List<Student> studentList;
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
                studentList = InsertByExcel.studentExcel(new File(realPath + File.separator + newFilename));
                System.out.println("获取信息成功");
                InsertExcelInfo insertExcelInfo = new InsertExcelInfo();
                insertExcelInfo.setAll(studentList.size());
                for (int i = 0; i < studentList.size(); i++) {
                    try {
                        studentDao.insertStudent(studentList.get(i));
                        insertExcelInfo.setOk(insertExcelInfo.getOk() + 1);
                    }catch (Exception e){
                        e.printStackTrace();
                        insertExcelInfo.setDone(insertExcelInfo.getDone() + 1);
                        continue;
                    }
                }
                remassge.setMsg(1);
                remassge.setData(insertExcelInfo);
            } catch (Exception e) {
                //上传的数据表用问题
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
    public Remassge studentSelect(Integer page, Integer limit, Student student) {
        Remassge remassge = new Remassge();
        try {
            List<Student> studentList = studentDao.selectStudent(student);
            PageHelper.startPage(page, limit);
            PageInfo<Student> pageInfo = new PageInfo<>(studentList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge studentSelectCount(Student student) {
        Remassge remassge = new Remassge();
        try {
            int count = studentDao.selectStudentCount(student);
            remassge.setMsg(1);
            remassge.setData(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge studentSelectUsedByChecker(Integer page, Integer limit, Student student) {
        Remassge remassge = new Remassge();
        try {
            List<Student> studentList = studentDao.selectUsedByCheckerStudent(student);
            PageHelper.startPage(page, limit);
            PageInfo<Student> pageInfo = new PageInfo<>(studentList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge studentDelete(List<Student> studentList) {
        Remassge remassge = new Remassge();
        try {
            studentDao.deleteStudent(studentList);
            for (int i = 0; i < studentList.size(); i++) {
                String realPath = "D:" + File.separator + "qcss" +
                        File.separator + studentList.get(i).getSeriesName() +
                        File.separator + studentList.get(i).getYear() +
                        File.separator + studentList.get(i).getClassId() +
                        File.separator + studentList.get(i).getStudentId() + studentList.get(i).getStudentName();
                String realPath2 = "D:" + File.separator + "qcss" +
                        File.separator + studentList.get(i).getSeriesName() +
                        File.separator + studentList.get(i).getYear() +
                        File.separator + studentList.get(i).getClassId();
                String realPath3 = "D:" + File.separator + "qcss" +
                        File.separator + studentList.get(i).getSeriesName() +
                        File.separator + studentList.get(i).getYear();
                String realPath4 = "D:" + File.separator + "qcss" +
                        File.separator + studentList.get(i).getSeriesName();
                DirDelete.deleteDir(new File(realPath));
                try {
                    File dir = new File(realPath2);
                    if (dir.exists()) {
                        /**
                         * 删除目录必须为空目录才可以
                         */
                        dir.delete();
                        System.out.println("删除成功！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("该届次下还学生");
                }
                try {
                    File dir = new File(realPath3);
                    if (dir.exists()) {
                        dir.delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("该系下还有班级");
                }
                try {
                    File dir = new File(realPath4);
                    if (dir.exists()) {
                        dir.delete();
                    }
                } catch (Exception e) {
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
    public Remassge studentUpdate(Student student) {
        Remassge remassge = new Remassge();
        try {
            studentDao.updateStudent(student);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}

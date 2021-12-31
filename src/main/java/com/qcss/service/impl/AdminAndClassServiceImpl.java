package com.qcss.service.impl;

import com.qcss.dao.AdminAndClassDao;
import com.qcss.dao.CheckerAndClassDao;
import com.qcss.pojo.ClassInfo;
import com.qcss.service.AdminAndClassService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Service
public class AdminAndClassServiceImpl implements AdminAndClassService {
    @Autowired
    AdminAndClassDao adminAndClassDao;
    @Autowired
    CheckerAndClassDao checkerAndClassDao;
    @Override
    public Remassge adminAndClassInsert(ClassInfo classInfo) {
        return null;
    }

    @Override
    public Remassge adminAndClassInsertWithExcel(MultipartFile file) {
        return null;
    }

    @Override
    public Remassge adminAndClassSelect(Integer page, Integer limit, ClassInfo classInfo) {
        return null;
    }

    @Override
    public Remassge adminAndClassDelete(List<ClassInfo> classInfoList) {
        return null;
    }

    @Override
    public Remassge adminAndClassUpdate(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        ClassInfo classInfo1 = new ClassInfo();
        int flag;
        classInfo1.setYear(classInfo.getYear());
        classInfo1.setClassId(classInfo.getClassId());
        try{
            List<ClassInfo> classInfoList = adminAndClassDao.selectAdminAndClass(classInfo1);
            flag = classInfoList.size();
            classInfoList.clear();
            classInfoList.add(classInfo);
            if (flag == 1){
                adminAndClassDao.updateAdminAndClass(classInfo);
            }else {
                adminAndClassDao.insertAdminAndClass(classInfo);
            }
            remassge.setMsg(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }
}

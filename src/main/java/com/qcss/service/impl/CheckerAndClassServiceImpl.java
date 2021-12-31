package com.qcss.service.impl;

import com.qcss.dao.CheckerAndClassDao;
import com.qcss.pojo.ClassInfo;
import com.qcss.service.CheckerAndClassService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckerAndClassServiceImpl implements CheckerAndClassService {
    @Autowired
    CheckerAndClassDao checkerAndClassDao;
    @Override
    public Remassge checkerAndClassInsert(ClassInfo classInfo) {
        return null;
    }

    @Override
    public Remassge checkerAndClassSelect(Integer page, Integer limit, ClassInfo classInfo) {
        return null;
    }

    @Override
    public Remassge checkerAndClassDelete(List<ClassInfo> classInfoList) {
        return null;
    }

    @Override
    public Remassge checkerAndClassUpdate(ClassInfo classInfo) {
        Remassge remassge = new Remassge();
        ClassInfo classInfo1 = new ClassInfo();
        int flag;
        classInfo1.setYear(classInfo.getYear());
        classInfo1.setClassId(classInfo.getClassId());
        try{
            List<ClassInfo> classInfoList = checkerAndClassDao.selectCheckerAndClass(classInfo1);
            flag = classInfoList.size();
            if (flag == 1){
                checkerAndClassDao.updateCheckerAndClass(classInfo);
            }else {
                checkerAndClassDao.insertCheckerAndClass(classInfo);
            }
            remassge.setMsg(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }
}

package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.CheckerAndClassDao;
import com.qcss.dao.CheckerDao;
import com.qcss.dao.LoginDao;
import com.qcss.exception.InsertException;
import com.qcss.pojo.Admin;
import com.qcss.pojo.Checker;
import com.qcss.service.CheckerService;
import com.qcss.util.InsertByExcel;
import com.qcss.util.InsertExcelInfo;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CheckerServiceImpl implements CheckerService {
    @Autowired
    CheckerDao checkerDao;
    @Autowired
    LoginDao loginDao;
    @Autowired
    CheckerAndClassDao checkerAndClassDao;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public Remassge checkerInsert(Checker checker,Admin admin) throws InsertException {
        Remassge remassge = new Remassge();
        try {
            checker.setAdminId(admin.getAdminId());
            checkerDao.insertChecker(checker);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InsertException("0");
        }
        return remassge;
    }

    @Override
    public Remassge checkerInsertWithExcel(MultipartFile file, Admin admin) {
        Remassge remassge = new Remassge();
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "insertSpace";
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        List<Checker> checkerList;
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
                checkerList = InsertByExcel.checkerExcel(new File(realPath + File.separator + newFilename));
                System.out.println("获取信息成功");
                InsertExcelInfo insertExcelInfo = new InsertExcelInfo();
                insertExcelInfo.setAll(checkerList.size());
                for (int i = 0; i < checkerList.size(); i++) {
                    try {
                        checkerList.get(i).setAdminId(admin.getAdminId());
                        checkerDao.insertChecker(checkerList.get(i));
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
                e.printStackTrace();
                remassge.setMsg(3);
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
    public Remassge checkerSelect(Integer page, Integer limit, Checker checker) {
        Remassge remassge = new Remassge();
        try {
            List<Checker> checkerList = checkerDao.selectChecker(checker);
            PageHelper.startPage(page, limit);
            PageInfo<Checker> pageInfo = new PageInfo<>(checkerList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge checkerDelete(List<Checker> checkerList) {
        Remassge remassge = new Remassge();
        try {
            checkerDao.deleteChecker(checkerList);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge checkerUpdate(Checker checker) {
        Remassge remassge = new Remassge();
        try {
            checkerDao.updateChecker(checker);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}

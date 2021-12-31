package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.AdminDao;
import com.qcss.dao.LoginDao;
import com.qcss.exception.InsertException;
import com.qcss.pojo.Admin;
import com.qcss.pojo.LoginInfo;
import com.qcss.service.AdminService;
import com.qcss.util.InsertByExcel;
import com.qcss.util.InsertExcelInfo;
import com.qcss.util.Remassge;
import com.qcss.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    LoginDao loginDao;
    /**
     * 管理员
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public Remassge adminInsert(Admin admin) throws InsertException {
        Remassge remassge = new Remassge();
        admin.setAddTime(String.valueOf(System.currentTimeMillis()));
        try {
            adminDao.insertAdmin(admin);
            remassge.setMsg(1);
        } catch (Exception e) {
            throw new InsertException("0");
        }
        return remassge;
    }

    @Override
    public Remassge adminInsertWithExcel(MultipartFile file) {
        Remassge remassge = new Remassge();
        String realPath = "D:" + File.separator + "qcss" +
                File.separator + "insertSpace";
        String newFilename = String.valueOf(System.currentTimeMillis()) + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        List<Admin> adminList;
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
                adminList = InsertByExcel.adminExcel(new File(realPath + File.separator + newFilename));
                System.out.println("获取信息成功");
                InsertExcelInfo insertExcelInfo = new InsertExcelInfo();
                insertExcelInfo.setAll(adminList.size());
                for (int i = 0; i < adminList.size(); i++) {
                    try {
                        adminDao.insertAdmin(adminList.get(i));
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
    public Remassge adminSelect(Integer page, Integer limit, Admin admin) {
        Remassge remassge = new Remassge();
        try {
            PageHelper.startPage(page, limit);
            List<Admin> adminList = adminDao.selectAdmin(admin);
            for (int i = 0; i < adminList.size(); i++) {
                adminList.get(i).setAddTime(Time.toString(Long.valueOf(adminList.get(i).getAddTime())));
            }
            PageInfo<Admin> pageInfo = new PageInfo<>(adminList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
    public Remassge adminDelete(List<Admin> adminList) throws InsertException{
        Remassge remassge = new Remassge();
        List<LoginInfo> loginInfoList = new ArrayList<>();
        for (int i = 0; i < adminList.size(); i++) {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.setName(String.valueOf(adminList.get(i).getAdminId()));
            loginInfoList.add(loginInfo);
        }
        try {
            adminDao.deleteAdmin(adminList);
            loginDao.deleteLoginInfo(loginInfoList);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InsertException("0");
        }
        return remassge;
    }

    @Override
    public Remassge adminUpdate(Admin admin) {
        Remassge remassge = new Remassge();
        try {
            adminDao.updateAdmin(admin);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}

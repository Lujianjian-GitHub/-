package com.qcss.controller;

import com.qcss.pojo.Admin;
import com.qcss.pojo.LoginInfo;
import com.qcss.service.AdminService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 完成对学生和审核人员的所有操作
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    /**
     * 管理员
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge adminInsert(Admin admin){
        Remassge remassge = new Remassge();
        try {
            return adminService.adminInsert(admin);
        }catch (Exception e){
            e.getMessage();
            remassge.setMsg(Integer.valueOf(e.getMessage()));
        }
        return remassge;
    }

    @RequestMapping("/insert/withExcel")
    @ResponseBody
    public Remassge adminInsertWithExcel(@RequestParam("file")MultipartFile file){
        return adminService.adminInsertWithExcel(file);
    }

    @RequestMapping("/select")
    @ResponseBody
    public Remassge adminSelect(Integer page, Integer limit,Admin admin){
        return adminService.adminSelect(page, limit, admin);
    }
    @RequestMapping("/select/myself")
    @ResponseBody
    public Remassge adminSelectMyself(Integer page, Integer limit, Admin admin, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo)httpSession.getAttribute("loginInfo");
        admin.setAdminId(loginInfo.getName());
        return adminService.adminSelect(page, limit, admin);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Remassge adminDelete(@RequestBody List<Admin> adminList){
        Remassge remassge = new Remassge();
        try {
            return adminService.adminDelete(adminList);
        }catch (Exception e){
            e.getMessage();
            remassge.setMsg(Integer.valueOf(e.getMessage()));
        }
        return remassge;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Remassge adminUpdate(Admin admin){
        return adminService.adminUpdate(admin);
    }
}

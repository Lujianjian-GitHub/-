package com.qcss.controller;

import com.qcss.pojo.Admin;
import com.qcss.pojo.ClassInfo;
import com.qcss.pojo.LoginInfo;
import com.qcss.pojo.QualityData;
import com.qcss.service.ECharsService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/eChars")
public class ECharsController {

    @Autowired
    ECharsService eCharsService;
    //系统管理员首页数据获取
    @RequestMapping("/getSeriesData")
    @ResponseBody
    public Remassge eCharsGetSeriesData(){
        return eCharsService.getSeriesData();
    }
    //学生首页数据获取
    @RequestMapping("/getStudentData")
    @ResponseBody
    public Remassge eCharsGetStudentData(HttpSession httpSession){
        LoginInfo loginInfo =  (LoginInfo) httpSession.getAttribute("loginInfo");
        QualityData qualityData = new QualityData();
        qualityData.setStudentId(loginInfo.getName());
        return eCharsService.getStudentData(qualityData);
    }
    //审核人员首页数据获取
    @RequestMapping("/getCheckerData")
    @ResponseBody
    public Remassge eCharsGetCheckerData(HttpSession httpSession){
        LoginInfo loginInfo =  (LoginInfo) httpSession.getAttribute("loginInfo");
        ClassInfo classInfo = new ClassInfo();
        classInfo.setCheckerId(loginInfo.getName());
        return eCharsService.getCheckerData(classInfo);
    }
    //审核人员首页数据获取
    @RequestMapping("/getAdminData")
    @ResponseBody
    public Remassge eCharsGetAdminData(HttpSession httpSession){
        LoginInfo loginInfo =  (LoginInfo) httpSession.getAttribute("loginInfo");
        Admin admin = new Admin();
        admin.setAdminId(loginInfo.getName());
        return eCharsService.getAdminData(admin);
    }
}

package com.qcss.controller;

import com.qcss.pojo.ClassInfo;
import com.qcss.service.AdminAndClassService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/adminAndClass")
public class AdminAndClassController {

    @Autowired
    AdminAndClassService adminAndClassService;

    @RequestMapping("/update")
    @ResponseBody
    public Remassge adminAndClassUpdate(ClassInfo classInfo){
        return adminAndClassService.adminAndClassUpdate(classInfo);
    }
}

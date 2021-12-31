package com.qcss.controller;

import com.qcss.pojo.ClassInfo;
import com.qcss.service.CheckerAndClassService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/checkerAndClass")
public class CheckerAndClassController {
    @Autowired
    CheckerAndClassService checkerAndClassService;
    @RequestMapping("/update")
    @ResponseBody
    public Remassge checkerAndClassUpdate(ClassInfo classInfo){
        return checkerAndClassService.checkerAndClassUpdate(classInfo);
    }
}

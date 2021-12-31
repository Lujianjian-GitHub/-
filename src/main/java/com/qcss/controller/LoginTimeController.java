package com.qcss.controller;

import com.qcss.pojo.LoginTime;
import com.qcss.service.LoginTimeService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loginTime")
public class LoginTimeController {

    @Autowired
    LoginTimeService loginTimeService;

    @RequestMapping("/select")
    @ResponseBody
    public Remassge loginTimeSelect(LoginTime loginTime){
        return loginTimeService.loginTimeSelect(loginTime);
    }

    @RequestMapping("/select/usedIndex")
    @ResponseBody
    public Remassge loginTimeSelectUsedIndex(){
        return loginTimeService.loginTimeSelectUsedIndex();
    }

    @RequestMapping("/update")
    @ResponseBody
    public Remassge loginTimeUpdate(LoginTime loginTime){
        System.out.println(loginTime.toString());
        return loginTimeService.loginTimeUpdate(loginTime);
//        return null;
    }

}

package com.qcss.controller;


import com.qcss.pojo.LoginInfo;
import com.qcss.service.LoginService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 负责控制登陆时需要的接口
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/select")
    @ResponseBody
    public Remassge loginInfoSelect(Integer page, Integer limit,LoginInfo loginInfo){
        loginInfo.setStatus(3);
        return loginService.loginInfoSelect(page,limit,loginInfo);
    }
    @RequestMapping("/resetPassword")
    @ResponseBody
    public Remassge loginInfoResetPassword(LoginInfo loginInfo){
        System.out.println("重置密码");
        System.out.println(loginInfo.toString());
        return loginService.loginInfoResetPassword(loginInfo);
    }

    @RequestMapping("/check")
    @ResponseBody
    public Remassge loginInfoCheck(LoginInfo loginInfo, HttpSession httpSession){
        Remassge remassge = loginService.loginInfoCheck(loginInfo);
        //不判断会出现空指针异常
        if(remassge.getMsg() == 1){
            LoginInfo loginInfo1 = (LoginInfo) remassge.getData();
            httpSession.setAttribute("loginInfo",loginInfo1);
        }
        return remassge;
    }
    @RequestMapping("/out")
    @ResponseBody
    public Remassge loginInfoOut(HttpSession httpSession){
        Remassge remassge = new Remassge();
        httpSession.invalidate();
        System.out.println("退出登录");
        remassge.setMsg(1);
        return remassge;
    }

    @RequestMapping("/changePassword")
    @ResponseBody
    public Remassge seriesSetOne(LoginInfo loginInfo, HttpSession httpSession){
//        return sudoService.seriesSetOne(series);
        LoginInfo loginInfo1 = (LoginInfo) httpSession.getAttribute("loginInfo");
        loginInfo.setName(loginInfo1.getName());
//        System.out.println(loginInfo.toString());
        return loginService.changePassword(loginInfo);
    }
}

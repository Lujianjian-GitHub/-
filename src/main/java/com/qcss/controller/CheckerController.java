package com.qcss.controller;

import com.qcss.pojo.Admin;
import com.qcss.pojo.Checker;
import com.qcss.pojo.LoginInfo;
import com.qcss.service.CheckerService;
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

@Controller
@RequestMapping("/checker")
public class CheckerController {
    @Autowired
    CheckerService checkerService;
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge checkerInsert(Checker checker,HttpSession httpSession){
        Remassge remassge = new Remassge();
        Admin admin = new Admin();
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        admin.setAdminId(loginInfo.getName());
        try {
            return checkerService.checkerInsert(checker,admin);
        }catch (Exception e){
            e.getMessage();
            remassge.setMsg(Integer.valueOf(e.getMessage()));
        }
        return remassge;
    }
    @RequestMapping("/insert/withExcel")
    @ResponseBody
    public Remassge checkerInsertWithExcel(@RequestParam("file")MultipartFile file, HttpSession httpSession){
        Admin admin = new Admin();
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        admin.setAdminId(loginInfo.getName());
        return checkerService.checkerInsertWithExcel(file, admin);
    }
    @RequestMapping("/select")
    @ResponseBody
    public Remassge checkerSelect(Integer page, Integer limit, Checker checker){
        return checkerService.checkerSelect(page,limit,checker);
    }

    @RequestMapping("/select/myself")
    @ResponseBody
    public Remassge checkerSelectMyself(Integer page, Integer limit, Checker checker, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo)httpSession.getAttribute("loginInfo");
        checker.setCheckerId(loginInfo.getName());
        return checkerService.checkerSelect(page,limit,checker);
    }

    @RequestMapping("/select/usedByAdmin")
    @ResponseBody
    public Remassge checkerSelectUsedByAdmin(Integer page, Integer limit, Checker checker, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        checker.setAdminId(loginInfo.getName());
        return checkerService.checkerSelect(page,limit,checker);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Remassge checkerDelete(@RequestBody List<Checker> checkerList){
        return checkerService.checkerDelete(checkerList);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Remassge checkerUpdate(Checker checker){
        return checkerService.checkerUpdate(checker);
    }
}

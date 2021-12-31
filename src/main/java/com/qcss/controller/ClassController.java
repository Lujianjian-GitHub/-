package com.qcss.controller;

import com.qcss.pojo.ClassInfo;
import com.qcss.pojo.LoginInfo;
import com.qcss.service.ClassService;
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
@RequestMapping("/class")
public class ClassController {

    @Autowired
    ClassService classService;
    /**
     * 班级信息
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge classInfoInsert(ClassInfo classInfo){
        return classService.classInfoInsert(classInfo);
    }

    @RequestMapping("/insert/withExcel")
    @ResponseBody
    public Remassge classInfoInsertWithExcel(@RequestParam("file")MultipartFile file){
        return classService.classInsertWithExcel(file);
    }
//    @RequestMapping("/insert/withExcel2")
//    @ResponseBody
//    public Remassge classInfoInsertWithExcel2(@RequestParam("file")MultipartFile file){
//        return classService.classInsertWithExcel2(file);
//    }
    @RequestMapping("/select")
    @ResponseBody
    public Remassge classInfoSelect(Integer page, Integer limit,ClassInfo classInfo){
        return classService.classInfoSelect(page, limit, classInfo);
    }
    @RequestMapping("/select/usedByAdmin")
    @ResponseBody
    public Remassge classInfoSelectUsedByAdmin(Integer page, Integer limit, ClassInfo classInfo, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        classInfo.setAdminId(loginInfo.getName());
        return classService.classInfoSelect(page, limit, classInfo);
    }
    @RequestMapping("/select/usedByChecker")
    @ResponseBody
    public Remassge classInfoSelectUsedByChecker(Integer page, Integer limit, ClassInfo classInfo, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        classInfo.setCheckerId(loginInfo.getName());
        return classService.classInfoSelect(page, limit, classInfo);
    }
    @RequestMapping("/select/distinctYear")
    @ResponseBody
    public Remassge classInfoSelectDistinctYear(ClassInfo classInfo){
        return classService.classInfoSelectDistinctYear(classInfo);
    }
    @RequestMapping("/select/distinctClassId")
    @ResponseBody
    public Remassge classInfoSelectDistinctClassId(ClassInfo classInfo){
        return classService.classInfoSelectDistinctClassId(classInfo);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Remassge classInfoDelete(@RequestBody List<ClassInfo> classInfoList){
        return classService.classInfoDelete(classInfoList);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Remassge classInfoUpdate(ClassInfo classInfo){
        return classService.classInfoUpdate(classInfo);
    }
}

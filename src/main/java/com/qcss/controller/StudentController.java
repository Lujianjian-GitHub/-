package com.qcss.controller;

import com.qcss.pojo.LoginInfo;
import com.qcss.pojo.Student;
import com.qcss.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge studentInsert(Student student){
        return studentService.studentInsert(student);
    }

    @RequestMapping("/insert/withExcel")
    @ResponseBody
    public Remassge studentInsertWithExcel(@RequestParam("file")MultipartFile file){
        return studentService.studentInsertWithExcel(file);
    }
    @RequestMapping("/select")
    @ResponseBody
    public Remassge studentSelect(Integer page, Integer limit, Student student){
        return studentService.studentSelect(page, limit, student);
    }
    @RequestMapping("/select/myself")
    @ResponseBody
    public Remassge studentSelectMyself(Integer page, Integer limit, Student student, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        student.setStudentId(loginInfo.getName());
        return studentService.studentSelect(page, limit, student);
    }
    @RequestMapping("/select/count")
    @ResponseBody
    public Remassge studentSelectCount(Student student){
        return studentService.studentSelectCount(student);
    }
    @RequestMapping("/select/usedByAdmin")
    @ResponseBody
    public Remassge studentSelectUsedByAdmin(Integer page, Integer limit, Student student, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        student.setAdminId(loginInfo.getName());
        return studentService.studentSelect(page, limit, student);
    }
    @RequestMapping("/select/usedByChecker")
    @ResponseBody
    public Remassge studentSelectUsedByChecker(Integer page, Integer limit, Student student, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        student.setCheckerId(loginInfo.getName());
        return studentService.studentSelectUsedByChecker(page, limit, student);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Remassge studentDelete(@RequestBody List<Student> studentList){
        return studentService.studentDelete(studentList);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Remassge studentUpdate(Student student){
        return studentService.studentUpdate(student);
    }

}

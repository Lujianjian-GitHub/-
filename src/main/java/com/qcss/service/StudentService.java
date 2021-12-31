package com.qcss.service;

import com.qcss.pojo.Student;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    /**
     * 学生
     */
    public Remassge studentInsert(Student student);
    public Remassge studentInsertWithExcel(MultipartFile file);
    public Remassge studentSelect(Integer page, Integer limit,Student student);
    public Remassge studentSelectCount(Student student);
    public Remassge studentSelectUsedByChecker(Integer page, Integer limit,Student student);
    public Remassge studentDelete(List<Student> studentList);
    public Remassge studentUpdate(Student student);
}

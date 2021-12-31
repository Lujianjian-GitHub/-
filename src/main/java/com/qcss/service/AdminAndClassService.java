package com.qcss.service;

import com.qcss.pojo.ClassInfo;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminAndClassService {
    public Remassge adminAndClassInsert(ClassInfo classInfo);
    public Remassge adminAndClassInsertWithExcel(MultipartFile file);
    public Remassge adminAndClassSelect(Integer page, Integer limit,ClassInfo classInfo);
    public Remassge adminAndClassDelete(List<ClassInfo> classInfoList);
    public Remassge adminAndClassUpdate(ClassInfo classInfo);
}

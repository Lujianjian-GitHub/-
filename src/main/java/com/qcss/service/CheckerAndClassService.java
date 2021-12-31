package com.qcss.service;

import com.qcss.pojo.ClassInfo;
import com.qcss.util.Remassge;

import java.util.List;

public interface CheckerAndClassService {
    public Remassge checkerAndClassInsert(ClassInfo classInfo);
    public Remassge checkerAndClassSelect(Integer page, Integer limit,ClassInfo classInfo);
    public Remassge checkerAndClassDelete(List<ClassInfo> classInfoList);
    public Remassge checkerAndClassUpdate(ClassInfo classInfo);
}

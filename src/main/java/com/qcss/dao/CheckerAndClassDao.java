package com.qcss.dao;

import com.qcss.pojo.ClassInfo;

import java.util.List;

public interface CheckerAndClassDao {
    public int insertCheckerAndClass(ClassInfo classInfo);

    public List<ClassInfo> selectCheckerAndClass(ClassInfo classInfo);

    public int deleteCheckerAndClass(List<ClassInfo> classInfoList);

    public int updateCheckerAndClass(ClassInfo classInfo);
}

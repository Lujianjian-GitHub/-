package com.qcss.dao;

import com.qcss.pojo.ClassInfo;

import java.util.List;

public interface AdminAndClassDao {
    public int insertAdminAndClass(ClassInfo classInfo);

    public List<ClassInfo> selectAdminAndClass(ClassInfo classInfo);

    public int deleteAdminAndClass(List<ClassInfo> classInfoList);

    public int updateAdminAndClass(ClassInfo classInfo);
}

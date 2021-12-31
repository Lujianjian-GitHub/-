package com.qcss.dao;

import com.qcss.pojo.ClassInfo;

import java.util.List;

public interface ClassDao {
    /**
     * 班级设置
     *
     */
    public int insertClassInfo(ClassInfo classInfo);

    public List<ClassInfo> selectClassInfo(ClassInfo classInfo);
    public List<ClassInfo> selectDistinctYearClassInfo(ClassInfo classInfo);
    public List<ClassInfo> selectDistinctClassIdClassInfo(ClassInfo classInfo);

    public int deleteClassInfo(List<ClassInfo> classInfoList);

    public int updateClassInfo(ClassInfo classInfo);
}

package com.qcss.service;

import com.qcss.pojo.ClassInfo;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClassService {
    /**
     *班级设置
     */
    public Remassge classInfoInsert(ClassInfo classInfo);
    public Remassge classInsertWithExcel(MultipartFile file);
    public Remassge classInsertWithExcel2(MultipartFile file);
    public Remassge classInfoSelect(Integer page, Integer limit,ClassInfo classInfo);
    public Remassge classInfoSelectDistinctYear(ClassInfo classInfo);
    public Remassge classInfoSelectDistinctClassId(ClassInfo classInfo);
    public Remassge classInfoDelete(List<ClassInfo> classInfoList);
    public Remassge classInfoUpdate(ClassInfo classInfo);
}

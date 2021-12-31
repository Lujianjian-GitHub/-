package com.qcss.service;

import com.qcss.pojo.Admin;
import com.qcss.pojo.ClassInfo;
import com.qcss.pojo.QualityData;
import com.qcss.util.Remassge;

public interface ECharsService {
    public Remassge getSeriesData();
    public Remassge getStudentData(QualityData qualityData);
    public Remassge getCheckerData(ClassInfo classInfo);
    public Remassge getAdminData(Admin admin);
}

package com.qcss.dao;

import com.qcss.pojo.QualityData;
import com.qcss.pojo.Student;

import java.util.List;

public interface QualityDataDao {
    public int insertQualityData(QualityData qualityData);

    public List<QualityData> selectQualityData(QualityData qualityData);

    public int deleteQualityData(List<QualityData> qualityDataList);

    public int updateQualityData(QualityData qualityData);

    public QualityData selectGetStudentData(QualityData qualityData);
    public Integer selectGetCheckerData(Student student);
}

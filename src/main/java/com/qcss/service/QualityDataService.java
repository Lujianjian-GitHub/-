package com.qcss.service;

import com.qcss.pojo.LoginInfo;
import com.qcss.pojo.QualityData;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QualityDataService {
    public Remassge qualityDataInsert(QualityData qualityData);
    public Remassge qualityDataUpload(Integer id, MultipartFile file, LoginInfo loginInfo);
    public Remassge qualityDataSelect(Integer page, Integer limit,QualityData qualityData);
    public Remassge qualityDataDelete(List<QualityData> qualityDataList);
    public Remassge qualityDataUpdate(QualityData qualityData);
}

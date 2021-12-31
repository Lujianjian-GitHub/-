package com.qcss.service;

import com.qcss.pojo.Quality;
import com.qcss.util.Remassge;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QualityService {
    /**
     * 素质学分
     */
    public Remassge qualityInsert(Quality quality);
    public Remassge qualityInsertWithExcel(MultipartFile file);
    public Remassge qualityDelete(List<Quality> qualityList);
    public Remassge qualityUpdate(Quality quality);
    public Remassge qualitySelect(Integer page, Integer limit,Quality quality);
    public Remassge qualitySelectDistinctOneClass(Quality quality);
    public Remassge qualitySelectDistinctTwoClass(Quality quality);
    public Remassge qualitySelectDistinctThreeClass(Quality quality);
    public Remassge qualitySelectDistinctLevel(Quality quality);
    public Remassge qualitySelectDistinctGrade(Quality quality);
    public Remassge qualitySelectDistinctType(Quality quality);
}

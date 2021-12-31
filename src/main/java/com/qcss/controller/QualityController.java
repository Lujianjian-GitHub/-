package com.qcss.controller;

import com.qcss.pojo.Quality;
import com.qcss.service.QualityService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Controller
@RequestMapping("/quality")
public class QualityController {
    @Autowired
    QualityService qualityService;

    /**
     *
     * 素质学分
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge qualityInsert(Quality quality){
        return qualityService.qualityInsert(quality);
    }

    @RequestMapping("/insert/withExcel")
    @ResponseBody
    public Remassge qualityInsertWithExcel(@RequestParam("file")MultipartFile file){
        return qualityService.qualityInsertWithExcel(file);
    }

    @RequestMapping("/select")
    @ResponseBody
    public Remassge qualitySelect(Integer page, Integer limit,Quality quality){
        return qualityService.qualitySelect(page, limit, quality);
    }
    @RequestMapping("/delete")
    @ResponseBody
    public Remassge qualityDelete(@RequestBody List<Quality> qualityList){
        return qualityService.qualityDelete(qualityList);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Remassge qualityUpdate(Quality quality){
        return qualityService.qualityUpdate(quality);
    }
    @RequestMapping("/selectDistinctOneClassQuality")
    @ResponseBody
    public Remassge selectDistinctOneClassQuality(Quality quality){
        return qualityService.qualitySelectDistinctOneClass(quality);
    }
    @RequestMapping("/selectDistinctTwoClassQuality")
    @ResponseBody
    public Remassge selectDistinctTwoClassQuality(Quality quality){
        return qualityService.qualitySelectDistinctTwoClass(quality);
    }
    @RequestMapping("/selectDistinctThreeClassQuality")
    @ResponseBody
    public Remassge selectDistinctThreeClassQuality(Quality quality){
        return qualityService.qualitySelectDistinctThreeClass(quality);
    }
    @RequestMapping("/selectDistinctLevelQuality")
    @ResponseBody
    public Remassge selectDistinctLevelQuality(Quality quality){
        return qualityService.qualitySelectDistinctLevel(quality);
    }
    @RequestMapping("/selectDistinctGradeQuality")
    @ResponseBody
    public Remassge selectDistinctGradeQuality(Quality quality){
        return qualityService.qualitySelectDistinctGrade(quality);
    }
    @RequestMapping("/selectDistinctTypeQuality")
    @ResponseBody
    public Remassge selectDistinctTypeQuality(Quality quality){
        return qualityService.qualitySelectDistinctType(quality);
    }
}

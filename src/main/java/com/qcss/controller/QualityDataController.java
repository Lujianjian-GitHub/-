package com.qcss.controller;

import com.qcss.pojo.LoginInfo;
import com.qcss.pojo.QualityData;
import com.qcss.pojo.Student;
import com.qcss.service.ECharsService;
import com.qcss.service.QualityDataService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/qualityData")
public class QualityDataController {
    @Autowired
    QualityDataService qualityDataService;
    @Autowired
    ECharsService eCharsService;
    /**
     * 素质学分
     */
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge qualityDataInsert(QualityData qualityData, HttpSession httpSession) {
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        qualityData.setStudentId(loginInfo.getName());
        qualityData.setCheckStatus(2);
        qualityData.setAddTime(String.valueOf(System.currentTimeMillis()));
//        System.out.println(qualityData.toString());
        return qualityDataService.qualityDataInsert(qualityData);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Remassge qualityDataUpload(QualityData qualityData, @RequestParam("file")MultipartFile file, HttpSession httpSession){
        System.out.println(qualityData.getId());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        return qualityDataService.qualityDataUpload(qualityData.getId(), file, loginInfo);
    }
    @RequestMapping("/update")
    @ResponseBody
    public Remassge qualityDataUpload(QualityData qualityData){
        System.out.println(qualityData.getId());
        System.out.println(qualityData.getCheckStatus());
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(qualityData.toString());
        return qualityDataService.qualityDataUpdate(qualityData);
    }

    @RequestMapping("/select")
    @ResponseBody
    public Remassge qualityDataSelect(Integer page, Integer limit,QualityData qualityData){
        return qualityDataService.qualityDataSelect(page, limit, qualityData);
    }

    @RequestMapping("/select/usedByStudent")
    @ResponseBody
    public Remassge qualityDataSelectUsedByStudent(Integer page, Integer limit, QualityData qualityData, HttpSession httpSession){
        LoginInfo loginInfo = (LoginInfo) httpSession.getAttribute("loginInfo");
        qualityData.setStudentId(loginInfo.getName());
        return qualityDataService.qualityDataSelect(page, limit, qualityData);
    }

    @RequestMapping("/select/cord")
    @ResponseBody
    public Remassge qualityDataSelectCord(Student student){
        QualityData qualityData = new QualityData();
        qualityData.setStudentId(student.getStudentId());
        return eCharsService.getStudentData(qualityData);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Remassge qualityDataDelete(@RequestBody List<QualityData> qualityDataList){
        return qualityDataService.qualityDataDelete(qualityDataList);
    }


}

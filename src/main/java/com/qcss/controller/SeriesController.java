package com.qcss.controller;

import com.qcss.pojo.Series;
import com.qcss.service.SeriesService;
import com.qcss.util.Remassge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    SeriesService seriesService;
    @RequestMapping("/insert")
    @ResponseBody
    public Remassge seriesInsert(Series series, HttpSession httpSession){
        System.out.println(httpSession.getAttribute("loginInfo").toString());
        return seriesService.seriesInsert(series);
    }
    //删除系信息
    @RequestMapping("/delete")
    @ResponseBody
    public Remassge seriesDelete(@RequestBody List<Series> seriesList){
        return seriesService.seriesDelete(seriesList);
    }
    //更新系信息
    @RequestMapping("/update")
    @ResponseBody
    public Remassge seriesUpdate(Series series){
        return seriesService.seriesUpdate(series);
    }
    //查找系信息
    @RequestMapping("/select")
    @ResponseBody
    public Remassge seriesSelect(Integer page, Integer limit,Series series){
        return seriesService.seriesSelect(page, limit, series);
    }
}

package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.SeriesDao;
import com.qcss.pojo.Series;
import com.qcss.service.SeriesService;
import com.qcss.util.DirDelete;
import com.qcss.util.Remassge;
import com.qcss.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {
    @Autowired
    SeriesDao seriesDao;

    @Override
    public Remassge seriesInsert(Series series) {
        Remassge remassge = new Remassge();
        series.setAddTime(String.valueOf(System.currentTimeMillis()));
        try {
            seriesDao.insertSeries(series);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge seriesDelete(List<Series> seriesList) {
        Remassge remassge = new Remassge();

        try {
            seriesDao.deleteSeries(seriesList);
            for (int i = 0; i < seriesList.size(); i++) {
                String realPath = "D:" + File.separator + "qcss" +
                        File.separator + seriesList.get(i).getName();
                DirDelete.deleteDir(new File(realPath));
            }
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge seriesUpdate(Series series) {
        Remassge remassge = new Remassge();
        series.setAddTime(String.valueOf(System.currentTimeMillis()));
        try {
            seriesDao.updateSeries(series);
            remassge.setMsg(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge seriesSelect(Integer page, Integer limit, Series series) {
        Remassge remassge = new Remassge();
        try {
            PageHelper.startPage(page, limit);
            List<Series> seriesList = seriesDao.selectSeries(series);
            for (int i = 0; i < seriesList.size(); i++) {
                seriesList.get(i).setAddTime(Time.toString(Long.valueOf(seriesList.get(i).getAddTime())));
            }
            PageInfo<Series> pageInfo = new PageInfo<>(seriesList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }
}

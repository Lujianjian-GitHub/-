package com.qcss.dao;

import com.qcss.pojo.Series;

import java.util.List;

public interface SeriesDao {
    //创建一个系
    public int insertSeries(Series series);
    //查看全部系信息
    public List<Series> selectSeries(Series series);
    //删除信息
    public int deleteSeries(List<Series> seriesList);
    //更新系信息
    public int updateSeries(Series series);
    public Long countSeries();
}

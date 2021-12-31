package com.qcss.service;

import com.qcss.pojo.Series;
import com.qcss.util.Remassge;

import java.util.List;

public interface SeriesService {
    //设立一个新的系
    public Remassge seriesInsert(Series series);
    //查找系
    public Remassge seriesSelect(Integer page, Integer limit,Series series);
    //删除信息
    public Remassge seriesDelete(List<Series> seriesList);
    //更新信息
    public Remassge seriesUpdate(Series series);
}

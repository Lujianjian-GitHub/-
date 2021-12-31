package com.qcss.dao;

import com.qcss.pojo.Quality;

import java.util.List;

public interface QualityDao {
    /**
     * 素质学分设定
     */
    public int insertQuality(Quality quality);

    public List<Quality> selectQuality(Quality quality);

    public int deleteQuality(List<Quality> qualityList);

    public int updateQuality(Quality quality);

    public List<Quality> selectDistinctOneClassQuality(Quality quality);

    public List<Quality> selectDistinctTwoClassQuality(Quality quality);

    public List<Quality> selectDistinctThreeClassQuality(Quality quality);
    public List<Quality> selectDistinctLevelQuality(Quality quality);
    public List<Quality> selectDistinctGradeQuality(Quality quality);
    public List<Quality> selectDistinctTypeQuality(Quality quality);
}

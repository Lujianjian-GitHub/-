package com.qcss.dao;

import com.qcss.pojo.Checker;

import java.util.List;

public interface CheckerDao {
    /**
     * 学生设置
     */
    public int insertChecker(Checker checker);

    public List<Checker> selectChecker(Checker checker);

    public int deleteChecker(List<Checker> checkerList);

    public int updateChecker(Checker checker);
    public Long countChecker(Checker checker);
}

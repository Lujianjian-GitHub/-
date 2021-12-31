package com.qcss.dao;

import com.qcss.pojo.LoginTime;

import java.util.List;

public interface LoginTimeDao {
    public int insertLoginTime(LoginTime loginTime);

    public List<LoginTime> selectLoginTime(LoginTime loginTime);

//    public int deleteQuality(List<LoginTime> qualityList);

    public int updateLoginTime(LoginTime loginTime);

}

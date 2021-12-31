package com.qcss.dao;

import com.qcss.pojo.LoginInfo;

import java.util.List;

/**
 * 登录时进行数据库的操作
 */
public interface LoginDao {
    /**
     * 根据登录信息查询用户是否存在，且信息正确
     */
    //创建一个系
    public int insertLoginInfo(LoginInfo loginInfo);
    //查看全部系信息
    public List<LoginInfo> selectLoginInfo(LoginInfo loginInfo);
    //删除信息
    public int deleteLoginInfo(List<LoginInfo> loginInfoList);
    //更新信息
    public int updateLoginInfo(LoginInfo loginInfo);

    public LoginInfo checkLoginInfo(LoginInfo loginInfo);







    public LoginInfo ifFind(LoginInfo loginInfo);
    public int reflushtime(LoginInfo loginInfo);

    //修改密码
    public int changePassword(LoginInfo loginInfo);

    public int insertLogin(LoginInfo loginInfo);

    public int deleteLogin(List<LoginInfo> loginInfoList);

}

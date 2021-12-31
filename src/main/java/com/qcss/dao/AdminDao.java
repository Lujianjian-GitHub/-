package com.qcss.dao;

import com.qcss.pojo.Admin;

import java.util.List;

public interface AdminDao {



    /**
     * 添加系管理员
     *
     */
    public int insertAdmin(Admin admin);

    public List<Admin> selectAdmin(Admin admin);

    public int deleteAdmin(List<Admin> adminList);

    public int updateAdmin(Admin admin);

    public Long countAdmin(Admin admin);

}

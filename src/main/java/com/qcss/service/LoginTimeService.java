package com.qcss.service;

import com.qcss.pojo.LoginTime;
import com.qcss.util.Remassge;

public interface LoginTimeService {
    public Remassge loginTimeInsert(LoginTime loginTime);
    public Remassge loginTimeSelect(LoginTime loginTime);
    public Remassge loginTimeSelectUsedIndex();
//    public Remassge adminDelete(List<Admin> adminList);
    public Remassge loginTimeUpdate(LoginTime loginTime);
}

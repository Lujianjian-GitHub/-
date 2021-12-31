package com.qcss.service;

import com.qcss.pojo.LoginInfo;
import com.qcss.util.Remassge;

/**
 * 登录服务层的接口
 */
public interface LoginService {
    public Remassge loginInfoSelect(Integer page, Integer limit,LoginInfo loginInfo);
    public Remassge loginInfoCheck(LoginInfo loginInfo);
    public Remassge loginInfoResetPassword(LoginInfo loginInfo);
    public Remassge loginInfoInsert(LoginInfo loginInfo);
    public Remassge changePassword(LoginInfo loginInfo);
}

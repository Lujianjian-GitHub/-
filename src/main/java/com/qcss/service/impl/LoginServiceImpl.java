package com.qcss.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qcss.dao.LoginDao;
import com.qcss.dao.LoginTimeDao;
import com.qcss.pojo.LoginInfo;
import com.qcss.pojo.LoginTime;
import com.qcss.service.LoginService;
import com.qcss.util.Remassge;
import com.qcss.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;
    @Autowired
    LoginTimeDao loginTimeDao;

    public Remassge loginInfoSelect(Integer page, Integer limit,LoginInfo loginInfo){
        Remassge remassge = new Remassge();
        try {
            PageHelper.startPage(page, limit);
            List<LoginInfo> loginInfoList = loginDao.selectLoginInfo(loginInfo);
            for (int i = 0; i < loginInfoList.size(); i++) {
                loginInfoList.get(i).setTime(Time.toString(Long.valueOf(loginInfoList.get(i).getTime())));
            }
            PageInfo<LoginInfo> pageInfo = new PageInfo<>(loginInfoList);
            remassge.setMsg(1);
            remassge.setCount(pageInfo.getTotal());
            remassge.setData(pageInfo.getList());
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }

    //校验用户名和密码
    @Override
    public Remassge loginInfoCheck(LoginInfo loginInfo) {
        Remassge remassge = new Remassge();
        LoginInfo loginInfo1 = new LoginInfo();
        //现查询用户登录信息
        boolean isFind = false;
        try {
            loginInfo1 = loginDao.checkLoginInfo(loginInfo);
            if (loginInfo1 != null) {
                isFind = true;
                remassge.setData(loginInfo1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (isFind){
            //是否在登录时间范围
            try {
                LoginTime loginTime = new LoginTime();
                loginTime.setUserStatus(loginInfo1.getStatus());
                if (loginInfo1.getStatus() == 4){
                    remassge.setMsg(1);
                    return remassge;
                }
                List<LoginTime> loginTimes = loginTimeDao.selectLoginTime(loginTime);
                if (loginTimes.size() == 0){
                    remassge.setMsg(1);
                    return remassge;
                }
                loginTime = loginTimes.get(0);
                long stratTime = Long.valueOf(loginTime.getStartTime());
                long endTime;
                long nowTime;
                int howL = loginTime.getHowLong();
                switch(howL)
                {
                    case -1:
                        remassge.setMsg(3);
                        break;
                    case 99:
                        remassge.setMsg(1);
                        break;
                    default :
                        endTime = stratTime + 1000*60*60*60*24*howL;
                        nowTime = System.currentTimeMillis();
//                        System.out.println(stratTime+"-"+nowTime+"-"+endTime);
                        if (stratTime <= nowTime && nowTime <= endTime){
                            remassge.setMsg(1);
                        }else {
                            remassge.setMsg(3);
                        }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //用户登录信息错误
            remassge.setMsg(-1);
        }
        return remassge;
    }

    @Override
    public Remassge loginInfoInsert(LoginInfo loginInfo) {
        return null;
    }


    @Override
    public Remassge changePassword(LoginInfo loginInfo) {
        Remassge remassge = new Remassge();
        try {
            if (loginDao.checkLoginInfo(loginInfo) != null) {
//                System.out.println("可以执行修改密码！");
                loginDao.updateLoginInfo(loginInfo);
                remassge.setMsg(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge loginInfoResetPassword(LoginInfo loginInfo) {
        Remassge remassge = new Remassge();
        LoginInfo loginInfo1 = new LoginInfo();
        loginInfo1.setName(loginInfo.getName());
        loginInfo1.setNewPassword("123456");
        try {
            loginDao.updateLoginInfo(loginInfo1);
            remassge.setMsg(1);
        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }
}

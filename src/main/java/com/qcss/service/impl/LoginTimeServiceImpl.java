package com.qcss.service.impl;

import com.qcss.dao.LoginTimeDao;
import com.qcss.pojo.LoginTime;
import com.qcss.service.LoginTimeService;
import com.qcss.util.Remassge;
import com.qcss.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginTimeServiceImpl implements LoginTimeService {
    @Autowired
    LoginTimeDao loginTimeDao;
    @Override
    public Remassge loginTimeInsert(LoginTime loginTime) {
        Remassge remassge = new Remassge();
        try{

        }catch (Exception e){
            e.printStackTrace();
        }
        return remassge;
    }

    @Override
    public Remassge loginTimeSelect(LoginTime loginTime) {
        Remassge remassge = new Remassge();
        try {
            List<LoginTime> loginTimes = loginTimeDao.selectLoginTime(loginTime);
            LoginTime loginTime1 = new LoginTime();
            if (loginTimes.size() == 0){
                remassge.setMsg(-1);
                return remassge;
            }
            loginTime1 = loginTimes.get(0);
            loginTime1.setStartTime(Time.toString(Long.valueOf(loginTimes.get(0).getStartTime())));
            remassge.setData(loginTime1);
            remassge.setMsg(1);
            System.out.println(remassge.toString());
        }catch (Exception e){
            e.printStackTrace();
            remassge.setMsg(-1);
        }
        return remassge;
    }

    @Override
    public Remassge loginTimeSelectUsedIndex() {
        Remassge remassge = new Remassge();
        try {
            List<LoginTime> loginTimes = loginTimeDao.selectLoginTime(null);
            if (loginTimes.size() == 0){
                remassge.setMsg(-1);
                return remassge;
            }
            for (int i = 0; i < loginTimes.size(); i++) {
                loginTimes.get(i).setStartTime(Time.toString(Long.valueOf(loginTimes.get(i).getStartTime())));
            }
            System.out.println(loginTimes.toString());
            remassge.setData(loginTimes);
            remassge.setMsg(1);
        }catch (Exception e){
            e.printStackTrace();
            remassge.setMsg(-1);
        }
        return remassge;
    }

    @Override
    public Remassge loginTimeUpdate(LoginTime loginTime) {
        Remassge remassge = new Remassge();
        boolean flag = false;
        boolean isSelect = false;
        if (loginTime.getStartTime() == null || "".equals(loginTime.getStartTime())){
            loginTime.setStartTime(String.valueOf(System.currentTimeMillis()));
        }else{
            loginTime.setStartTime(String.valueOf(Time.timeToLong(loginTime.getStartTime())));
        }
//        System.out.println(loginTime.toString());
        //查看是否存在
        try{
            List<LoginTime> loginTimes = loginTimeDao.selectLoginTime(loginTime);
            if (loginTimes.size() != 0){
                flag = true;
            }
            isSelect = true;
        }catch (Exception e){
            e.printStackTrace();
            remassge.setMsg(-1);
        }
        if (isSelect){
            if (flag){
                //存在修改
                try {
                    loginTimeDao.updateLoginTime(loginTime);
                    remassge.setMsg(1);
                }catch (Exception e){
                    e.printStackTrace();
                    remassge.setMsg(-1);
                }
            }else{
                //不存在添加
                try {
                    loginTimeDao.insertLoginTime(loginTime);
                    remassge.setMsg(1);
                }catch (Exception e){
                    e.printStackTrace();
                    remassge.setMsg(-1);
                }
            }
        }
        return remassge;
    }
}

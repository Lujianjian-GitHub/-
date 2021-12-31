package com.qcss.pojo;

/**
 * 登录时的信息用户名、密码、权限、登录时间
 */
public class LoginInfo {
    private String name;
    private String password;
    private String newPassword;
    private Integer status;
    private String time;
    private String beforTime;

    @Override
    public String toString() {
        return "LoginInfo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", status=" + status +
                ", time='" + time + '\'' +
                ", beforTime='" + beforTime + '\'' +
                '}';
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public LoginInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBeforTime() {
        return beforTime;
    }

    public void setBeforTime(String beforTime) {
        this.beforTime = beforTime;
    }

}

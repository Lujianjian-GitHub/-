package com.qcss.pojo;

public class LoginTime {
    private String startTime;
    private Integer howLong;
    private Integer userStatus;

    @Override
    public String toString() {
        return "LoginTime{" +
                "startTime='" + startTime + '\'' +
                ", howLong=" + howLong +
                ", userStatus=" + userStatus +
                '}';
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Integer getHowLong() {
        return howLong;
    }

    public void setHowLong(Integer howLong) {
        this.howLong = howLong;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }
}

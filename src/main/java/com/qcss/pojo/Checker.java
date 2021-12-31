package com.qcss.pojo;

public class Checker {
    private String seriesId;
    private String seriesName;
    private String checkerId;
    private String checkerName;
    private Integer year;
    private Integer classId;
    private String sex;
    private String tel;
    private String adminId;
    private String adminName;
    private Integer checkerCount;

    @Override
    public String toString() {
        return "Checker{" +
                "seriesId='" + seriesId + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", checkerId='" + checkerId + '\'' +
                ", checkerName='" + checkerName + '\'' +
                ", year=" + year +
                ", classId=" + classId +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", checkerCount=" + checkerCount +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getCheckerCount() {
        return checkerCount;
    }

    public void setCheckerCount(Integer checkerCount) {
        this.checkerCount = checkerCount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}

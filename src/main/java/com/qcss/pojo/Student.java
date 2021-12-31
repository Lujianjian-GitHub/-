package com.qcss.pojo;

public class Student {
    private String seriesId;
    private String seriesName;
    private Integer year;
    private Integer classId;
    private String studentId;
    private String studentName;
    private String sex;
    private String tel;
    private String password;
    private String adminId;
    private String checkerId;
    private Integer noCheck;
    private Integer checkStatus;
    private Integer studentCount;

    @Override
    public String toString() {
        return "Student{" +
                "seriesId='" + seriesId + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", year=" + year +
                ", classId=" + classId +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", sex='" + sex + '\'' +
                ", tel='" + tel + '\'' +
                ", password='" + password + '\'' +
                ", adminId='" + adminId + '\'' +
                ", checkerId='" + checkerId + '\'' +
                ", noCheck=" + noCheck +
                ", checkStatus=" + checkStatus +
                ", studentCount=" + studentCount +
                '}';
    }

    public Integer getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }

    public Integer getNoCheck() {
        return noCheck;
    }

    public void setNoCheck(Integer noCheck) {
        this.noCheck = noCheck;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
}

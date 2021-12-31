package com.qcss.pojo;

public class ClassInfo {
    private Integer classId;
    private Integer year;
    private String seriesId;
    private String seriesName;
    private String adminId;
    private String adminName;
    private String checkerId;
    private String checkerName;

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", year=" + year +
                ", seriesId='" + seriesId + '\'' +
                ", seriesName='" + seriesName + '\'' +
                ", adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", checkerId='" + checkerId + '\'' +
                ", checkerName='" + checkerName + '\'' +
                '}';
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}

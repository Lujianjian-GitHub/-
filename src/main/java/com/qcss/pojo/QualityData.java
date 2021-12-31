package com.qcss.pojo;

public class QualityData {
    private Integer id;
    private String studentId;
    private Integer qualityId;
    private String description;
    private String filePath;
    private String bz;
    private String addTime;
    private Integer checkStatus;
    private Integer oneClass;
    private String twoClass;
    private String threeClass;
    private Integer level;
    private Integer grade;
    private Integer type;
    private Integer uploadType;
    private Integer sumData;
    private Integer countData;

    @Override
    public String toString() {
        return "QualityData{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", qualityId=" + qualityId +
                ", description='" + description + '\'' +
                ", filePath='" + filePath + '\'' +
                ", bz='" + bz + '\'' +
                ", addTime='" + addTime + '\'' +
                ", checkStatus=" + checkStatus +
                ", oneClass=" + oneClass +
                ", twoClass='" + twoClass + '\'' +
                ", threeClass='" + threeClass + '\'' +
                ", level=" + level +
                ", grade=" + grade +
                ", type=" + type +
                ", uploadType=" + uploadType +
                ", sumData=" + sumData +
                ", countData=" + countData +
                '}';
    }

    public Integer getSumData() {
        return sumData;
    }

    public void setSumData(Integer sumData) {
        this.sumData = sumData;
    }

    public Integer getCountData() {
        return countData;
    }

    public void setCountData(Integer countData) {
        this.countData = countData;
    }

    public Integer getUploadType() {
        return uploadType;
    }

    public void setUploadType(Integer uploadType) {
        this.uploadType = uploadType;
    }

    public Integer getOneClass() {
        return oneClass;
    }

    public void setOneClass(Integer oneClass) {
        this.oneClass = oneClass;
    }

    public String getTwoClass() {
        return twoClass;
    }

    public void setTwoClass(String twoClass) {
        this.twoClass = twoClass;
    }

    public String getThreeClass() {
        return threeClass;
    }

    public void setThreeClass(String threeClass) {
        this.threeClass = threeClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Integer getQualityId() {
        return qualityId;
    }

    public void setQualityId(Integer qualityId) {
        this.qualityId = qualityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

}

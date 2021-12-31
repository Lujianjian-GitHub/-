package com.qcss.pojo;

public class Quality {
    public Integer qualityId;
    public Integer oneClass;
    public String twoClass;
    public String threeClass;
    public Integer level;
    public Integer grade;
    public Integer type;
    public Integer mark;
    public Integer isDescription;
    public Integer uploadType;

    @Override
    public String toString() {
        return "Quality{" +
                "qualityId=" + qualityId +
                ", oneClass=" + oneClass +
                ", twoClass='" + twoClass + '\'' +
                ", threeClass='" + threeClass + '\'' +
                ", level=" + level +
                ", grade=" + grade +
                ", type=" + type +
                ", mark=" + mark +
                ", isDescription=" + isDescription +
                ", uploadType=" + uploadType +
                '}';
    }

    public Integer getUploadType() {
        return uploadType;
    }

    public void setUploadType(Integer uploadType) {
        this.uploadType = uploadType;
    }

    public Integer getIsDescription() {
        return isDescription;
    }

    public void setIsDescription(Integer isDescription) {
        this.isDescription = isDescription;
    }

    public Integer getQualityId() {
        return qualityId;
    }

    public void setQualityId(Integer qualityId) {
        this.qualityId = qualityId;
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

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }
}

package com.qcss.pojo;

/**
 * 院的基本信息
 */
public class Series {
    private String seriesId;
    private String name;
    private String description;
    private String addTime;
    private Integer seriesCount;

    @Override
    public String toString() {
        return "Series{" +
                "seriesId='" + seriesId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", addTime='" + addTime + '\'' +
                ", seriesCount=" + seriesCount +
                '}';
    }

    public Integer getSeriesCount() {
        return seriesCount;
    }

    public void setSeriesCount(Integer seriesCount) {
        this.seriesCount = seriesCount;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

}

package com.qcss.util;

public class InsertExcelInfo {
    private Integer all = 0;
    private Integer ok = 0;
    private Integer done = 0;

    @Override
    public String toString() {
        return "InsertExcelInfo{" +
                "all=" + all +
                ", ok=" + ok +
                ", done=" + done +
                '}';
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    public Integer getOk() {
        return ok;
    }

    public void setOk(Integer ok) {
        this.ok = ok;
    }

    public Integer getDone() {
        return done;
    }

    public void setDone(Integer done) {
        this.done = done;
    }
}

package com.qcss.util;

public class Remassge {
    private int status;//状态码
    private int code;
    private int msg;//信息
    private Object data;//数据
    private long count;

    @Override
    public String toString() {
        return "Remassge{" +
                "status=" + status +
                ", code=" + code +
                ", msg=" + msg +
                ", data=" + data +
                ", count=" + count +
                '}';
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getMsg() {
        return msg;
    }

    public void setMsg(int msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static Remassge text(){
        Remassge remassge = new Remassge();
        remassge.setMsg(200);
        return remassge;
    }
}

package com.zhouzhou.spring.pojo;

/**
 * @author 周万宁
 * @className Teacher
 * @create 2022/12/31-2:50
 * @description
 */
public class Teacher {
    private  Integer tid;
    private String tname;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Teacher(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teacher() {
    }
}

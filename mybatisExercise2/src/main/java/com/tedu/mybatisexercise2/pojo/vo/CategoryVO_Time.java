package com.tedu.mybatisexercise2.pojo.vo;


import java.util.Date;

public class CategoryVO_Time {
    private String name;
    private String intro;
    private Date created;

    @Override
    public String toString() {
        return "CategoryVO_Time{" +
                "name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", created=" + created +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

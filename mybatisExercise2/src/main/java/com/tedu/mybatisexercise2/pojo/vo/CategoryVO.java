package com.tedu.mybatisexercise2.pojo.vo;


public class CategoryVO {
    private String name;
    private String intro;

    @Override
    public String toString() {
        return "CategoryVO{" +
                "name='" + name + '\'' +
                ", intro='" + intro + '\'' +
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
}

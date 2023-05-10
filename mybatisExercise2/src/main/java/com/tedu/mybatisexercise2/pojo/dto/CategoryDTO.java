package com.tedu.mybatisexercise2.pojo.dto;


import java.util.Date;

public class CategoryDTO {
    private Integer id;
    private String name;
    private String intro;
    private Date created;

    public CategoryDTO() {

    }

    public CategoryDTO(String name, String intro, Date created) {
        this.name = name;
        this.intro = intro;
        this.created = created;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", intro='" + intro + '\'' +
                ", created=" + created +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

package cn.tedu.mybatisannotation.pojo;

import java.util.Date;

public class Weibo {
    private Integer id;
    private String content;
    private Date created;
    private Integer user_id;

    @Override
    public String toString() {
        return "Weibo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", user_id=" + user_id +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }


}

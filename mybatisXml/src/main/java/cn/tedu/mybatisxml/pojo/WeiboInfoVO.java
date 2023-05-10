package cn.tedu.mybatisxml.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WeiboInfoVO {
    //文章id 用戶暱稱 文章內容
    private Integer id;
    private String content;
    private String nickname;
    @JsonFormat(pattern = "yyyy-MM-dd")//自定義時間格式的註解大小寫固定
    private Date created;

    @Override
    public String toString() {
        return "WeiboInfoVO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", nickname='" + nickname + '\'' +
                ", created=" + created +
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}

package cn.tedu.weibo.pojo.vo;

public class WeiboIndexVO {
    private Integer id;
    private String nickname;
    private String content;

    @Override
    public String toString() {
        return "WeiboIndexVO{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

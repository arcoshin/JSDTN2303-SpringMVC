package cn.tedu.weibo.pojo.dto;


/**
 * 客戶寫什麼就傳什麼
 */
public class CommentDTO {
    private Integer weiboId;
    private String content;

    @Override
    public String toString() {
        return "CommentDTO{" +
                "weiboId=" + weiboId +
                ", content='" + content + '\'' +
                '}';
    }

    public Integer getWeiboId() {
        return weiboId;
    }

    public void setWeiboId(Integer weiboId) {
        this.weiboId = weiboId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

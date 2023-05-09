package cn.tedu.mybatisxml.pojo;

import java.util.Date;

/**
 * 數據庫查詢到的結果
 * 從服務器數據庫傳送到客戶端的數據可以封裝為VO
 *
 * 客戶瀏覽查詢到的資料時可以不用展示所有的字段
 */
public class WeiboVO {
    private String content;
    private Date created;
    private int uid;

    @Override
    public String toString() {
        return "WeiboVO{" +
                "content='" + content + '\'' +
                ", created=" + created +
                ", uid=" + uid +
                '}';
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

    public int getUidd() {
        return uid;
    }

    public void setUidd(int uidd) {
        this.uid = uidd;
    }
}

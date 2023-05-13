package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    /**
     * 文章詳情顯示評論詳情
     */
    List<CommentVO> selectByWeiboId(Integer id);

    /**
     * 添加一條評論
     */
    int insert(Comment comment);
}

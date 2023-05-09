package cn.tedu.mybatisxml.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
    /**
     * 添加一條評論
     */
    int insert(@Param("content") String content, @Param("uid") Integer uid, @Param("wid") Integer wid);

    /**
     * 根據id刪除評論
     */
//    int deleteById(@Param("id") Integer id);//其實非必須
    int deleteById(Integer id);

    /**
     * 根據評論id修改內容
     */
    int updateById(@Param("id") Integer id, @Param("content") String content);
}

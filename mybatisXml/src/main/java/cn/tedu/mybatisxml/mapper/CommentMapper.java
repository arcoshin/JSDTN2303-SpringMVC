package cn.tedu.mybatisxml.mapper;

import cn.tedu.mybatisxml.pojo.Comment;
import cn.tedu.mybatisxml.pojo.CommentInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;//其實非必要也能實現，但可以增加可讀性

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 添加一條評論
     */
    int insert(@Param("content") String content, @Param("uid") Integer uid, @Param("wid") Integer wid);
//    int insert(String content,Integer uid,Integer wid);

    /**
     * 根據id刪除評論
     */
//    int deleteById(@Param("id") Integer id);
    int deleteById(Integer id);

    /**
     * 根據評論id修改內容
     */
//    int updateById(@Param("id") Integer id, @Param("content") String content);
    int updateById(Integer id,String content);

    /**
     * 根據id數組參數刪除評論
     */
    int deleteByIdArray(Integer[] id);

    /**
     * 根據id集合參數刪除評論
     */
    int deleteByIdList(List id);

    /**
     * 根據可變參數刪除評論
     */
    int deleteByIds(Integer...ids);

    /**
     * 根據id動態修改數據
     */
    int dynamicUpdateById(Comment comment);

     /**
     * 展示評論
     */
    List<CommentInfoVO> commentInfo();
}

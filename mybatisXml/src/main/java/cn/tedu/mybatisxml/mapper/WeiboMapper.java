package cn.tedu.mybatisxml.mapper;

import cn.tedu.mybatisxml.pojo.Weibo;
import cn.tedu.mybatisxml.pojo.WeiboVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WeiboMapper {
    /**
     * 新增一條文章
     */
    int insert(Weibo weibo);

    /**
     * 通過id刪除文章
     */
    int deleteById(int id);

    /**
     * 通過id還有user_id刪除文章
     */
    int deleteByIdAndUser_id(int id,int definitionUid);

    /**
     * 透過id更新文章
     */
    int updateByID(Weibo weibo);

    /**
     * 查詢所有文章
     */
    List<Weibo> selectAll(Weibo weibo);

    /**
     * 透過id查詢某篇文章
     */
    WeiboVO selectById(int id);

    /**
     * 搜尋所有文章資訊
     */
    List<WeiboVO> selectByCol();

    /**
     * 搜尋id區間內的所有文章資訊
     */
    List<Weibo> selectByIdInterval(int min,int max);

    /**
     * 查詢文章總數
     */
    Integer selectCount();



}

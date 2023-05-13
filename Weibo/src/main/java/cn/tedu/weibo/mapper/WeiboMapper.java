package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.WeiboDetailVO;
import cn.tedu.weibo.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeiboMapper {
    /**
     * 發表一篇文章
     */
    int insert(Weibo weibo);

    /**
     * 文章列表
     */
    List<WeiboIndexVO> selectIndex();

    WeiboDetailVO selectById(int id);
}


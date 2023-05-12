package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.User;
import cn.tedu.weibo.pojo.vo.UserVO;

public interface UserMapper {
    /**
     * 根據用戶名查詢用戶訊息
     */
    UserVO selectByUsername(String username);

    /**
     * 新增一條用戶數據
     */
    int insert(User user);
}

package cn.tedu.mybatisxml.mapper;

import cn.tedu.mybatisxml.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper //必須添加此註解，Spring根據此接口創建對應的實現類
public interface UserMapper {
    /**
     * 新增一條用戶數據
     */
    int insert(User user);

    /**
     * 透過id刪除用戶
     */
    int deleteById(int id);

    /**
     * 查詢ID大於某個數的用戶資料
     */
    List<User> selectByIdInterval(int min,int max);
}

package cn.tedu.mybatisannotation.mapper;

import cn.tedu.mybatisannotation.pojo.User;
import cn.tedu.mybatisannotation.pojo.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //必須添加此註解，Spring根據此接口創建對應的實現類
public interface UserMapper {
    @Insert("INSERT INTO user VALUES(NULL,#{username},#{password},#{nickname},#{created})")
    int insert(User user);

    /**
     * 查詢ID大於某個數的用戶資料
     */
    @Select("SELECT username,password FROM user WHERE id>#{id}")
    List<UserVO> selectUser(int id);
}

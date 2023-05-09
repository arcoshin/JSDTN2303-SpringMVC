package cn.tedu.mybatisannotation.mapper;

import cn.tedu.mybatisannotation.pojo.Weibo;
import cn.tedu.mybatisannotation.pojo.WeiboVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("INSERT INTO weibo (id,content,created,user_id) VALUES(NULL,#{content},#{created},#{user_id})")
    int insert(Weibo weibo);

    @Delete("DELETE FROM weibo WHERE id=#{id}")
    int deleteWeiboById(int id);

    @Delete("DELETE FROM weibo WHERE id=#{id} AND user_id=#{user_id}")
    int deleteWeiboByIdAndUser_id(Weibo weibo);

    @Update("UPDATE weibo SET content=#{content},created=#{created},user_id=#{user_id} WHERE id=#{id}")
    int updateByID(Weibo weibo);

    @Select("SELECT * FROM weibo")
    List<Weibo> selectAll(Weibo weibo);

    @Select("SELECT * FROM weibo WHERE id=#{id}")
    Weibo selectById(int id);

    /**
     * UID為user_id的別名
     * 名稱或別名需與VO類中的屬性名稱一致才能正確傳入
     * @return
     */
    @Select("SELECT content,created,user_id as uid FROM weibo")
    List<WeiboVO> selectByCol();

}

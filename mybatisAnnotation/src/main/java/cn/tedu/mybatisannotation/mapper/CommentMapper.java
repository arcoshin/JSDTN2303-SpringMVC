package cn.tedu.mybatisannotation.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CommentMapper {
    /**
     * 添加一條評論
     *///..............................SQL語句->使用字段名
    @Insert("INSERT INTO comment (content,user_id,weibo_id) " +
//......................佔位符->使用類中參數名
            "VALUES(#{content},#{uid},#{wid})")
    int insert(
            /**
             * 參數標記是為了辨別傳入參數
             * 使用VLAUES中所指定的參數名
             */
            @Param("content") String content,
            @Param("uid") Integer uid,
            @Param("wid") Integer wid
    );

    /**
     * 根據評論id修改內容
     */
    @Update("UPDATE comment SET content = #{content} WHERE id = #{id}")
    int update(@Param("id") Integer id, @Param("content") String content);
}

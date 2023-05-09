package cn.tedu.mybatisannotation.mapper;

import cn.tedu.mybatisannotation.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {
    @Insert("INSERT INTO comment VALUES(NULL,#{content},#{created},#{uid},#{wid})")
    int insert(Comment comment);
}

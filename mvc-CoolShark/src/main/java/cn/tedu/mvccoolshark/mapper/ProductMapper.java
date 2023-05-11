package cn.tedu.mvccoolshark.mapper;

import cn.tedu.mvccoolshark.pojo.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    @Insert("INSERT INTO coolshark VALUES(NULL,#{title},#{price},#{num})")
    void insert(Product product);
}

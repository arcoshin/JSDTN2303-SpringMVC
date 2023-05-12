package cn.tedu.mvccoolshark.mapper;

import cn.tedu.mvccoolshark.pojo.entity.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface ProductMapper {
    /**
     * 插入一條商品數據
     */
    void insert(Product product);

    /**
     * 展示商品列表
     */
    List<Product> productList();

    /**
     * 刪除一個商品
     */
    @Delete("DELETE FROM product WHERE id=#{id}")
    void deleteProductById(int id);

    void updateProductById(Product product);
}

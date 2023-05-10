package cn.tedu.mybatisexercise.mapper;

import cn.tedu.mybatisexercise.pojo.entity.Order;
import cn.tedu.mybatisexercise.pojo.vo.OrderVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
     * 添加一條數據
     */
    @Insert("INSERT INTO orders VALUES(NULL,#{state},#{amount},#{created})")
    int insert(Order order);

    /**
     * 查詢所有訂單
     */
    @Select("SELECT state,amount,created FROM orders")
    List<Order> selectAll();

    /**
     * 通過id查詢訂單
     */
    @Select("SELECT id,state,amount,created FROM orders WHERE id=#{id}")
    Order selectOne(int id);

    /**
     * 通過id修改訂單
     */
    @Update("UPDATE orders SET state=#{state},amount=#{amount},created=#{created} WHERE id=#{id}")
    int updateOne(Order order);

    /**
     * 通過id刪除訂單
     */
    @Delete("DELETE FROM orders WHERE id=#{id}")
    int deleteById(int id);

    /**
     * 統計訂單總數
     */
    @Select("SELECT COUNT(*) FROM orders")
    int selectCount();

    /**
     * 訂單狀態與訂單金額一覽表
     */
    @Select("SELECT state,amount FROM orders")
    List<OrderVO> selectVO();
}

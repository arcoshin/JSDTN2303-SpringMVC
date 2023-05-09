package cn.tedu.mybatisexercise;

import cn.tedu.mybatisexercise.mapper.OrderMapper;
import cn.tedu.mybatisexercise.pojo.entity.Order;
import cn.tedu.mybatisexercise.pojo.vo.OrderVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class MybatisExerciseApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    /**
     * 驗證與數據庫是否正常連接
     */
    @Test
    void contextLoads() {
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
    }

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 添加一條數據
     */
    @Test
    void insert() {
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setCreated(new Date());
            order.setAmount(new Random().nextInt(100000) + 10000);
            order.setState("狀態" + i);

            orderMapper.insert(order);
        }
    }

    /**
     * 查詢所有訂單
     */
    @Test
    void selectAll() {
        List<Order> allList = orderMapper.selectAll();
        System.out.println(allList);
    }

    /**
     * 通過id查詢訂單
     */
    @Test
    void selectOne() {
        Order order = orderMapper.selectOne(55);
        System.out.println(order);
    }

    /**
     * 通過id修改訂單
     */
    @Test
    void updateOne() {
        Order order = new Order();
        order.setCreated(new Date());
        order.setAmount(998877);
        order.setState("狀態666666");
        order.setId(66);

        orderMapper.updateOne(order);
    }

    /**
     * 通過id刪除訂單
     */
    @Test
    void deleteById() {
        orderMapper.deleteById(99);
    }

    /**
     * 統計訂單總數
     */
    @Test
    void selectCount() {
        System.out.println(orderMapper.selectCount());
    }

    /**
     * 訂單狀態與訂單金額一覽表
     */
    @Test
    void selectVO() {
        List<OrderVO> orderVOList = orderMapper.selectVO();
        System.out.println(orderVOList);
    }


}

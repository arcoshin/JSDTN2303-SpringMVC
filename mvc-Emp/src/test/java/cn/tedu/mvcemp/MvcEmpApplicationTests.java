package cn.tedu.mvcemp;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;

@SpringBootTest
class MvcEmpApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    @Test
    void contextLoads() {
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
    }

}

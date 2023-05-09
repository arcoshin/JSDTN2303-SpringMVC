package cn.tedu.mybatisannotation;

import cn.tedu.mybatisannotation.mapper.CommentMapper;
import cn.tedu.mybatisannotation.mapper.UserMapper;
import cn.tedu.mybatisannotation.mapper.WeiboMapper;
import cn.tedu.mybatisannotation.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootTest
class MybatisannotationApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    //測試是否成功連接數據庫
    @Test
    void contextLoads() {
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("中文名稱");
        user.setPassword("123456");
        user.setNickname("中文暱稱");
        user.setCreated(new Date());

        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Autowired
    private WeiboMapper weiboMapper;

    @Test
    void insertWeibo() {
        Weibo weibo = new Weibo();
        weibo.setContent("中文內容");
        weibo.setCreated(new Date());
        weibo.setUser_id(new Random().nextInt(5 - 1) + 1);
        int insertWeibo = weiboMapper.insert(weibo);
        System.out.println(insertWeibo);
    }

    /**
     * 判斷條件為一個字段時，可以直接在方法中傳參
     *
     * @Delete("DELETE FROM weibo WHERE id=#{id}")
     * void deleteWeiboById(int id);
     */
    @Test
    void deleteWeiboById() {
        int dw = weiboMapper.deleteWeiboById(2);
        System.out.println(dw);
    }

    /**
     * 判斷條件為多個字段時，可以直接在方法中傳對象
     *
     * @Delete("DELETE FROM weibo WHERE id=#{id} AND user_id=#{user_id}")
     * int deleteWeiboByIdAndUser_id(Weibo weibo);
     */
    @Test
    void deleteWeiboByIdAndUser_id() {
        Weibo weibo = new Weibo();
        weibo.setId(3);
        weibo.setUser_id(2);
        System.out.println(weiboMapper.deleteWeiboByIdAndUser_id(weibo));
    }

    /**
     * 更新數據時可以將整個參數以對象作為媒介傳參
     */
    @Test
    void updateWeiboById() {
        Weibo weibo = new Weibo();
        weibo.setId(9);
        weibo.setContent("二次修改的中文內容");
        weibo.setCreated(new Date());
        weibo.setUser_id(99);

        int update = weiboMapper.updateByID(weibo);
        System.out.println(update);
    }

    /**
     * 查詢資料時也可以讓數據以對象的方式返回
     */
    @Test
    void selectAll() {
        Weibo weibo = new Weibo();
        List<Weibo> weiboList = weiboMapper.selectAll(weibo);
        System.out.println(weiboList);
    }

    @Test
    void selectById() {
        Weibo weibo = weiboMapper.selectById(8);
        System.out.println(weibo);
    }


    /**
     * 查詢指定字段的數據
     */
    @Test
    void selectByCol() {
        List<WeiboVO> weiboList = weiboMapper.selectByCol();
        System.out.println(weiboList);
    }


    /**
     * 查詢id大於20的用戶名與密碼
     */
    @Test
    void selectWeiboById() {
        List<UserVO> userVoList = userMapper.selectUser(20);
        System.out.println(userVoList);
    }

    @Autowired
    private CommentMapper commentMapper;

    @Test
    void insertComment() {
        Comment comment = new Comment();
        comment.setContent("中文評論");
        comment.setCreated(new Date());
        comment.setUid(9999);
        comment.setWid(8888);
        int insert = commentMapper.insert(comment);
        System.out.println(insert);
    }


}

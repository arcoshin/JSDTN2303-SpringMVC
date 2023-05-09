package cn.tedu.mybatisxml;

import cn.tedu.mybatisxml.mapper.CommentMapper;
import cn.tedu.mybatisxml.mapper.UserMapper;
import cn.tedu.mybatisxml.mapper.WeiboMapper;
import cn.tedu.mybatisxml.pojo.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MybatisxmlApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    //測試是否成功連接數據庫
    @Test
    void contextLoads() {
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
    }

    /**==============================
     *     自動裝配 UserMapper
     ==============================*/

    @Autowired
    private UserMapper userMapper;

    /**
     * 新增一個用戶
     */
    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("透過xml新增用戶");
        user.setPassword("123456");
        user.setNickname("中文暱稱");
        user.setCreated(new Date());

        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

    /**
     * 透過id刪除一個用戶
     */
    @Test
    void deleteById(){
        int i = userMapper.deleteById(29);
    }

    /**
     * 查詢id大於20的用戶名與密碼
     */
    @Test
    void selectUserByIdInterval() {
        List<User> userList = userMapper.selectByIdInterval(20,99);
        System.out.println(userList);
    }

    /**==============================
     *     自動裝配 WeiboMapper
     ==============================*/
    @Autowired
    private WeiboMapper weiboMapper;

    /**
     * 新增一篇文章
     */
    @Test
    void insertWeibo() {
        Weibo weibo = new Weibo();
        weibo.setContent("中文內容");
        weibo.setCreated(new Date());
        weibo.setUser_id(9999);
        int insertWeibo = weiboMapper.insert(weibo);
        System.out.println(insertWeibo);
    }

    /**
     * 透過id刪除一篇文章
     */
    @Test
    void deleteWeiboById() {
        int dw = weiboMapper.deleteById(28);
        System.out.println(dw);
    }

    /**
     * 透過多條件刪除一篇文章
     */
    @Test
    void deleteWeiboByIdAndUser_id() {
        weiboMapper.deleteByIdAndUser_id(29,9999);
    }

    /**
     * 藉由id更新文章
     */
    @Test
    void updateById() {
        Weibo weibo = new Weibo();
        weibo.setId(30);
        weibo.setContent("二次修改的中文內容999999");
        weibo.setCreated(new Date());
        weibo.setUser_id(999999);

        int update = weiboMapper.updateByID(weibo);
        System.out.println(update);
    }

    /**
     * 查詢所有文章
     */
    @Test
    void selectAll() {
        Weibo weibo = new Weibo();
        List<Weibo> weiboList = weiboMapper.selectAll(weibo);
        System.out.println(weiboList);
    }

    /**
     * 藉由id搜尋文章
     */
    @Test
    void selectById() {
        WeiboVO weiboVO = weiboMapper.selectById(8);
        System.out.println(weiboVO);
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
     * 查詢id區間內的所有文章
     */
    @Test
    void selectWeiboByIdInterval(){
        List<Weibo> wriboList = weiboMapper.selectByIdInterval(2, 25);
        System.out.println(wriboList);
    }

    /**
     * 查詢文章總數
     */
    @Test
    void selectCount(){
        Integer count = weiboMapper.selectCount();
        System.out.println(count);
    }


    /**==============================
     *     自動裝配 CommentMapper
     ==============================*/
    @Autowired
    private CommentMapper commentMapper;

    @Test
    void insertComment() {
            int insert = commentMapper.insert("一條中文內容by xml", 222, 777);
            System.out.println(insert);
    }

    @Test
    void deleteComment(){
        int i = commentMapper.deleteById(3);
        System.out.println(i);
    }

    @Test
    void updateComment() {
        int update = commentMapper.updateById(2, "一條修改過的中文內容by xml");
        System.out.println(update);
    }




}

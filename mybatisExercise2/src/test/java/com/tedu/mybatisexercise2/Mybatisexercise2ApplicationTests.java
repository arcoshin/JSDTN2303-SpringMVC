package com.tedu.mybatisexercise2;

import com.tedu.mybatisexercise2.mapper.CategoryMapper;
import com.tedu.mybatisexercise2.pojo.dto.CategoryDTO;
import com.tedu.mybatisexercise2.pojo.entity.Category;
import com.tedu.mybatisexercise2.pojo.vo.CategoryVO;
import com.tedu.mybatisexercise2.pojo.vo.CategoryVO_Time;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class Mybatisexercise2ApplicationTests {
    @Autowired
    private SqlSession sqlSession;

    @Test
    void contextLoads() {
        Connection connection = sqlSession.getConnection();
        System.out.println(connection);
    }

    /**
     * ==========
     * 自動裝配
     * ==========
     */
    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 創建一個分類
     */
    @Test
    void createCategory() {
            CategoryDTO categoryDTO = new CategoryDTO("待刪除類", "等你示範", new Date());
            categoryMapper.createCategory(categoryDTO);
    }

    /**
     * 查詢所有分類
     */
    @Test
    void selectAllCategory() {
        List<CategoryVO_Time> categoryVOTimeList = categoryMapper.selectAllCategory();
        System.out.println(categoryVOTimeList);
    }

    /**
     * 透過id查詢分類
     */
    @Test
    void selectById() {
        CategoryVO_Time categoryVO_time = categoryMapper.selectById(5);
        System.out.println(categoryVO_time);
    }

    /**
     * 透過id修改描述
     */
    @Test
    void updateIntroById() {
        categoryMapper.updateIntroById(10, "我就爛，不可回收");
    }

    /**
     * 統計分類總數
     */
    @Test
    void selectCount() {
        int count = categoryMapper.selectCount();
        System.out.println(count);
    }

    /**
     * 查詢所有分類的名稱與描述
     */
    @Test
    void selectAllNameAndIntro() {
        List<CategoryVO> categoryVOList = categoryMapper.selectAllNameAndIntro();
        System.out.println(categoryVOList);
    }

    /**
     * 透過id數組批量刪除分類
     */
    @Test
    void deleteByIdArray() {
        Integer[] ids = {12, 13, 14};
        categoryMapper.deleteByIdArray(ids);
    }

    /**
     * 透過id集合批量刪除分類
     */
    @Test
    void deleteByIdList() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(16);
        categoryMapper.deleteByIdList(list);
    }

    /**
     * 透過可變參數批量刪除分類
     */
    @Test
    void deleteByIds() {
        categoryMapper.deleteByIds(16,17,18,19);
    }

    /**
     * 動態修改分類
     */
    @Test
    void dynamicUpdateCategoryById(){
        Category category = new Category();
        category.setId(3);
        category.setName("廚具類");
//        category.setIntro("廚房各種小東西");
//        category.setCreated(new Date());
        categoryMapper.dynamicUpdateCategoryById(category);
    }
}

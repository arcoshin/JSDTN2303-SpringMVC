package com.tedu.mybatisexercise2.mapper;

import com.tedu.mybatisexercise2.pojo.dto.CategoryDTO;
import com.tedu.mybatisexercise2.pojo.entity.Category;
import com.tedu.mybatisexercise2.pojo.vo.CategoryVO;
import com.tedu.mybatisexercise2.pojo.vo.CategoryVO_Time;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    /**
     * 創建一個分類
     */
    int createCategory(CategoryDTO categoryDTO);

    /**
     * 查詢所有分類
     */
    List<CategoryVO_Time> selectAllCategory();

    /**
     * 通過id查詢分類
     */
    CategoryVO_Time selectById(int id);

    /**
     * 透過id修改描述
     */
    int updateIntroById(int id, String intro);

    /**
     * 統計分類總數
     */
    int selectCount();

    /**
     * 查詢所有分類的名稱與描述
     */
    List<CategoryVO> selectAllNameAndIntro();

    /**
     * 透過id數組批量刪除分類
     */
    Integer deleteByIdArray(Integer[] ids);

    /**
     * 透過id集合批量刪除分類
     */
    Integer deleteByIdList(List<Integer> list);

    /**
     * 透過可變參數批量刪除分類
     */
    Integer deleteByIds(Integer... ids);

    /**
     * 透過id動態修改數據
     */
    int dynamicUpdateCategoryById(Category category);
}

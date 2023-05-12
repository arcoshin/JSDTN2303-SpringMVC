package cn.tedu.mvcemp.mapper;

import cn.tedu.mvcemp.pojo.entity.Emp;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

public interface EmpMapper {
    /**
     * 增
     */
    void insert(Emp emp);

    /**
     * 查
     */
    List<Emp> select();

    /**
     * 刪
     */
    @Delete("DELETE FROM emp WHERE id=#{id}")
    void delete(int id);

    /**
     * 改
     */
    void update(Emp emp);

}

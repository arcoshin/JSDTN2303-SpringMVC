package cn.tedu.mvcaddress.mapper;

import cn.tedu.mvcaddress.pojo.entity.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressMapper {

    void insert(Address address);

    @Select("SELECT * FROM address")
    List<Address> select();

    @Delete("DELETE FROM address WHERE id=#{id}")
    void delete(Integer id);

    void update(Address address);
}

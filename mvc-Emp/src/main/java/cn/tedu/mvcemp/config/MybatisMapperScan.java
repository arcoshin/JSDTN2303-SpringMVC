package cn.tedu.mvcemp.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.mvcemp.mapper")
public class MybatisMapperScan {

}

package cn.tedu.mvcaddress.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cn.tedu.mvcaddress.mapper")
public class MybatisMapperScan {
}

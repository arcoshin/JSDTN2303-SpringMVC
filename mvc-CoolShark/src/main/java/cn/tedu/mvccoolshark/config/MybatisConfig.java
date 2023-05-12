package cn.tedu.mvccoolshark.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自動將mapper目錄中的所有接口添加@Mapper註解的配置文件類
 */
//添加註解使之成為配置類，工程啟動時會自動加載
@Configuration
//添加掃描器，設置掃描範圍
@MapperScan("cn.tedu.mvccoolshark.mapper")
public class MybatisConfig {
}

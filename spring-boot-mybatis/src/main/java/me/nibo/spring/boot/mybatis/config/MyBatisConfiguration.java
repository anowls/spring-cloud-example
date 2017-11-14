package me.nibo.spring.boot.mybatis.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author NiBo
 */
@Configuration
//@MapperScan("me.nibo.spring.boot.mybatis.mapper")
public class MyBatisConfiguration {

//    @Bean
//    public MapperScannerConfigurer mapperScannerConfigurer() {
//
//        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
//        mapperScannerConfigurer.setBasePackage("me.nibo.spring.boot.mybatis.mapper");
//        Properties propertiesMapper = new Properties();

//        // MySQL
////        propertiesMapper.setProperty("IDENTITY","SELECT REPLACE(UUID(),\"-\",\"\")");
//        // Oracle
//        propertiesMapper.setProperty("IDENTITY","SELECT SYS_GUID()");

////        propertiesMapper.setProperty("IDENTITY","SELECT UUID()");
////        propertiesMapper.setProperty("ORDER","BEFORE");
//        mapperScannerConfigurer.setProperties(propertiesMapper);
//        return mapperScannerConfigurer;
//    }

    
}

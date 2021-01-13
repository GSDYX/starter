package com.gsdyx.starter.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.MybatisMapWrapperFactory;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置分页插件
 *
 * @author ZJQ
 * @date 2020/10/19 16:15
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");

        return page;
    }


    /**
    * 返回map转驼峰
    * @Param:
    */
    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer(){
        return configuration -> configuration.setObjectWrapperFactory(new MybatisMapWrapperFactory());
    }
}

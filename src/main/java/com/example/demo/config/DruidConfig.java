package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

  
    /**  
    * @ClassName: DruidConfig  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */  
    
@Configuration //标识该类被纳入spring容器中实例化并管理
@ServletComponentScan //用来扫描所有的servlet 、 filter 、 listener
public class DruidConfig {

	@Bean
	@ConfigurationProperties(prefix="spring.datasource.druid") //加载时读取指定的配置信息 并且以 spring.datasource.druid 开头的配置信息
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
	
}

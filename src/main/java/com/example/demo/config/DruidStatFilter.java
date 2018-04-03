package com.example.demo.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;

  
    /**  
    * @ClassName: DruidStatFilter  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */  
    
@WebFilter(
			filterName="druidWebStatFilter" , 
			urlPatterns= {"/*"} , 
			initParams= {
					@WebInitParam(name="exclusions" , value="*.js,*.jpg,*.png,*.gif,*.ico,*.css,/druid/*") //配置本过滤器放行的请求后缀
			}
		)
public class DruidStatFilter extends 
WebStatFilter
//StatViewFilter 
{

}

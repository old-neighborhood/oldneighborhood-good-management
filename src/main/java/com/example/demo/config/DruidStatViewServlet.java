package com.example.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

  
    /**  
    * @ClassName: DruidStatViewServlet  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */  
    
@WebServlet(
			urlPatterns= {"/druid/*"} , 
			initParams = {
					@WebInitParam(name="allow" , value="127.0.0.1") ,
//					@WebInitParam(name="deny" , value="") ,
					@WebInitParam(name="loginUsername" , value="pc") , 
					@WebInitParam(name="loginPassword" , value="123") , 
					@WebInitParam(name="resetEnable" , value="true")
			}
		)
public class DruidStatViewServlet extends StatViewServlet {
	private static final long serialVersionUID = 1L;

}

  
    /**    
    * @Title: GoodService.java  
    * @Package com.example.demo.service  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年4月2日  
    * @version V1.0    
    */  
    
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Good;

/**  
    * @ClassName: GoodService  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年4月2日  
    *    
    */

public interface GoodService {
	public void addGood(Good good); 
	
	public void delGood(String g_ID);
	
	public List<Good> getGoods(String m_ID);
	
	public Good getGood(String g_ID);
	
	public void modGood(
			String g_name,
			String g_price,
			String g_amount,
			String g_intro,
			String g_ID
			);

	public String getG_ID();
}

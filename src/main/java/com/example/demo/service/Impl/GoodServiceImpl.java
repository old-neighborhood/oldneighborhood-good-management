  
    /**    
    * @Title: GoodServiceImpl.java  
    * @Package com.example.demo.service.Impl  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年4月2日  
    * @version V1.0    
    */  
    
package com.example.demo.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodDao;
import com.example.demo.entity.Good;
import com.example.demo.service.GoodService;

/**  
    * @ClassName: GoodServiceImpl  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年4月2日  
    *    
    */
@Service("GoodService")
public class GoodServiceImpl implements GoodService{
	@Resource
	private GoodDao goodDao;
	@Override
	public void addGood(Good good) {
		goodDao.save(good);
	}

	@Override
	public void delGood(String g_ID) {
		goodDao.delete(g_ID);
	}

	@Override
	public List<Good> getGoods(String m_ID) {
		
		return goodDao.findByM_ID(m_ID);
	}

	@Override
	public Good getGood(String g_ID) {
		return goodDao.findOne(g_ID);
	}

	@Override
	public void modGood(String g_name, String g_price, String g_amount, String g_intro, String g_ID) {
		goodDao.update(g_name,g_price,g_amount,g_intro,g_ID);
	}

	@Override
	public String getG_ID() {
		return goodDao.getG_ID();
	}

}

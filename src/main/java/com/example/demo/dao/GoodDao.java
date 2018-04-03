  
    /**    
    * @Title: GoodDao.java  
    * @Package com.example.demo.dao  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年4月2日  
    * @version V1.0    
    */  
    
package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Good;

/**  
    * @ClassName: GoodDao  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年4月2日  
    *    
    */

public interface GoodDao extends JpaRepository<Good, String> {
	@Query(value="select g_ID, g_name, m_ID, g_image, g_price, g_amount,g_type,g_intro,g_date"
			+ " from good where m_ID=? order by g_date desc" , nativeQuery=true)
	List<Good> findByM_ID(String m_ID);

	@Transactional
	@Modifying
	@Query(value="update good as g set g.g_name=?,g.g_price=?,g.g_amount=?,g.g_intro=? where g.g_ID=?" ,
			nativeQuery=true)
	void update(String g_name, String g_price, String g_amount, String g_intro, String g_ID);

	@Query(value="select g_ID "
			+ " from good order by g_date desc limit 1" , nativeQuery=true)
	String getG_ID();

}

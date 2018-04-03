  
    /**    
    * @Title: Good.java  
    * @Package com.example.demo.entity  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年4月2日  
    * @version V1.0    
    */  
    
package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


/**  
    * @ClassName: Good  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年4月2日  
    *    
    */
@Entity
@Table(name="good")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Good implements Serializable{

	  
	    /**  
	    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	    */  
	    
	private static final long serialVersionUID = -1061920194885226859L;
	  
		    /**  
		     * 创建一个新的实例 Good.  
		     *  
		     * @param g_ID
		     * @param g_name
		     * @param m_ID
		     * @param g_price
		     * @param g_amount
		     * @param g_image
		     * @param g_type
		     * @param g_intro
		     * @param g_date  
		     */  
		    
		
	@Id
	@NonNull
	private String g_ID;
	@NonNull
	private String g_name;
	@NonNull
	private String m_ID;
	@NonNull
	private String g_price;
	@NonNull
	private String g_amount;
	private String g_image;
	@NonNull
	private String g_type;
	private String g_intro;
	@Column(columnDefinition = "timestamp not null default now()", updatable = false)
	private Timestamp g_date;
	  
	    /**  
	     * 创建一个新的实例 Good.  
	     *  
	     * @param g_ID
	     * @param g_name
	     * @param m_ID
	     * @param g_price
	     * @param g_amount
	     * @param g_image
	     * @param g_type
	     * @param g_intro  
	     */  
	    
	public Good(String g_ID, String g_name, String m_ID, String g_price, String g_amount, String g_image, String g_type,
			String g_intro) {
		super();
		this.g_ID = g_ID;
		this.g_name = g_name;
		this.m_ID = m_ID;
		this.g_price = g_price;
		this.g_amount = g_amount;
		this.g_image = g_image;
		this.g_type = g_type;
		this.g_intro = g_intro;
	}
	
	
}

  
    /**    
    * @Title: GoodController.java  
    * @Package com.example.demo.controller  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年4月2日  
    * @version V1.0    
    */  
    
package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Good;
import com.example.demo.service.GoodService;

import sun.misc.BASE64Decoder;

/**  
    * @ClassName: GoodController  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年4月2日  
    *    
    */
@SuppressWarnings("restriction")
@Controller
public class GoodController {
	@Resource
	private GoodService goodService;
	private String g_ID="";
	@RequestMapping("/")
	@ResponseBody
	public String test1() {
		return "/GoodList";
	}
	@RequestMapping("/getM_ID")
	@ResponseBody
	public String getG_ID() {
		return g_ID;
	}
	@RequestMapping("/setG_ID")
	@ResponseBody
	public String setG_ID(String g_ID) {
		this.g_ID = g_ID;
		System.out.println(g_ID);
		return "{\"result\":\"success\"}";
	}
	@RequestMapping("/getGood")
	@ResponseBody
	public Good getGood() {
		
		return goodService.getGood(g_ID);
	}
	
	@RequestMapping("/getGoods")
	@ResponseBody
	public List<Good> getGoodList(String m_ID){
		List<Good> goods = goodService.getGoods(m_ID);
		return goods;
	}
	
	@RequestMapping("/modifyGood")
	@ResponseBody
	public String modifyGood(@RequestBody Map<String,Object> reqMap) {
		System.out.println(reqMap.get("g_name").toString()+" "+
				reqMap.get("g_price").toString()+" "+
				reqMap.get("g_amount").toString()+" "+
				reqMap.get("g_intro").toString()+" "+
				g_ID);
		goodService.modGood(
				reqMap.get("g_name").toString(),
				reqMap.get("g_price").toString(),
				reqMap.get("g_amount").toString(),
				reqMap.get("g_intro").toString(),
				g_ID
				);
		
		if(reqMap.get("g_image")!=null&&reqMap.get("g_image").toString().length()>1000) {
			String imgStr = reqMap.get("g_image").toString();
			System.out.println("base64:"+imgStr);
			String path = "C:\\pc\\workspace\\oldneighborhood-validate\\src\\main\\resources\\img\\good\\"+g_ID+".jpg";
			imgStr = imgStr.replaceAll("data:image/jpeg;base64,", ""); 
			BASE64Decoder decoder = new BASE64Decoder();
			try {
				byte[] b = decoder.decodeBuffer(imgStr);
				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {
						b[i] += 256;
					}
				}
				System.out.println(path);
				 File imageFile = new File(path);
		            imageFile.createNewFile();
		               if(!imageFile.exists()){
		                   imageFile.createNewFile();
		                }
		                OutputStream imageStream = new FileOutputStream(imageFile);
		                imageStream.write(b);
		                imageStream.flush();
		                imageStream.close();           
				} catch (Exception e) {
				}
			}
		
		return "{\"result\":\"success\"}";
	}
	
	@RequestMapping("/addGood")
	@ResponseBody
	public String addGood(@RequestBody Map<String,Object> reqMap) {
		//System.out.println(key);
		String m_ID = goodService.getG_ID();
		m_ID = m_ID.replace("GD","");
		int num = Integer.parseInt(m_ID);
		num++;
		String ID = "GD"; 
		for(int i=String.valueOf(num).length();i<8;i++) {
			ID+="0";
		}
		ID+=num;
		System.out.println(reqMap.get("g_image").toString());
		
		String imgStr = reqMap.get("g_image").toString();
		System.out.println("base64:"+imgStr);
		String path = "C:\\pc\\workspace\\oldneighborhood-validate\\src\\main\\resources\\img\\good\\"+ID+".jpg";
		imgStr = imgStr.replaceAll("data:image/jpeg;base64,", ""); 
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			System.out.println(path);
			 File imageFile = new File(path);
	            imageFile.createNewFile();
	               if(!imageFile.exists()){
	                   imageFile.createNewFile();
	                }
	                OutputStream imageStream = new FileOutputStream(imageFile);
	                imageStream.write(b);
	                imageStream.flush();
	                imageStream.close();           
			} catch (Exception e) {
			}
		
		Good good = new Good(
				ID,
				reqMap.get("g_name").toString(),
				reqMap.get("m_ID").toString(),
				reqMap.get("g_price").toString(),
				reqMap.get("g_amount").toString(),
				"/good/"+ID+".jpg",
				reqMap.get("g_type").toString(),
				reqMap.get("g_intro").toString()
				);
		goodService.addGood(good);
		return "{\"result\":\"success\"}";
	}
	@RequestMapping("/deleteGood")
	@ResponseBody
	public String deleteGood() {
		System.out.println(g_ID);
		goodService.delGood(g_ID);
		return "{\"result\":\"success\"}";
	}
}

package com.example.demo.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages= {"com.example.demo.controller"})
public class JsonpConfig extends AbstractJsonpResponseBodyAdvice{

	public JsonpConfig() {
		super("callback" , "jsonp") ;
		System.out.println("-----");
	}
	
}

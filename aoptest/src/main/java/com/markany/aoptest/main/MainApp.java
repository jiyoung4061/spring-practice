package com.markany.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.markany.aoptest.service.ProductService;
import com.markany.aoptest.vo.ProductVo;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/config/applicationContext.xml");
		
		ProductService ps = ac.getBean(ProductService.class);
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
		
		((ConfigurableApplicationContext)ac).close(); // 자원정리(ApplicationContext의 부모 클래스에 close가 정의되어있어서 casting한 후 자원정리해줌)
	}

}

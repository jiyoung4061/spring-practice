package com.markany.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
public class MainController {
	
//	// container 생성
//	public void init() throws ServletException{
//		new XMLPathApplicationContext(ServletName + "-context.xml"); // continer이름 설정을 안했으면 web.xml에 설정한 서블릿 이름으로 
//		//설정했으면 그 이름을 parameter값으로
//	}
	
	@ResponseBody
	@RequestMapping({"", "/main"}) // url을 여러개 주고싶을떄!
	public String main() {
		return "MainController:main";
	}
}

package com.markany.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	// RequestMapping annotation : dispatcher가 backend controller로 넘겨주는 설정
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	@RequestMapping("/hello2")
	public String hello2(String name) { // request.parameter 처리하기
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello.jsp");
		
		return mav;
	}
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello.jsp";
	}
	@RequestMapping("/hello5")
	@ResponseBody // return 타입이 메세지라는 뜻/
	public String hello5(String name) {
		return "hello " +name;
	}
}

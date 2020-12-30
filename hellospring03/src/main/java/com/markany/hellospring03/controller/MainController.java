package com.markany.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
	@ResponseBody
	@RequestMapping({"", "/main"}) // url을 여러개 주고싶을떄!
	public String main() {
		return "MainController:main";
	}
}
package com.markany.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Jiyoung
 * 
 * @RequestMapping 예제
 * Method(Handler) 단독 맵핑
 * Class 단독 맵핑
 *  
 */

@Controller
@RequestMapping("/guestbook/*")
public class GuestBookController {
	
	@ResponseBody
	@RequestMapping
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "GuestbookController:delete";
	}
}

package com.markany.hellospring.controller;

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
@RequestMapping("/guestbook")
public class GuestBookController {
	
	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete() {
		return "GuestbookController:delete";
	}
}

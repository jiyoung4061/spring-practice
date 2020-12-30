package com.markany.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.markany.hellospring03.vo.UserVo;

/*
 * @author bit
 * 
 *  @RequestMapping 예제
 *  Class + Method(Handler) 맵핑
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	public String join(String name, String email, String password) {
	public String join(UserVo vo) {
		System.out.println("UserController:join>" + vo);
		return "redirect:/"; // path 설정할 때, hellospring03하면X
	}

	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value = "n") String name) { // parameter의 이름과 프로그램에서 이름이 다를경우
		/*
		 * n 파라미터 값이 전달되지 않으면 400 Bad Request 오류 발생
		 */
		System.out.println("--->" + name + "<---");
		return "UserController:update";
	}

	@ResponseBody
	@RequestMapping("/update2")
	public String update2(
			@RequestParam(value = "n", required = true, defaultValue = "entername") String name,
			@RequestParam(value = "a", required = true, defaultValue = "0") int age) {
		// require : n파라미터값이 필수로 들어가야함(false일 경우엔 없어도 오류X)
		// defaultVale : n파라미터 값이 없을 경우 초기값 설정
		System.out.println("--->" + name + "<------>" + age + "<---");
		return "UserController:update";
	}
}

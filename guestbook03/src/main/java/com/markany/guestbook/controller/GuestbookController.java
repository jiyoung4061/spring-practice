package com.markany.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.markany.guestbook.repository.GuestBookRepository;
import com.markany.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController{
	
	@Autowired
	private GuestBookRepository guestbookRepository;
	
	public GuestbookController() {
		guestbookRepository = new GuestBookRepository();
	}
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestBookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		model.addAttribute("newLine", "\n");
		return "index";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(GuestBookVo vo) {
		guestbookRepository.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete() {
		return "delete";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(GuestBookVo vo) {
		guestbookRepository.delete(vo);
		return "redirect:/";
	}
}

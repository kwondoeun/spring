package com.simple.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.command.Quiz01VO;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	//1번 문제
	@RequestMapping("/quiz01")
	public String quiz01() {
		return "quiz/quiz01";
	}
	
	@RequestMapping("/sendBirth")
	public String sendBirth(@ModelAttribute("article") Quiz01VO vo) {
		
		System.out.println(vo.toString());
		
		return "quiz/quiz01_ok";
	}
	//2번 문제
	@RequestMapping("/quiz02")
	public String quiz02() {
		return "quiz/quiz02";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("id") String id,
					   @ModelAttribute("pw") String pw,
					   @ModelAttribute("name") String name,
					   @ModelAttribute("email") String email) {
		
		return "quiz/quiz02_ok";
	}
	//3번 문제
	@RequestMapping("/quiz03")
	public String quiz03() {
		return "quiz/quiz03";
	}
	
	@RequestMapping(value = "/join2", method=RequestMethod.POST)
	public String join2(@RequestParam("id") String id,
						@RequestParam("pw") String pw,
						@RequestParam("pw_check") String pw_check,
						RedirectAttributes ra) {
		
		if(id.equals("")) {
			
			ra.addFlashAttribute("msg", "아이디를 확인하세요");
			return "redirect:/quiz/quiz03";
			
		} else if (!pw.equals(pw_check)) {
			
			ra.addFlashAttribute("msg", "비밀번호를 확인하세요");
			return "redirect:/quiz/quiz03";
			
		} else {
			return "quiz/quiz03_ok";
		}
		
		
	}
	
	

}

package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.command.ScoreVO;
import com.simple.score.service.ScoreService;
import com.simple.score.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {
	
	//1st
	//ScoreServiceImpl service = new ScoreServiceImpl();
	
	//2nd - 서비스를 bean으로 생성한다. 의존객체 자동주입
	
	//3nd - @Service로 빈으로 생성하고, 의존객체 자동주입
	@Autowired//이름을 찾다가 없으면 타입찾음
	@Qualifier("xxx")
	private ScoreService service; //인터페이스 타입 선언, 구현체가 만들어지고 호출되면 오버라이딩된게 실행되기 때문 결과는 동일
	
	//화면출력
	@RequestMapping("/scoreRegist")
	public String registView() {
		return "service/scoreRegist";
	}
	
	//폼요청
	@RequestMapping(value ="/regist", method=RequestMethod.POST)
	public String regist(ScoreVO vo) {
		//System.out.println(vo.toString());
		
		service.regist(vo); //멤버변수를 통해 호출
		
		return "service/scoreResult";
	}
	
	//목록화면(으로 데이터 들고 나올수 있음)
	@RequestMapping("/scoreList")
	public String scoreList(Model model) {
		
		//data조회
		ArrayList<ScoreVO> list = service.getList();
		model.addAttribute("list", list);
		
		System.out.println(list.toString());
		
		return "service/scoreList";
	}
	
	//삭제요청
	@RequestMapping("/delete")
	public String delete(@RequestParam("num") int num) {
		
		service.delete(num);
		
		return "redirect:/service/scoreList"; //삭제후에 목록으로
	}
	

}

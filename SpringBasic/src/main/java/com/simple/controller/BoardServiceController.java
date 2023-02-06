package com.simple.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.board.service.BoardService;
import com.simple.command.BoardVO;

@Controller
@RequestMapping("/service")
public class BoardServiceController {
	
	@Autowired
	@Qualifier("board")
	private BoardService service;
	
	//화면출력
	@RequestMapping("/boardRegister")
	public String registView() {
		return "service/boardRegister";
	}
	
	//폼요청
	@RequestMapping(value ="/register", method=RequestMethod.POST)
	public String register(BoardVO vo) {
		//System.out.println(vo.toString());
		service.boardRegist(vo);
		
		return "service/boardResult";
	}
	
	@RequestMapping("/boardList")
	public String  boardList(Model model) {
		
		ArrayList<BoardVO> list = service.getList();
		model.addAttribute("list", list);
		
		return "service/boardList";
	}
	
	@RequestMapping("/boardDelete")
	public String dalete(@RequestParam("num") int num) {
		
		service.boardDelete(num);
		
		return "redirect:/service/boardList"; //삭제후에 목록으로
	}	
}

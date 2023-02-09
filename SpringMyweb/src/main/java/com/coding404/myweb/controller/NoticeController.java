package com.coding404.myweb.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coding404.myweb.command.TripVO;
import com.coding404.myweb.trip.service.TripService;
import com.coding404.myweb.util.Criteria;
import com.coding404.myweb.util.PageVO;

@Controller
@RequestMapping("/trip")
public class NoticeController {
	
	
	@Autowired
	@Qualifier("tripService")
	private TripService tripService;
	

	//등록화면
	@RequestMapping("/notice_write")
	public String notice_write() {
		
		return "trip/notice_write";
	}
	
	@RequestMapping("/notice_list")
	public String notice_list(Criteria cri, Model model) {

		//데이터
		//ArrayList<TripVO> list = tripService.getList(cri);
		//페이지네이션
		//int total = tripService.getTotal();
		//PageVO pageVO = new PageVO(cri, total);
		
		//페이지 검색처리
		/*
		 * 1. 화면에서는 page, amount, searchType, searchName을 넘긴다.
		 * 2. criteria에서 검색값을 받는다.
		 * 3. sql을 바꾼다. (동적쿼리)
		 * 4. total sql을 바꾼다 (동적쿼리)
		 * 5. 페이지 a태그 클릭시 searchType, searchName을 쿼리스트링으로 넘긴다.
		 * 6. 검색키워드 유지
		 */
		System.out.println(cri.toString());
		
		ArrayList<TripVO> list = tripService.getList(cri);
		
		int total = tripService.getTotal(cri);
		
		PageVO pageVO = new PageVO(cri, total);
		
		
		
		
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		return "trip/notice_list";
	}
	
	@RequestMapping("/notice_view")
	public String notice_view(@RequestParam("tno") int tno,
							  Model model,
							  HttpServletResponse response,
							  HttpServletRequest request) {
		
		//클릭한 글 번호에 대한 내용을 조회
		TripVO vo = tripService.getContent(tno);
		model.addAttribute("vo", vo);
		
		//조회수 - Cookie or 세션 이용해서 조회수 중복 방지
		tripService.upHit(tno);
		
		//이전글 다음글
		ArrayList<TripVO> list = tripService.getPrevNext(tno);
		model.addAttribute("list", list);
		
//		Cookie cookie = new Cookie("key", "1");
//		cookie.setMaxAge(30);
//		response.addCookie(cookie);
		
		
		
		
		
		
		
		return "trip/notice_view";
	}

	
	//수정화면
	@RequestMapping("/notice_modify")
	public String notice_modify(@RequestParam("tno") int tno,
								Model model) {
		
		//클릭한 글 번호에 대한 내용을 조회
		TripVO vo = tripService.getContent(tno);
		model.addAttribute("vo", vo);
		
		return "trip/notice_modify";
	}
	
	//수정, 상세 화면이 완전 동일하다면
//	@RequestMapping({"notice_view", "notice_modify"})
//	public void notice_view(@RequestParam("tno") int tno,
//							Model model) {
//		
//		TripVO vo = tripService.getContent(tno);
//		model.addAttribute("vo", vo);
//	}
	
	
	
	
	
	//글등록
	@RequestMapping(value="/registForm", method = RequestMethod.POST)
	public String registForm(TripVO vo, RedirectAttributes ra) {

		
		int result = tripService.noticeRegist(vo);
		String msg = result == 1 ? "문의사항이 정상 등록되었습니다" : "문의 등록에 실패했습니다";
		ra.addFlashAttribute("msg", msg);
		
		return "redirect:/trip/notice_list";
	}
	
	//글수정
	@RequestMapping(value="/modifyForm", method = RequestMethod.POST)
	public String modifyForm(TripVO vo,
							 RedirectAttributes ra) {
				
		//업데이트작업-화면에서는 tno가 필요하기 때문에 hidden태그를 이용해서 넘겨주세요.
		int result = tripService.noticeModify(vo);
		String msg = result == 1 ? "문의사항이 수정되었습니다" : "수정에 실패했습니다";
		ra.addFlashAttribute("msg", msg);
				
		return "redirect:/trip/notice_list";
		//return "redirect:/trip/notice_view?tno=" + vo.getTno();
	}
	
	//글삭제
	@RequestMapping(value="/deleteForm", method = RequestMethod.POST)
	public String deleteForm(@RequestParam("tno") int tno,
							 RedirectAttributes ra) {
		
		/*
		 * service, mapper에는 noticeDelete 메서드로 삭제를 진행
		 * 삭제 이후에는 list화면으로 이동해주면 됩니다.
		 */
		int result = tripService.noticeDelete(tno);
		String msg = result == 1 ? "삭제 되었습니다" : "삭제에 실패했습니다";
		ra.addFlashAttribute("msg", msg);	
		
		return "redirect:/trip/notice_list";
	}
	
	
	
	
	
	
	
	
	
	
			
	
}

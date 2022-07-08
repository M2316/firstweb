package com.spring.firstweb.board.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.firstweb.board.service.IBoardService;
import com.spring.firstweb.model.BoardVO;
import com.spring.firstweb.util.paging.PagingCreater;
import com.spring.firstweb.util.paging.PagingVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	@GetMapping("/list")
	public String viewList(Model model,PagingVO paging) {
		System.out.println("/board/list : get 리스트 요청 들어옴");
		
		System.out.println("사용자가 선택한 페이지 넘버" + paging.getSelPageNum());
		
		PagingCreater pc = new PagingCreater(service.countContents(paging),paging);
		model.addAttribute("contents",service.getContentAll(paging));
		model.addAttribute("pc",pc);
		
		
		System.out.println("게시물 끌고온거 : " + service.getContentAll(paging));
		System.out.println("keyword : " +paging.getKeyword());
		System.out.println("condition  : " +paging.getCondition());
		System.out.println("선택한 페이지 번호 :" + paging.getSelPageNum());
		System.out.println("페이지당 content수 : " + paging.getContentPcs());
		System.out.println("총 게시물 수 : " + pc.getContentCnt());
		return "/board/boardList";
	}
	
	@GetMapping("/detail/{bno}")
	public String contentDetail(@PathVariable int bno, Model model) {
		
		System.out.println("/board/detail/" + bno + " : get 요청이 들어옴");
		BoardVO vo = service.getContent(bno);
		model.addAttribute("content",vo);
		
		System.out.println("content ---->>> " + vo );
		return "/board/boardDetail";
	}
	
	@GetMapping("/modContent")
	public String modContent( int bno ,Model model){
		
		System.out.println("/board/modContent : post 수정페이지 요청 넘겨진 값" + bno);
		BoardVO vo = service.getContent(bno);
		model.addAttribute("content",vo);
		return "/board/boardModify";
	}
	
	@PostMapping("/updateContent")
	public String updateContent(BoardVO content,RedirectAttributes ra) {
		
		System.out.println("/board/updateContent : post 업데이트 요청이 들어옴" + content);
		
		service.modContent(content);
		return "redirect:/board/detail/" + content.getBno();
	}
	
	@PostMapping("/deleteContent")
	public String deleteContent(BoardVO content,RedirectAttributes ra) {
		System.out.println("/board/deleteContent : post 삭제 요청 들어옴");
		service.delContent(content.getBno());
		return "redirect:/board/list";
	}
	
}

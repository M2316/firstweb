package com.spring.firstweb.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.resource.HttpResource;

import com.spring.firstweb.model.UserVO;
import com.spring.firstweb.user.service.IUserService;
import com.spring.firstweb.util.email.EmailSendService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	@Autowired
	private EmailSendService emailservice;
	
	@GetMapping("/userJoin")
	public void join() {}
	
	
	@PostMapping("/userCheck")
	@ResponseBody
	public String userCheck(@RequestBody String userId) {
		System.out.println("/user/userCheck : post 유저 체크 요청 들어옴");
		System.out.println("userID : " + userId);
		UserVO user = service.getUserInfo(userId);	
		System.out.println("userID 조회된 사용자 값 : " + user);
		if(user == null) {
			return "success";
		}
		return "fail";
	}
	@PostMapping("/insert")
	public String insert(UserVO user) {
		System.out.println("/user/insert : Post 가입 이벤트 실행!");
		System.out.println("회원 가입 요청 유저 정보 : " + user);
		service.userInsert(user);
		return "/user/userLogin";
	}
	@GetMapping("/userLogin")
	public void userLogin() {
		System.out.println("/user/login : get");
	}
	
	@GetMapping("/emailCheck/{email}")
	@ResponseBody
	public String emailCheck(@PathVariable String email) {
		System.out.println("/user/emailCheck : post 이메일 인증요청 들어옴! email : " + email);
		return emailservice.joinEmailSend(email);
	}
	
	@PostMapping("/login")
	public String userLogin(UserVO vo,RedirectAttributes ra,HttpServletResponse response,HttpSession session) {
		System.out.println(vo);
		UserVO user = service.getUserInfo(vo.getUserId());
		if(user == null) {
			System.out.println("user 조회된 정보  : " + user);
			ra.addFlashAttribute("msg", "userIdNotMatched");
			return "redirect:/user/userLogin";
		}else {
			if(vo.getUserPw().equals(user.getUserPw())) {
				session.setAttribute("user", user);
				return "redirect:/";
			}else {
				ra.addFlashAttribute("msg", "userPwNotMatched");
				return "redirect:/user/userLogin";
			}
		}
		
	}
	
	@GetMapping("/userLogout")
	public String logout(HttpSession session,RedirectAttributes ra) {
		session.setAttribute("user", null);
		return "redirect:/user/userLogin";
	}
	
}

package com.spring.firstweb.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
//		service.userInsert(user);
		return "/user/userLogin";
	}
	@GetMapping("/userLogin")
	public void userLogin() {
		System.out.println("/user/login : get");
	}
	
	@PostMapping("/emailCheck")
	@ResponseBody
	public String emailCheck(String email) {
		System.out.println("/user/emailCheck : post 이메일 인증요청 들어옴! email : " + email);
		return emailservice.joinEmailSend(email);
	}
	
}

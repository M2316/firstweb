package com.spring.firstweb.util.email;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailSendService {

	@Autowired
	private JavaMailSender mailSender;
	
	private int authNum;
	
	//난수 발생( 알아서 하면 됨)
	public void makeRandomNumber() {
		//난수의 범위 : 111111 ~ 999999
		Random r = new Random();
		int checkNum = r.nextInt(899999) + 100000; // random 100000 보다 작은 수가 나올 수 있기 때문에 100000 을 더한 값을 해준다
		System.out.println("인증번호 " + checkNum);
		authNum = checkNum;
	}

	//회원 가입 시 사용할 이메일 양식!!!
	public String joinEmailSend(String email) {
		makeRandomNumber();
		
		String setFrom = "031pjs@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "firstweb에 가입해 주셔서 감사합니다!"
				+ "<br><br><br><br>"
				+ "인증 번호 : " + authNum+"<br><br><br><br>"
						+ "인증 번호를 입력하여 회원 가입을 완료해 주세요~";
		emailSender(setFrom, toMail, title, content);
		return authNum+"";
	}
	
	
	//이메일 전송 메서드
	public void emailSender(String setFrom, String toMail, String title, String content) {
		
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message,true,"utf-8");
			
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}

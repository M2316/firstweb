package com.spring.firstweb.mapper;

import java.util.List;

import com.spring.firstweb.model.UserVO;

public interface IUserMapper {

	//유저 정보 조회
	UserVO getUserInfo(String userId);
	
	//유저 정보 전체 조회
	List<UserVO> getUserList();
	
	//탈퇴
	void userDelete(UserVO user);
	
	//가입
	void userInsert(UserVO user);
	
	
	
}

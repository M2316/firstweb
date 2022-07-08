package com.spring.firstweb.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.firstweb.mapper.IUserMapper;
import com.spring.firstweb.model.UserVO;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public UserVO getUserInfo(String userId) {
		return mapper.getUserInfo(userId);
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userDelete(UserVO user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void userInsert(UserVO user) {
		mapper.userInsert(user);

	}

}

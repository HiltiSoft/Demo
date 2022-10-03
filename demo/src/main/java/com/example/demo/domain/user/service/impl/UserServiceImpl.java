package com.example.demo.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;

	//*User signup */
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");
		mapper.insertOne(user);
	}
	
	@Override
	public List<MUser> getUsers(MUser user){
		System.out.print("UserServiceImpl/List: userId=" + user.getUserId() + " userName=" + user.getUserName() +"\n");
		return mapper.findMany(user);
	}
	
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}
	
	/** Update user */
	@Override
	public void updateUserOne(String userId, String password, String userName) {
		System.out.println("UserServiveImpl: " + userId + ";" + password + ";" + userName +"\n");
		mapper.updateOne(userId, password, userName);
	}
	
	/** Delete user */
	@Override
	public void deleteUserOne(String userId) {
		int count = mapper.deleteOne(userId);
	}
}

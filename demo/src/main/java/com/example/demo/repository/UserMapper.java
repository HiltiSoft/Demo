package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.model.MUser;

@Mapper
public interface UserMapper {

	/*User signup */
	public int insertOne(MUser user);

	/* Get user */
	public List<MUser> findMany();
	
	/*Get user (1 record) */
	public MUser findOne(String userId);
}

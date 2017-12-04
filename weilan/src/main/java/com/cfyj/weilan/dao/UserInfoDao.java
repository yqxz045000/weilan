package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cfyj.weilan.entity.User;

@Mapper
public interface UserInfoDao {

	void insertUserInfo(User user);
	
	User getById(int userId);

}

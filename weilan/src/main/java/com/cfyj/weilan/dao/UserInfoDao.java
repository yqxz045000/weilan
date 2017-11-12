package com.cfyj.weilan.dao;

import com.cfyj.weilan.entity.User;

public interface UserInfoDao {

	void insertUserInfo(User user);
	
	User getById(int userId);

}

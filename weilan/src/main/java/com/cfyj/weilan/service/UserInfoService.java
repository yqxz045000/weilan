package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserInfo;
import com.cfyj.weilan.entity.User;

public interface UserInfoService {
	
	public boolean addUser(User user);
	
	public Response editUserInfo(UserInfo user);
	
	public User getById(int userId);

}

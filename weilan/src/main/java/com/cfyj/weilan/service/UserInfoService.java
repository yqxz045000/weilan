package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.User;

public interface UserInfoService {
	
	public Response addUser(User user);
	
	public Response editUserInfo(User user);
	
	public User getById(int userId);
	
	public Response checkEditData(User user,String type);
	
	
	

}

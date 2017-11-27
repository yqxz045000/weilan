package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserView;
import com.cfyj.weilan.entity.User;

public interface UserAccountService {
	
	public boolean checkPasswd(String password,String oldePassword);
	
	public Response addUserAccount(User account);
	
	public User Login(User account);
	
	public User getByAccount(String account);
	
	public User getByUserId(int id );
	
	public UserView initUser(User user);
	
	
	
}

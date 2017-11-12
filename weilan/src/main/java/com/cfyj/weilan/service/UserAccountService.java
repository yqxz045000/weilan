package com.cfyj.weilan.service;

import com.cfyj.weilan.entity.User;

public interface UserAccountService {
	
	public String checkPasswd(User account);
	
	public void addUserAccount(User account);
	
	
	
}

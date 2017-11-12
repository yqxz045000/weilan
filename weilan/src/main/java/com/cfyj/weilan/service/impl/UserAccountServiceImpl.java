package com.cfyj.weilan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cfyj.weilan.dao.UserAccountDao;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.service.UserAccountService;

public class UserAccountServiceImpl extends LogServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountDao userAccountDao;

	@Override
	public String checkPasswd(User account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUserAccount(User account) {
		try {
			userAccountDao.insertUserAccount(account);			
		} catch (Exception e) {
			log.error("UserAccountServiceImpl-addUserAccount：创建帐号异常",e);
			throw new RuntimeException("UserAccountServiceImpl-addUserAccount：创建帐号异常");
		}
		
	}

}

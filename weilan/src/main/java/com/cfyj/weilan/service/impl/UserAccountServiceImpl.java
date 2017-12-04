package com.cfyj.weilan.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.cfyj.weilan.dao.UserAccountDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserView;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.service.UserAccountService;
import com.cfyj.weilan.utils.MD5Util;

public class UserAccountServiceImpl extends LogServiceImpl implements UserAccountService {
	
	@Autowired
	private UserAccountDao userAccountDao;


	@Override
	public boolean addUserAccount(User account) {
		try {
			int i = userAccountDao.insertUserAccount(account);		
			if(i>0) {
				return true;			
			}else {
				return false;	
			}
		} catch (Exception e) {
			log.error("UserAccountServiceImpl-addUserAccount：创建帐号异常",e);
			throw new RuntimeException("UserAccountServiceImpl-addUserAccount：创建帐号异常");
		}	
	}


	@Override
	public boolean checkPasswd(String password,String passwordDB) {
		return passwordDB.equalsIgnoreCase(MD5Util.MD5(password));
	}


	@Override
	public User Login(User user) {
		User dbUser = null;
		if(user!=null && StringUtils.isNotBlank(user.getUserAccount()) &&  StringUtils.isNotBlank(user.getPasswd())) {	
			dbUser = getByAccount(user.getUserAccount());
			boolean flag = dbUser!=null?checkPasswd(user.getPasswd(),dbUser.getPasswd()) : false;
			if(flag) {
				//成功
				return dbUser;
			}
		}		
		return dbUser;
	}


	@Override
	public User getByAccount(String account) {
		return userAccountDao.findByAccount(account);
	}


	@Override
	public User getByUserId(int id) {	
		return userAccountDao.findByUserId(id);
	}


	@Override
	public UserView initUser(User user) {
		/**
		 * 登录成功进行帐号的数据初始化
		 */
		return null;
	}


}

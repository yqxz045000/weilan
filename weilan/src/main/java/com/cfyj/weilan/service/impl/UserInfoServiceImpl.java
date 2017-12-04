package com.cfyj.weilan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfyj.weilan.constant.UserConstant;
import com.cfyj.weilan.dao.UserInfoDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserInfo;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.service.UserAccountService;
import com.cfyj.weilan.service.UserInfoService;
import com.cfyj.weilan.utils.MD5Util;

@Service
public class UserInfoServiceImpl extends LogServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoDao  userInfoDao;
	
	@Autowired
	private UserAccountService userAccountService;
	
	@Override
	@Transactional
	public Response addUser(User user) {	
		Response res ;
		user.setPasswd( MD5Util.MD5(user.getPasswd()));
		user.setLevel(UserConstant.USERLEVEL_1);
		userInfoDao.insertUserInfo(user);
		if(userAccountService.addUserAccount(user)) {
			res = new Response(CodeDict.SUCCESS);
		}else {
			log.error("生成UserAccount失败");
			res = new Response(CodeDict.FAIL);
		}		
		return res;
	}

	@Override
	public Response editUserInfo(User user) {
			
		
		return null;
	}

	@Override
	public User getById(int userId) {
		User user = userInfoDao.getById(userId);	
		return user;
	}

	@Override
	public Response checkEditData(User user, String type) {
		// TODO Auto-generated method stub
		return null;
	}

}

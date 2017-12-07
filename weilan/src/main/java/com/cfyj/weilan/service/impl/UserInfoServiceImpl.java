package com.cfyj.weilan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.weilan.dao.UserInfoDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserInfo;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.service.UserInfoService;
import com.cfyj.weilan.utils.BaseLogUtil;

@Service
public class UserInfoServiceImpl extends BaseLogUtil implements UserInfoService {

	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public boolean addUser(User user) {
		int num = userInfoDao.insertUserInfo(user);
		return num == 0 ? false : true;
	}

	@Override
	public Response editUserInfo(UserInfo UserInfo) {
		Response res = new Response(CodeDict.SUCCESS);
		int num = userInfoDao.updateUserInfo(UserInfo);		
		return res;
	}

	@Override
	public User getById(int userId) {
		User user = userInfoDao.getById(userId);
		return user;
	}

}

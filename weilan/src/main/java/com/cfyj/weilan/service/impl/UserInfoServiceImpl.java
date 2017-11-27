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
//		private String id;				//主键，程序生成
//		private String nickname	;		// 	昵称
//		private String sex	;			// 	性别
//		private Timestamp  birthday;	// 	出生年月
//		private String  headImg;		// 	头像
//		private String  address;		// 	地址，暂不启用，留作扩展
//		
//		/*********************账户信息**************************************/
//		private String userAccount;		//帐号
//		private String passwd;			//密码
//		private String oldPasswd;		//旧密码
//		
//		/************************系统属性*******************************/
//		
//		private String  type;			// 	类型，暂不启用，留作扩展
//		private String  status; 		//	状态：正常、冻结、
//		private String  level;			//级别
		
		user.setPasswd( MD5Util.MD5(user.getPasswd()));
		user.setLevel(UserConstant.USERLEVEL_1);
		userInfoDao.insertUserInfo(user);
		userAccountService.addUserAccount(user);
		Response res = new Response();
		res.setCode(CodeDict.SUCCESS.getCode());
		res.setMsg(CodeDict.SUCCESS.getDesc());
		
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

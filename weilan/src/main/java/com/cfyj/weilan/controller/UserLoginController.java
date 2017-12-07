package com.cfyj.weilan.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.constant.UserConstant;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserView;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.service.UserAccountService;
import com.cfyj.weilan.service.UserInfoService;
import com.cfyj.weilan.utils.BaseLogUtil;

/**
 * 
 * @author cfyj
 *2017年12月6日 下午1:47:57
 *
 */
@RestController
@RequestMapping("userAccount")
public class UserLoginController extends BaseLogUtil{

	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 登录
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("login")
	public Response login(User user,HttpSession session) {
		Response res = new Response(CodeDict.FAIL);
		res.setMsg("帐号或密码错误");
		user = userAccountService.Login(user);
		if(user!=null) {
			//进行帐号的初始化
			 UserView view = userAccountService.initUser(user);
			 session.setAttribute(UserConstant.USERVIEW, view);
			 res = new Response(CodeDict.SUCCESS);
		}
		
		return res;
	}
	
	/**
	 * 注册后自动登录，并跳转到首页。
	 * @param user
	 * @return
	 */
	@PostMapping("register")
	public Response register(User user) {	
		user = new User();
		user.setAddress("上海市");
		user.setBirthday(new Date());
		user.setHeadImg("headImg");
		user.setNickname("nickname");
		user.setPasswd("passwd");
		user.setSex("1");
		user.setUserAccount("userAccount");
	
		CommonRes<User> res = userAccountService.addUserAccount(user);
		
		return res;
	}
	
	
}

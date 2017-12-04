package com.cfyj.weilan.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.constant.UserConstant;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.UserView;
import com.cfyj.weilan.entity.User;
import com.cfyj.weilan.service.UserAccountService;

@RestController
@RequestMapping
public class UserLoginController {

	@Autowired
	private UserAccountService userAccountService;
	
	
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
	
	
}

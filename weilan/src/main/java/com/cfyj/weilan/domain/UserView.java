package com.cfyj.weilan.domain;

import java.util.Set;

import com.cfyj.weilan.entity.User;

/**
 * 在session中保存的user信息：
 * 1.包含用户的个人信息
 * 2.保存权限信息
 * 3.也可以缓存一些信息
 * @author cfyj
 *2017年11月27日 下午4:45:00
 *
 */
public class UserView {

	private User user ;
	
	private Set<String> url;
}

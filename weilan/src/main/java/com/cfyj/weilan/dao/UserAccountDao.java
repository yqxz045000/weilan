package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.User;

@Mapper
public interface UserAccountDao {

	public int insertUserAccount(User user);
	
	/**
	 * 返回所有的账户信息
	 * @param userAccount
	 * @return
	 */
	public User findByAccount(@Param("userAccount") String userAccount);
	
	/**
	 * 返回无密码的账户信息
	 * @param id
	 * @return
	 */
	public User findByUserId( @Param("id") int id);

	public int findNumById(@Param("id") int id);

}

package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.User;

public interface UserAccountDao {

	public int insertUserAccount(User user);

	public User findByAccount(@Param("account") String account);

	public User findByUserId( @Param("id") int id);

}

package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.domain.UserInfo;
import com.cfyj.weilan.entity.User;

@Mapper
public interface UserInfoDao {

	int insertUserInfo(User user);
	
	User getById(@Param("id") int id);

	int updateUserInfo(UserInfo userInfo);

}

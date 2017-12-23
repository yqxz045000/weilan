package com.cfyj.weilan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.domain.query.UserInfoSummaryQuery;
import com.cfyj.weilan.entity.UserInfoSummary;

@Mapper
public interface UserInfoSummaryDao {

	public int count(UserInfoSummaryQuery query);

	public List<UserInfoSummary> findBycondition(UserInfoSummaryQuery query);
	
	public int insert(UserInfoSummary userInfoSummary);
	
	public int updateByUserId(UserInfoSummary userInfoSummary);

	public UserInfoSummary findByUserId(@Param("userId") int userId);
	

}

package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.query.UserInfoSummaryQuery;
import com.cfyj.weilan.entity.UserInfoSummary;

/**
 * 
 * @author cfyj
 *2017年12月23日 下午1:03:26
 *对用户数据进行统计:
 */
public interface UserInfoSummaryService {

	public Page<UserInfoSummary> query(UserInfoSummaryQuery query );
	
	public boolean addUserInfoSummary(UserInfoSummary userInfoSummary);
	
	public boolean editUserInfoSummary(UserInfoSummary userInfoSummary);
	
	/**
	 * 检测账户是否存在
	 * @param userId
	 * @return
	 */
	public boolean isExitByUserId(int userId);
	
	
}

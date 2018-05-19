package com.cfyj.weilan.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.weilan.dao.UserInfoSummaryDao;
import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.query.UserInfoSummaryQuery;
import com.cfyj.weilan.entity.UserInfoSummary;
import com.cfyj.weilan.service.UserInfoSummaryService;
import com.cfyj.weilan.utils.DateUtil;

@Service
public class UserInfoSummaryServiceImpl implements UserInfoSummaryService {

	@Autowired
	private UserInfoSummaryDao userInfoSummaryDao;

	@Override
	public Page<UserInfoSummary> query(UserInfoSummaryQuery query) {
		Page<UserInfoSummary> page = new Page<UserInfoSummary>();
		int num = userInfoSummaryDao.count(query);
		List<UserInfoSummary> list = userInfoSummaryDao.findBycondition(query);
		page.setResult(list);
		page.setTotalRecord(num);
		return page;
	}

	@Override
	public boolean addUserInfoSummary(UserInfoSummary userInfoSummary) {
		if (userInfoSummary.getUserId() < 1) {
			return false;
		}
		userInfoSummaryDao.insert(userInfoSummary);
		return true;
	}

	@Override
	public boolean editUserInfoSummary(UserInfoSummary userInfoSummary) {
		if (userInfoSummary.getUserId() < 1) {
			return false;
		}
		userInfoSummaryDao.updateByUserId(userInfoSummary);
		return true;
	}

	@Override
	public boolean isExitByUserId(int userId) {
		return userInfoSummaryDao.findByUserId(userId)!=null? true:false;

	}

	@Override
	public boolean sumUserInfoSummary(int userId) {
		
		userInfoSummaryDao.sumUserInfoSummaryByUserId(userId);
		return true;
	}

}

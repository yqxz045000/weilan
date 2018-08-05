package com.cfyj.weilan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.query.UserInfoSummaryQuery;
import com.cfyj.weilan.entity.UserInfoSummary;
import com.cfyj.weilan.service.UserInfoSummaryService;

@RestController
@RequestMapping("userInfoSummary")
public class UserInfoSummaryController {

	
	@Autowired
	private UserInfoSummaryService userInfoSummaryService;
	
	
	
	@PostMapping("query")
	public CommonRes<Page<UserInfoSummary>> query(UserInfoSummaryQuery query){
		CommonRes<Page<UserInfoSummary>> resp = new CommonRes<Page<UserInfoSummary>>(CodeDict.SUCCESS);
		Page<UserInfoSummary> page = userInfoSummaryService.query(query);
		resp.setData(page);
		return resp;
	}
	
	
	
	
}

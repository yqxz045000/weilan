package com.cfyj.weilan.service.impl;

import java.util.List;

import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.weilan.dao.AnnoyanceWallDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.query.AnnoyanceWallQuery;
import com.cfyj.weilan.entity.AnnoyanceWall;
import com.cfyj.weilan.entity.UserInfoSummary;
import com.cfyj.weilan.service.AnnoyanceWallService;
import com.cfyj.weilan.service.UserInfoSummaryService;


@Service
public class AnnoyanceWallServiceImpl implements AnnoyanceWallService {
	
	@Autowired
	private AnnoyanceWallDao annoyanceWallDao; 
	
	@Override
	public Response addAnnoyanceWall(AnnoyanceWall annoyanceWall) {
		Response res = new Response(CodeDict.SUCCESS); 
		//TODO做一个消息过滤，过滤一些敏感词
		annoyanceWall.setMsg(ESAPI.encoder().encodeForHTML(annoyanceWall.getMsg()));
		annoyanceWallDao.insertAnnoyanceWall(annoyanceWall);	
		return res;
	}

	@Override
	public Page<AnnoyanceWall> query(AnnoyanceWallQuery query) {
		Page<AnnoyanceWall> page = new Page<AnnoyanceWall>();
		List<AnnoyanceWall> list = annoyanceWallDao.findByCondition(query);
		page.setResult(list);
		page.setPageNo(query.getPageNo()+1);//返回下一页的
		return page;
	}

}

package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.query.AnnoyanceWallQuery;
import com.cfyj.weilan.entity.AnnoyanceWall;

public interface AnnoyanceWallService {
	
	
	public Response addAnnoyanceWall(AnnoyanceWall annoyanceWall);
	
	/**
	 * 可以做条件查询
	 * @param query
	 * @return
	 */
	public Page<AnnoyanceWall> query(AnnoyanceWallQuery query);

	
	
}

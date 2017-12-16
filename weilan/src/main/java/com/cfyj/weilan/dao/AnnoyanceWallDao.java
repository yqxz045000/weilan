package com.cfyj.weilan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cfyj.weilan.domain.query.AnnoyanceWallQuery;
import com.cfyj.weilan.entity.AnnoyanceWall;

@Mapper
public interface AnnoyanceWallDao {

	public int insertAnnoyanceWall(AnnoyanceWall annoyanceWall);

	public List<AnnoyanceWall> findByCondition(AnnoyanceWallQuery query);

}

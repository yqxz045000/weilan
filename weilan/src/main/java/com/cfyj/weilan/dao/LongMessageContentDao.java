package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.LongMessageContent;

@Mapper
public interface LongMessageContentDao {

	public int deleteById(@Param("id") int id);

	public int insertLongMessageContent(LongMessageContent content);

	public int updateLongMessageContent(LongMessageContent content);

	public int findLastUpdateId(Integer userId);

}

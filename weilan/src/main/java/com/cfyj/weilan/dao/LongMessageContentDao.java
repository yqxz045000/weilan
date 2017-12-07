package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.LongMessageContent;

@Mapper
public interface LongMessageContentDao {

	int deleteById(@Param("id") int id);

	int insertLongMessageContent(LongMessageContent content);

	int updateLongMessageContent(LongMessageContent content);

}

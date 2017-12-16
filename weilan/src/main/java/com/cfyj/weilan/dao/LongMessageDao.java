package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.LongMessage;

@Mapper
public interface LongMessageDao {
	
	//获取不包含content的实体
	LongMessage getById(@Param("id") int id,@Param("userId") int userId);

	int deleteById(@Param("id") int id,@Param("userId") int userId);
	//获取包含content的实体
	LongMessage getLongMessageById(@Param("id") int id,@Param("userId") int userId);

	int insertLongMessage(LongMessage message);

	int updateLongMessage(LongMessage message);

}

package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cfyj.weilan.entity.LongMessage;

@Mapper
public interface LongMessageDao {
	
	//获取不包含content的实体
	LongMessage getById(int id, int userId);

	int deleteById(int id, int userId);
	//获取包含content的实体
	LongMessage getLongMessageById(int id, int userId);

	int insertLongMessage(LongMessage message);

	int updateLongMessage(LongMessage message);

}

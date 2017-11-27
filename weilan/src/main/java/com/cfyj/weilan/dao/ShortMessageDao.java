package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.ShortMessage;

public interface ShortMessageDao {

	public int insertShortMessage(ShortMessage message);

	public int deleteById( @Param("id")  int id, @Param("userId") int userId);

	public ShortMessage findById(@Param("id") int id,@Param("userId") int userId);

}

package com.cfyj.weilan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.domain.query.ShortMessageQuery;
import com.cfyj.weilan.entity.ShortMessage;

@Mapper
public interface ShortMessageDao {

	public int insertShortMessage(ShortMessage message);

	public int deleteById( @Param("id")  int id, @Param("userId") int userId);

	public ShortMessage findById(@Param("id") int id,@Param("userId") int userId);

	public List<ShortMessage> findByCondition(ShortMessageQuery query);

	public int findCountByCondition(ShortMessageQuery query);

}

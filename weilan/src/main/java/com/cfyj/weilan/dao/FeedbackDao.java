package com.cfyj.weilan.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.Feedback;

@Mapper
public interface FeedbackDao {

	public int insertFeedback(Feedback back);

	public int updateFeedback(Feedback back);

	public Feedback findByUserIdAndStatus(@Param("userId") int userId,@Param("status") String status);

	public Feedback findLastFeedbackByUserId(@Param("userId") int userId);

	public Feedback findById(@Param("id") int id);

}

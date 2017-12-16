package com.cfyj.weilan.service;

import java.util.List;

import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Feedback;

public interface FeedbackService {

	public Response addFeedback(Feedback back);
	
	public Response replyFeedback(Feedback back);
	
	//给用户使用，获取最新的一条记录
	public Feedback getUserFeedback(int userId);
	
	//后台管理使用，条件分页查询
	public List<Feedback> getAll();
	
	//获取指定的
	public Feedback getById(int userId);
	
}

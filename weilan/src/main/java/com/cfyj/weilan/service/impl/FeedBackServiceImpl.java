package com.cfyj.weilan.service.impl;

import java.util.List;

import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.weilan.constant.Constant;
import com.cfyj.weilan.dao.FeedbackDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Feedback;
import com.cfyj.weilan.service.FeedBackService;

@Service
public class FeedBackServiceImpl implements FeedBackService {
	
	@Autowired
	private FeedbackDao feedbackDao;

	@Override
	public Response addFeedback(Feedback back) {
		Response res ;
		Feedback backDB = feedbackDao.findByUserIdAndStatus(back.getUserId(),Constant.STATUS_FREEZE);
		if(backDB==null) {
			res = new Response(CodeDict.SUCCESS);
			back.setMsg(ESAPI.encoder().encodeForHTML(back.getMsg()));
			feedbackDao.insertFeedback(back);	
		}else {
			res = new Response(CodeDict.FAIL);
			res.setMsg("您反馈的信息还未被处理，请再反馈信息处理后在申请，谢谢。");
		}
		return res;
	}

	@Override
	public Response replyFeedback(Feedback back) {
		Response res = new Response(CodeDict.SUCCESS);
		back.setReplyMsg(ESAPI.encoder().encodeForHTML(back.getReplyMsg()));
		feedbackDao.updateFeedback(back);	//只更改状态和回复
		return res;
	}

	@Override
	public Feedback getUserFeedback(int userId) {
		//获取最新的一条记录（不管是已回复还是未回复）
		Feedback feedback= feedbackDao.findLastFeedbackByUserId(userId);	
		return feedback;
	}

	@Override
	public List<Feedback> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Feedback getById(int id) {
		return feedbackDao.findById(id);

	}

}

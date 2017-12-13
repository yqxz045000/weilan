package com.cfyj.weilan.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Feedback;
import com.cfyj.weilan.service.FeedbackService;

@RestController
@RequestMapping("feedBack")
public class FeedbackController {

	@Autowired
	private FeedbackService feedBackService;
	
	private int userId = 1;
	
	@PostMapping("addFeedback")
	public Response addFeedback(Feedback Feedback) {
		Response res ;
		if(StringUtils.isBlank(Feedback.getMsg())|| StringUtils.isBlank(Feedback.getType())) {
			res = new Response(CodeDict.FAIL,"请填写要反馈的内容和类型");
			return res;
		}
		Feedback.setUserId(userId);
		res = feedBackService.addFeedback(Feedback);
		return res;	
	}
	
	@PostMapping("addFeedback")
	public CommonRes<Feedback> getUserFeedback() {
		CommonRes<Feedback> res  = new CommonRes<Feedback>(CodeDict.SUCCESS);
		Feedback Feedback =  feedBackService.getUserFeedback(userId);
		res.setData(Feedback);
		return res;
	}
	
	
}

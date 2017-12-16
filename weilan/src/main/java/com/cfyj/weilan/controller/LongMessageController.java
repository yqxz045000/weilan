package com.cfyj.weilan.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.LongMessage;
import com.cfyj.weilan.service.LongMessageService;

@RestController
@RequestMapping("essay")
public class LongMessageController {
	
	private int userId = 1;

	@Autowired
	private LongMessageService longMessageService;
	
	
	@PostMapping("add")
	public Response  add(LongMessage longMessage) {
		Response res;
		longMessage.setUserId(userId);
		if(StringUtils.isBlank(longMessage.getTitle()) || StringUtils.isBlank(longMessage.getResume()) || longMessage.getCategoryId()<=0
				|| longMessage.getContent()==null ||StringUtils.isBlank(longMessage.getContent().getContent()) ) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("标题、文章内容都必须填写，请谱写你的诗篇~");
		}else {
			res = longMessageService.addLongMessage(longMessage);				
		}
		return res;
	}
	
	@PostMapping("edit")
	public Response  edit(LongMessage longMessage) {
		Response res;
		longMessage.setUserId(userId);
		if(longMessage.getId()<=0 ||StringUtils.isBlank(longMessage.getTitle()) || StringUtils.isBlank(longMessage.getResume()) || longMessage.getCategoryId()<=0
				|| longMessage.getContent()==null ||StringUtils.isBlank(longMessage.getContent().getContent()) ) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("标题、文章内容都必须填写，请谱写你的诗篇~");
		}else {
			longMessage.getContent().setId(longMessage.getContentId());
			longMessage.getContent().setUserId(userId);
			res = longMessageService.editLongMessage(longMessage);			
		}
		return res;
	}
		
	@PostMapping("delete")
	public Response  deleteById(int id ) {
		Response res;
	
		if(id<=0) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("请刷新页面重新操作~");
		}else {
			res = longMessageService.deleteById(id, userId);			
		}
		return res;
	}
	
	@PostMapping("getById")
	public CommonRes<LongMessage> getById(int id){
		CommonRes<LongMessage> res = new CommonRes<LongMessage>(CodeDict.FAIL);
		
		if(id<=0) {
			res.setMsg("请刷新页面重新操作~");
		}else {
			LongMessage message = longMessageService.getById(id, userId);			
			res.setCodeDict(CodeDict.SUCCESS);
			res.setData(message);
		}
		return res;
	}
	
	@PostMapping("query")
	public CommonRes<List<LongMessage>> query(){
		//TODO
		return null;
	}

}

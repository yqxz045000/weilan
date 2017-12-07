package com.cfyj.weilan.service.impl;

import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cfyj.weilan.dao.LongMessageContentDao;
import com.cfyj.weilan.dao.LongMessageDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.LongMessage;
import com.cfyj.weilan.entity.LongMessageContent;
import com.cfyj.weilan.service.LongMessageService;
import com.cfyj.weilan.utils.BaseLogUtil;

@Service
public class LongMessageServiceImpl extends BaseLogUtil  implements LongMessageService {
	
	@Autowired
	private  LongMessageDao  longMessageServiceDao ;
	
	@Autowired
	private  LongMessageContentDao  longMessageContentServiceDao ;

	@Override
	@Transactional
	public Response addLongMessage(LongMessage message) {
		//TODO 这里对背景图片弄一下
		Response res = new Response(CodeDict.SUCCESS);
		LongMessageContent content = message.getContent();
		message.setResume(ESAPI.encoder().encodeForHTML(message.getTitle()));
		message.setResume(ESAPI.encoder().encodeForHTML(message.getResume()));
		content.setContent(ESAPI.encoder().encodeForHTML(content.getContent()));
		int contentId= longMessageContentServiceDao.insertLongMessageContent(content);
		message.setContentId(contentId);
		longMessageServiceDao.insertLongMessage(message);
		
		return res;
	}

	@Override
	public Response editLongMessage(LongMessage message) {
		Response res = new Response(CodeDict.SUCCESS);
		LongMessageContent content = message.getContent();
		message.setResume(ESAPI.encoder().encodeForHTML(message.getTitle()));
		message.setResume(ESAPI.encoder().encodeForHTML(message.getResume()));
		content.setContent(ESAPI.encoder().encodeForHTML(content.getContent()));
		longMessageContentServiceDao.updateLongMessageContent(content);
		longMessageServiceDao.updateLongMessage(message);
		
		return res;
	}

	@Override
	@Transactional
	public Response deleteById(int id, int userId) {
		Response res= new Response(CodeDict.FAIL);
		LongMessage message = longMessageServiceDao.getById(id,userId);
		if(message!=null && message.getId()>0 && message.getContentId()>0) {
			int num = longMessageContentServiceDao.deleteById(id);
			if(num==0) return res;
			num = longMessageServiceDao.deleteById(id, userId);
			if(num==0) return res;
			res.setCodeDict(CodeDict.SUCCESS);
		}else {
			res.setMsg("未找到该记录，请刷新页面重新删除。");
		}
		
		return res;
	}

	@Override
	public LongMessage getById(int id, int userId) {
		LongMessage message = longMessageServiceDao.getLongMessageById(id,userId);	
		return message;
	}

	@Override
	public Page<LongMessage> getByCondition(Page<LongMessage> page, int userId) {
//		Page<LongMessage> page = new Page<LongMessage>();
//		int num = longMessageServiceDao.findCountByCondition(query);
//		List<LongMessage> list = longMessageServiceDao.findByCondition(query);
//		page.setResult(list);
//		page.setPageNo(query.getPageNo());	
//		page.setPageSize(query.getPageSize());
//		page.setTotalRecord(num);	
		return page;

	}



}

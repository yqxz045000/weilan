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
import com.cfyj.weilan.entity.ShortMessage;
import com.cfyj.weilan.service.LongMessageService;
import com.cfyj.weilan.service.ShortMessageService;
import com.cfyj.weilan.utils.BaseLogUtil;

@Service
public class LongMessageServiceImpl extends BaseLogUtil implements LongMessageService {

	@Autowired
	private LongMessageDao longMessageServiceDao;

	@Autowired
	private LongMessageContentDao longMessageContentServiceDao;

	@Autowired
	private ShortMessageService shortMessageService;

	@Override
	@Transactional()
	public Response addLongMessage(LongMessage message) {
		// TODO 这里对背景图片弄一下
		Response res = new Response(CodeDict.SUCCESS);
		LongMessageContent content = message.getContent();
		message.setResume(ESAPI.encoder().encodeForHTML(message.getTitle()));
		message.setResume(ESAPI.encoder().encodeForHTML(message.getResume()));
		content.setContent(ESAPI.encoder().encodeForHTML(content.getContent()));
		content.setUserId(message.getUserId());
		
		longMessageContentServiceDao.insertLongMessageContent(content);
		// int contentId= content.getId();
		int contentId = longMessageContentServiceDao.findLastUpdateId(message.getUserId());
		message.setContentId(contentId);
		//TODO这个插入是使用LAST_INSERT_ID()来做的，在高并发的场景下可能会出现数据错乱
		longMessageServiceDao.insertLongMessage(message);
		
		ShortMessage shortMessage = new ShortMessage();
		shortMessage.setCategoryId(message.getCategoryId());
		shortMessage.setContent(message.getResume());
		shortMessage.setEssayId(message.getId());
		shortMessage.setUserId(message.getUserId());
		shortMessageService.addShortMessageByE(shortMessage);

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
		Response res = new Response(CodeDict.FAIL);
		LongMessage message = longMessageServiceDao.getById(id, userId);
		if (message != null && message.getId() > 0 && message.getContentId() > 0) {
			int num = longMessageContentServiceDao.deleteById(message.getContentId());
			if (num == 0)
				return res;
			longMessageServiceDao.deleteById(id, userId);
			res.setCodeDict(CodeDict.SUCCESS);
		} else {
			res.setMsg("未找到该记录，或许已经被删除，请刷新页面。");
		}

		return res;
	}

	@Override
	public LongMessage getById(int id, int userId) {
		LongMessage message = longMessageServiceDao.getLongMessageById(id, userId);
		return message;
	}

	@Override
	public Page<LongMessage> getByCondition(Page<LongMessage> page, int userId) {
		// Page<LongMessage> page = new Page<LongMessage>();
		// int num = longMessageServiceDao.findCountByCondition(query);
		// List<LongMessage> list = longMessageServiceDao.findByCondition(query);
		// page.setResult(list);
		// page.setPageNo(query.getPageNo());
		// page.setPageSize(query.getPageSize());
		// page.setTotalRecord(num);
		return page;

	}

}

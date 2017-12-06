package com.cfyj.weilan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cfyj.weilan.dao.ShortMessageDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.query.ShortMessageQuery;
import com.cfyj.weilan.entity.ShortMessage;
import com.cfyj.weilan.service.ShortMessageService;
import com.cfyj.weilan.utils.BaseLogUtil;

public class ShortMessageServiceImpl extends BaseLogUtil  implements ShortMessageService {
	
	@Autowired
	private  ShortMessageDao shortMessageDao;

	@Override
	public Response addShortMessage(ShortMessage message) {
		Response res ; 
		int result = shortMessageDao.insertShortMessage(message);
		if(result >0) {
			res = new Response(CodeDict.SUCCESS);
		}else {
			res = new Response(CodeDict.FAIL);
		}	
		return res;
	}

	@Override
	public Response deleteById(int id, int userId) {
		Response res ; 
		int result = shortMessageDao.deleteById(id,userId);
		if(result >0) {
			res = new Response(CodeDict.SUCCESS);
		}else {
			res = new Response(CodeDict.FAIL);
		}	
		return res;
	}

	@Override
	public ShortMessage getById(int id, int userId) {
		return shortMessageDao.findById(id,userId);
	}

	@Override
	public Page<ShortMessage> getByCondition(ShortMessageQuery query) {
		Page<ShortMessage> page = new Page<ShortMessage>();
		int num = shortMessageDao.findCountByCondition(query);
		List<ShortMessage> list = shortMessageDao.findByCondition(query);
		page.setResult(list);
		page.setPageNo(query.getPageNo());	
		page.setPageSize(query.getPageSize());
		page.setTotalRecord(num);
		
		return page;
	}
	
	/**
	 * check insert or update data usability
	 */
	@Override
	public Response checkEditDate(ShortMessage message) {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.cfyj.weilan.service.impl;

import org.springframework.stereotype.Service;

import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.LongMessage;
import com.cfyj.weilan.service.LongMessageService;
import com.cfyj.weilan.utils.BaseLogUtil;

@Service
public class LongMessageServiceImpl extends BaseLogUtil  implements LongMessageService {

	@Override
	public Response addLongMessage(LongMessage message) {
		
		
		
		return null;
	}

	@Override
	public Response deleteById(int id, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LongMessage getById(int id, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<LongMessage> getByCondition() {
		// TODO Auto-generated method stub
		return null;
	}

}

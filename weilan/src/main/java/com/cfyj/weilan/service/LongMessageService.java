package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.LongMessage;

public interface LongMessageService {

	public  Response addLongMessage(LongMessage message);
	
	public Response deleteById(int id,int userId);
	
	public LongMessage getById(int id,int userId);
	
	public Page<LongMessage> getByCondition(); 
	
}

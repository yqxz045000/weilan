package com.cfyj.weilan.service;

import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.query.ShortMessageQuery;
import com.cfyj.weilan.entity.ShortMessage;

/**
 * 
 * @author cfyj
 * 2017年11月12日 上午9:14:54
 *	1.增加
 *	2.删除
 *	3.获取
 *
 */
public interface ShortMessageService {

	
	public  Response addShortMessage(ShortMessage message);
	
	//增长长文类型
	public boolean addShortMessageByE(ShortMessage message);
	
	public Response deleteById(int id,int userId);
	
	public ShortMessage getById(int id,int userId);
	
	/**
	 * 上一层对数据自己做check，这一层只保存
	 * @param query
	 * @return
	 */
	public Page<ShortMessage> getByPage(ShortMessageQuery query);
	
//	public Response checkEditDate(ShortMessage message);
	
	
}

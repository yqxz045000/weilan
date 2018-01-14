package com.cfyj.weilan.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.Page;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.domain.query.ShortMessageQuery;
import com.cfyj.weilan.entity.ShortMessage;
import com.cfyj.weilan.service.ShortMessageService;

@RestController
@RequestMapping("memory")
public class ShortMessageController {
	private int userId = 1;

	@Autowired
	private ShortMessageService shortMessageService;
		
	@PostMapping("add")
	public Response add(ShortMessage shortMessage) {
		Response res;
		if (StringUtils.isNotBlank(shortMessage.getContent()) && shortMessage.getCategoryId()!=null && shortMessage.getCategoryId()>0) {
			shortMessage.setUserId(userId);
			res = shortMessageService.addShortMessage(shortMessage);
		} else {
			res = new Response(CodeDict.FAIL);
			res.setMsg("添加失败：内容和分类为必填项");
		}
		return res;
	}
	
	@PostMapping("delete")
	public Response delete(@RequestParam(name ="id",required=true) int id) {
		Response res = null ;
		if(id>0) {
			res =  shortMessageService.deleteById(id, userId);
		}else {
			res = new Response(CodeDict.FAIL);
		}
		return res;
	}
	
	@PostMapping("getById")
	public CommonRes<ShortMessage> getById(@RequestParam(name ="id",required=true) int id) {
		CommonRes<ShortMessage> res = null ;
		if(id>0) {
			ShortMessage shortMessage =  shortMessageService.getById(id, userId);
			res = new CommonRes<ShortMessage> (CodeDict.SUCCESS);
			res.setData(shortMessage);
		}else {
			res = new CommonRes<ShortMessage> (CodeDict.FAIL);
		}
		return res;
	}
	
	@PostMapping("query")
	public CommonRes<Page<ShortMessage>> getByPage(ShortMessageQuery query){
		query.setUserId(userId);
		CommonRes<Page<ShortMessage>> res = new  CommonRes<Page<ShortMessage>>(CodeDict.SUCCESS);
		Page<ShortMessage> page = shortMessageService.getByPage(query);
		res.setData(page);
		return res;
	}
	
	

}

package com.cfyj.weilan.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.CommonRes;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Category;
import com.cfyj.weilan.service.CategoryService;

@RestController
@RequestMapping("category")
public class CategoryController {
	
	private int userId = 1;

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("add")
	public  Response add(Category category) {
		Response res ;
		if(StringUtils.isNoneBlank(category.getName())) {
			category.setUserId(userId);
			res = categoryService.addCategory(category);
		}else {
			res = new Response(CodeDict.FAIL);
			res.setMsg("名称为必填项");
		}
		return res;
	}
	
	@PostMapping("edit")
	public  Response edit(Category category) {
		Response res ;
		if(category!=null &&  StringUtils.isNoneBlank(category.getName()) && userId>0) {
			category.setUserId(userId);
			res = categoryService.editCategory(category);
		}else {
			res = new Response(CodeDict.FAIL);
			res.setMsg("名称为必填项");
		}
		return res;
	}
	
	@PostMapping("delete")
	public Response delete(@RequestParam(name="id",required=true) int id) {
		Response res ;
		if( id>0 && userId>0) {
			res = categoryService.deleteById(id, userId);
		}else {
			res = new Response(CodeDict.FAIL);
		}
		return res;
	}
	
	@PostMapping("getById")
	public CommonRes<Category> getById(@RequestParam(name="id",required=true) int id){
		CommonRes<Category> res ;
		if( id>0 && userId>0) {
			Category category = categoryService.getById(id, userId);
			res = new CommonRes<Category>(CodeDict.SUCCESS);
			res.setData(category);
		}else {
			res = new CommonRes<Category>(CodeDict.FAIL);
		}
		return  res;
	}
	
	@PostMapping("query")
	public CommonRes<List<Category>> query(){
		CommonRes<List<Category>> res  = new CommonRes<List<Category>> (CodeDict.SUCCESS);
		List<Category> all = categoryService.getAll(userId);
		res.setData(all);
		return  res;
	}
	
	
}

package com.cfyj.weilan.service;

import java.util.List;

import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Category;

public interface CategoryService {

	public Response addCategory(Category category);
	
	public Response editCategory(Category category);
	
	public Response deleteById(int id,int userId);
	
	public Category getById(int id,int userId);
	
	/**
	 * 获取所有分类，包含系统的和用户自身的
	 * @return
	 */
	public List<Category> getAll();
	
	
	
}

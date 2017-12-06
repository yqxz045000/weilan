package com.cfyj.weilan.service.impl;

import java.util.List;

import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;

import com.cfyj.weilan.dao.CategoryDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Category;
import com.cfyj.weilan.service.CategoryService;
import com.cfyj.weilan.utils.BaseLogUtil;
/**
 * 
 * @author cfyj
 *2017年12月6日 下午2:22:08
 *上一层需要对传入下一层的数据做check
 */
public class CategoryServiceImpl extends BaseLogUtil implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	private int max_categoryNum =10;  //TODO  动态获取
	
	/**
	 * 对用户的分类数量进行控制
	 */
	@Override
	public Response addCategory(Category category) {
		Response res ; 
		int categoryNum = categoryDao.findNumById(category.getId(),category.getUserId());
		if(categoryNum>max_categoryNum) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("增加失败：已到达最大数量");
			return res;
		}
		String name = ESAPI.encoder().encodeForHTML(category.getName() );
		String des =  ESAPI.encoder().encodeForHTML(category.getDescription());
		log.debug("des:" + des + ",name: "+name);
		category.setName(name);
		category.setDescription(des);
		int num = categoryDao.insertCategory(category);
		res = num>0? new Response(CodeDict.SUCCESS) : new Response(CodeDict.FAIL);
		return res;
	}
	
	@Override
	public Response editCategory(Category category) {
		Response res ; 
		Category dbCategory = categoryDao.findById(category.getId(), category.getUserId());
		String name = ESAPI.encoder().encodeForHTML(category.getName() );
		String des =  ESAPI.encoder().encodeForHTML(category.getDescription());
		if(dbCategory==null || !dbCategory.getName().equals(name)) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("分类名称已存在");
			return res;
		}
		log.debug("des:" + des + ",name: "+name);
		category.setName(name);
		category.setDescription(des);
		int num = categoryDao.updateCategory(category);
		res = num>0? new Response(CodeDict.SUCCESS) : new Response(CodeDict.FAIL);
		return res;
	}

	@Override
	public Response deleteById(int id,int userId) {
		int num  = categoryDao.deleteById(id,userId);
		Response res = new Response(num>0? CodeDict.SUCCESS:CodeDict.FAIL);
		log.debug("用户:"+userId+"删除分类"+id+",结果为："+res);
		return res;
	}

	@Override
	public Category getById(int id,int userId) {
		return  categoryDao.findById(id,userId);	
	}

	/**
	 * 系统分类和用户分类进行联查
	 */
	@Override
	public List<Category> getAll() {
		return  categoryDao.findAllByUserId();		
	}

}

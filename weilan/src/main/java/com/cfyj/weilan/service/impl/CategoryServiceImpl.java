package com.cfyj.weilan.service.impl;

import java.util.List;

import org.owasp.esapi.ESAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cfyj.weilan.dao.CategoryDao;
import com.cfyj.weilan.domain.CodeDict;
import com.cfyj.weilan.domain.Response;
import com.cfyj.weilan.entity.Category;
import com.cfyj.weilan.entity.UserInfoSummary;
import com.cfyj.weilan.service.CategoryService;
import com.cfyj.weilan.service.UserInfoSummaryService;
import com.cfyj.weilan.utils.BaseLogUtil;
import com.cfyj.weilan.utils.XXSUtils;
/**
 * 
 * @author cfyj
 *2017年12月6日 下午2:22:08
 *上一层需要对传入下一层的数据做check
 */
@Service
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
		Integer categoryNum = categoryDao.findNumById(category.getUserId());
		if(categoryNum>max_categoryNum) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("增加失败：已到达最大数量");
			return res;
		}
		
		category.setDescription(XXSUtils.reEncode(category.getDescription()));
		int num = categoryDao.insertCategory(category);
		res = num>0? new Response(CodeDict.SUCCESS) : new Response(CodeDict.FAIL);
	
		return res;
	}
	
	@Override
	public Response editCategory(Category category) {
		Response res ; 
		Category dbCategory = categoryDao.findById(category.getId(), category.getUserId());

		if(dbCategory!=null && dbCategory.getName().equals(category.getName())) {
			res = new Response(CodeDict.FAIL);
			res.setMsg("分类名称已存在");
			return res;
		}

		category.setDescription(XXSUtils.reEncode(category.getDescription()));
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
	public List<Category> getAll(int userId) {
		return  categoryDao.findAllByUserId(userId);		
	}

}

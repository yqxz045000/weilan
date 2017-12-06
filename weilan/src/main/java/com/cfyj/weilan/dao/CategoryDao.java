package com.cfyj.weilan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.Category;

public interface CategoryDao {

	int deleteById( @Param("id") int  id, @Param("userId")int userId);

	Category findById(@Param("id")int id, @Param("userId")int userId);

	List<Category> findAllByUserId();

	int insertCategory(Category category);

	int updateCategory(Category category);

	int findNumById(Integer id, Integer userId);

}

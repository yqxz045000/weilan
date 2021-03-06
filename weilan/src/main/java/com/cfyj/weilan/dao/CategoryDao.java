package com.cfyj.weilan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cfyj.weilan.entity.Category;

@Mapper
public interface CategoryDao {

	int deleteById( @Param("id") int  id, @Param("userId")int userId);

	Category findById(@Param("id")int id, @Param("userId")int userId);

	List<Category> findAllByUserId(@Param("userId")int userId);

	int insertCategory(Category category);

	int updateCategory(Category category);

	int findNumById(@Param("userId")int userId);

}

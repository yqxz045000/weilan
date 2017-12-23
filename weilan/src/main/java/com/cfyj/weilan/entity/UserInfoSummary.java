package com.cfyj.weilan.entity;

import lombok.Data;

/**
 * 用户数据汇总
 * @author cfyj
 *2017年12月23日 下午12:56:33
 *
 */
@Data
public class UserInfoSummary {

//	private Long id ;
	private Integer userId; //主键
	private Integer shortMessageNum;  //短文数量
	private Integer longMessageNum;  //长文数量
	private Integer imgNum;			//图片数量
	private Integer categoryNum;	//分类数量
	private Integer feedbackNum; 	//反馈数量
	private Integer annoyanceWallNum ; //烦恼墙发布数量
	private Integer longMessageSpaceSize; 		//长文的占用空间
	private Integer imgSpaceSize; 		//图片的占用空间
	
	private User user ;

}

package com.cfyj.weilan.domain.query;

import java.util.Date;

import lombok.Data;

@Data
public class UserInfoSummaryQuery extends PageQuery{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8428320271751370015L;
	
	private Integer userId;
	
	private Date beginTime;
	
	private Date endTime;
}

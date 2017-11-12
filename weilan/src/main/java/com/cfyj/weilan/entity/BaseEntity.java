package com.cfyj.weilan.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2765072520384646344L;
	private Timestamp createTime;// 		创建时间
	private Timestamp modifyTime;// 		修改时间
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	
}

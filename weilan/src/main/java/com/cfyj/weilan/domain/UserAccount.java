package com.cfyj.weilan.domain;


import java.sql.Timestamp;

import com.cfyj.weilan.entity.BaseEntity;

/**
 * 
 * @author cfyj
 * 2017年11月12日 上午10:43:21
 *	记录账户信息
 */
public class UserAccount extends BaseEntity{

	private static final long serialVersionUID = 3113754709615583767L;
	/********************* 账户信息 **************************************/
	private String id;	//算法生成id
	private String userAccount; // 帐号
	private String passwd; // 密码
	private String oldPasswd; // 旧密码
	private String ip;//最后登录ip
	private Timestamp lastLoginTime;//最后登录时间

	/************************ 系统属性 *******************************/

	private String type; // 类型，暂不启用，留作扩展
	private String status; // 状态：正常、冻结、，默认正常
	private Integer level; // 级别,拥有默认级别
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getOldPasswd() {
		return oldPasswd;
	}
	public void setOldPasswd(String oldPasswd) {
		this.oldPasswd = oldPasswd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	
	

}

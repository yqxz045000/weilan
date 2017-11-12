package com.cfyj.weilan.domain;


import com.cfyj.weilan.entity.BaseEntity;

/**
 * 
 * @author cfyj
 * 2017年11月12日 上午10:43:21
 *	记录账户信息
 *
 */
public class UserAccount extends BaseEntity{

	private static final long serialVersionUID = 3113754709615583767L;
	/********************* 账户信息 **************************************/
	private String userAccount; // 帐号
	private String passwd; // 密码
	private String oldPasswd; // 旧密码

	/************************ 系统属性 *******************************/

	private String type; // 类型，暂不启用，留作扩展
	private String status; // 状态：正常、冻结、
	private Integer level; // 级别
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
	
	
	

}

package com.cfyj.weilan.entity;

import java.sql.Timestamp;

/**
 * 
 * @author cfyj 2017年11月11日 下午5:24:07 记录用户个人信息
 *
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = -5315889764337801051L;

	/**************** 个人信息 ****************************/
	private Integer id; // 主键，程序生成
	private String nickname; // 昵称
	private String sex; // 性别
	private Timestamp birthday; // 出生年月
	private String headImg; // 头像
	private String address; // 地址，暂不启用，留作扩展

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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

}

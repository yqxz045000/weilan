package com.cfyj.weilan.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author cfyj 2017年11月11日 下午5:24:07 记录用户个人信息
 *
 */
public class User extends BaseEntity {

	private static final long serialVersionUID = -5315889764337801051L;

	/**************** 个人信息 ****************************/
	private Integer id; // 主键，程序生成
	private String nickname; // 昵称 //可重复
	private String sex; // 性别
	private Date birthday; // 出生年月
	private String headImg; // 头像
	private String address; // 地址，暂不启用，留作扩展
	private String phone;//手机号

	/********************* 账户信息 **************************************/
	private String userAccount; // 帐号 不可重复
	private String passwd; // 密码
	private String oldPasswd; // 旧密码
	
	private String type; // 类型，暂不启用，留作扩展
	private String status; // 状态：正常、冻结、
	private Integer level; // 级别
	private String ip;//最后登录ip
	private Timestamp lastLoginTime;//最后登录时间
	
	

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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

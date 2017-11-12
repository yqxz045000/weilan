package com.cfyj.weilan.domain;

import java.sql.Timestamp;

import com.cfyj.weilan.entity.BaseEntity;

/**
 * 
 * @author cfyj
 * 2017年11月12日 上午10:43:56
 *	记录用户信息
 *
 */
public class UserInfo  extends BaseEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7703110009374913131L;
	/**************** 个人信息 ****************************/
	private Integer id; // 主键，程序生成
	private String nickname; // 昵称
	private String sex; // 性别
	private Timestamp birthday; // 出生年月
	private String headImg; // 头像
	private String address; // 地址，暂不启用，留作扩展
	
	
	
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
	
	
}

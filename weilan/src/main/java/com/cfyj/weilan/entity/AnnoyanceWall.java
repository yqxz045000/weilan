package com.cfyj.weilan.entity;
/**
 * 烦恼墙
 * @author cfyj
 *2017年12月13日 下午2:48:01
 *
 */
public class AnnoyanceWall extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376614943910046742L;

	private Integer id;
	
	private int userId;
	
	private String msg;
	
	private String nickName;
	
	private String ip;
	
	private String type;
	
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

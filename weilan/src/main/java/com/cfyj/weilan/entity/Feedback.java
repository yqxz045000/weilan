package com.cfyj.weilan.entity;
/**
 * 反馈信息
 * @author cfyj
 *2017年12月12日 下午7:59:33
 *
 */
public class Feedback extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6194970702633470043L;

	private Integer id;
	
	private Integer userId;
	
	private String msg; //内容
	
	private String status; //处理状态，0未处理，1已处理,10异常。
	
	private String type;//反馈类型
	
	private String replyMsg;//回复

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
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

	public String getReplyMsg() {
		return replyMsg;
	}

	public void setReplyMsg(String replyMsg) {
		this.replyMsg = replyMsg;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", userId=" + userId + ", msg=" + msg + ", status=" + status + ", type=" + type
				+ ", replyMsg=" + replyMsg + "]";
	}



}

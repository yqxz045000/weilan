package com.cfyj.weilan.entity;

/**
 * 
 * @author cfyj
 *2017年12月6日 下午5:45:50
 *longMessage的content
 */
public class LongMessageContent extends BaseEntity{

	private static final long serialVersionUID = 3161019238877094344L;
	
	private Integer id;
	
	private String content;
	
	private Integer userId;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

package com.cfyj.weilan.entity;
/**
 * 系统的常量表:储存一些动态可更改的常量
 * @author cfyj
 *2017年12月6日 下午3:53:12
 *
 */
public class SystemConstant extends BaseEntity {
	
	private static final long serialVersionUID = 6159766310513247134L;

	private String id;
	
	private String key;
	
	private String value ;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SystemConstant [id=" + id + ", key=" + key + ", value=" + value + "]";
	}

}

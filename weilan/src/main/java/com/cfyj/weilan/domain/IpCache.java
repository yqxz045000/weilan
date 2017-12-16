package com.cfyj.weilan.domain;

public class IpCache {
	
	private Long time;
	
	private Integer num;

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public IpCache(Long time, Integer num) {
		super();
		this.time = time;
		this.num = num;
	}
	
	public void incrementNum() {
		++num;
	}

	public IpCache() {
		super();
	}
	
}

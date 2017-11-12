package com.cfyj.weilan.domain;

public class CommonRes<T>  extends Response{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4033220658647870015L;
	public T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	

}

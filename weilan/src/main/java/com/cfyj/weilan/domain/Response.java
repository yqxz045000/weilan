package com.cfyj.weilan.domain;

public class Response extends BaseDomain{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4377710414136079214L;
	public int code;
	public String msg;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Response() {
		super();
	}
	public Response(CodeDict codeDict) {
		this.setCode(codeDict.getCode());
		this.setMsg(codeDict.getDesc());
	}
	@Override
	public String toString() {
		return "Response [code=" + code + ", msg=" + msg + "]";
	}
	
	
	
}

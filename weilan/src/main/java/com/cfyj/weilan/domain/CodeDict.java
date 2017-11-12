package com.cfyj.weilan.domain;

public enum CodeDict {
	SUCCESS("成功", 1), FAIL("失败", 2), EXEC("异常", 0);

	private String desc = "失败";
	private int code = 2;

	private CodeDict(String desc, int code) {
		this.desc = desc;
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}

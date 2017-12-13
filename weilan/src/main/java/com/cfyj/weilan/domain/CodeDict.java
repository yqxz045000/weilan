package com.cfyj.weilan.domain;

public enum CodeDict {
	SUCCESS("成功", 1), FAIL("失败", 2),OperationRes("您短时间内操作次数过多，请10分钟之后再执行，谢谢", 3),EXEC("异常", 0);

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

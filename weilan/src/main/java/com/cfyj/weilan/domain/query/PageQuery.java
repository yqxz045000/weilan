package com.cfyj.weilan.domain.query;

import com.cfyj.weilan.domain.BaseDomain;

public class PageQuery extends BaseDomain{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer pageNo=1;			//当前页
	
	private Integer pageSize=10;		//页大小
	
	private Integer totalRecord=0;	//总记录数
	
	private Integer totalPage=1;		//总页数
	
	

	public int getPageNo() {
		return pageNo==null?0:pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		if(totalRecord==null || totalRecord==0) {
			return 0;
		}
		if(totalRecord%pageSize>0) {
			totalPage = (totalRecord/pageSize)+1;
		}else {
			totalPage = totalRecord/pageSize;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getBegin() {
		if(this.pageNo==null) {
			this.pageNo = 1;
		}
		return (this.pageNo-1)*(this.pageSize);
	}
	
	public int getEnd() {
		return this.pageSize;
	}


}

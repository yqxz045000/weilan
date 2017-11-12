package com.cfyj.weilan.domain;
/**
 * 
 * @author cfyj
 * 2017年11月11日 下午5:51:44
 *	page对象
 *
 */
public class Page<T> extends BaseDomain{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8316790964378786456L;

	private Integer pageNo;			//当前页
	
	private Integer pageSize=10;		//页大小
	
	private Integer totalRecord;	//总记录数
	
	private Integer totalPage;		//总页数
	
	private T result;			//结果集

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

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
	
	

}

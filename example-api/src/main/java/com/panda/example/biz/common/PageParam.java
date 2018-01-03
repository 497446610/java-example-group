package com.panda.example.biz.common;

/**
 * 分页参数
 *
 */
public class PageParam {
	/**
	 * 页码
	 */
	private int pageIndex;

	/**
	 * 每页记录数
	 */
	private int pageSize;

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	

}

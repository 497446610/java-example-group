package com.panda.example.biz.common;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * 分页参数
 *
 */
public class PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8674441712591505992L;

	/**
	 * 页码
	 */
	@Min(value = 1, message = "页码不能小于1")
	private int pageIndex;

	/**
	 * 每页记录数
	 */
	@Max(value = 1000, message = "每页记录数不能大于1000")
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

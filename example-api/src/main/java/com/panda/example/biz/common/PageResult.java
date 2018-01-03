package com.panda.example.biz.common;

import java.util.List;

@SuppressWarnings({ "rawtypes" })
public class PageResult extends PageParam {

	/**
	 * 总的记录数
	 */
	private long total;

	/**
	 * 数据列表
	 */

	private List rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

}

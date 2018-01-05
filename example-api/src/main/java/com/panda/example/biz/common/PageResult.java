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

	/**
	 * 计算总的页数
	 * 
	 * @return
	 */
	public Long getTotalPage() {
		if (getTotal() < 0) {
			return 0L;
		}
		if (getPageSize() <= 0) {
			return 0L;
		}
		Long count = getTotal() / getPageSize();
		if (getTotal() % getPageSize() > 0) {
			count++;
		}
		return count;
	}

}

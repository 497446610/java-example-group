package com.panda.example.biz.api.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.panda.example.biz.common.PageParam;
import com.panda.example.biz.common.PageResult;
import com.panda.example.dao.common.Page;

@SuppressWarnings({ "rawtypes" })
public class BaseService {

	/**
	 * 错误日志
	 */
	private final static Logger logger = LoggerFactory.getLogger(BaseService.class);

	public Page query2Page(PageParam pageParam) {
		Page page = new Page(pageParam.getPageIndex(), pageParam.getPageSize());
		return page;
	}

	public PageResult pageList2PageResult(List rows, Page page) {
		PageResult result = new PageResult();
		result.setRows(rows);
		result.setPageIndex(page.getCurrPage());
		result.setPageSize(page.getPageSize());
		result.setTotal(page.getTotalPages());
		return result;
	}

	public PageResult emptyPageResult(Page page) {
		PageResult result = new PageResult();
		result.setRows(new ArrayList());
		result.setPageIndex(page.getCurrPage());
		result.setPageSize(page.getPageSize());
		result.setTotal(page.getTotalPages());
		return result;
	}

	public void copyProperties(Object dest, Object source) {
		if (dest == null || source == null) {
			return;
		}

		try {
			BeanUtils.copyProperties(dest, source);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}

package com.cy.memories.common.utils;

import java.util.List;

import com.cy.memories.common.vo.PageObject;




public class PageUtil {
	private static int pageSize = 5;
	public static int getPageSize() {
		return pageSize;
	}
	public static int getStartIndex(Integer pageCurrent) {
		return (pageCurrent-1)*pageSize;
	}
	public static <T> PageObject<T> newPageObject( Integer rowCount,List<T> records,Integer pageSize,Integer pageCurrent) {
		PageObject<T> pageObject = new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		pageObject.setPageCurrent(pageCurrent);
		return pageObject;
	}
}

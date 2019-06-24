package com.cy.memories.qzone.service;

import com.cy.memories.common.vo.PageObject;

public interface PageService<T> {
	 PageObject<T> findPageObjects(
			 String username,Integer pageCurrent);
}

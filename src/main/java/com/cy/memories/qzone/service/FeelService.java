package com.cy.memories.qzone.service;

import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.entity.FeelEntity;
import com.cy.memories.qzone.vo.FeelUserFeelCommVo;

public interface FeelService {
	//PageObject<FeelUserVo> findPageObjects(Integer userId,Integer pageCurrent);
	PageObject<FeelUserFeelCommVo> findPageObjects(Integer userId,Integer pageCurrent);
	int insertFeels(FeelEntity feel);
}

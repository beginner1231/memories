package com.cy.memories.qzone.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.entity.JournalEntity;

public interface JournalService {
	PageObject<JournalEntity> findPageObjects(Integer userId,Integer pageCurrent);
	int deleteObject(Integer id);
	int updateObject(JournalEntity entity);
	int deleteObjects(@Param("ids")Integer... ids);
	int insertObject(JournalEntity entity);
	JournalEntity findObjectById(Integer id);
	
}

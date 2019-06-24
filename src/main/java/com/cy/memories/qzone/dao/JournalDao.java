package com.cy.memories.qzone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.memories.qzone.entity.JournalEntity;


@Mapper
public interface JournalDao {
	
	int getRowCount(@Param("userId")Integer userId);
	
	List<JournalEntity> findPageObjects (
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	int deleteObject(Integer id);
	
	int deleteObjects(@Param("ids")Integer... ids);
	
	int insertObject(JournalEntity entity);
	
	int updateObject(JournalEntity entity);
	
	JournalEntity findObjectById(Integer id);
	
}

package com.cy.memories.qzone.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cy.memories.qzone.entity.FeelCommEntity;

@Mapper
public interface FeelCommDao {
	int insertObject(FeelCommEntity entity);
}

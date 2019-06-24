package com.cy.memories.qzone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.memories.qzone.entity.FeelEntity;
import com.cy.memories.qzone.vo.FeelUserFeelCommVo;

@Mapper
public interface FeelDao {
	int getRowCount(Integer userId);
	/*
	 * List<FeelUserVo> doFindObjects(
	 * 
	 * @Param("userId")Integer userId,
	 * 
	 * @Param("startIndex")Integer startIndex,
	 * 
	 * @Param("pageSize")Integer pageSize);
	 */
	List<FeelUserFeelCommVo> doFindObjects(
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	int insertFeels(FeelEntity feel);
}

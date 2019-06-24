package com.cy.memories.qzone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.memories.common.exception.ServiceException;
import com.cy.memories.qzone.dao.FeelCommDao;
import com.cy.memories.qzone.entity.FeelCommEntity;
import com.cy.memories.qzone.service.FeelCommService;
@Service
public class FeelCommServiceImpl implements FeelCommService {
	@Autowired
	private FeelCommDao feelCommDao;
	@Override
	public int insertObject(FeelCommEntity entity) {
		//参数校验
		if(entity==null) {
			throw new ServiceException("请输入内容");
		}
		if(StringUtils.isEmpty(entity.getContent())) {
			throw new ServiceException("评论内容不能为空");
		}
		//执行添加操作
		int rows = feelCommDao.insertObject(entity);
		if(rows==0) {
			throw new ServiceException("评论失败");
		}
		return rows;
	}

}
package com.cy.memories.qzone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.memories.common.exception.ServiceException;
import com.cy.memories.common.utils.PageUtil;
import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.dao.FeelDao;
import com.cy.memories.qzone.entity.FeelEntity;
import com.cy.memories.qzone.service.FeelService;
import com.cy.memories.qzone.vo.FeelUserFeelCommVo;
@Service
public class FeelServiceImpl implements FeelService {
	@Autowired
	private FeelDao feelDao;
	/*
	 * @Override public PageObject<FeelUserVo> findPageObjects(Integer userId,
	 * Integer pageCurrent) { //1.参数验证 if(pageCurrent==null||pageCurrent<1) { throw
	 * new IllegalArgumentException("页码不正确"); } //2.根据查询条件查询总记录数 int rowCount =
	 * feelDao.getRowCount(userId); if(rowCount==0) { throw new
	 * ServiceException("没有符合条件的记录"); } int startIndex =
	 * PageUtil.getStartIndex(pageCurrent); int pageSize = PageUtil.getPageSize();
	 * List<FeelUserVo> records = feelDao.doFindObjects(userId, startIndex,
	 * pageSize); PageObject<FeelUserVo> pageObject =
	 * PageUtil.newPageObject(rowCount, records, pageSize, pageCurrent); return
	 * pageObject; }
	 */
	@Override
	public PageObject<FeelUserFeelCommVo> findPageObjects(Integer userId, Integer pageCurrent) {
		//1.参数验证
		if(pageCurrent==null||pageCurrent<1) {
			throw new IllegalArgumentException("页码不正确");
		}
		//2.根据查询条件查询总记录数
		int rowCount = feelDao.getRowCount(userId);
		if(rowCount==0) {
			throw new ServiceException("没有符合条件的记录");
		}
		int startIndex = PageUtil.getStartIndex(pageCurrent);
		int pageSize = PageUtil.getPageSize();
		List<FeelUserFeelCommVo> records = feelDao.doFindObjects(userId, startIndex, pageSize);
		System.out.println(records);
		PageObject<FeelUserFeelCommVo> pageObject = PageUtil.newPageObject(rowCount, records, pageSize, pageCurrent);
		return pageObject;
	}
	@Override
	public int insertFeels(FeelEntity feel) {
		//参数校验
		if(feel==null) {
			throw new ServiceException("请输入内容");
		}
		if(StringUtils.isEmpty(feel.getContent())) {
			throw new ServiceException("说说内容不能为空");
		}
		//执行添加说说操作
		int rows = feelDao.insertFeels(feel);
		if(rows==0) {
			throw new ServiceException("添加失败");
		}
		return rows;
	}
	
}

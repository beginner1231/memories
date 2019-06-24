package com.cy.memories.qzone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.memories.common.exception.ServiceException;
import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.dao.MessagesBoardDao;
import com.cy.memories.qzone.entity.MessagesBoard;
import com.cy.memories.qzone.service.MessagesBoardService;

@Service
public class MessagesBoardServiceImpl implements MessagesBoardService{
	@Autowired
	private MessagesBoardDao messagesBoardDao;
	@Override
	public PageObject<MessagesBoard> findPageObjects(
		Integer userId, Integer pageCurrent) {
		//1.判定pageCurrent参数合法性
		if(pageCurrent==null||pageCurrent<1) 
		throw new IllegalArgumentException("当前页码值不正确");
		//2.查询日志总记录数,并进行判定
		int rowCount=messagesBoardDao.getRowCount(userId);
		if(rowCount==0)
		throw new ServiceException("没有找到对应记录");
		//3.查询当前页日志记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<MessagesBoard> records=
				messagesBoardDao.findMessagesObjects(userId);
		//4.对查询结果进行封装并返回
		PageObject<MessagesBoard> po=new PageObject<>();
		po.setRowCount(rowCount);
		po.setRecords(records);
		po.setPageCurrent(pageCurrent);
		po.setPageSize(pageSize);
		int pageCount=(rowCount-1)/pageSize+1;
		po.setPageCount(pageCount);
		return po;
	}

	@Override
	public int insertMessage(String content, Integer userId, Integer createUserId) {
		int rows=messagesBoardDao.insertMessager(content, userId, createUserId);
		if (rows==0)
		throw new ServiceException("删除失败");
		return rows;
	}

	@Override
	public int deletetMessage(Integer id) {
		return messagesBoardDao.deletetMessage(id);
	}
}

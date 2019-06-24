package com.cy.memories.qzone.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cy.memories.common.exception.ServiceException;
import com.cy.memories.common.utils.PageUtil;
import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.dao.JournalDao;
import com.cy.memories.qzone.entity.JournalEntity;
import com.cy.memories.qzone.service.JournalService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class JournalServiceImpl implements JournalService{
	@Autowired
	private JournalDao journalDao;

	@Override
	public PageObject<JournalEntity> findPageObjects(Integer userId, Integer pageCurrent) {
		//1.校验参数
		//1.1验证pageCurrent的合法性，
		if (pageCurrent==null||pageCurrent<1) {
			//不合法抛出IllegalArgumentException异常
			throw new IllegalArgumentException("页码不正确");
		}

		//2.基于条件查询总记录数并进行校验
		//2.1) 执行查询
		int rowCount = journalDao.getRowCount(userId);
		//2.2) 验证查询结果,假如结果为0不再执行如下操作
		if (rowCount==0) {
			throw new ServiceException("纪录不存在");
		}

		//3.基于条件查询当前页记录(pageSize定义为2)
		//3.1)定义pageSize
		int pageSize = PageUtil.getPageSize();
		//3.2)计算startIndex
		int startIndex = PageUtil.getStartIndex(pageCurrent);
		//3.3)执行当前数据的查询操作
		List<JournalEntity> records = journalDao.findPageObjects(userId, startIndex, pageSize);
		System.out.println(records);
		//4.对分页信息以及当前页记录进行封装
		//4.1)构建PageObject对象
		//4.2)封装数据
		PageObject<JournalEntity> pageObject = PageUtil.newPageObject(rowCount, records, pageSize, pageCurrent);

		//5.返回封装结果。
		return pageObject;
	}

	@Override
	public int deleteObject(Integer id) {
		//1.验证数据的合法性
		if (id==null||id<=0) {
			throw new IllegalArgumentException("请先选择");
		}

		int rows = journalDao.deleteObject(id);
		if (rows==0) {
			throw new ServiceException("此菜单可能已经不存在");
		}

		return rows;

	}

	@Override
	public int updateObject(JournalEntity entity) {
		//1.合法验证
		if(entity==null) {
			throw new ServiceException("保存对象不能为空");
		}
		if (StringUtils.isEmpty(entity.getTitle())) {
			throw new ServiceException("标题不能为空");
		}
		if (StringUtils.isEmpty(entity.getContent())) {
			throw new ServiceException("内容不能为空");
		}

		//2.更新数据
		int rows=journalDao.updateObject(entity);
		if(rows==0) {
			throw new ServiceException("记录可能已经不存在");
		}
		//3.返回数据
		return rows;
	}

	@Override
	public int deleteObjects(Integer... ids) {
		int rows = journalDao.deleteObjects(ids);
		if (rows>0) {
			log.info("delete ok,rows="+rows);
		}
		//3.验证并返回结果
		return rows;
	}

	@Override
	public int insertObject(JournalEntity entity) {
		//1.合法验证
		if (entity==null) {
			throw new ServiceException("保存对象不能为空");
		}
		if (StringUtils.isEmpty(entity.getTitle())) {
			throw new ServiceException("标题不能为空");
		}
		if (StringUtils.isEmpty(entity.getContent())) {
			throw new ServiceException("内容不能为空");
		}
		//2.保存数据
		int rows;
		try{
			rows=journalDao.insertObject(entity);
		}catch(Exception e){
			e.printStackTrace();
			throw new ServiceException("保存失败");
		}
		//3.返回数据
		return rows;
	}

	@Override
	public JournalEntity findObjectById(Integer id) {
		if (id==null||id<1){
            throw new ServiceException("参数数据不合法,id="+id);
        }
        JournalEntity journal = journalDao.findObjectById(id);
        if (journal==null){
            throw new ServiceException("此日志不存在");
        }
        
        return journal;
	}

}

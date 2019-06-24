package com.cy.memories.qzone.service;

import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.entity.MessagesBoard;

public interface MessagesBoardService {
	   /**
	    * 基于id删除留言信息
	    * @param id
	    * @return
	    */
	   PageObject<MessagesBoard> findPageObjects(Integer userId, Integer pageCurrent);
	   
	   int insertMessage(String content,Integer userId,Integer createUserId);
	   int deletetMessage(Integer id);
}

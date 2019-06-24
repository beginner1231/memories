package com.cy.memories.qzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.memories.common.vo.JsonResult;
import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.entity.MessagesBoard;
import com.cy.memories.qzone.service.MessagesBoardService;

@Controller
@RequestMapping("/messageBoard/")
public class MessageBoardConreoller {
	@Autowired
	private MessagesBoardService messagesBoardService;

	@RequestMapping("doMessageBoardUI")
	public String doIndexUI() {
		return "messages-board";
	}

	@RequestMapping("findMessagesObjects")
	@ResponseBody
	public JsonResult findMessagesObjects(Integer userId, Integer pageCurrent) {
		PageObject<MessagesBoard> pageObject = messagesBoardService.findPageObjects(userId, pageCurrent);
		return new JsonResult(pageObject);
	}

	@RequestMapping("insertMessage")
	@ResponseBody
	public JsonResult insertMessage(String content, Integer userId, Integer createUserId) {
		messagesBoardService.insertMessage(content, userId, createUserId);
		return new JsonResult("发表成功" );
	}
	@RequestMapping("deleteMessage")
	@ResponseBody
	public JsonResult deleteMessage(Integer id) {
		messagesBoardService.deletetMessage(id);
		return new JsonResult("删除成功" );
	}
}

package com.cy.memories.qzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.memories.common.vo.JsonResult;
import com.cy.memories.qzone.entity.FeelCommEntity;
import com.cy.memories.qzone.service.FeelCommService;

@Controller
@RequestMapping("/feelcomm/")
public class FeelCommController {
	@Autowired
	private FeelCommService feelCommService;
	@RequestMapping("insertCommObject")
	@ResponseBody
	public JsonResult insertCommObject(FeelCommEntity entity) {
		feelCommService.insertObject(entity);
		return new JsonResult("save ok");
	}
}

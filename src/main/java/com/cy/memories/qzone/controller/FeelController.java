package com.cy.memories.qzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.memories.common.vo.JsonResult;
import com.cy.memories.qzone.entity.FeelEntity;
import com.cy.memories.qzone.service.FeelService;

@Controller
@RequestMapping("/feel/")
public class FeelController {
	@Autowired
	private FeelService feelService;
	
	/** 返回说说列表页面 */
	@RequestMapping("doFeelListUI")
	public String doFeelListUI() {
		return "feel";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer pageCurrent) {
		//获取登录用户
		//SysUser user=(SysUser)SecurityUtils.getSubject().getPrincipal();
		//sysUserService.validById(id,valid,user.getUsername());
		return new JsonResult(feelService.findPageObjects(1, pageCurrent));
	}
	@RequestMapping("insertFeels")
	@ResponseBody
	public JsonResult insertFeels(FeelEntity entity) {
		//获取登录用户
		//SysUser user=(SysUser)SecurityUtils.getSubject().getPrincipal();
		//sysUserService.validById(id,valid,user.getUsername());
		feelService.insertFeels(entity);
		return new JsonResult("save ok");
	}
}

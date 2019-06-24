package com.cy.memories.qzone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.memories.common.vo.JsonResult;
import com.cy.memories.qzone.entity.JournalEntity;
import com.cy.memories.qzone.service.JournalService;

@Controller
@RequestMapping("/journal/")
public class JournalController {
	@Autowired
	private JournalService journalService;

	@RequestMapping("doJournalUI")
	public String doJournalUI() {
		return "projects";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer userId, Integer pageCurrent) {
		
		return new JsonResult(journalService.findPageObjects(1, pageCurrent));
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(JournalEntity entity) {
		journalService.updateObject(entity);
		return new JsonResult("更新成功");
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(JournalEntity entity) {
		journalService.insertObject(entity);
		return new JsonResult("保存成功");
	}
	
	@RequestMapping("doDeleteObject")
    @ResponseBody
    public JsonResult doDeleteObject(Integer id) {
        journalService.deleteObject(id);
        return new JsonResult("删除成功");
    }
	
	@RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids) {
        journalService.deleteObjects(ids);
        return new JsonResult("删除成功");
    }
	
	@RequestMapping("doEditorUI")
	public String doEditorUI() {
		return "text-editor";
	}
	
	@RequestMapping("doEditorUI2")
	public String doEditorUI2() {
		return "text-editor2";
	}
	
	@RequestMapping("doFindObjectById")
    @ResponseBody
    public JsonResult doFindObjectById(Integer id) {
        return new JsonResult(journalService.findObjectById(id));
    }
}

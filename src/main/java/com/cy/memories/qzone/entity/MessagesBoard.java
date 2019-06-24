package com.cy.memories.qzone.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author hzihao
 *	留言板实体类
 */
public class MessagesBoard implements Serializable{
	private static final long serialVersionUID = -5529200217189925180L;
	/**
	 * 留言记录主键
	 */
	private Integer id;
	/**
	 * 留言内容
	 */
	private String content;
	/**
	 * 被留言者id
	 */
	private Integer userId;
	/**
	 * 留言创建者id
	 */
	private Integer createUserId;
	/**
	 * 留言时间
	 */
	private Date createdTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}
	public Date getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	
}

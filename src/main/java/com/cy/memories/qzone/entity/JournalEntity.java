package com.cy.memories.qzone.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class JournalEntity implements Serializable{
	private static final long serialVersionUID = 1612729563702711669L;
	private Integer id;
	private String title;
	private String content;
	private Date createdTime;
	private Date modifiedTime;
	private String label;
	private Integer userId=1;
}

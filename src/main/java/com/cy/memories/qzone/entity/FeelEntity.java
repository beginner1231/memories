package com.cy.memories.qzone.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class FeelEntity implements Serializable {
	private static final long serialVersionUID = -3920905693943431201L;
	private Integer id;
	private Integer userId;
	private Date createdTime;
	private String content;
}

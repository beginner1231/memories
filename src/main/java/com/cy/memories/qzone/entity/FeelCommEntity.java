package com.cy.memories.qzone.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class FeelCommEntity implements Serializable {
	private static final long serialVersionUID = 5369194157812955578L;
	private Integer id;
	private Date createdTime;
	private String content;
	private Integer userId;
	private Integer feelId;
}

package com.cy.memories.qzone.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data
public class FeelCommUserVo implements Serializable {
	private static final long serialVersionUID = -7792755671031743723L;
	private Integer id;
	private Integer userId;
	private Integer feelId;
	private Date createdTime;
	private String content;
	private String nickName;
}

package com.cy.memories.qzone.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class FeelUserFeelCommVo implements Serializable{
	private static final long serialVersionUID = -4294744873534540847L;
	private Integer id;
	private Integer userId;
	private Date createdTime;
	private String content;
	private String nickName;
	private List<FeelCommUserVo> feelcomms;
}

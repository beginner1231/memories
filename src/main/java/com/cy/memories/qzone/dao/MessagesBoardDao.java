package com.cy.memories.qzone.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cy.memories.qzone.entity.MessagesBoard;

/**
 * 
 * @author hzihao
 *  留言板dao接口
 */
@Mapper
public interface MessagesBoardDao {
	/**
	 * 查询用户所有留言
	 */
	  List<MessagesBoard> findMessagesObjects( @Param("userId")Integer userId);
	  /**
	   * 总记录数
	   *
	   */
	  int getRowCount(@Param("userId")Integer userId);
	  /**
	   * 发表留言
	   *
	   */
	  int insertMessager(@Param("content")String content,
			  						@Param("userId")Integer userId,
			  						@Param("createUserId")Integer createUserId);
	  
	  int deletetMessage(@Param("id")Integer id);
}

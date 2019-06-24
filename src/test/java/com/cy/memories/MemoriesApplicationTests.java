package com.cy.memories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.memories.common.vo.PageObject;
import com.cy.memories.qzone.dao.JournalDao;
import com.cy.memories.qzone.entity.JournalEntity;
import com.cy.memories.qzone.service.JournalService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoriesApplicationTests {
	@Autowired
	private JournalService journalService;
	@Test
	public void testDeleteObject() {
		PageObject<JournalEntity> findPageObjects = journalService.findPageObjects(1, 1);
		System.out.println(findPageObjects);
	}

}

package com.cy.memories;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cy.memories.qzone.dao.FeelDao;
import com.cy.memories.qzone.vo.FeelUserFeelCommVo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemoriesApplicationTests {
	@Autowired
	private FeelDao feelDao;

    @Test
    public void contextLoads() {
    	List<FeelUserFeelCommVo> doFindObjects = feelDao.doFindObjects(1, 0, 5);
    	System.out.println(doFindObjects);
    }
    

}

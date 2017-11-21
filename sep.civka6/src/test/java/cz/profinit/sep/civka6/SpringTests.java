package cz.profinit.sep.civka6;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cz.profinit.sep.civka6.dao.ObjektDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringTests {

	@Autowired
	ObjektDao objektDao;
	
	@Test
	public void testObjektDao() {
		Assert.assertEquals(5, objektDao.count());
	}
	
}

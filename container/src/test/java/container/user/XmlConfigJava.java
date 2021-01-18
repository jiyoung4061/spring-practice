package container.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes= {AppConfig01.class})
@ContextConfiguration(locations= {"/container/config/user/applicationContext01.xml"})
public class XmlConfigJava {
	@Autowired
	@Qualifier("user2") // class가 많을때 id로 구분지어줌
	private User user;
	
	@Test
	public void testUserNotNull() {
		assertNotNull(user); // 
	}
	
	@Ignore
	@Test
	public void testGetName() {
//		assertEquals(user.getName(), "둘리"); 
	}
}

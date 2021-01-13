package container.user;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import container.config.user.AppConfig01;

public class JavaConfigTest {
	
	@Test
	public void testJavaConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = ac.getBean(User.class);
		assert(user != null);

		// 자원 정리
		((ConfigurableApplicationContext) ac).close();
	}
	
	@Test
	private void testJavaConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("container.config.user");
																		// 위 package경로에가서 scan하면서 어떤것이 config파일인지 스캔함
																		
		User user = ac.getBean(User.class);
		assert(user != null);

		// 자원 정리
		((ConfigurableApplicationContext) ac).close();
	}
}

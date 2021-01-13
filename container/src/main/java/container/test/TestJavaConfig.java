package container.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import container.config.user.AppConfig01;
import container.user.User;

public class TestJavaConfig {

	public static void main(String[] args) {

		// 1. 직접 자바 설정 클래스를 전달
		// testJavaConfig01();

		// 2. 직접 자바 설정 클래스가 있는 베이스 패키지를 전달
		testJavaConfig02();

	}

	private static void testJavaConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = ac.getBean(User.class);
		System.out.println(user);

		// 자원 정리
		((ConfigurableApplicationContext) ac).close();
	}
	
	private static void testJavaConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("container.config.user");
																		// 위 package경로에가서 scan하면서 어떤것이 config파일인지 스캔함
																		
		User user = ac.getBean(User.class);
		System.out.println(user);

		// 자원 정리
		((ConfigurableApplicationContext) ac).close();
	}

}

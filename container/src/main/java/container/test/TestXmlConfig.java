package container.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import container.user.User;
import container.user.User1;
import container.user.User2;

// 나중에 junit으로 갈 부분
public class TestXmlConfig {

	public static void main(String[] args) {

		// XML Auto Configuration(Annotation Scanning)
		 testBeanFactory01();

		// XML Bean Configuration(빈설정, Explicit(명시적) Configuration)
		 testBeanFactory02();

		// XML Auto Configuration(Annotation Scanning)
		 testApplicationContext01();

		// XML Bean Configuration(빈설정, Explicit(명시적) Configuration)
		testApplicationContext02();
	}

	// XML Auto Configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		// 절대경로로 바꿔준다?
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("container/config/user/applicationContext01.xml"));

		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean의 id가 자동생성됨
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Bean Configuration(빈설정, Explicit(명시적) Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("container/config/user/applicationContext02.xml"));

		User2 user2 = bf.getBean(User2.class);
		System.out.println(user2.getName());

		// 빈설정(Explicit Config)에서는 Bean의 id가 자동 생성되지 않음!
		// 명시적으로 설정해야함!!
		user2 = (User2) bf.getBean("user");
		System.out.println(user2.getName());
	}

	// XML Auto Configuration(Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("container/config/user/applicationContext01.xml");

		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean의 id가 자동생성됨
		user1 = (User1) ac.getBean("user1");
		System.out.println(user1.getName());

		// 자원 정리
		((ConfigurableApplicationContext) ac).close();
	}

	// XML Bean Configuration(빈설정, Explicit(명시적) Configuration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("container/config/user/applicationContext02.xml");

		// id로 빈 가져오기
		User user = (User) ac.getBean("user1");
		System.out.println(user);

		// name으로 빈 가져오기 => 왠만하면 id사용할것!
		user = (User) ac.getBean("usr");
		System.out.println(user);

		// 1. 1개 파라미터로 생성된 빈 가져오기
		// 2. type으로 빈 가져오기
		// =>같은 타입의 객체가 2개이상 있으면 ERROR!
		// =>type + id 또는 type + name으로 가져와야함.
		user = ac.getBean("user2", User.class);
		System.out.println(user);

		// 2개 파라미터로 생성된 빈 가져오기1
		user = ac.getBean("user3", User.class);
		System.out.println(user);

		// 2개 파라미터로 생성된 빈 가져오기2=>index 사용
		user = ac.getBean("user4", User.class);
		System.out.println(user);

		// 기본생성자 + setter + DI 적용한 사용한 빈 가져오기 1
		user = ac.getBean("user5", User.class);
		System.out.println(user);

		// 기본생성자 + setter + DI 적용한 사용한 빈 가져오기 2
		user = ac.getBean("user6", User.class);
		System.out.println(user);

		// setter를 사용한 list 세팅하기
		user = ac.getBean("user7", User.class);
		System.out.println(user);

		// 자원 정리
		((ConfigurableApplicationContext) ac).close();
	}
}

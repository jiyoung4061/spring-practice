package container.config.user;

import org.springframework.context.annotation.Bean;

import container.user.User;

//@Configuration : 안해줘도 됨!! (package 지정해주어서!)
public class AppConfig01 {
	
	@Bean
	public User user() {
		return new User();
	}
}

package container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import container.videosystem.Avengers;
import container.videosystem.DVDPlayer;
import container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	// bean 생성 method들

	@Bean
	public Avengers avengers() {
		return new Avengers();
	}

	// 주입하기01:파라미터로 Bean(avengers) 전달하기 <setter 주입>
//	@Bean
	public DVDPlayer dvdPlayer01(DigitalVideoDisc dvd) {
		// bean 생성과 동시에 DI주입
		DVDPlayer dvdPlayer = new DVDPlayer();
		dvdPlayer.setDvd(dvd);
		return dvdPlayer;
	}

	// 주입하기02 <생성자 주입> : 파라미터로 Bean 전달하기
//	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}

	// 주입하기03 <생성자 주입> : Bean 생성 method를 직접호출 => 헷갈려서 잘 안씀!!
	@Bean
	public DVDPlayer dvdPlayer03() {
		return new DVDPlayer(avengers());
	}

	// 주입하기04 : 같은 타입을 생성할 경우
	@Bean("player04") // bean id를 설정하고싶을 경우
	public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}

}

package container.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	/*
	 * // Wiring01 : 필드 직접주입(CGLib) => 장: getter, setter가 필요없어 코드가 깨끗해짐 // @Inject
	 * // 자바 표준 Wiring Annotation => 많이 쓰이지X
	 * 
	 * @Autowired // @Qualifier("hsRapper3Final") // named사용했을때, component
	 * annotation에서 이름지정해주었을때
	 * 
	 * @Qualifier("highSchoolRapper3Final") // id는 class이름에서 맨앞에 대문자를 소문자로 만들어줌
	 */
	private CompactDisc cd;

//	// 기본 생성자
//	public CDPlayer() {}
	// Wiring02 : 생성자 주입
	@Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}

	// Wiring03 : setter 주입
//	@Autowired
	public void setCd(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// Wiring04 : 일반 method 주입
	@Autowired
	public void insertCd(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}

	public void play() {
		cd.play();
	}

}

package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component	// 싱글톤 패턴으로 Sender 객체가 생성, 객체 변수명은 sender가 된다.
//@Component("sendersender") // 객체 변수명 다르게 쓰려면 명시해주기
//@Scope("prototype") // prototype으로 쓰고 싶다면 명시해주기
public class Sender implements SenderInter {
	
	public void show() {
		System.out.println("Sender 클래스 내 show 메서드 수행");
	}

}

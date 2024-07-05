package anno1_auto;

import org.springframework.stereotype.Component;

@Component
public class Sender2 implements SenderInter{

	@Override
	public void show() {
		System.out.println("Sender2 클래스 내 show 메서드 처리");
		
	}
}

package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("aopInit.xml");
		
		// AOP 적용 전 - 관심사항 아직 없엉
//		MessageInter inter = (MessageInter) context.getBean("targetBean");
//		inter.sayHi();
		
		// 
		// 원래는 sayHi() 하나만 수행하게끔 계획
		// 근데 누군가가 sayHi 전에 다른 기능 (로그인, 보안 등) 넣어달라
		// 프로젝트 규모가 크다고 가정
		// 어느 세월에 하나하나 다 하느냐
		
		// AOP 적용 후
		MessageInter inter = (MessageInter) context.getBean("proxy");
		inter.sayHi();
		
		// 필요에 따라서 
	

	}

}

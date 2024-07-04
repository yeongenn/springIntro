package pack.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		/*
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("configuration.xml");
		*/
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("configuration.xml");
		
		// singleton 확인용 (다형성 X)
//		MessageImpl messageImpl = (MessageImpl) context.getBean("messageImpl");
//		messageImpl.sayHi();
		
//		MessageImpl messageImpl2 = (MessageImpl) context.getBean("messageImpl");
//		messageImpl2.sayHi();
		
//		System.out.println("객체 주소 : " + messageImpl + " / " + messageImpl2);
		// MessageImpl@3a079870 / MessageImpl@3a079870
		// 주소가 동일하다 -> 싱글톤 패턴~!
		// bean scope="prototype" 명시해주면
		// MessageImpl@6f3b5d16 / MessageImpl@78b1cc93 -> 주소가 다르다
		// heap 영역에 2개의 객체가 인스턴스
		
		// 다형성 처리
		// Spring에서는 이 방법으로~
		MessageInter inter = (MessageInter) context.getBean("messageImpl");
		inter.sayHi();
		
		// casting한 것과 동일한 결과
//		MessageInter inter2 = context.getBean("messageImpl", MessageInter.class);
//		inter.sayHi();
		
		// ApplicationContext 타입으로 선언하면 context.close()가 불가능
		// GenericXmlApplicationContext 타입으로 선언해주면 close가 가능
		context.close(); 

	}

}

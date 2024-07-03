package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		// 처리 1 : 전통적 방법
		Message1 message1 = new Message1();
		message1.sayHello("ye");
		
		Message2 message2 = new Message2();
		message2.sayHello("yeye");
		
		System.out.println();
		MessageInter inter;
		inter = message1;
		inter.sayHello("abc");
		inter = message2;
		inter.sayHello("def");
		
		// 처리 2 : Spring 방법
		// (init.xml 작성)
		System.out.println("\n--Spring 방법--");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("init.xml"); // 웹에서는 내부적으로 처리
		MessageInter inter2 = (MessageInter) context.getBean("mes1");
		inter2.sayHello("orange");
		MessageInter inter3 = (MessageInter) context.getBean("mes2");
		inter3.sayHello("sydney");
	}

}

package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("bankInit.xml");
		Gogek daniel = context.getBean("gogek", Gogek.class);
		daniel.selectBank("shinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.println("daniel ~ : ");
		daniel.showMoney();
		
		Gogek john = context.getBean("gogek", Gogek.class);
		john.selectBank("shinhan");
		john.playInputMoney(500);
		john.playOutputMoney(200);
		System.out.println("john ~ : ");
		john.showMoney(); // 5300원이 아니라 5600원이 나온다! -> 싱글톤이기 때문
		// 어떤 프로그램을 만드느냐에 따라 싱글톤 사용가능 여부가 다르겠지
		// 싱글톤 쓰면 안되는 프로그램에서는 prototype으로 선언해줘야겠지
		
		Gogek oscar = context.getBean("gogek", Gogek.class);
		oscar.selectBank("hana");
		oscar.playInputMoney(500);
		oscar.playOutputMoney(100);
		System.out.println("oscar ~ : ");
		oscar.showMoney();
		
		System.out.println("객체 주소");
		System.out.println("daniel : " + daniel); // Gogek@37f1104d
		System.out.println("john : " + john); // Gogek@37f1104d
		System.out.println("oscar : " + oscar); // Gogek@37f1104d
		// @Scope("prototype") 입력하고 나면 주소가 다 달리 나온다
	}

}

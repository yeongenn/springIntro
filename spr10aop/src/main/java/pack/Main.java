package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("aopInit.xml");
		
		LogicInter inter = (LogicInter) context.getBean("loginImpl");		
		inter.selectDataProcess1();
		inter.selectDataProcess2();
		
				
	}

}

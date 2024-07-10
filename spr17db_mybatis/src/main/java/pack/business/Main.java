package pack.business;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@Configuration
@ComponentScan(basePackages = "pack")
public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Main.class);
		/*
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("init.xml");
		*/
		BusinessInter inter = (BusinessInter) context.getBean("businessImpl");
		inter.dataPrint();
		
	}

}

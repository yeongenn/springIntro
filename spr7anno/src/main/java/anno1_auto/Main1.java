package anno1_auto;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "anno1_auto") // xml에서 scan하지 말고 메인에서 - xml 의존성 탈피
public class Main1 {

	public static void main(String[] args) {
		// @Autowired 메인
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Main1.class);
		SenderProcess process = 
				(SenderProcess) context.getBean("senderProcess");
		process.dispData();
	}

}

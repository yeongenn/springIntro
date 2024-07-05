package anno3_etc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("my")
public class MyProcess {
	// @Value : 변수의 값을 초기화하기 위해 사용할 수도 있다
	// spEL(Spring EL) : #{표현식}, 만들어진 Component 객체를 이용, private는 getter를 ~?
	// 속성값을 참조할 때는 $ 기호 + 중괄호로 표현한다 ${property.name}
	
	@Value("#{dataInfo.name}") // @Value로 값 주입하기
	private String name;
	
	private String part;
	
	@Autowired
	//public MyProcess(@Value("전산부") String part) {
	public MyProcess(@Value("#{dataInfo.part}") String part) {
		this.part = part;
	}
	
	@Value("123") // 기본이 String type
	private int age;
	
	@Value("1, 2, 3, 4")
	private int arr[];
	
	public void showData() {
		System.out.println("name : " + name);
		System.out.println("part : " + part);
		System.out.println("age : " + age);
		System.out.println(arr[0] + " " + arr[3]);
	}

}

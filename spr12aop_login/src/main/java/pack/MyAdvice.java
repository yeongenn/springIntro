package pack;

import java.util.Scanner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvice {

	@Around("execution(public void startProcess())")
	public Object abc(ProceedingJoinPoint joinPoint) throws Throwable {
		// MethodInterceptor와 ProceedingJoinPoint의 차이?
		
		System.out.println("AOP 시작 >>> 핵심 로직 수행 전 ID 검증");
		
		System.out.print("Input ID : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		sc.close();
		
		if(!id.equals("ok")) {
			System.out.println("아이디 불일치! 작업을 종료합니당");
			return null; // null을 반환하면 proceed를 만나지 않고 메서드 종료
		}
		
		Object object = joinPoint.proceed(); // 핵심 로직 수행하기
		
		return object;
	}
}

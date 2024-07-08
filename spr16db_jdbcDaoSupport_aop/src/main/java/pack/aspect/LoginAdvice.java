package pack.aspect;

import java.util.Scanner;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAdvice { // 관심사항

	@Around("execution(public void jikwonList())")
	public Object haha(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.print("로그인 아이디 입력 : ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		
		if(!id.equals("kor")) {
			System.out.println("아이디 불일치~ 로그인 실패~!");
			return null;
		}
		
		Object object = joinPoint.proceed();
		sc.close();
		
		return object;
	}
}

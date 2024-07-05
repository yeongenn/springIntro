package aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

// 핵심 로직 전후로 삽입할 관심 코드
// ex) transaction, login, security, log ...
// MethodInterceptor 
public class MyAdvice implements MethodInterceptor {
	
	// invoke 메서드 : 시스템에 의해서 호출된다
	// joinpoint에 삽입되어 동작할 코드 기술
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("핵심 로직 수행 전 뭔가를 처리");
		// target 메서드 이름 얻기
		String targetMethodName = invocation.getMethod().getName();
		System.out.println("적용된 메서드명 : " + targetMethodName);
		
		Object object = invocation.proceed();
		// 선택된 핵심 로직 메서드 중 하나 - sayHi()로 지적할 예정
		
		System.out.println("핵심 로직 수행 후 마무리 처리");
		
		return object;
	}
	
}

package pack;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
public class OurAdvice { // Aspect 클래스 : Advice용
	
	@Around("execution(* *..*LogicInter*.*(..)) or execution(public void selectAll())")
	public Object kbs(ProceedingJoinPoint joinPoint) throws Throwable{
		// 수행 시간 체크
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		System.out.println("핵심 메서드 수행 전 관심사항 실행");
		
		Object object = joinPoint.proceed(); // 선택된 핵심 메서드 수행, 반환값은 object에 저장
		
		System.out.println("핵심 메서드 수행 후 관심사항 실행");
		
		stopWatch.stop();
		System.out.println("처리 시간 : " + stopWatch.getTotalTimeSeconds());
		return object;
	}
	
	// ...

}

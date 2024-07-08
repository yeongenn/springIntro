package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bsnsImpl")
public class BusinessImpl implements BusinessInter {
	// DB 처리를 하는 모델 클래스를 포함관계로 호출
	
	private SangpumInter inter;
	
	@Autowired
	public BusinessImpl(SangpumInter inter) {
		this.inter = inter;
	}
	
	/*
	@Override
	public void selectProcess() {
		for(SangpumDto s : inter.selectAll()) {
			System.out.println(s.getCode() + " " + 
								s.getSang() + " " + 
								s.getSu() + " " + 
								s.getDan());
		}

	}
	*/
	
	// 람다 표현식 사용
	// 
	@Override
	public void selectProcess() {
		inter.selectAll().forEach(s -> 
			System.out.println(s.getCode() + " " + 
								s.getSang() + " " + 
								s.getSu() + " " + 
								s.getDan())
				);
		
	}
	

}

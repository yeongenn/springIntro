package pack;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BusinessImpl implements BusinessInter {
	// 모델 클래스를 사용
	//
	
	
	@Autowired
	@Qualifier("sangpumImpl") // 생성자에는 쓸 수 없음
	private SangpumInter inter;
	
	
	@Override
	public void selectProcess() {
		ArrayList<SangpumDto> myList = inter.selectAll();
		//System.out.println(myList);
		
		for(SangpumDto s : myList) {
			System.out.println(s.getCode() + " " + s.getSang() +
									" " + s.getSu() + " " + s.getDan());
		}
	}

}

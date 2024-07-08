package pack.business;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.GogekDto;
import pack.model.GogekInter;

@Service("bsnsImpl")
public class BusinessImpl implements BusinessInter {
	@Autowired
	private GogekInter gogekInter;
	
	@Override
	public void jikwonList() {
		Scanner sc = new Scanner(System.in);
		System.out.print("고객 번호 입력 : ");
		String gogekNum = sc.nextLine();
		System.out.print("고객 이름 입력 : ");
		String gogekName = sc.nextLine();
		
		
		// 고객번호, 고객이름 불일치 경우 처리
		if (gogekInter.jikwonInCharge(gogekNum, gogekName).isEmpty()) {
			System.out.println("로그인 정보 불일치~");
		}
		
		for(GogekDto g : gogekInter.jikwonInCharge(gogekNum, gogekName)) {
			System.out.println(g.getJikwon_name() + " "
								+ g.getJikwon_jik() + " "
								+ g.getJikwon_gen());
		}
	}
	

}

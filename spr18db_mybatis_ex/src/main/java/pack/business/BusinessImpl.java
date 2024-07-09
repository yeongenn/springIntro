package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter {
	
	@Autowired
	private JikwonInter inter;
	
	@Override
	public void dataPrint() {
		// 직원 전체 출력 ---------------------------------
		List<JikwonDto> list = inter.selectJikwonAll();
		
		System.out.println("사번\t사원명\t부서명\t입사년");
		for(JikwonDto j : list) {
			System.out.println(j.getJikwon_no() + "\t"
								+ j.getJikwon_name() + "\t"
								+ j.getBuser_name() + "\t"
								+ j.getJikwon_year());
		}
		
		//list = null; // list 초기화 해야하나..?
		System.out.println();
		
		// 부서별 인원수 ---------------------------------
		list = inter.countByBuser();
		
		System.out.println("부서명\t인원수");
		for(JikwonDto j : list) {
			System.out.println(j.getBuser_name() + "\t"
								+ j.getJikwon_count());
		}
		
		//list = null; // list 초기화 해야하나..?
		System.out.println();
		
		// 부서별 최대 급여자 ----------------------------
		list = inter.maxPayByBuser();
		System.out.println("부서명\t사원명\t급여");
		for(JikwonDto j : list) {
			System.out.println(j.getBuser_name() + "\t"
								+ j.getJikwon_name() + "\t"
								+ j.getJikwon_pay());
		}
	}

}

package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.Jikwon;
import pack.model.JikwonInterface;

@Service
public class BusinessImpl implements BusinessInter {
	
	@Autowired
	private JikwonInterface jikwonInterface;
	
	@Override
	public void dataPrint() {
		// 전체 직원 출력
		List<Jikwon> jlist = jikwonInterface.selectAll();
		
		System.out.println("dataPrint 메서드에서 출력~");
		System.out.println("사번\t사원명\t부서번호\t입사일");
		for(Jikwon j : jlist) {
			System.out.println(j.getNum() + "\t"
								+ j.getName() + "\t"
								+ j.getBuserNum() + "\t"
								+ j.getIbsaYear());
		}
		
		System.out.println("---");
		
		// 부서별 인원수 출력
		List<Object[]> olist = jikwonInterface.countByBuser();
		System.out.println("\n\n부서번호\t인원수");
		for(Object[] o : olist) {
			System.out.println(o[0] + "\t" + o[1]);
		}
		
	}

}

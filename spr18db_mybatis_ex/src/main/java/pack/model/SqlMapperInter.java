package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface SqlMapperInter {
	
	// to fix : 소속 부서 null인 경우 '무소속' 설정
	@Select("select jikwon_no, jikwon_name, buser_name, year(jikwon_ibsail) as jikwon_year from jikwon inner join buser on buser_num = buser_no")
	public List<JikwonDto> selectDataAll();
	
	@Select("select buser_name, count(jikwon_no) as jikwon_count from jikwon inner join buser on buser_num = buser_no group by buser_name")
	public List<JikwonDto> countByBuser();
	
	// 최대, 최소는 limit 1로 구하는 방법도 O <- 만약 해당 row가 복수면 이 쿼리 적용 X
	@Select("SELECT buser_name, jikwon_name, jikwon_pay FROM jikwon inner join buser on buser_num = buser_no, "
			+ "(SELECT buser_num, MAX(jikwon_pay) maxpay FROM jikwon GROUP BY buser_num) T1 "
			+ "WHERE jikwon.buser_num = T1.buser_num AND jikwon_pay = T1.maxpay")
	public List<JikwonDto> maxPayByBuser();
	
	
}

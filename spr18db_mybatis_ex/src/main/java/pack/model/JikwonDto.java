package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JikwonDto {
	
	// 테이블 칼럼명이랑 동일해야 한단다
	private String jikwon_no, jikwon_name, buser_name, jikwon_year;
	
	private String jikwon_count, jikwon_pay;
	

}

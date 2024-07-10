package pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class Jikwon {
	// JPQL 통해서 select문으로 조회할 때
	// 물리테이블 칼럼명 X
	// Entity 필드에 선언한 변수명 O

	@Id
	@Column(name="jikwon_no")
	private int num;
	
	@Column(name="jikwon_name")
	private String name;
	
	@Column(name="buser_num")
	private int buserNum;
	
	@Column(name="jikwon_ibsail")
	private String ibsaYear;
	
}

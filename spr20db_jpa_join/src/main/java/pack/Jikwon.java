package pack;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Id
	@Column(name="jikwon_no")
	private int jikwonNo;

	@Column(name="jikwon_name")
	private String jikwonName;
	
	// Join
	// 하나의 부서에는 여러명의 직원 (여러명의 직원이 하나의 부서) , 1 : N (N : 1)
	@ManyToOne // 테이블 연관관계
	@JoinColumn(name="buser_num", referencedColumnName = "buser_no")
	private Buser buser;
	
	// 입사년도만 가져올거임
	@Column(name="jikwon_ibsail")
	private Date jikwonYear;
}

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
@NoArgsConstructor // JPA에서는 빈생성자라도 생략이 불가
@AllArgsConstructor

@Entity // DB의 특정 테이블과 맵핑할게~
@Table(name="mem") // 이 테이블이랑 맵핑할게~ // 클래스명과 테이블명이 같으면 따로 명시 안해줘도 된다
public class MemDto { // JPA는 camel 표기법으로 쓰면 Mem_Dto로 인식한다
// 만약 @Table을 쓰면서 테이블명을 특정해주지 않으면 클래스명으로 생성된 테이블을 먼저 찾는다
// 이 클래스의 경우 클래스명이 MemDto니까 Mem_Dto라는 이름의 테이블을 먼저 찾는다
	
	@Id //  이 칼럼은 pk
	@Column(name="num") // 원본테이블 칼럼명과 변수명이 다를 경우 명시해줘야
	private int number;
	
	@Column(name="name", nullable = true) //
	private String name;
	
	// 칼럼명과 변수명이 같다면 생략 가능
	private String addr;
}

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
@Builder // builder pattern : @Builder를 사용하면 유연하게 생성 가능 - 원하는 것만 넣을 수 있다
public class SangpumDto {
	
	private String code, sang, su, dan;

	
}

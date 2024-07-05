package anno2_resource;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class AbcProcess {
	@Resource(name="abc1") // type이 아닌 객체변수 이름에 의한 맵핑
	private Abc1 abc1;
	
	private Abc2 abc2;
	
	@Resource(name="abcabc2")
	public void setAbc2(Abc2 abc2) {
		this.abc2 = abc2;
	}
	
	public void showData() {
		abc1.setIrum("금요일~!");
		abc2.setNai(23);
		
		String str = "결과 : 이름은 " + abc1.getIrum();
		str += ", 나이는 " + abc2.getNai();
		System.out.println(str);
	}
}

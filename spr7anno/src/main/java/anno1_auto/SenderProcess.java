package anno1_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component // 가독성 낮음
@Service //@Service("senderProcess")와 동일
public class SenderProcess {
	// @Autowired : Bean의 자동 삽입을 위해 사용하는 어노테이션, name에 의한 매핑이 아니라 type으로 매핑
	
	//@Autowired // field injection
	//private Sender sender;
	
	@Autowired
	@Qualifier("sender") // SenderInter 타입의 객체 중 sender 와 매칭하겠다~
	private SenderInter senderInter;
	
	/*
	@Autowired // constructor injection
	public SenderProcess(Sender sender) {
		this.sender = sender;
	}
	
	@Autowired // setter injection
	public void setSender(Sender sender) {
		this.sender = sender;
	}
	*/
	
	/*
	public Sender getSender() {
		return sender;
	}
	*/
	
	public void dispData() {
		//sender.show();
		senderInter.show();
	}
}

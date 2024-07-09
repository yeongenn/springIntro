package pack;

import org.springframework.stereotype.Service;

@Service("bImpl")
public class BusinessLogicImpl implements BusinessLogicInter {
	
	public BusinessLogicImpl() {
		
	}

	@Override
	public void startProcess() {
		System.out.println("검증을 했으므로 핵심 로직 수행");

	}

}

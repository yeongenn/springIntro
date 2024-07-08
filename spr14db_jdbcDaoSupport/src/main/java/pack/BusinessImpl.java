package pack;


public class BusinessImpl implements BusinessInter {
	// DB 처리를 하는 모델 클래스를 포함관계로 호출
	
	private SangpumInter inter;
	
	public void setInter(SangpumInter inter) {
		this.inter = inter;
	}
	
	@Override
	public void selectProcess() {
		for(SangpumDto s : inter.selectAll()) {
			System.out.println(s.getCode() + " " + 
								s.getSang() + " " + 
								s.getSu() + " " + 
								s.getDan());
		}

	}

}

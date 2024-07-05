package pack.gogek;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import pack.bank.Bank;
import pack.bank.HanaBank;
import pack.bank.ShinhanBank;

@Service
@ComponentScan("pack.bank")
@Scope("prototype")
public class Gogek {
	private Bank bank;
	
	@Autowired(required = true) // false면 해당 타입 객체가 있으면 사용하고, 없으면 맵핑하지 않겠다
	private ShinhanBank shinhanBank;
	
	@Resource(name="hanaBank") // name으로 맵핑
	private HanaBank hanaBank;
	
	public void selectBank(String sel) {
		if(sel.equals("shinhan")) {
			bank = shinhanBank;
		} else if(sel.equals("hana")){
			bank = hanaBank;
		}
	}
	
	public void playInputMoney(int money) {
		bank.inputMoney(money);
	}

	public void playOutputMoney(int money) {
		bank.outputMoney(money);
	}
	
	private String msg;
	
	@PostConstruct // 생성자 처리 후 자동 호출 : 초기화 작업 가능
	public void abc() {
		msg = "계좌 잔고 : "; 
	}
	
	@PreDestroy // 웹서비스 종료 직전 자동 호출 : 마무리 작업 가능
	public void def() {
		if(shinhanBank != null) shinhanBank = null;
		if(hanaBank != null) hanaBank = null;
	}
	
	public void showMoney() {
		System.out.println(msg + bank.getMoney());
	}
}

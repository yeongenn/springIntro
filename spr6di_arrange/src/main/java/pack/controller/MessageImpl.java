package pack.controller;

import pack.model.MyInfoInter;
import pack.other.OutFileInter;

public class MessageImpl implements MessageInter {
	private String m1, m2; // constructor injection
	private int year;
	private MyInfoInter inter;
	
	private String spec; // setter injection
	private OutFileInter fileInter;
	
	public MessageImpl(String m1, String m2, 
			int year, MyInfoInter inter) {
		this.m1 = m1;
		this.m2 = m2;
		this.year = year;
		this.inter = inter;
	}
	
	public void setSpec(String spec) {
		this.spec = spec;
	}
	
	public void setFileInter(OutFileInter fileInter) {
		this.fileInter = fileInter;
	}
	
	@Override
	public void sayHi() {
		String msg = "MessageImpl 클래스에서 sayHi :";
		msg += "\n" + m1 + " " + m2;
		msg += "\n" + year + "년 " + m2;
		msg += "\n" + inter.myData();		
		msg += "\n" + spec;
		
		System.out.println(msg);
		
		// 위 메세지를 파일로 출력하기
		fileInter.outFile(msg);
	}

}

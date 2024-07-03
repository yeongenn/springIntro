package pack.controller;

import java.util.Scanner;

import pack.model.SangpumImpl;
import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter; // SangpumInter를 구현한 여러 클래스를 다 쓰고 싶다
	// private SangpumImpl sangpumImpl; // 이렇게도 가능은 하지만 SangpumImpl 객체만 사용할 수 있다
	private String[] result;
	
	// DI - constructor injection
	public MyImpl(SangpumInter inter) { // SangpumInter 구현한 여러 클래스 중 어떤 걸 쓸지는 생성자 통해 들어온다
		this.inter = inter;
	}
	
	// 스프링은 다형성 덩어리~
	// 함수형 언어는 다형성을 구현할 수 X
	// 따라서 파이썬 같은 언어에 클래스가 도입
	
	@Override
	public void inputData() {
		// 키보드로 상품명, 수량, 단가 입력받기
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("상품명을 입력하세요 : ");
			String sangpum = sc.nextLine();
			System.out.print("수량을 입력하세요 : ");
			int quantity = sc.nextInt();
			System.out.print("단가를 입력하세요 : ");
			int price = sc.nextInt();
			
			result = inter.calcPrice(sangpum, quantity, price);
						
		} catch (Exception e) {
			System.out.println("inputData error : " + e);
		}

	}

	@Override
	public void showData() {
		StringBuilder sb = new StringBuilder();
		String[] units = {"상품명", "가격"};
		sb.append(units[0] + " : " + result[0] + ", ");
		sb.append(units[1] + " : " + result[1]);
		
		System.out.println(sb.toString());
	}

}

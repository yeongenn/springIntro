package pack.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import pack.model.SangpumImpl;
import pack.model.SangpumInter;

public class MyImpl implements MyInter {
	private SangpumInter inter;
	private HashMap<String, String> result;
	
	public void setInter(SangpumInter inter) {
		this.inter = inter;
	}

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
		System.out.println(result);
		
	}

}

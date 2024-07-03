package pack.model;

import java.util.HashMap;
import java.util.Map;

public class SangpumImpl implements SangpumInter {

	/*
	@Override
	public String[] calcPrice(String sangpum, int quantity, int price) {
		// String...?
		String[] arr = new String[2];
		arr[0] = sangpum;
		arr[1] = Integer.toString(quantity * price);
		
		return arr;
				
	}
	*/
	
	@Override
	public HashMap<String, String> calcPrice(String sangpum, int quantity, int price) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("상품명", sangpum);
		map.put("가격", Integer.toString(quantity * price));
		return map;
	}
	
	

}

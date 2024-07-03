package pack.model;

import java.util.HashMap;
import java.util.Map;

public class SangpumImpl implements SangpumInter {

	
	@Override
	public String[] calcPrice(String sangpum, int quantity, int price) {
		// String...?
		String[] arr = new String[2];
		arr[0] = sangpum;
		arr[1] = Integer.toString(quantity * price);
		
		return arr;
				
	}
	
	
	

}

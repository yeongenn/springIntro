package pack.model;

import java.util.HashMap;
import java.util.Map;

public interface SangpumInter {

	HashMap<String, String> calcPrice(String sangpum, int quantity, int price);
}

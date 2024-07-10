package pack.model;

import java.util.List;

public interface JikwonInterface {
	
	List<Jikwon> selectAll();
	
	List<Object[]> countByBuser();

}

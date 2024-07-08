package pack.model;

import java.util.List;

import org.springframework.dao.DataAccessException;

public interface GogekInter {
	List<GogekDto> jikwonInCharge(String gogekNum, String gogekName);

}

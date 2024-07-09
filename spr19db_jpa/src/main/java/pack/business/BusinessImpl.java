package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.MemDto;

@Service
public class BusinessImpl implements BusinessInter {
	
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataPrint() {
		List<MemDto> memList = dataInterface.selectDataAll();
		
		System.out.println("dataPrint 메서드에서 출력~");
		for(MemDto m : memList) {
			System.out.println(m.getNumber() + " "
								+ m.getName() + " "
								+ m.getAddr());
		}
	}

}

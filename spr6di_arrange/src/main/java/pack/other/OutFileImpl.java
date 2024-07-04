package pack.other;

import java.io.FileWriter;
import java.io.WriteAbortedException;

public class OutFileImpl implements OutFileInter {
	private String filePath; // 출력 파일 경로 기억	
	
	@Override
	public void outFile(String msg) {
		// 메세지를 파일로 출력
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write(msg);
			writer.close();
			System.out.println("파일 저장 완료");
		} catch (Exception e) {
			System.out.println("outFile error : " + e);
		}
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}

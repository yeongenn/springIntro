package pack;

public class MyProcess { // setter injection
	private int nai;
	private String name;
	private ShowData showData;
	
	public MyProcess() {
		
	}
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setShowData(ShowData showData) {
		this.showData = showData;
	}
	
	public void displayData() {
		System.out.println("이름은 " + name + ", 나이는 " + nai + 
							", 별명은 " + showData.processNickname() + 
							", 취미는 " + showData.processHobby());
	}
}

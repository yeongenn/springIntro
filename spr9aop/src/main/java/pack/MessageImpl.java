package pack;

public class MessageImpl implements MessageInter {
	// 핵심 로직을 구현한 클래스 : AOP Target
	
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHi() {
		System.out.println("비즈니스 로직 수행");
		System.out.println("안녕안녕 " + name + "님~");
		// ...
		// 예컨대 반복문 계속 돌리기, DB 다녀오기 ... 와 같은 로직 수행하느라
		// sayHi()를 처리하는데 꽤 시간이 든다고 가정하고 지연시간 부여
		
		int t = 0;
		while(t < 5) {
			try {
				Thread.sleep(1000);
				System.out.print(".");
				t++;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		System.out.println("sayHi 완료!");

	}

}

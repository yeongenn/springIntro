package pack;

public class OurProcess {
	private String name;
	private int su;
	private Gugudan gugudan;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSu(int su) {
		this.su = su;
	}
	
	public void setGugudan(Gugudan gugudan) {
		this.gugudan = gugudan;
	}
	
	@Override
	public String toString() {
		int[] results = gugudan.numberCalc(su);
		String str = "";
		for (int i = 0; i < results.length; i++) {
			str += su + " * " + i + " = " + results[i] + "\n";
		}
		return "작성자 : " + name + "\n" + su + "단 결과 : \n" + str;
	}
	
}

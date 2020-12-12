package singleton.step1;

public class AClass {
	private int inVar;//1
	private static AClass INSTANCE;//2
	
	public static AClass getInstance() {//3
		if(INSTANCE==null) {
			INSTANCE = new AClass();//4
		}
		return INSTANCE;//5
	}
	
	public int getInVar() {
		return inVar;
	}
	public void setInVar(int inVar) {
		this.inVar = inVar;
	}
	
}

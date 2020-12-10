package singleton.step1;

public class SingletonClass {
	private int i;
	
	public static SingletonClass INSTANCE; //Singleton객체를 가르킨다
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {//객체가 아직 존재하지 않는다.
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	
	private SingletonClass() { // public > private static (singleton)
		i = 10;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}

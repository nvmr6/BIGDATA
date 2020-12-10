package singleton.step2;

public class SingletonClass {
	private static SingletonClass INSTANCE; // 싱글톤 = 타입
	private int i;
	private SingletonClass() {//생성자
		i = 10;
	}
	
	public static SingletonClass getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new SingletonClass();
		}
		return INSTANCE;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}

/*
 * private static SingletonClass INSTANCE= new SingletonClass();
 * public static SingletonClass getInstance() {
		return INSTANCE;
	}
 */

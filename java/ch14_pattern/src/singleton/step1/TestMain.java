package singleton.step1;

public class TestMain {
	public static void main(String[] args) {
		SingletonClass obj1 = SingletonClass.getInstance(); //new 사용이 안 된다.
		SingletonClass obj2 = SingletonClass.getInstance();
		
		System.out.println(obj1.getI());
		obj1.setI(999);//여러 객체 생성이 가능하다.
		System.out.println(obj2.getI()); // 객채룰 하나만 사용하여 1을 변경해도 2도 같아진다.
		
		AClass obj3 = AClass.getInstance();
		AClass obj4 = AClass.getInstance();
		
		obj3.setInVar(666);
		System.out.println(obj3.getInVar());
		obj3.setInVar(999);//여러 객체 생성이 가능하다.
		System.out.println(obj4.getInVar()); // 객채룰 하나만 사용하여 1을 변경해도 2도 같아진다.
	}
}

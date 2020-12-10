package singleton.step2;

public class FirstClass {
	public FirstClass() {
		SingletonClass singletonobj = SingletonClass.getInstance();
		System.out.println("FirstClass형 객체 생성");
		System.out.println(singletonobj.getI());
		singletonobj.setI(999);
		System.out.println(singletonobj.getI()); //변경후에도 변수는 사라지나 남아있음
	}
}

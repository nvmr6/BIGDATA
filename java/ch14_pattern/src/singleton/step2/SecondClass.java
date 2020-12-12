package singleton.step2;

public class SecondClass {

	public SecondClass() {
		SingletonClass singletonobj = SingletonClass.getInstance();
		System.out.println("SecondClass 생성자");
		System.out.println(singletonobj.getI());
	}
	
}

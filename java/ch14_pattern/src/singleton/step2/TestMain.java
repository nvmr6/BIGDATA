package singleton.step2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstObj = new FirstClass(); //주소값이 들어감, 객체가 메모리에 고정(static)
		SecondClass secondObj = new SecondClass();
		
		SingletonClass singleobj = SingletonClass.getInstance();
		System.out.println("메인 메소드에서 singobj안의 i값은");
		System.out.println(singleobj.getI());
	}
}

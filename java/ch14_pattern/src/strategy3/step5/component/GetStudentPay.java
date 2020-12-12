package strategy3.step5.component;

public class GetStudentPay implements IMoney{

	@Override
	public void money() {
		System.out.println("교육급여를 받습니다.");
	}
	
}

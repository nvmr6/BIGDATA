package com.lec.ex08_pay;

public class TestMain {
	public static void main(String[] args) {
		SalaryEmployee[] s = {new SalaryEmployee("홍직원", 50000000),
							  new SalaryEmployee("박직원", 60000000),
						      new SalaryEmployee("이직원", 70000000)};
		HourlyEmployee[] h = {new HourlyEmployee("김알바", 50, 8500),
							  new HourlyEmployee("정알바", 80, 8500)};
		
		for(SalaryEmployee temp: s) {
			System.out.println("=====월급명세서=====");
			System.out.println("성함: "+temp.getName());
			System.out.println("월급: "+temp.computePay());
			System.out.println("상여금: "+temp.computeIncentive());
			System.out.println("수  고  하  셨  습  니  다.");
		}
		for(HourlyEmployee temp: h) {
			System.out.println("=====월급명세서=====");
			System.out.println("성함: "+temp.getName());
			System.out.println("월급: "+temp.computePay());
			System.out.println("상여금: "+temp.computeIncentive());
			System.out.println("수  고  하  셨  습  니  다.");
		}
	}
}


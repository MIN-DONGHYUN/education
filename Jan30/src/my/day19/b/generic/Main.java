package my.day19.b.generic;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		// Employee 만 저장할 수 있는 Box_Anything 객체를 생성하자 
		Box_Anything<Employee> box_employee = new Box_Anything<>(); 		//box_employee는 오로지 employee만 저장해야 한다,
		box_employee.register(new Employee("leess", "Qwer", "이순신", "이사" ));
		box_employee.register(new Employee("eomjh", "Qwer", "엄정화", "부장" ));
		box_employee.register(new Employee("hongkd", "Qwer", "홍길동", "대리" ));
		
		List<Employee> empList = box_employee.getList();
		
		for(Employee emp : empList) 		//emp에 leess, eomjh 등등이 쏙 들어온다
		{
			System.out.println(emp);
		}
		/*
			1. 아이디 : leess
			2. 비밀번호 : Qwer
			3. 성명 : 이순신
			4. 직급 : 이사
			
			1. 아이디 : eomjh
			2. 비밀번호 : Qwer
			3. 성명 : 엄정화
			4. 직급 : 부장
			
			1. 아이디 : hongkd
			2. 비밀번호 : Qwer
			3. 성명 : 홍길동
			4. 직급 : 대리
		*/
		
		
		// String 만 저장할 수 있는 Box_Anything 객체를 생성하자 
		Box_Anything<String> box_string = new Box_Anything<>(); 		//box_string는 오로지 sting만 저장해야 한다,
		box_string.register("한석규");
		box_string.register("두석규");
		box_string.register("세석규");
		
		List<String> empString = box_string.getList();
		
		for(String str : empString) 		//str에 한석규, 두석규 등등이 쏙 들어온다
		{
			System.out.println(str);
		}
		
		/*
			한석규
			두석규
			세석규
		*/
		
		// Integer 만 저장할 수 있는 Box_Anything 객체를 생성하자 
		Box_Anything<Integer> box_int = new Box_Anything<>(); 		//box_int는 오로지 Integer만 저장해야 한다,
		box_int.register(10);
		box_int.register(20);
		box_int.register(30);
		
		List<Integer> intList = box_int.getList();
		
		// 오토 언박싱 원래 Integer을 써야하지만 int num으로 해도 됨 
		for(int num : intList) 		//num에 10 20 30이 쏙 들어온다
		{
			System.out.println(num);
		}
		/*
			10
			20
			30
		*/
	}//end of main

}

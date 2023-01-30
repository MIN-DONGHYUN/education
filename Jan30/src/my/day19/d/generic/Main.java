package my.day19.d.generic;

import java.util.*;

public class Main {

	@SuppressWarnings("unchecked")		// 메인 베소드에서 경고는 보이지 말거라 !!!!!!!!!!!!!
	public static void main(String[] args) {
		
		Box_wildCard_Employee box = new Box_wildCard_Employee();  // 객체 생성 
		
		/////////////////////////////////////////////////////
		System.out.println("\n~~~~~~~~ 모든 타입이 가능한 경우 ~~~~~~~~\n");
		
		Box_Anything<Employee> emp = new Box_Anything<>(); // Box_anything에 있는것을 emp에 넣는다????
		
		// emp 레지스터에 값을 저장시킨다.
		emp.register(new Employee("superman","1234","슈퍼맨","부장"));
	    emp.register(new Employee("wonderwoman","0070","원더우맨","과장"));
	    emp.register(new Employee("batman","5678","배트맨","사원"));

	    
	    Box_Anything<String> str = new Box_Anything<>();
	    str.register("GOAT 메시");
	    str.register("GOAT 두메시");
	    str.register("GOAT 세메시");
	    
	    Box_Anything<Integer> num = new Box_Anything<>();
	    num.register(10);
	    num.register(20);
	    num.register(30);
	    
	    
	    box.register_anything(emp);   //emp를 넣는다.
	    box.register_anything(str);   //str를 넣는다.
	    box.register_anything(num);   //num를 넣는다.
	    
	    // anything_list에 모든것을 넣어준다. // 모든 타입을 출력할 수 있다.
	    List<Box_Anything<?>> anything_list =  box.get_anything();
	    
	    for( Box_Anything<?> b : anything_list)
	    {
	    	//List<object> list = b.getList();
	    	//또는
	    	List<?> list = b.getList();  // List<Object>라고 나온다. object는 최상위 클래스이다. (다형성)

	    	for(Object obj : list)		//? 대신에 Object를 사용한다.
	    	{
	    		System.out.println(obj); //obj를 출력
	    	}// end of for
	    	
	    	System.out.println("#################");
	    	
	    }//end of for
	    
	    /*
	    
			~~~~~~~~ 모든 타입이 가능한 경우 ~~~~~~~~
			
			1. 아이디 : superman
			2. 비밀번호 : 1234
			3. 성명 : 슈퍼맨
			4. 직급 : 부장
			
			1. 아이디 : wonderwoman
			2. 비밀번호 : 0070
			3. 성명 : 원더우맨
			4. 직급 : 과장
			
			1. 아이디 : batman
			2. 비밀번호 : 5678
			3. 성명 : 배트맨
			4. 직급 : 사원
			
			#################
			GOAT 메시
			GOAT 두메시
			GOAT 세메시
			#################
			10
			20
			30
			#################
		*/
	    ///////////////////////////////////////////////////////
	    
	    
	    System.out.println("\n~~~ 와일드 카드의 하한제한 하기. T 와 그 조상클래스들만 사용가능한 경우 ~~~\n"); 
	    
	    Employee_Child_Executive executive_emp = new Employee_Child_Executive("leess","Qwer", "이순신" , "사장" , "1-01");
	  
	    Employee employee = new Employee("eomjh", "1234" , "엄정화", "부장");
	    
	    // Box_Anything은 제네릭이 있었기 때문에 <>를 사용
	    Box_Anything<Employee_Child_Executive> box_executive_emp = new Box_Anything<>();
	    
	    box_executive_emp.register(executive_emp);
	    
	    // 제네릭이 부모클래스이다.
	    Box_Anything<Employee> box_emp = new Box_Anything<>();
	    box_emp.register(employee);
	    box_emp.register(executive_emp);  
	    
	    
	    box.register_executive(box_executive_emp);  // super는 하한제한
	    box.register_executive(box_emp);			// box_executive_emp 부터 box_emp까지 
	    
	    
	    Employee_Child_Plain plain_emp = new Employee_Child_Plain("hongkd", "1234", "홍길동" , "사원" ,4000);
	    Box_Anything<Employee_Child_Plain> box_plain =  new Box_Anything<>();
	    box_plain.register(plain_emp);   //  상한제한 
	    
	    // box.register_executive(box_plain);  // !!! 하한제한에 걸려 오류 발생 !!!!!
	    
	    /*   
	      box.register_executive(Box_Anything<? super Employee_Child_Executive> item) 이므로
	      파라미터가 Employee_Child_Executive 을 포함한 Employee_Child_Executive 의 조상클래스들만 
	      입력이 되어지므로 Employee_Child_Plain 을 형태를 띄는 box_plain 은 입력이 불가하기 때문이다. 
	   */
	    
	    
	    List<Box_Anything<? super Employee_Child_Executive>> executive_super_list = box.get_executive();
	    
	    for(Box_Anything<? super Employee_Child_Executive> b : executive_super_list)
	    {
	    	List<?> list = b.getList();
	    	for(Object obj: list)			// ? 는 못쓰므로 object를 사용한다.
	    	{
	    		System.out.println(obj);
	    	}// end of for 
	    }// end of for
	    
	    /*
	     	
			== 임직원 ==
			1. 아이디 : leess
			2. 비밀번호 : Qwer
			3. 성명 : 이순신
			4. 직급 : 사장
			5. 법인카드번호 : 1-01
			
			1. 아이디 : eomjh
			2. 비밀번호 : 1234
			3. 성명 : 엄정화
			4. 직급 : 부장
			
			== 임직원 ==
			1. 아이디 : leess
			2. 비밀번호 : Qwer
			3. 성명 : 이순신
			4. 직급 : 사장
			5. 법인카드번호 : 1-01

	    */
	    
	    
	    ///////////////////////////////////////////////////////
	    
	    System.out.println("\n~~~ 와일드 카드의 상한제한 하기. T 와 그 자손클래스들만 사용가능한 경우 ~~~\n"); 
	    
	    Employee_Child_Plain_Child plain_child_emp = new Employee_Child_Plain_Child("kangkc", "1237", "강감찬", "사원" , 3600, 24);
	    Box_Anything<Employee_Child_Plain_Child> box_plain_child = new Box_Anything<>();
	    
	    box_plain_child.register(plain_child_emp);
	    
	    box.register_Plain(box_plain); 		//상한 제한 plain부터 자식까지 
	    box.register_Plain(box_plain_child);
	    
	   // box.register_Plain(box_emp); // !!!! 오류 발생 !!!!!
	    
	    /*   
	      register_plain(Box_Anything<? extends Employee_Child_Plain> item) 이므로
	      파라미터가 Employee_Child_Plain 를 포함한 자식클래스 까지만 입력이 가능한데
	      box_emp 는 Box_Anything<Employee> 인데 이것은 Employee_Child_Plain 의 부모클래스 이므로
	      상한제한에 걸려서 입력이 불가하다.     
	   */
	    
	    
	    // 출력부분 
	    List <Box_Anything<? extends Employee_Child_Plain>> child_plain_list = box.get_plain();
	    
	    for(Box_Anything<? extends Employee_Child_Plain> b : child_plain_list)
	    {
	    	List<Employee_Child_Plain> list = (List<Employee_Child_Plain>) b.getList();
	    	
	    	for(Employee_Child_Plain plain: list)
	    	{
	    		System.out.println(plain);
	    		
	    	}// end of for
	    	
	    } // end of for
	    
	    /*
		    ~~~ 와일드 카드의 상한제한 하기. T 와 그 자손클래스들만 사용가능한 경우 ~~~
	
			== 일반직원 ==
			1. 아이디 : hongkd
			2. 비밀번호 : 1234
			3. 성명 : 홍길동
			4. 직급 : 사원
			5. 연봉 : 4000만원
			
			== 일반직원 ==
			1. 아이디 : kangkc
			2. 비밀번호 : 1237
			3. 성명 : 강감찬
			4. 직급 : 사원
			5. 연봉 : 3600만원
			6. 계약 개월수 : 24개월
		*/
	    
	    
	    
	    
	}  // end of main

}

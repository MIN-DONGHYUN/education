package my.day16.c.block;

public class Child extends Parent{

	//field (첫번째)
	String name = "은하";	//맴버변수(인스턴스 변수)의 초기화
	static int count; 		//맴버변수의 초기화 
	
	// ==static 초기화 블럭 (두번째) == //
	static {			//static 초기화 불럭
		// static 초기화 블럭은 인스턴스(객체)를 생성하기 전에 먼저 호출되어지며
		// 중요한 것은 오로지 1번만 호출된다는 것이다.
		// 주로 static 초기화 블럭은 환경설정서 사용된다.
		
		System.out.println("*** Child 클래스의 'static 초기화 블럭' 호출됨. ***");
		count++;
				
		//name = "강만두";		// 이것은 인스턴스이므로 오류가 생긴다.
		// static 초기화 블럭에는 오로지 static 변수만 들어올 수 있고, 
		// 인스턴스 변수는 들어올 수 없다.!!!!!!!!!!!!!!!!!!!!
		
	}
	
	// == instance(인스턴스) 초기화 블럭 (네번째) == //
	{
		System.out.println("### Child 클래스의 instance(인스턴스) 초기화 블럭이 호출됨  ###");
		name = "유아";
	}
	
	
	// == 생성자 == //
	public Child() {
		
		super(); 		//(세번째)
						// 부모클래스가 자식 클래스보다 먼저 호출 됨 
		//(다섯번째)
		System.out.println("=== 자식클래스인 Child 클래스의 기본생성자 호출함 === ");
		name = "윤하";
	}
	
	
}

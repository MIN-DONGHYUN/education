package my.day16.d.Final;

public class Child_1 extends Final_test_1{

	int age;
	
	void mytest() {
		System.out.println(">>연습입니다.<<");
	}
	
	@Override
	void greeting() {
		System.out.println("\n--- Hi Hello ---\n");
	}
	
	//메소드의 final을 붙이면 자식 클래스에서 메소드의 override(오버라이딩, 재정의)를 할 수 없게 된다.
	//final 이기 때문에 오버라이딩도 값 변경이 불가하다.
	/*
	@Override
	final void rule() {
		System.out.println("*** Honesty ***");
	}
	*/
}

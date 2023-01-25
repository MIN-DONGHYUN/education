package my.day16.d.Final;

public class Final_test_1 {

	String id;
	String name;
	
	// 필드에 final이 붙으면 더 이상 새로운 값으로 할당할 수 없다.
	final double PI = 3.141592; // 원주율, 상수변수라 부르고 관습상 대문자로 적어준다(PI)
	
	void greeting() {
		System.out.println("=== 안녕하세요 ===");
	}
	
	//메소드의 final을 붙이면 자식 클래스에서 메소드의 override(오버라이딩, 재정의)를 할 수 없게 된다.
	final void rule() {
		System.out.println("+++ 정직하게 살자 +++");
	}
	
	
	
}

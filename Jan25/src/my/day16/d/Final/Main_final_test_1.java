package my.day16.d.Final;

public class Main_final_test_1 {

	public static void main(String[] args) {
		
		Final_test_1 ft1 = new Final_test_1();
		
		ft1.id = "leess";
		ft1.name = "이순삼";
		ft1.name = "이순신";
		
		// ft1.PI = 123.12123;  // PI는 Final을 사용하여서 새로운 값을 할당 할 수 없기에 오류!!

		///////////////////////////////////////////////////
		
		Child_1 child = new Child_1();
		child.greeting(); 	//자식클래스에서 오버라이딩(재정의) 했으므로 영문 출력
		child.rule();		//자식 클래스에서 오버라이딩 할 수 없음 final이기 때문에 
		child.mytest();
		/*
			--- Hi Hello ---
		
			+++ 정직하게 살자 +++
			>>연습입니다.<<
		*/
		
	} // end of main()

}

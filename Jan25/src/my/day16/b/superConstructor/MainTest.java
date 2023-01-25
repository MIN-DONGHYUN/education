package my.day16.b.superConstructor;

public class MainTest {

	public static void main(String[] args) {
		
		Child child = new Child();
		/*
		 	>>> 확인용 Parent 클래스의 기본생성자 호출함 <<< 
			=== 확인용 child클래스의 기본생성자 호출함 ===
		*/
		
		// 자식클래스(child)의 기본생성자가 호출되어질때는 항상 부모클래스(parent)의 기본생성자가 먼저 호출되어지고 나서 
		// 그 다음에 자식클래스(child)의 기본생성자가 호출되어진다.  
		
		child.childInfo();
		/*
		 	아이디 : eomjh
			암 호 : 1234
			성 명 : 엄정화
		*/
	}

}

package my.day16.c.block;

public class MainBlock {

	public static void main(String[] args) {
		
		Child child_1 = new Child();		// 인스턴스(객체)를 만듬 
		
		/*
		    *** Child 클래스의 'static 초기화 블럭' 호출됨. ***
		    >> 부모클래스인 Parent 클래스의 기본생성자 호출됨 <<
			### Child 클래스의 instance(인스턴스) 초기화 블럭이 호출됨  ###
			=== 자식클래스인 Child 클래스의 기본생성자 호출함 === 
		*/

		System.out.println("child_1.name => " + child_1.name);
		// child_1.name => 윤하
		
		
		System.out.println("child.count => " + Child.count);
		// child.count => 1
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		Child child_2 = new Child();		// 인스턴스(객체)를 만듬 
											// 두번째로 static을 호출했기 때문에 static은 실행하지 않는다. (static은 한번만 실행된다.) 
		child_2.name = "주현";

		/*
		 	>> 부모클래스인 Parent 클래스의 기본생성자 호출됨 <<
			### Child 클래스의 instance(인스턴스) 초기화 블럭이 호출됨  ###
			=== 자식클래스인 Child 클래스의 기본생성자 호출함 === 
		 */
		
		System.out.println("child_2.name => " + child_2.name);
		// child_2.name => 주현
		
		
		System.out.println("child.count => " + Child.count);
		// child.count => 1
		
	}

}

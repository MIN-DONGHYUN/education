package my.day16.e.Interface;

public class Maininterface {

	public static void main(String[] args) {
		
		Rectangle rt = new Rectangle();	//사각형을 불러옴 
		Triangle tri = new Triangle();	//삼각형을 불러옴
		Circle cir = new Circle();	// 원을 불러옴 
		
		System.out.println("가로 4, 세로 5 인 사각형의 넓이 => " + rt.area(4, 5));
		System.out.println("밑변 4, 높이 5 인 삼각형의 넓이 => " + tri.area(4, 5));
		System.out.println("반지름이 4 인 원의 넓이 => " + cir.area(4));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~\n");
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!//
		// == 다형성(Polymorphism) == //
		// ==> 자식클래스로 생성되어진 객체를 부모클래스의 타입으로 받을 수가 있다.
		// => 특정한 인터페이스로 구현된 클래스의 객체는 특정한 인터페이스의 타입으로 받을 수 가 있다.
		
		Figure fg1 = new Rectangle();	//사각형을 불러옴 Figure으로 받아올 수 있다.
		Figure fg2 = new Triangle();	//삼각형을 불러옴
		Figure fg3 = new Circle();	// 원을 불러옴 
		
		System.out.println("가로 4, 세로 5 인 사각형의 넓이 => " + fg1.area(4, 5));
		System.out.println("밑변 4, 높이 5 인 삼각형의 넓이 => " + fg2.area(4, 5));
		System.out.println("반지름이 4 인 원의 넓이 => " + fg3.area(4));
		
		System.out.println("\n~~~~~~~~~~~~~~~~~\n");
		
		//Figure fg4 = new Figure();	// 이건 사용이 불가하다.
		Figure[] fg_arr = new Figure[3];	// 이건 배열의 저장소이므로 사용이 가능하다.
		
		fg_arr[0] = new Rectangle();
		fg_arr[1] = new Triangle();
		fg_arr[2] = new Circle();
		
		for(Figure fg : fg_arr)	// 확장 for문이다. , 배열 크기만큼 반복
		{
			if( fg instanceof Circle )	// 실제 인스턴스는 누구냐!
			{
				System.out.println(fg.area(4));
			}
			else
			{
				System.out.println(fg.area(4, 5));
			}
				
		}
		
	}//end of main

}

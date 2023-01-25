package my.day16.e.Interface;

public class Rectangle implements Figure {  // implements는 Figure를 구현한다라는 말이다.
											//미완성 메소드를 구현하기 위해 

	//Rectangle 이라는 클래스는 Figure 라는 인터페이스를 implements(구현)해야 한다는 말이다.
	
	//오버라이딩 
	@Override
	public double area(double x, double y) {

		//사각형 넓이 구하기 
		return x*y;
	}

	@Override
	public double area(double r) {
		// 사용하지 않아도 써줘야함 
		return 0;
	}
}

package my.day16.e.Interface;

public class Triangle implements Figure {

	//Triangle 이라는 클래스는 Figure 라는 인터페이스를 implements(구현)해야 한다는 말이다.
	
	//오버라이딩
	@Override
	public double area(double x, double y) {
		
		//삼각형 넓이 구하기 
		return x*y*0.5;
	}

	@Override
	public double area(double r) {
		// 사용하지 않아도 써줘야함 
		return 0;
	}

}

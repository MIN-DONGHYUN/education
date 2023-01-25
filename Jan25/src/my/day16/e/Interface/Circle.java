package my.day16.e.Interface;

public class Circle implements Figure {

	@Override
	public double area(double x, double y) {
		// 사용하지 않아도 써줘야함 
		return 0;
	}

	@Override
	public double area(double r) {
		// 원의 넓이를 구하기 위해  
		return PI*r*r;
	}

}

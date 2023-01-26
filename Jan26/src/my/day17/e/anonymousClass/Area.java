package my.day17.e.anonymousClass;

public class Area implements InterArea {

	@Override
	public double area(double x, double y) {
		
		// 면적 구하기 가로 * 세로 
		return x*y;
	}

}

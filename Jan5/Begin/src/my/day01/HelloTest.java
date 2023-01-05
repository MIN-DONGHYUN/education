package my.day01;   // 패키지 (경로가 여기)
 
//import java.lang.*; //기본적으로 생략되어있기에 쓸 필요가 없음 
import java.util.Date; //Date를 사용하려면 import를 해야한다.

public class HelloTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Hello World!!"); //sysout에 ctrl + space bar하면 자동으로 나옴 
		System.out.println("안녕하세요~~");
		Date now = new Date(); //inport 해야 할 경우
		//java.util.Date now = new java.util.Date(); //위에 선언 안하면 일일이 써야한다.
		System.out.println("현재시간 : " + now);
	}
}

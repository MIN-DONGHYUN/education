package my.day04.c.scanner;

import java.util.Scanner;   // util 패키지의 전체를 사용


public class Scanner4Main2 {

	public static void main(String[] args) {
		
		System.out.print("== 키보드로 부터 2개의 정수를 입력받아서 더한 결과 알아보기== \n");
		
		Scanner sc = new Scanner(System.in); // 키보드 사용을 위해 사용
		
		String inputStr = "";    // try뿐만 아니라 catch에도 사용하기위해 전역변수 설정
		
		
		try {  //throw 가능성이 있는 오류를 잡기 위해 시도
			
			System.out.print("1. 첫번째 정수 : ");
		
			inputStr = sc.nextLine();    	 //  "10" inputStr은 지역변수
											 // "안녕하세요"
		
			int num1 = Integer.parseInt(inputStr);  //문자열을 int형으로 변환하는 것이다.
		
			System.out.print("2. 두번째 정수 : ");
		
			inputStr = sc.nextLine();     //  "20"
										  // "좋은하루"
		
			int num2 = Integer.parseInt(inputStr);  //문자열을 int형으로 변환하는 것이다.
		
			System.out.println(" >> 더한 결과 :" + num1 + "+" + num2 + "=" + (num1 + num2));
			// >> 더한 결과 : 10 + 20 = 30 
		} // end of try
		
		catch(NumberFormatException e) {   //오류 잡기위해 사용한다. java.lang패키지 이므로 쓸필요 X
			
			System.out.println(">>>" + inputStr + "는 정수가 아니므로 정수로 입력하세요 !! <<");
			
		}// end of catch
		
		
		sc.close(); //메모리 절약하기 위해 사용

	}

}

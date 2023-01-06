package my.day04.c.scanner;

import java.util.Scanner;

public class Scanner5Main {

	public static void main(String[] args) {
		
		System.out.println(" == 키보드로 부터 두개의 숫자를 입력받아서 사칙연산 (+,-,*,/)한 결과 알아보기\n");
		
		Scanner sc = new Scanner(System.in);  // 키보드를 사용하기위해 사용 
		
		String inputStr = ""; //전역변수 설정 
	
		
		try {  // 오류를 잡기위해 미리 시도함 


			System.out.print(">>> 첫번째 정수 입력 : ");

			inputStr = sc.nextLine();    // 문자열을 입력 받아라

			// "문자열"을 int 타입으로 형변환 시켜주는 방법
			int num1 = Integer.parseInt(inputStr); // 입력받은 문자열을 int로 변경한다. 

			


			System.out.print(">>> 두번째 정수 입력 : ");

			inputStr = sc.nextLine();    // 문자열을 입력 받아라

			// "문자열"을 int 타입으로 형변환 시켜주는 방법
			int num2 = Integer.parseInt(inputStr); // 입력받은 문자열을 int로 변경한다. 



			System.out.print(">>사칙연산(+,-,*,/)중에 한가지를 선택 : "); 

			String operator = sc.nextLine();// "+","-","*","/"
			// "몰라요" 등등은 오류

			double result = 0;  // 결과를 담기 위한 변수 설정 , 실수는 double, float (/하기 위해 실수로 설정)

			boolean b_flag = true;  //b_는 블린타입이다.


			switch (operator) { //operator 에 들어올 수 있는 타입은 byte, short, int, char, String (정수)만 가능하다.
			//long, 실수 는 불가하다.
			case "+":

				result = num1 + num2;
				break;   // break를 만나면 스위치 문을 나간다.

			case "-":

				result = num1 - num2;
				break;   // break를 만나면 스위치 문을 나간다.	

			case "*":

				result = num1 * num2;
				break;   // break를 만나면 스위치 문을 나간다.	
			case "/":

				result = (double)num1 / num2;   // 25/2 => 12.5
				break;   // break를 만나면 스위치 문을 나간다.

			default:

				b_flag = false;  // if문을 사용하기위해 블린 타입을 false로 변경한다.80번줄

				System.out.println(">>" + operator + "는 사칙연산(+,-,*,/)이 아니므로 계산이 불가합니다. !!");

				break;
			} // end of switch
			

			if(b_flag) {    // b_flag가 true을때만 돌아가게 된다.
				
				if("/".equals(operator)) {  //operator가 나누기일때만 실행   // 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
									        //문자열 비교는 "3".equals("5);
					System.out.println(">> 결과 : " + num1 + operator + num2 + "=" + result + "입니다.");
				}//end of if
				else { // 나머지 실행
					System.out.println(">> 결과 : " + num1 + operator + num2 + "=" + (int)result + "입니다.");  // (int)는 캐스팅하는 것
				}//end of else
				
			}//end of if 
		}// end of try
		
		catch(NumberFormatException e) {  // java.lang 패키지이기 때문에 imfort할 필요 없음 
										  // 이러한 오류가 생기면 모든 부분을 생략하고 catch로 와서 실행한다.
			
			System.out.println(">> " + inputStr  + "은(는) 정수가 아닙니다. 정수만 입력하세요!! <<");
			
		}// end of catch
		

		sc.close(); // 메모리 낭비 방지 스케너 닫기
	}//end of public static void main(String[] args

}// end of public class Scanner5Main

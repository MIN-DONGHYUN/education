package my.day04.c.scanner;

//import java.util.Scanner;
//import java.util.InputMismatchException;
import java.util.Scanner;   // util 패키지의 전체를 사용


public class Scanner3Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 => ");
		
		try {	
		
			String inputStr = sc.nextLine();   //문자열 받아오기
		
			int n = Integer.parseInt(inputStr) + 10;  //문자열을 int 타입으로 변경해주는 것이다.
													  // 2023 + 10
		
								      // "2023" 엔터 (정상) 
									  // "안녕하세요"는 int 타입으로 형변환 불가이므로 java.lang.NumberFormatException 발생 
									  // "1561564564562321 는 int 타입으로 형변환 불가이므로 java.lang.NumberFormatException 발생 
									  // "1.51561"는 int 타입으로 형변환 불가이므로 java.lang.NumberFormatException 발생 
		

			System.out.println("입력한 정수레 10을 더한값 : " + n);
		
		
		} //end of try
		catch(java.lang.NumberFormatException e) {  // java.lang 패키지는 안써도 됨 오류를 잡는 catch
		//catch(NumberFormatException e)            // 이렇게도 사용가능 
			
			System.out.print(">>> 정수를 입력하세요 !!!!! <<< \n");
			
		} // end of catch
		
		
		sc.close(); //메모리 절약하기 위해 사용

	}

}

package my.day04.c.scanner;

//import java.util.Scanner;
//import java.util.InputMismatchException;
import java.util.*;   // util 패키지의 전체를 사용


public class Scanner2Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 => ");
		
		try {   //미리 시도하는 것 (오류 잡기 위해서 사용하는 듯함)
			
			int inputNum = sc.nextInt();  // 2023 엔터 (정상)
										  // 안녕하세요로 입력시 오류!
								      	  // 1561564564561 int 보다 높으면 오류
									      // 실수로 들어와도 오류
		
		
			sc.nextLine();   // 스케너 버퍼에 있는 찌꺼기 삭제
		
			System.out.println("입력한 정수 : " + inputNum);
		
		} // end of try
		
		catch(java.util.InputMismatchException e) {    //시도에서 오류가 발생시 실행한다. InputMismatchException만 
			System.out.println(">>> 정수만 입력하세요!!! <<< \n");
		} //end of catch
		
		
		
		sc.close();

	}

}

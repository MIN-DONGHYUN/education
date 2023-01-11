package my.day08.a.qize;

import java.util.Scanner;

public class QuizMain1 {

	/*      
	   === 홀수 및 짝수의 합 구하기 ===
	   
	   ▷ 첫번째 정수 입력하세요: 1
	   ▷ 두번째 정수 입력하세요: 10
	   
	   >>> 결과 <<<
	   1부터 10까지의 홀수의 합 : 25
	   1+3+5+7+9 = 25
	   
	   1부터 10까지의 짝수의 합 : 30
	   2+4+6+8+10 = 30
	   
	   === 홀수 및 짝수의 합 구하기 ===
	   
	   ▷ 첫번째 정수 입력하세요: 2
	   ▷ 두번째 정수 입력하세요: 9
	   
	   >>> 결과 <<<
	   2부터 9까지의 홀수의 합 : 24
	   3+5+7+9 = 24
	   
	   2부터 9까지의 짝수의 합 : 20
	   2+4+6+8 = 20
	*/   
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=== 홀수 및 짝수의 합 구하기 === \n");
		
		while(true) {
			
			try {			
				System.out.print("> 첫번째 정수 입력하세요 : ");
				String strFirstNo = sc.nextLine();				// 키보드 문자열로 받아옴 
				int firstNo = Integer.parseInt(strFirstNo);		// String 타입 정수로 
				
				System.out.print("> 두번째 정수 입력하세요 : ");
				String strSecondNo = sc.nextLine();				// 키보드 문자열로 받아옴 
				int secondNo = Integer.parseInt(strSecondNo);	// String 타입 정수로
				
				int holSum = 0;  //홀수의 누적의 합계를 저장하는 변수
				int jjakSum = 0;  //짝수의 누적의 합계를 저장하는 변수
				
				int hol_startNo = 0, jjak_startNo = 0;  //변수설정
				
				if(firstNo % 2 == 0)// 첫번째 입력받은 값이 짝수이라면 
				{					// 2
					hol_startNo = firstNo + 1;
					jjak_startNo = firstNo;
				}
				else		// 첫번째 입력받은 값이 홀수이라면 
				{			// 1
					jjak_startNo = firstNo + 1;
					hol_startNo = firstNo;
				}
				
				// == 홀수 및 짝수의 합을 구한다. ==
				String str_hol = "", str_jjak = "";		// 문자열 생성
				
				int status_1 = 0, status_2 = 0;  //status 변수 설정
				
				while(true) // 무한 반복
				{
					String str_add = ("".equals(str_hol) && "".equals(str_jjak))?"":"+";   //삼항연산자 
					// 맨처음이라면 "", 아니라면 +를 넣어준다.

					if(hol_startNo <= secondNo) // 홀수 시작 이 두번째 정수보다 작으면 
					{
						holSum += hol_startNo; //홀수만 더한다
						str_hol += str_add + hol_startNo;  //문자열 결합
						
						hol_startNo += 2;		// 2증가
						
						status_1 = 1;
					}
					
					if(jjak_startNo <= secondNo)	// 짝수 시작 이 두번째 정수보다 작으면 
					{
						jjakSum += jjak_startNo;  //짝수만 더한다
						str_jjak += str_add + jjak_startNo;  //문자열 결합 
						
						jjak_startNo += 2;		// 2증가
						
						status_2 = 1;
					}
					
					if(hol_startNo > secondNo && jjak_startNo > secondNo)  // secondNo를 넘어가면 
					{
						break;  //while문 탈출
					}
				}// end of while
				
				if(status_1 * status_2  == 1) //홀, 짝수가 프로그램이 실행되어서 둘다 1이라면
				{
					System.out.println("\n >>> 결과 <<<");
					System.out.println(firstNo + "부터 "+ secondNo +"까지의 홀수의 합 : " + holSum);
					System.out.println( str_hol + " = " + holSum + "\n");
					System.out.println(firstNo + "부터 " + secondNo + "까지의 짝수의 합 : " + jjakSum);
					System.out.println( str_jjak + " = " + jjakSum);
				}
				
				else			//홀, 짝수가 프로그램이 하나라도 실행 안되어서 0이라면
				{
					System.out.println(">> 첫번째 정수가 두번째 정수보다 작아야 합니다. << \n");
					//continue; //맨 위로 돌아간다.
				}

				sc.close();		//메모리 누수 방지 
				break;				//while 탈출 
				
			}
			catch(NumberFormatException e) {		//이런 에러가 잡히면 실행
				System.out.println(" >> [경고] 정수만 입력하세요!! << \n");
			}
			
			
		}// end of while(ture)		

		System.out.println("\n === 프로그램 종료 ===");  //System.err.println하면 빨간색으로 나옴 
		sc.close();		//메모리 누수 방지 
	}// end of main

}

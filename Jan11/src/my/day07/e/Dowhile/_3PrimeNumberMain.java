package my.day07.e.Dowhile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class _3PrimeNumberMain {

	// === 소수란? === 
	   // 소수란? 1과 자기 자신으로밖에 나누어지지 않는 1 이외의 정수 
	   // 예> 1 부터 10까지의 소수를 나타내면 
	   //       2%2 ==> 0   2 는 소수
	   //       3%3 ==> 0   3 는 소수
	   //       4%2 ==> 0   4 는 소수가 아님
	   //       5%5 ==> 0   5 는 소수
	   //       6%2 ==> 0   6 는 소수가 아님
	   //       7%7 ==> 0   7 는 소수
	   //       8%2 ==> 0   8 는 소수가 아님
	   //       9%3 ==> 0   9 는 소수가 아님
	   //      10%2 ==> 0  10 는 소수가 아님     
	
	/*
	    === 실행결과 ===
	    > 시작 자연수 : 1(엔터)
	    >끝 자연수 : 20(엔터)
	    1부터 20까지의 소수는?
	    2,3,5,7,11,13,17,19
	    
	    1부터 20까지의 소수의 개수? 8개
	    
	    1부터 20까지의 소수의 합? 77
	    
	    === 프로그램 종효 ===
	*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int startNo=0;	// 전역변수 
		int endNo=0;
	
		do {
			try {
				System.out.print(" > 시작 자연수 : " );
				startNo = sc.nextInt();  // "1" 정상 "1.545" 비정상 "안녕" 비정상 int를 받아오는 것임
											 // 자연수이기 때문에 0 또는 음수이면 경고를 날리자 
				sc.nextLine();   // 버퍼를 비우기 위해 사용한다.
				
				System.out.print(" > 끝 자연수 : " );
				endNo = sc.nextInt();  // "1" 정상 "1.545" 비정상 "안녕" 비정상 int를 받아오는 것임
				
				sc.nextLine();   // 버퍼를 비우기 위해 사용한다.
			
				if(startNo < 1 || endNo < 1)  // start,endNO  가 1보다 작으면 
				{
					System.out.println(">> [경고} 입력하시는 값은 모두 자연수이여야 합니다.!! << \n");
				}
				else if(startNo >= endNo)	// startNo 가 endNo보다 같거나, 크면 
				{
					System.out.println(">> [경고} 두번째 입력한 숫자가 첫번째 입력한 숫자보다 커야 합니다 !! << \n");
				}
				else	// 그외
				{
					break;  //do while문 나가기
				}
			}
			catch(InputMismatchException e) {
				System.out.println(">> [경고} 자연수만 입력하세요!! << \n");
				sc.nextLine();  //버퍼 비우기 
			}
		}
		while(true);   // 무한 반복 조건이 참인 경우 계속 돌아감 
		
		String str_result = ""; //결과값
		int cnt = 0;  // 소수의 누적개수
		int sum = 0;  // 고구들의 누적의 합계
		
		for(int i= startNo ; i <= endNo; i++)		// 시작수부터 끝 숫자까지 반복
		{
			if(i == 1) //i가 소수인지 아닌지를 검사할 대상값이다.
					   //1 은 소수가 아니므로 검사할 필요가 없기에 continue;를 사용해 스킵한다.
			{
				continue; // 밑으로 내려가지 않고 증감식으로 돌아간다.
			}
			/*
			   나누기를 했을때 나머지가 얼마가 되는지 일일이 검사를 한다.
			   만약에 i가 2라면 ==> 2%2 == 0   2는 소수이다.
			   만약에 i가 3라면 ==> 3%2 != 0   
			   만약에 i가 3라면 ==> 3%3 == 0   3는 소수이다.
			   만약에 i가 4라면 ==> 4%2 == 0   4%3(검사할 필요가 없다) 4는 소수가 아니다.
			   만약에 i가 5라면 ==> 5%2 != 0   5%3 !=0   5%4 != 0 5%5 ==0 5는 소수이다.
			   ................
			   만약에 i가 9라면 ==> 9%2 != 0   9%3 == 0  9%4(검사할 필요가 없다.) 9는 소수가 아니다.
			*/
			
			boolean isSosu = true;  // 깃발 올림,내림처럼 경우의 수는 두가지
			
			for(int j=2; j < i;j++) //j가 분모에 들어갈 값이다. , i는 분자이다.
			{
				if(i%j == 0)  // 분자 나누기 j의 나머지가 0이면 검사할 대상인 i느 소수가 아닌 경우이다.
				{
					isSosu = false; // 소수가 아니므로 boolean값을 false로 나타내준다.
					break; //for문을 빠져 나온다.
				}
			}// end of for
			
			// 검사대상인 i가 소수이라면 쌓아준다.
			if(isSosu == true)   //그냥 isSosu라고 써도 결과가 참이냐를 물어봄
			{
																  //삼항연산자
				String str_add = (!"".equals(str_result))?",":""; //.equals는 문자열 비교, 맨처음이라면 ,를 넣지 않는다.
				
				//string이므로 문자열로 나열
				str_result += str_add + i;   //소수인것만 결과값을 더한다.
				
				cnt ++; // 소수의 개수를 누적
				sum += i; // 소수들의 누적의 합계를 구한다.
			}
			
			
		}// end of for
		
		System.out.println( startNo + "부터 " + endNo +"까지의 소수는?\n" + str_result + "\n");
		//2,3,5,7,11,13,17,19
		
		System.out.println( startNo + "부터 " + endNo +"까지의 소수의 개수?  " + cnt +"개" );
		// 1부터 20까지의 소수의 개수? 8개
		System.out.println( startNo + "부터 " + endNo +"까지의 소수의 합?  " + sum);
		// 1부터 20까지의 소수의 합? 77
		
		sc.close();  //메모리 누수 방지 
	}// end of main

}

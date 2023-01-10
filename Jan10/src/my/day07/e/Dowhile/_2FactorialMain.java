package my.day07.e.Dowhile;

import java.util.Scanner;

public class _2FactorialMain {

	//  === 입사문제 === //
	/*
	 	>> 알고 싶은 팩토리얼 수 입력 => 5(엔터)
	 	>> 5! = 120
	 	
	 	5! = 5*4*3*2*1
	 	7! = 7*6*5*4*3*2*1
	 	
	 	>> 또 할래?[Y/N] => s(엔터)
	 	>> [경고] Y 또는 N만 입력하세요!!
	 	
	 	>> 또 할래?[Y/N] => Y(엔터)
	 	
	 	>> 알고 싶은 팩토리얼 수 입력 => 안녕 또는 1.1561(엔터)
	 	## [경고] 정수만 입력하세요!! ## 
	 	
	 	>> 알고 싶은 팩토리얼 수 입력 => -6 또는 0(엔터)
	 	>> [경고] 자연수만 입력하세요!! <<
	 	
	 	>> 알고 싶은 팩토리얼 수 입력 => 6(엔터)
	 	>> 6! = 720
	 	>> 또 할래?[Y/N] => N(엔터)
	 	== 프로그램 종료 ==
	*/
	
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		outer:	 // outer: 은 레이블 이라고 부르는데 그 레이블명이 지금은 outer이다. // 이름은 마음대로 사용가능 
		do
		{
			try
			{
				System.out.print(">> 알고 싶은 팩토리엉 수 입력 =>");
				int num = Integer.parseInt(sc.nextLine()); //String으로 키보드에서 받아온후 int로 변환 "5" 가능, "-7" "0" "1.154" "안녕"은 불가 
				
				if(num <= 0)	// 자연수가 아닌 음수와 0이면은 
				{
					System.out.println(">> [경고] 자연수만 입력하세요!! <<\n");
					continue;  // continue; 를 만나면 아래로 덜어지지 않고 do-while(조건식);의 조건식으로 돌아간다.
				}
				else if(num > 20)   // 20이상이라면 
				{
					System.out.println(">> [경고] 20이내만 가능합니다 <<\n");
					continue;   // continue; 를 만나면 아래로 덜어지지 않고 do-while(조건식);의 조건식으로 돌아간다.
				}
				
				long result = 1;  //long타입의 result 설정 long타입이 넘어가면 오류 
				// 정상이라면 5*4*3*2*1
				for(int i = num; i>0 ; i--)  // 입력받은것이 5라면 1씩 감하면서 반복한다. 1까지 반복 
				{
					//result = result * i;
					result *= i;             // 결과 값을 1씩 줄이면서 곱해서 result에 대입 
				} // end of for
					
				System.out.println(num + "! = " + result);		//팩토리얼 출력
					
				do
				{
					System.out.print(">> 또 할래?[Y/N] => ");
						
					String yn = sc.nextLine();			//yn받을 문자열 키보드로부터 받기
						
					if("n".equalsIgnoreCase(yn))		// 대,소문자 n이 나온다면
					{
						break outer;				 //outer; 쪽으로 돌아감
					}
					else if("y".equalsIgnoreCase(yn))		//대,소문자 y 이면 
					{
						break; // 두번째 do - while문 빠져나가기 
					}
					else
					{
						System.out.println(">> [경고] Y 또는 N만 입력하세요!! \n");	//출력
					}
				} // end of do
				while(true);   //무한 반복 
				
			}
			catch(NumberFormatException e)  //try에서 시도한 것에서 에러가 난다면 
			{
				System.out.println("## [경고] 정수만 입력하세요!! ##\n");   //출력 
			}
		}
		while(true);  // 무한 반복
		
		System.out.println("\n == 프로그램 종료 ==");	// 프로그램 종료

		sc.close();  // 메모리 누수 방지 
		
	} // end of main

}

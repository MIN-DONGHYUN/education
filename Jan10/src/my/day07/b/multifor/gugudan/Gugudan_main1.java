package my.day07.b.multifor.gugudan;

import java.util.Scanner;

public class Gugudan_main1 {

	public static void main(String[] args) {
		
		/*
	      >> 몇단볼래? => 8엔터
	      
	      === 8단 ===
	      8*1=8
	      8*2=16 
	      8*3=24
	      8*4=32
	      8*5=40
	      8*6=48
	      8*7=56
	      8*8=64
	      8*9=72 
	      
	      >> 또 하시겠습니까?[Y/N] => y엔터 또는 Y엔터
	      
	      >> 몇단볼래? => 1.34엔터 또는 똘똘이엔터
	      >>> [경고] 2단부터 9단까지만 가능합니다 <<<
	      
	      >> 몇단볼래? => 345엔터
	      >>> [경고] 2단부터 9단까지만 가능합니다 <<<
	      
	      >> 몇단볼래? => 3엔터
	      
	      === 3단 ===
	      3*1=3
	      3*2=6 
	      3*3=9
	      3*4=12
	      3*5=15
	      3*6=18
	      3*7=21
	      3*8=24
	      3*9=27
	         
	      >> 또 하시겠습니까?[Y/N] => s엔터 또는 S엔터
	      >>> [경고] Y 또는 N 만 가능합니다!! <<<
	      
	      >> 또 하시겠습니까?[Y/N] => n엔터 또는 N엔터
	      
	      == 프로그램종료 ==   
	   */   
		Scanner sc = new Scanner(System.in);	// 키보드를 사용하기 위해 
		
		
		/*
		   === 레이블을 사용하여 break; 하기 ===
		       레이블명 뒤에눈 : 을 붙이며 반드시 반복문 앞에 써야 한다.
		*/
		
		outer: // outer: 은 레이블 이라고 부르는데 그 레이블명이 지금은 outer이다. // 이름은 마음대로 사용가능 
		
		for(;;)			// 무한 반복 
		{
			try 	// NumberFormatException를 잡기위해 미리 시도 
			{
				System.out.print(">> 몇단 볼래? => ");	// 출력
			
				String strDan = sc.nextLine();   // 문자열 타입으로 키보드 입력을 받는다.
				
				int dan = Integer.parseInt(strDan);   //strdan문자열을 dan에 int 형으로 저장 "8" 성공 , "345" 실패, "1.34" 실패, "똘똘이" 실패
				
				if( 2 <= dan && dan <=9)	//2단 부터 9까지 일때
				{
					// 해당하는 단을 출력하기 
					System.out.println("=== " + dan + "단 ===");
					for(int i=0; i <9; i++)			// 단을 나타내는 것 
					{
						System.out.println(dan + "*" + (i+1) + "=" +  (dan*(i+1)));    // 단을 나타낸다.
					} //end of for
						
					for(;;)   // 무한 반복
					{
						System.out.print("\n>> 또 하시겠습니까?[Y/N] =>");    // "y" 또는 "Y"
						// "n" 또는 "N"
						// "s"
						// "몰라"
						String yn = sc.nextLine();			// yn에 키보드 입력값을 문자열로 받아온다.
	
						/*if("n".equals(yn) || "N".equals(yn) )		// 소문자 n이나 대문자 N일 경우에는 .equals(조건)을 잘 사용하도록 하자
						{
						//위와 같은 것이다.
						}*/
	
						////////////////중요////////////////////
						if("n".equalsIgnoreCase(yn))		// 소문자 n이나 대문자 N일 경우에는 .equalsIgnoreCase을 잘 사용하도록 하자 
															// .equalsIgnoreCase(조건) 은 대소문자 구분없이 n이면은 실행한다.
						{
							sc.close();			// 키보드 더 이상 안쓰기 때문에 메모리 누수 방지위해 사용 
							break outer; // 1번째 for 무한 반복을 나간다. 레이블이 되어진 outer에 빠져나가 1번째 for문을 나갈 수 있다.
										 // 레이블 명이 outer 라고 선언되어진 반복문 (for)을 빠져나가는 것이다.
						}
						else if("y".equalsIgnoreCase(yn))    // 소문자 y이나 대문자 Y일 경우에는 .equalsIgnoreCase을 잘 사용하도록 하자 
															// .equalsIgnoreCase(조건) 은 대소문자 구분없이 y이면은 실행한다.
						{
							break;	// 2번째 for 무한 반복을 나간다.
									// 가장 가까운 반복문(for)을 빠져나오는 것이다.
						}
						else			//n과 y 가 아닌 경우에는 
																// yn <== "Y", "y", "n", "N"을 제외한 나머니 "s", "몰라" 등을 입력한 경우 실행한다.
						{
							System.out.println(">>> [경고] Y 또는 N 만 가능합니다!! <<<");		//출력
						}
					}//end of for2
	
				}//end of if
				else				// 2~9까지의 숫자가 아니라면 
				{
					System.out.println(">>> [경고] 2단부터 9단까지만 가능합니다 <<<\n");
				}
			}
			catch(NumberFormatException e)  // 에러 NumberFormatException를 잡기위해서 catch
			{
				System.out.println("### [경고] 2단부터 9단까지만 가능합니다 ### \n");
			}

		}// end of for1
		
		System.out.println("\n== 프로그램종료 ==");  // 출력 
		
	} //end of main

}

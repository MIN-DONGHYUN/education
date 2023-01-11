//Math.random은 해킹당한적이 있으므로 웬만하면 사용말고 _2randomMain을 보자 

package my.day08.b.random;

import java.util.Scanner;

public class _1MathRandomMain {	

	public static void main(String[] args) {
		
		// === 랜덤한 정수를 뽑아낸다 ===//
		double random = Math.random();  // 랜덤은 double형으로 받는다. Math.random
		System.out.println("random => " + random);
		// random => 매번마다 값이 달라진다.
		
		/*
		   java.lang.Math.random() 메소드는 
		   0.0 이상 1.0 미만의 실수(double)값을 랜덤하게 나타내어주는 메소드이다.
		       즉,  0.0 <= 임의이 난수(실수)  < 0
		   
		   1 부터 10 까지 중 랜덤한 정수를 얻어와 본다. 
		   
		   랜덤한 정수 = (int)(Math.random()*구간범위) + 시작값;   // 공식이다.
		   Math.random() = 0.0 일때 
		              (int)0.0*(10-1+1)+1 ==> 1 
		              
		   Math.random() = 0.0872948627250868 일때 
		              (int)0.0872948627250868*(10-1+1)+1 ==> 1 
		              
		   Math.random() = 0.8606970691775878 일때 
		              (int)0.8606970691775878*(10-1+1)+1 ==> 9 
		              
		   Math.random() = 0.21534823746789 일때 
		              (int)0.21534823746789*(10-1+1)+1 ==> 3 
		              
		   Math.random() = 0.5672984827210117 일때 
		              (int)0.5672984827210117*(10-1+1)+1 ==> 6 
		
		
		
		3 부터 7 까지 중 랜덤한 정수를 얻어와 본다. 
		   
		   랜덤한 정수 = (int)(Math.random()*구간범위) + 시작값;   // 공식이다.
		   Math.random() = 0.0 일때 
		              (int)0.0*(7-3+1)+3 ==> 3 
		              
		   Math.random() = 0.0872948627250868 일때 
		              (int)0.0872948627250868*(7-3+1)+3 ==> 3
		              
		   Math.random() = 0.8606970691775878 일때 
		              (int)0.8606970691775878*(7-3+1)+3 ==> 7 
		              
		   Math.random() = 0.21534823746789 일때 
		              (int)0.21534823746789*(7-3+1)+3 ==> 4
		              
		   Math.random() = 0.5672984827210117 일때 
		              (int)0.5672984827210117*(7-3+1)+3 ==> 5 
		
		
		*/
		
		// 1 부터 10까지 중 랜덤한 정수를 얻어와 본다.
		//랜덤한 정수 = (int)(Math.random()*끝-시작값+1) + 시작값;   // 공식이다.

		int rand1 = (int)(Math.random()*(10-1+1))+1;
		System.out.println("1 부터 10 까지의 랜덤한 정수 => " + rand1);
		
		// 3 부터 7까지 중 랜덤한 정수를 얻어와 본다.
		//랜덤한 정수 = (int)(Math.random()*끝-시작값+1) + 시작값;   // 공식이다.

		int rand2 = (int)(Math.random()*(7-3+1))+3;
		System.out.println("3 부터 7 까지의 랜덤한 정수 => " + rand2);
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		////////////////////////////////////////////////////////////
		
		// 인증키는 랜덤한 숫자 3개(0~9)와 랜덤한 대문자1개와 랜덤한 소문자 3개로 만들어진다.
		// Ex) 109Sata     090Bwac
		
		// 0 ~ 9 까지의 랜덤한 숫자 1개를 얻어오는 작업을 3번 반복해야 한다.
		String key = "";  // 인증키 받을 곳
		
		for(int i=0;i<3;i++)
		{
			int num = (int)(Math.random()*(9-0+1))+0;  //공식
			key += num;   // 문자열로 받기때문에 숫자 +가 아닌 그냥 몊에 적어준다.
		}
		
		//System.out.println("인증키 => " + key);  // 숫자 나타내기 
		
		int num = (int)(Math.random()*('Z'-'A'+1))+'A';  // 대문자를 나타내기 위해 
		
		key += (char)num;   //char로 형변환 대문자 표시를 위해 
		
		//System.out.println("인증키 => " + key);  // 대문자까지 나타내기 
		
		for(int i = 0; i <3; i++) 
		{
			num = (int)(Math.random()*('z'-'a'+1))+'a';  // 대문자를 나타내기 위해 
			
			key += (char)num;   //char로 형변환 소문자 표시를 위해 

		}
		System.out.println("인증키 => " + key);  // 소문자까지 나타내기 
		
		System.out.println("\n~~~~~~홀작 맞추기~~~~~~~\n");
		
		/*
		   선택[1:홀수 / [0:짝수] => 1
		   
		  컴퓨터가 낸 수 : 7 ==> 맞추었습니다.
		  컴퓨터가 낸 수 : 10 ==> 틀럈습니다.
		*/
		Scanner sc = new Scanner(System.in);
		
		outer: // 레이블이다.
		do {
			try {
				System.out.print("선택[1:홀수 / [0:짝수] ==> ");
				int choice = Integer.parseInt(sc.nextLine());  // 안녕하세요,  1.1515 안됨 
												  // 1 됨 입력받은 값을 int형으로 변경한다.
				if(choice != 0 && choice != 1)  // 0과 1이 아니라면
				{
					System.out.println(" >> [경고] 0또는 1만 입력하세요!! << \n");
				}
				else		//0 또는 1 을 받았다면 
				{			//PC에서 랜덤하게 1 ~ 10 까지중 하나만 가지도록 만든다.
					int rand_num = (int)(Math.random()*(10-1+1))+1;  // 1 ~ 10중 하나를 받기위해
					
					String result = "";  // 결과값 받기 위해 설정
					
					if(rand_num % 2 == choice) // 사용자가 지정한 0 또는 1 홀,짝이랑 같다면 실행 
					{
						result = "맞추었습니다.";
					}
					else			// 아니라면 
					{
						result = "틀렸습니다.";
					}
					
					System.out.println("\n컴퓨터가 낸 수 : " + rand_num +"==> " + result); //결과 출력
					
					do {
						System.out.print("\n>> 또 할래??[Y/N] => ");
						
						String yn = sc.nextLine();   // 문자열 키보드로 받아와 저장 
						
						if("Y".equalsIgnoreCase(yn))   //대,소문자 y일 경우 
						{
							break; // do-while문을 나간다.
						}
						else if("N".equalsIgnoreCase(yn))	//대,소문자 n일 경우 
						{
							break outer;  // outer로 빠져나간다.
						}
						else		//둘다 아닐 경우 
						{
							System.out.println(">> [경고] Y 또는 N만 입력하세요!! << \n");
						}
					}
					while(true); // 무한 반복 

				}
			}
			catch(NumberFormatException e) {   //이 에러가 나면 실행
				System.out.println(" >> [경고] 정수만 입력하세요!! << \n");
			}
		}
		while(true);  // 무한반복 
		
		sc.close();   //메모리 누수 방지 
		System.out.println(">> 프로그램 종료 <<");
		
	}// end of main

}

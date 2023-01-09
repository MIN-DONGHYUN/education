package my.day06.d.For;

import java.util.Scanner;

public class Sum2_main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) {  // 조건 없는 무한 반복
		
			try {
			
					System.out.print(">> 누적해야 할 시작 숫자 => ");  //5
		
					int startNo = Integer.parseInt(sc.nextLine()); // "5" String타입을 받되 바로 int로 변경 
					//  startNo = 5
					//  startNo = "안녕하세요"
					
					System.out.print(">> 누적해야 할 마지막 숫자 => ");  //5 
		
					int endNo = Integer.parseInt(sc.nextLine()); // "10" String타입을 받되 바로 int로 변경
					//  endNo = 1
					//  endNo = 10
					//  endNo = "건강하세요"
	
					if(endNo < startNo)
					{
						System.out.println("==[경고] 마지막 숫자는 시작 숫자보다 같거나 커야 합니다.==");
						continue;  // 반복문에서 continue를 만드는 순간 밑으로 안내려가고 증감식으로 간다.
					}
					// startNo     ==> 1    2    3   5
					// endNo       ==> 10   9    5   10 (정상)		
					// 반복해야할 회수 ==> 10   8    3   6번 반복
					// 반볻해야할 회수 ==> (endNo - startNo + 1) 번 반복
					
					int cnt = endNo - startNo + 1;  // 반복해야할 회수
								
					int sum = 0;  // 누적의 합을 저장시켜주는 변수,  0으로 초기화 함. 
					
					int start = startNo; // 스타트 넘버를 스타트에 저장
					
					String str = "";   // String의 변수 설정 
					
					for(int i = 0; i < cnt; i++)
					{
						////////////////////***************중요 삼항연산자 ********************////////////////
						String str_add = (i < cnt-1)?"+":"=";   //삼항연산자 i < cnt-1이 참이면 +, 거짓이면 =  
						
						str += start + str_add;  //str = str + start +"+";
						  					  //str = str + 5 +"+" + 6 + "+";
							  				  //str = str + 5 +"+" + 6 + "+" + 7 + "+";
						  					  // ...............
						  				      //str = "5+6+7+8+9+10=45"; 
						  
						  
						  sum += start++;   //sum = sum + start;
						 				   //sum = 0+5; //startNo를 두번 사용하기 위해 복사본인 start를 사용
						 				   //sum = 0+5+6;
						 				   //sum = 0+5+6+7;
										   //sum = 0+5+6+7+8;
										   //sum = 0+5+6+7+8+9;
										   //sum = 0+5+6+7+8+9+10;
						 
						 
						
					}// end of for
					
					System.out.println(startNo + " 부터" + endNo +" 까지의 누적의 합은 " + sum + " 입니다.");
					// 5부터 10까지의 누적의 합은 45입니다.
					
					System.out.println(str + sum);
					// 5 + 6 + 7 + 8 + 9 + 10 = 45 
					
					break;  // 무한 반복문 빠져나오기 
			
			}// end of try
			
			catch(NumberFormatException e) {
				System.out.println("==[경고] 정수만 입력하세요~~ ==");
			} // end of catch 
			
		}
		
		sc.close(); //메모리 누수 방지

	}// end of main()~~~~~~~~~~~~

}

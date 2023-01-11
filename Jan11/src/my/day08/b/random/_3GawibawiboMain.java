package my.day08.b.random;

import java.util.Random;
import java.util.Scanner;

public class _3GawibawiboMain {

	public static void main(String[] args) {
		
		Random rnd = new Random();  // Math.random보다 보완상 좋으므로 이렇게 사용하자
		
		Scanner sc = new Scanner(System.in);	//키보드 입력받기 위해
		
		String str_menuno="";  //전역변수 설정 
		
		int cnt = 0, win = 0, draw = 0, lose = 0;   // 게임한 횟수, 승,무,패 승률 나타내기 위해 설정
		
		do
		{
			System.out.println("\n =========== 메 뉴 ============\n"
								+ "1.가위\t2.바위\t3.보\t4. 게임종료\n"
								+ "============================="
								);
			System.out.print(">> 선택하세요 => ");
			
			str_menuno = sc.nextLine();   //int로 변환하지 않고 사용해보자 //사용자가 입력한 곳이다.
			
			//1~3까지 중 랜덤한 숫자 한개 만들기
			int rndnum = rnd.nextInt(3 - 1 + 1 ) + 1;
			
			/////!!!!!!!!!!!! 정수를 문자열로 변환하기 !!!!!!!!!!!!!/////
			String str_rndnum = String.valueOf(rndnum);   // 1 ==> "1",    2 ==> "2"  int형이 문자열로 변경된다.
			
			String str_pc_gbb = "";  //컴퓨터가 낸 가위바위보 하기 위해 설정 
			
			if("1".equals(str_rndnum))  // 컴퓨터가 낸것을 확인하기 위해 
			{
				str_pc_gbb = "가위";
			}
			
			else if("2".equals(str_rndnum))
			{
				str_pc_gbb = "바위";
			}
			else
			{
				str_pc_gbb = "보";
			}
			
			boolean status = true; // 블린 값을 설정 (상태를 보기 위해 설정)
			
			String str_user_gbb = "";  //사용자가 낸 가위바위보 하기 위해 설정
			
			switch (str_menuno) {  // 사용자가 입력한 문자를 비교한다.
			case "1":  //가위
				str_user_gbb = "가위";
				break;
			case "2":  //바위
				str_user_gbb = "바위";
				break;
			case "3":  //보
				str_user_gbb = "보";
				break;
			case "4":  // 게임 종료
				status = false; // (상태를 보기 위해 설정) 거짓 
				break;

			default:	//나머지 
				System.out.println(">> [경고] 메뉴에 존재하지 않는 것입니다. << \n");
				status = false; // (상태를 보기 위해 설정) 거짓 
				break;
			} //end of switch
			
			if(status)  // status가 true이면 결과물 출력 
			{
				String str_result="";  // 졌는지 이겼는지 나타내기위해 설정
				 
				
				//사용자가 이긴경우
				if("1".equals(str_menuno) && "3".equals(str_rndnum) || // 컴퓨터와 내 가위바위보를 비교 
				   "2".equals(str_menuno) && "1".equals(str_rndnum) || 
				   "3".equals(str_menuno) && "2".equals(str_rndnum))  
				{
					str_result = "이겼습니다.!!\n";
					win += 1;  //승리횟수 추가
				}
				//사용자가 진 경우
				else if("1".equals(str_menuno) && "2".equals(str_rndnum) || 
						"2".equals(str_menuno) && "3".equals(str_rndnum) || 
						"3".equals(str_menuno) && "1".equals(str_rndnum))
				{
					str_result = "졌습니다ㅠㅠ\n";
					lose+= 1;  // 진 횟수 추가 
				}
				//사용자 pc가 비긴경우 
				else
				{
					str_result = "비겼습니다 아깝다!\n";
					draw+= 1;  // 비긴횟수 추가 
				}
				cnt+= 1;     // 전체 게임 횟수 추가 
				
				
				System.out.println("\n=== 게임 결과 ===\n"
									+ "사용자 : " + str_user_gbb +"\n"
									+ "컴퓨터 : " + str_pc_gbb +"\n"
									+ "님이 " + str_result
									+ "현재까지 승무패 기록입니다. => "
									+ "총 " + cnt + "판 " + win + "승 " + draw + "무 " + lose + "패 입니다."
								);
			}
		}
		while(!("4".equals(str_menuno))); // 4만 안골라지않으면 나가지 말거라 
		
		
		sc.close(); // 메모리 누수 방지 
		System.out.println("\n>>프로그램 종료 <<");
	}// end of main

}

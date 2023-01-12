package my.day09.d.array;

import java.util.Scanner;

public class MemberMain {

	public static void main(String[] args) {
		
		Member[] mbrArr = new Member[4];  // 인스턴스 배열 4개 저장소 
		
		Member mbr1 = new Member();			// member 에 있는것 가져다 씀
		mbr1.id = "Leess";
		mbr1.passwd = "qWer1234$"; 
		mbr1.name = "이순신";
		
		Member mbr2 = new Member();			// member 에 있는것 가져다 씀
		mbr2.id = "eomjh";
		mbr2.passwd = "qWer1234@"; 
		mbr2.name = "엄정화";
		
		mbrArr[Member.count++] = mbr1;    //스테틱 필드로 선언하지 않으면 count는 계속 0일것이다.
		mbrArr[Member.count++] = mbr2;	  //count++을 두번하더라도 결국 count는 0으로 초기화 되기 때문에 스테틱을 사용하는 것이다. 
		
		
		//////////////////////////////////////////////////////////
		
		Scanner sc = new Scanner(System.in);		// 키보드로 입력받기위해 Scanner
		
		String str_menuNo = "";  // 전역변수 설정 
		
		
		Member login_mbr = null;  // 로그인 된 회원정보 초기값 Null
		
		
		
		do
		{
			String loginMsg = "";   // loginMsg초기값 
			String login_logout = "";  // 로그인 로그아웃을 나타내기위해 초기값 설정 
			String myInfoSearch = "";  // 내정보조회 하기 위해 초기값 설정
			String myInfoUpdate = "";  // 내정보 수정을 위해 초기값 설정 
			
			if(login_mbr == null)   // 로그인을 하지 않았으면
			{
				login_logout = "로그인";
			}
			else					// 로그인을 했으면 
			{
				loginMsg = "[" + login_mbr.name + " 님 로그인중]";   // 로그인 중이므로 상태 메시지 loginMsg에 넣는다. 
				login_logout = "로그아웃";  // 로그아웃을 나타낸다.  
				myInfoSearch = "4. 내정보조회   ";  //로그인 되어있는 상태이므로 출력하기 위해 
				myInfoUpdate = "5. 내정보수정   ";  //로그인 되어있는 상태이므로 출력하기 위해 
			}
			
			System.out.println("\n=========>> 메뉴" + loginMsg + "<<=========\n"
								+ "1. 회원가입  2. " + login_logout + "\n "
								+ "3. 모든회원조회  " + myInfoSearch + myInfoUpdate + " 6. 프로그램 종료\n"
								+ "==============================================\n"
							  );
			
			System.out.print("▷ 선택하세요 => ");
			
			str_menuNo = sc.nextLine();  // 문자열로 메뉴 선택을 위해 키보드에서 입력받음 
		
			
			switch (str_menuNo) {		// 선택한것을 골라주기 위해 switch문 실행 
			case "1":	// 회원가입 
				
				break;
			
			case "2":	// 로그인 또는 로그아웃
				
				if(login_mbr == null)	// 로그인 시도를 해야한다.
				{
					System.out.print("▷ ID : ");
					String id = sc.nextLine(); // 아이디를 키보드로 받아온다.
					
					System.out.print("▷ Passwd : ");
					String passwd = sc.nextLine(); // 비밀번호를 키보드로 받아온다.
					
					boolean isLoginSuccess = false;  // 흔적을 남기기 위해 사용 
					
					// 저장소(배열)을 검사해야한다.
					for(int i = 0; i < Member.count; i++)		// 스테틱필드에 있는 값까지 넣는다. 배열을 직접 넣으면 비어있는 공간은 null
					{											// 이기 때문에 오류가 발생한다.
						if(mbrArr[i].id.equals(id) && mbrArr[i].passwd.equals(passwd))   
						{									// mbrArr[0]은 이순신 , [1]은 엄정화
															// i번째 있는 아이디, 암호 가 같아야만 실행 	
															// 로그인시 입력해준 id 와 passwd가 배열속에 저장된 Member 객체에 존재
							
							isLoginSuccess = true; // 흔적을 true로 남기고 빠져나온다.
							
							login_mbr = mbrArr[i];  // 로그인 정보 값에 mbrArr[i]값을 넣는다
							
							login_mbr.point += 10; // 로그인을 하면 point를 10점씩 올려주고자 한다.
							
							break; // 한 사람이 로그인을 정확하게 했다면 for문을 나가서 다음사람이 안하도록 한다.
								   // for문의 break; 이다 
						}
						else						// 존재하지 않는 id, passwd라면은 
						{
							
						}
						
					}// end of for~~~~~~~~~~
					
					if(isLoginSuccess)			// 흔적이 참이면 실행
					{
						System.out.println(" >> 로그인 성공 !! << \n");  
					}
					else
					{
						System.out.println(" >> 로그인 실패 !! << \n");  
					}
				}
				
				else					// 로그아웃 시도를 해야한다.
				{
					login_mbr = null;   // 로그아웃 되어있으면 아무 정보가 없는 null로 간다.
					System.out.println(" >> 로그아웃 되었습니다. << \n"); 
				}
				
				break;		//switch의 break; 이다.
			case "3":	// 모든회원조회
				
				break;
			case "4":	// 내정보조회
				
				break;
			case "5":	// 내정보수정 
				
				break;
			case "6":	// 프로그램 종료
				
				break;
			

			default:
				break;
			}// end of switch
		
		
		}
		while(!("6".equals(str_menuNo))); // 6이면 탈출 

		sc.close();		//메모리 누수 방지 
		
		System.out.println("\n=== 프로그램 종료 ===");
	}// end of main

}

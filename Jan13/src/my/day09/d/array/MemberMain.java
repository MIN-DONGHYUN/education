package my.day09.d.array;

import java.util.Scanner;

import my.util.MyUtil;

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
								+ "1. 회원가입  2. " + login_logout + "\n"
								+ "3. 모든회원조회  " + myInfoSearch + myInfoUpdate + " 6. 프로그램 종료\n"
								+ "==============================================\n"
							  );
			
			System.out.print("▷ 선택하세요 => ");
			
			str_menuNo = sc.nextLine();  // 문자열로 메뉴 선택을 위해 키보드에서 입력받음 
		
			
			switch (str_menuNo) {		// 선택한것을 골라주기 위해 switch문 실행 
			
			case "1":	// 회원가입 
				
				// 배열 mbrArr 에 빈방(비어있는 즉, null로 되어진 방이 있는지 없는지 확인한 후 
				// 빈방이 있으면 회원가입을 진행하고, 빈방이 없으면 정원마감 이라는 메시지를 출력하도록 한다.
				
				if(Member.count < mbrArr.length) {  //스테틱 필드의 count가 배열의 길이보다 작으면 실행 
					
					String id = "";			// 전역변수로 설정 
					String passwd = "";
					String name = "";
					
					
					for(;;)   // 무한반복
					{
						System.out.print("\n1. 아이디 : ");
						id = sc.nextLine();			//아이디 입력받는다.
						
						boolean isIdDuplicate = false;		// 흔적 남기기 위해 사용 id중복 검사 
						
						//입력받은 id가 기존회원이 저장된 배열 mbrArr에 가서 동일한 id가 있는지 없는지 검사해 야한다
						for(int i = 0; i<Member.count; i++)    //count만큼 반복
						{
							if(mbrArr[i].id.equals(id))		//mbrArr배열에 저장되어있는 아이디가 입력받은 아이디일 경우
							{						 		//즉 입력받은 id 가 기존회원이 사용중인 id 인 경우, 즉, 중복된 id이다.
								isIdDuplicate = true;		// 흔적남기기 id중복되었다.!!!
								break;		// for문 탈출 
							}
						}	// end of for
						
						//if(isIdDuplicate || id.trim().length() == 0)	//trim은 좌우 공백을 모두 삭제해준다.
						// 또는 											//trim으로 공백을 삭제했는데 엔터만 나왔으면 글자수는 0이다. ""
						if(isIdDuplicate || id.trim().isEmpty())	// 입력받은 id를 좌우 공백을 제거한후 모두 비어있다면 ""
						{											// isEmpty 공백을 검사 
							System.out.println(">> [경고] 아이디가 중복되었거나 아이디를 입력하지 않으셨습니다. 새로운 아이디를 입력하세요 !! <<\n");
						}
						else			// 사용 가능한 아이디일때
						{
							System.out.println(">> " + id + "는 사용가능한 id 입니다.<<");
							break;		// 무한 반복이였던 for문 탈출 
						}
					}// end of for
					
					// 비밀번호 시작부분 
					for(;;)			// 비밀번호 무한반복
					{
						System.out.print("\n2. 비밀번호 : ");
						passwd = sc.nextLine();		// 비밀번호를 입력받는다.
						
						if( !MyUtil.isCheckPassed(passwd))		// 8~15자리의 대,소문자,숫자, 특수기호를 입력받고 체크할때 조건 충족이 안된다면
						{
							System.out.println(">> [경고] 비밀번호는 8글자 이상 15글자 이하의 대,소문자,숫자,특수기호가 혼합되어져야만 합니다. <<\n");
						}
						else									//비밀번호가 올바르게 입력이 되었을때
						{
							break; // 무한 반복일 탈출 
						}
					}// end of for 
					
					// 성명 시작부분 
					for(;;)			// 비밀번호 무한반복
					{
						System.out.print("\n3. 성명 : ");
						name = sc.nextLine();		// 이름를 입력받는다.
						
						if( name.trim().isEmpty())		//공백이 제거후 ""만 남아서 비어있다면 
						{
							System.out.println(">> [경고] 성명은 필수입력 사항입니다 <<\n");
						}
						else									//이름이 올바르게 입력이 되었을때
						{
							break; // 무한 반복일 탈출 
						}
					}// end of for 
					
					Member mbr = new Member();	//새로운 인스턴스(객체)를 만든것이다.
					mbr.id = id;				// 객체 만든 곳에 배열에 넣기 위해 먼저 저장 
					mbr.passwd = passwd;
					mbr.name = name;
					
					mbrArr[Member.count++] = mbr;    //스테틱 필드로 선언하지 않으면 count는 계속 0일것이다.
													 //count를 올린다.
					
					System.out.println(">> 회원가입 성공 !! [" + Member.count +" 번째 가입/정원: " + mbrArr.length + "명] << \n");
					
				}// end of if
				else					// 배열보다 스테틱필드의 count 가 넘어버리면 
				{
					System.out.println(">> [경고] 정원마감으로 인해 더이상 회원가입이 불가합니다. << \n");
				}
				
				break;		//switch의 break; 이다.		 
			
				
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
															// 로그인시 입력해준 id 와 passwd가 배열속에 저장된 Member 객체에 존재하는 경우
							
							isLoginSuccess = true; // 흔적을 true로 남기고 빠져나온다.
							
							login_mbr = mbrArr[i];  // 로그인 정보 값에 mbrArr[i]값을 넣는다
							
							login_mbr.point += 10; // 로그인을 하면 point를 10점씩 올려주고자 한다.
							
							break; // 한 사람이 로그인을 정확하게 했다면 for문을 나가서 다음사람이 안하도록 한다.
								   // for문의 break; 이다 
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
				
				if(login_mbr != null)	// 로그인이 되어있다면
				{
					System.out.println("-----------------------------------");
					System.out.println("아이디\t성명\t포인트");
					System.out.println("-----------------------------------");
					
					String allMember_info = "";            //모든 회원 정보를 누적하기 위해 
					
					for(int i = 0; i < Member.count; i++)		// count만큼 반복
					{
						allMember_info += mbrArr[i].showInfo() + "\n";		// 회원정보 누적 
					}	//end of for
					
					System.out.println(allMember_info);
					
				}
				else			//로그아웃 상태라면 
				{
					System.out.println(">> [경고] 먼저 로그인 하세요 !! << \n");
				}
					
				break;		//switch의 break; 이다.
				
				
			case "4":	// 내정보조회
				
				if(login_mbr != null)	// 로그인이 되어있다면
				{
					System.out.println(login_mbr.showMyInfo()+"\n");	// 로그인되어있는 사람의 정보만 보여라
				}
				else					//로그아웃 상태이면 
				{
					System.out.println(">> [경고] 메뉴에 없는 번호 입니다 << \n");
				}
				
				
				break;		//switch의 break; 이다.
				
				
			case "5":	// 내정보수정 
				
				if(login_mbr != null)	// 로그인이 되어있다면
				{
					System.out.println("\n===" + login_mbr.name + " 님의 회원정보 변경하기 ===");
					System.out.println(login_mbr.showMyInfo()+"\n");	// 로그인되어있는 사람의 정보만 보여라
					
					String newpasswd = "";		// 패스워드 입력받기위해 
					
					//비밀번호 변경
					for(;;)			// 비밀번호 무한반복
					{
						System.out.print("\n1. 비밀번호[비밀번호를 변경하지 않으려면 그냥 엔터하세요] : ");
						newpasswd = sc.nextLine();		// 비밀번호를 입력받는다.
						
						if("".equals(newpasswd))		//passwd.trim().isEmpty() 사용하지 않는 경우 , 공백을 엔터한 경우  
						{
							newpasswd = login_mbr.passwd;		// newpasswd에 현재 비밀번호 대입 
							break;  //무한 반복 탈출
						}
						else		//엔터가 아닌 값이 들어온 경우 
						{
							if( !MyUtil.isCheckPassed(newpasswd))		// 8~15자리의 대,소문자,숫자, 특수기호를 입력받고 체크할때 조건 충족이 안된다면
							{
								System.out.println(">> [경고] 비밀번호는 8글자 이상 15글자 이하의 대,소문자,숫자,특수기호가 혼합되어져야만 합니다. <<\n");
							}
							else									//비밀번호가 올바르게 입력이 되었을때
							{
								break; // 무한 반복일 탈출 
							}
						}
					}// end of for 
					
					login_mbr.passwd = newpasswd;		// 현재 비밀번호에 새 비밀번호 대입 
					
					String newname =""; 		// 이름을 변경하기위해 
					// 성명 변경 
					for(;;)			// 비밀번호 무한반복
					{
						System.out.print("\n2. 새성명[성명 를 변경하지 않으려면 그냥 엔터하세요] : ");
						newname = sc.nextLine();		// 이름를 입력받는다.
						
						if( "".equals(newname))		//공백이 제거후 ""만 남아서 비어있다면, 그냥 엔터라면  
						{
							break;	//반복문 탈출 
							
						}
						else						//엔터가 아닌 값(성명)이 올바르게 입력이 되었을때
						{
							if( newname.trim().isEmpty())	// 받아온 값이 공백이라면
							{
								System.out.println(">> [경고] 성명은 필수입력 사항입니다 <<\n");
							}
							else	//올바르게 입력받았다면 
							{
								login_mbr.name = newname;	//현재 성명에 새로운 성명 대입 
								break; // 무한 반복일 탈출 
							}
						}
					}// end of for 
					
					
					//변경된 정보를 확인하자 
					System.out.println("\n ==> 사용자 정보 변경한 후 알아보기 <==");
					System.out.println(login_mbr.showMyInfo()+"\n");	// 로그인되어있는 사람의 정보만 보여라
					
					
				}// end of if
				else					//로그아웃 상태이면 
				{
					System.out.println(">> [경고] 메뉴에 없는 번호 입니다 << \n");
				}
				
				
				break;		//switch의 break; 이다.
				
				
			case "6":	// 프로그램 종료
				
				break;		//switch의 break; 이다.
			

			default:
				System.out.println(">> [경고] 번호를 잘못 입력하셨습니다. <<\n");
				break;		//switch의 break; 이다.
			}// end of switch
		
		
		}
		while(!("6".equals(str_menuNo))); // 6이면 탈출 

		sc.close();		//메모리 누수 방지 
		
		System.out.println("\n=== 프로그램 종료 ===");
	}// end of main

}

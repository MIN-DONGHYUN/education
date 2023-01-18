package my.day13.encapsulation;

import java.util.Scanner;

public class Main_gujikja {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);		// 키보드 사용위해
		
		Ctrl_gujikja ctrl = new Ctrl_gujikja();			//ctrl를 불러옴 
		
		Gujikja[] guArr = new Gujikja[5]; //5개의 배열 선언 (객체 배열)
		
		//////////////////////////////////////////////////////////////////////
		
		Gujikja gu1 = new Gujikja();		//Gujikja에 새로운 맴버 
		gu1.setUserid("eomjh"); 			// 메소드를 호출한다. 유저 아이디를 알아보는 것 
											// 값을 넣어줄때만 메소드를 통해 userid에 값을 넣어준다	
		gu1.setPasswd("qwer1234$A");		// private에 들어가 있던 passwd필드에 대입하기 위해 set + 대문자 시작 문자를 사용  
		gu1.setName("엄정화");
		gu1.setJubun("9501172");
		
		guArr[Gujikja.count++] = gu1;		// 배열 count 증가 guArr애 저장 
		
		Gujikja gu2 = new Gujikja();
		gu2.setUserid("leess");				// 메소드를 호출한다. 유저 아이디를 알아보는 것
											// 값을 넣어줄때만 메소드를 통해 userid에 값을 넣어준다
		gu2.setPasswd("abCd123$B");			// private에 들어가 있던 passwd필드에 대입하기 위해 set + 대문자 시작 문자를 사용  
		gu2.setName("이순신");
		gu2.setJubun("0101173");
		
		guArr[Gujikja.count++] = gu2;		// 배열 count 증가 guArr애 저장 
		
		Gujikja gu3 = new Gujikja();
		gu3.setUserid("youks");				// 메소드를 호출한다. 유저 아이디를 알아보는 것
											// 값을 넣어줄때만 메소드를 통해 userid에 값을 넣어준다
		gu3.setPasswd("aSdf12345$C");		// private에 들어가 있던 passwd필드에 대입하기 위해 set + 대문자 시작 문자를 사용  
		gu3.setName("유관순");
		gu3.setJubun("8501172");
		
		guArr[Gujikja.count++] = gu3;		// 배열 count 증가 guArr애 저장 
		
		//////////////////////////////////////////////////////////////////////
		
		String smenuNo = "";		//전역변수 설정 
		
		do {
			ctrl.main_mune();  			// ctrl을 불러옴 메인메뉴를 불러온다.
			
			smenuNo = sc.nextLine();		//키보드로 입력값 받아옴
			
			switch (smenuNo) {
			case "1":			// 구직자 회원가입 
			
				ctrl.register(sc, guArr);   // 키보드 입력하기위해 Scanner넘기고 결과값을 배열에 담기 위해 guArr가 ()안에 있다.
											//구직자 회원가입을위한 메소드 
				break;
			case "2":			// 구직자 모두 보기  
				
				ctrl.showAll_info(guArr);		//구직자의 정보를 보이기 위해 ctrl에서 불러온다.
				break;
			case "3":			// 검색
				ctrl.search_menu(sc, guArr);			//검색하고 싶은 것을 나타내니까 scanner를 넘겨줘야한다.
												// 그리고 저장소를 알아야 하므로 guArr를 넘긴다.
				break;
			case "4":			// 프로그램 종료  
				
				break;
				
			default:		// 메뉴번호에 없는 값
				System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다. << \n");
				break;
			}	// end of switch
		} while(!("4".equals(smenuNo)) ); 		//4로 입력한 경우 반복문 탈출  
		
		
		
		sc.close();			//메모리 누수 방지 
		System.out.println("\n ====== 프로그램 종료 ======");
	}// end of main

}

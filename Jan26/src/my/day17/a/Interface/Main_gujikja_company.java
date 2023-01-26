package my.day17.a.Interface;

import java.util.Scanner;

public class Main_gujikja_company {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);		// 키보드 사용위해
		
		
		Inter_Ctrl_Total Ctrl_total = new Ctrl_Total();  // Ctrl_Total생성자 불러옴(메뉴판) 
		// 다형성!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		Member[] mbr_arr = new Member[10];		// 자식클래스를 부모클래스로 받는다. (다형성)
		
	
		//////////////////////////////////////////////////////////////////////
		// 기본 생성자는 원래 생략되어있다.
		Gujikja gu1 = new Gujikja();		//Gujikja에 새로운 맴버 
											// Member생성자 호출후 Gujikja생성자를 호출한다.
		
		gu1.setId("eomjh"); 			// 메소드를 호출한다. 유저 아이디를 알아보는 것 
											// 값을 넣어줄때만 메소드를 통해 Id에 값을 넣어준다	
		gu1.setPasswd("qwer1234$A");		// private에 들어가 있던 passwd필드에 대입하기 위해 set + 대문자 시작 문자를 사용  
		gu1.setName("엄정화");
		gu1.setJubun("9501172");
		gu1.setHope_money(5000); 			//엄정화 희망연봉 5000
		
		Ctrl_total.save_mbr_arr(gu1, mbr_arr);
		
		
		Gujikja gu2 = new Gujikja();		//Gujikja에 새로운 맴버 
											// Member생성자 호출후 Gujikja생성자를 호출한다.
		
		gu2.setId("leess");				// 메소드를 호출한다. 유저 아이디를 알아보는 것
											// 값을 넣어줄때만 메소드를 통해 Id에 값을 넣어준다
		gu2.setPasswd("abCd123$B");			// private에 들어가 있던 passwd필드에 대입하기 위해 set + 대문자 시작 문자를 사용  
		gu2.setName("이순신");
		gu2.setJubun("0101173");
		gu2.setHope_money(6000); 			//이순신 희망연봉 6000
		
		Ctrl_total.save_mbr_arr(gu2, mbr_arr);
		
		Gujikja gu3 = new Gujikja();		//Gujikja에 새로운 맴버 
											// Member생성자 호출후 Gujikja생성자를 호출한다.
		
		gu3.setId("youks");				// 메소드를 호출한다. 유저 아이디를 알아보는 것
											// 값을 넣어줄때만 메소드를 통해 Id에 값을 넣어준다
		gu3.setPasswd("aSdf12345$C");		// private에 들어가 있던 passwd필드에 대입하기 위해 set + 대문자 시작 문자를 사용  
		gu3.setName("유관순");
		gu3.setJubun("8501172");
		gu3.setHope_money(7000); 			//유관순 희망연봉 7000
		
		Ctrl_total.save_mbr_arr(gu3, mbr_arr);
		
		//------------------------------------------------//
		
		Company cp1 = new Company();   //Company 생성자 불러옴 
		cp1.setId("lg");
		cp1.setPasswd("qWer1234$");
		cp1.setName("LG");
		cp1.setBusiness_number("9234567890");
		cp1.setJobType("IT");
		cp1.setSeedMoney(70000000);
		
		Ctrl_total.save_mbr_arr(cp1, mbr_arr);
		
		Company cp2 = new Company();   //Company 생성자 불러옴 
		cp2.setId("Samsung");
		cp2.setPasswd("qWer1234$");
		cp2.setName("삼성전자");
		cp2.setBusiness_number("1234567890");
		cp2.setJobType("제조업");
		cp2.setSeedMoney(900000000);
		
		Ctrl_total.save_mbr_arr(cp2, mbr_arr);
		
		//////////////////////////////////////////////////////////////////////
		
		String smenuNo = "";		//전역변수 설정 
		
		do {
			Ctrl_total.main_menu(); 		// Ctrl_total의 메인 베뉴를 호출한다.(출력)
			smenuNo = sc.nextLine();		//키보드로 입력값 받아옴 (메인 메뉴)
			
			switch (smenuNo) {
			case "1":			// 구직자 회원가입 
				Ctrl_total.register_gu(sc , mbr_arr);		//메소드 호출 (키보드 사용을 위해 Scanner 넘겨줌, 생성된 객체를 저장시키기 위해 배열을 넘겨줌)
												// guArr저장소를 넘겨줌 
				break;
			case "2":			// 구인회사 회원 가입   
				Ctrl_total.register_cp(sc , mbr_arr);		//메소드 호출 (키보드 사용을 위해 Scanner 넘겨줌, 생성된 객체를 저장시키기 위해 배열을 넘겨줌)
												// cpArr저장소를 넘겨줌
				break;
			case "3":			// 구직자 로그인
				Gujikja login_gu = Ctrl_total.login_gu(sc, mbr_arr);			//메소드 호출 (키보드 사용을 위해 Scanner 넘겨줌, 생성된 객체를 저장시키기 위해 배열을 넘겨줌)
																		// guArr저장소를 넘겨줌
				if(login_gu != null)			// login_gu의값이 null이 아니면  
				{
					System.out.println(">> 구직자 로그인 성공 ^^ << \n");
					
					Ctrl_total.gu_munu(sc,login_gu, mbr_arr);		 // 구직자 전용 메뉴
																 //메소드 호출 (키보드 사용을 위해 Scanner 넘겨줌, 생성된 객체를 저장시키기 위해 배열을 넘겨줌)
														 		 // login_gu 는 정보수정등 을위해 						
				}
				else							// login_gu의값이 null이면
				{
					System.out.println(">> 구직자 로그인 실패 ㅠㅠ << \n");
				}
				
				break;
			case "4":			// 구인회사 로그인  
				Company login_cp = Ctrl_total.login_cp(sc, mbr_arr);		// 메소드 호출 (키보드 사용을 위해 Scanner 넘겨줌, 생성된 객체를 저장시키기 위해 배열을 넘겨줌)
												// cpArr저장소를 넘겨줌 
				if(login_cp != null)			// login_gu의값이 null이 아니면  
				{
					System.out.println(">> 구직자 로그인 성공 ^^ << \n");
					
					Ctrl_total.cp_munu(sc,login_cp, mbr_arr);		 // 구인회사 전용 메뉴
																 //메소드 호출 (키보드 사용을 위해 Scanner 넘겨줌, 생성된 객체를 저장시키기 위해 배열을 넘겨줌)
														 		 // login_cp 는 정보수정등 을위해
																 //사람을 찾고 싶기 때문에 구직자 정보를 넘겨줄것이다.
				}
				else							// login_cp의값이 null이면
				{
					System.out.println(">> 구직자 로그인 실패 ㅠㅠ << \n");
				}

				break;
			case "5":			// 프로그램 종료  
				
				break;
			default:		// 메뉴번호에 없는 값
				System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다. << \n");
				break;
			}	// end of switch
		} while(!("5".equals(smenuNo)) ); 		//5로 입력한 경우 반복문 탈출  
		
		
		
		sc.close();			//메모리 누수 방지 
		System.out.println("\n ====== 프로그램 종료 ======");
	}// end of main

}

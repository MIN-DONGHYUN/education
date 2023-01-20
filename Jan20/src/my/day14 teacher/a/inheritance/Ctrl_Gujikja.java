package my.day14.a.inheritance;

import java.util.Scanner;

public class Ctrl_Gujikja extends Ctrl_Total {

	// == 구직자(Gujikja) 신규 회원가입시
	//    Gujikja 클래스의 field 의 요구사항에 모두 맞으면
	//    Gujikja[] guArr 에 저장시켜주는 메소드 생성하기 ==
	public void register(Scanner sc, Gujikja[] guArr) {
				
		if(Gujikja.count < guArr.length) {
			// 지금까지 생성된 구직자 회원수가 guArr.length(배열크기, 정원)보다 적을 경우에만 신규회원을 받아들인다.	
			
			// 아이디는 필수 입력사항이면서 중복된 아이디로 입력하면 안된다.!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			
			String id;
			boolean isUseID;
			
			do {
				isUseID = true;
				
				System.out.print("1.아이디 : ");
				id = sc.nextLine(); // "eomjh"  "leess"   "youks"

				// == 가입된 구직자 회원들에 대해 중복아이디 검사하기 == //
				for(int i=0; i<Gujikja.count; i++) {
					if(id.equals(guArr[i].getId())) {
						System.out.println(">> 이미 사용중인 아이디 입니다. <<\n");
						isUseID = false;
						break;
					}
				}// end of for-------------------------
				
			} while (!isUseID);
			// end of do~while-----------------------
			
			System.out.print("2.비밀번호 : ");
			String passwd = sc.nextLine();
			
			System.out.print("3.성명 : ");
			String name = sc.nextLine();
			
			System.out.print("4.주민번호 : ");
			String jubun = sc.nextLine();
			
			Gujikja gu = new Gujikja();
			gu.setId(id);
			gu.setPasswd(passwd);
			gu.setName(name);
			gu.setJubun(jubun);
			
			if(gu.getId() != null &&
			   gu.getPasswd() != null &&
			   gu.getName() != null && 
			   gu.getJubun() != null) {
			      guArr[Gujikja.count++] = gu;
			      System.out.println("[구직자 회원으로 가입 성공함^^]\n");
			}
			
			else {
				System.out.println("[구직자 회원으로 가입 실패함ㅜㅜ]\n");
			}
			
		}
		
		else {
			// 지금까지 생성된 구직자 회원수가 guArr.length(배열크기, 정원) 와 같거나 클 경우에는 신규회원으로 받아들일 수 없다. 
			System.out.println(">> 정원이 초과하여 구직자 회원가입이 불가합니다.!! <<\n");
		}
		
	}// end of public void register(Scanner sc, Gujikja[] guArr)------

	
	// == 구직자 로그인 메소드 생성하기 == 
	public Gujikja login(Scanner sc, Gujikja[] guArr) {
		
		System.out.print("▷ 구직자 ID : ");
		String id = sc.nextLine();
		
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Gujikja.count; i++) {
			
			if( id.equals(guArr[i].getId()) &&
				passwd.equals(guArr[i].getPasswd())	) {
				return guArr[i];
			}
			
		}// end of for-------------------
		
		return null;
	}// end of public Gujikja login(Scanner sc, Gujikja[] guArr)-------


	// == 구직자 전용메뉴 메소드 생성하기 ==
	public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cpArr) {
		
		String str_menuno;
		
		do {
			System.out.println("=== 구직자 전용메뉴("+ login_gu.getName() +"님 로그인중) ===\n"
					        + "1.내정보 보기   2.내정보 수정   3.모든구인회사 조회   4.로그아웃 \n");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();
			
			switch (str_menuno) {
				case "1": // 내정보 보기
					show_myInfo(login_gu);		
					break;
					
				case "2": // 내정보 수정
					update_myInfo(sc, login_gu);
					break;
					
				case "3": // 모든구인회사 조회
					show_all_companyInfo(cpArr);
					break;
					
				case "4": // 로그아웃
					login_gu = null;
					break;				
		
				default:
					System.out.println("[경고] 메뉴에 있는 번호만 선택하세요!!\n");
					break;
			}// end of switch (str_menuno)-------------------------
			
		} while(!"4".equals(str_menuno));
		
		System.out.println(">> 로그아웃 되었습니다. << \n");
		
	}// end of public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cpArr)----------------
	
	
	// == 내정보 보기를 해주는 메소드 생성하기 == //
	private void show_myInfo(Gujikja login_gu) {
		
		System.out.println("\n=== "+ login_gu.getName() +"님의 정보 ==="); 
		
		System.out.println(login_gu);
		// my.day14.a.inheritance.Gujikja@74a14482
		/*
		    1.아이디 : eomjh
			2.비밀번호 : qWer1234$A
			3.성명 : 엄정화
			4.주민번호 : 9501172
			5.희망연봉 : 5,000만원 
		 */
	
		
	//	System.out.println(login_gu.toString());
		// my.day14.a.inheritance.Gujikja@74a14482
		/*
		    1.아이디 : eomjh
			2.비밀번호 : qWer1234$A
			3.성명 : 엄정화
			4.주민번호 : 9501172
			5.희망연봉 : 5,000만원 
		 */		
		
	}// end of private void show_myInfo(Gujikja login_gu)-----------
	
	
	// == 내정보 수정 해주는 메소드 생성하기 ==
	void update_myInfo(Scanner sc, Gujikja login_gu) {
		
		show_myInfo(login_gu);
		
		System.out.println(">> [주의사항] 변경하지 않고 예전의 데이터값을 사용하시려면 그냥 엔터하세요!!"); 
		
		System.out.print("1.비밀번호 : ");
		String new_passwd = sc.nextLine();
		
		System.out.print("2.성명 : ");
		String new_name = sc.nextLine();
		
		System.out.print("3.주민번호 : ");
		String new_jubun = sc.nextLine();
		
		
		String str_new_hope_money;
		int new_hope_money = 0;
		
		do {
			System.out.print("4.희망연봉 : ");
			str_new_hope_money = sc.nextLine(); // "9000"   ""(그냥엔터)
		                                        // "     "  "강아지" --> 불가 
			
			try {
				if("".equals(str_new_hope_money)) 
					break;
				
				new_hope_money = Integer.parseInt(str_new_hope_money);
				break;
			} catch(NumberFormatException e) {
				System.out.println("[경고] 희망연봉은 정수로만 입력하세요!!\n");
			}
			
		} while(true);
		
		System.out.println("");
		
		if( !new_passwd.trim().isEmpty() ) {
			login_gu.setPasswd(new_passwd);
		}
		
		if( !new_name.trim().isEmpty() ) {
			login_gu.setName(new_name);
		}
		
		if( !new_jubun.trim().isEmpty() ) {
			login_gu.setJubun(new_jubun);
		}
		
		if( !"".equals(str_new_hope_money)) {
			login_gu.setHope_money(new_hope_money);
		}
		
	}// end of void update_myInfo(Scanner sc, Gujikja login_gu)-------
	
	
	// == 모든구인회사 정보를 조회해주는 메소드 생성하기 == 
	private void show_all_companyInfo(Company[] cpArr) {
		
		if(Company.count == 0) {
			System.out.println(">> 구인회사로 등록된 회사가 한개도 없습니다. << \n");
		}
		
		else {
			System.out.println("=======================================\n"
					        + " 회사명    업종    사업자등록번호        자본금\n"
					        +  "=======================================");
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<Company.count; i++) {
			//	sb.append(cpArr[i].toString()+"\n");
			//  또는	
				sb.append(cpArr[i]+"\n");
			}// end of for------------------------
			
		//	System.out.println(sb.toString());
		//  또는 	
			System.out.println(sb);
		}
		
	}// end of private void show_all_companyInfo(Company[] cpArr)-------
	
	

}

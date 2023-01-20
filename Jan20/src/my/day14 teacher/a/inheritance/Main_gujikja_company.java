package my.day14.a.inheritance;

import java.util.Scanner;

public class Main_gujikja_company {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Ctrl_Total   ctrl_total = new Ctrl_Total();
		Ctrl_Gujikja ctrl_gu = new Ctrl_Gujikja();
		Ctrl_Company ctrl_cp = new Ctrl_Company();
		
		
		Gujikja[] guArr = new Gujikja[5];
		Company[] cpArr = new Company[3];
		
      /////////////////////////////////////////////////////
		Gujikja gu1 = new Gujikja();
		gu1.setId("eomjh");
		gu1.setPasswd("qWer1234$A");
		gu1.setName("엄정화");
		gu1.setJubun("9501172");
		gu1.setHope_money(5000);
		guArr[Gujikja.count++] = gu1;
		
		Gujikja gu2 = new Gujikja();
		gu2.setId("leess");
		gu2.setPasswd("abCd123$B");
		gu2.setName("이순신");
		gu2.setJubun("0101173");
		gu2.setHope_money(6000);
		guArr[Gujikja.count++] = gu2;
		
		Gujikja gu3 = new Gujikja();
		gu3.setId("youks");
		gu3.setPasswd("aSdf12345$C");
		gu3.setName("유관순");
		gu3.setJubun("8501172");
		gu3.setHope_money(7000);
		guArr[Gujikja.count++] = gu3;
		
		// ----------------------------------------- //
		
		Company cp1 = new Company();
		cp1.setId("lg");
		cp1.setPasswd("qWer1234$");
		cp1.setName("LG");
		cp1.setBusiness_number("9234567890");
		cp1.setJobType("IT");
		cp1.setSeedMoney(700000000);
		cpArr[Company.count++] = cp1;
		
		Company cp2 = new Company();
		cp2.setId("samsung");
		cp2.setPasswd("qWer1234$");
		cp2.setName("삼성전자");
		cp2.setBusiness_number("1234567890");
		cp2.setJobType("제조업");
		cp2.setSeedMoney(800000000);
		cpArr[Company.count++] = cp2;
		
		
      /////////////////////////////////////////////////////	
		
		String smenuNo = "";
		do {
			ctrl_total.main_menu(); // 메인메뉴
			smenuNo = sc.nextLine();
			
			switch (smenuNo) {
				case "1": // 구직자 회원가입
					ctrl_gu.register(sc, guArr);
					break;
					
				case "2": // 구인회사 회원가입
					ctrl_cp.register(sc, cpArr);
					break;
					
				case "3": // 구직자 로그인
					Gujikja login_gu = ctrl_gu.login(sc, guArr);
					
					if(login_gu != null) {
						System.out.println(">> 구직자 로그인 성공^^ <<\n");
						
						ctrl_gu.gu_menu(sc, login_gu, cpArr); // 구직자 전용메뉴
					}
					else {
						System.out.println(">> 구직자 로그인 실패ㅜㅜ <<\n");
					}
					
					break;
					
				case "4": // 구인회사 로그인
					Company login_cp = ctrl_cp.login(sc, cpArr);
					
					if(login_cp != null) {
						System.out.println(">> 구인회사 로그인 성공^^ <<\n");
						
						ctrl_cp.cp_menu(sc, login_cp, guArr); // 구인회사 전용메뉴
					}
					else {
						System.out.println(">> 구인회사 로그인 실패ㅜㅜ <<\n");
					}
					
					break;	
					
				case "5": // 프로그램 종료
					
					break;					
		
				default:  // 메뉴번호에 없는 값 
					System.out.println(">> [경고] 선택하신 번호는 메뉴에 없습니다. << \n");  
					break;
			}// end of switch(smenuNo)-------------------------
		
		} while( !("5".equals(smenuNo)) );
		// end of do~while------------------------------
		
		
		sc.close();
		
		System.out.println("\n~~~~~ 프로그램 종료 ~~~~~");

	}// end of main()-----------------------------------
	
	
	

}

package my.day12.a.abstraction;

import java.util.Scanner;

public class Gujikja_main {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);		// 키보드 사용위해
		
		GujikjaCtrl ctrl = new GujikjaCtrl();			//ctrl를 불러옴 
		
		Gujikja[] guArr = new Gujikja[5]; //5개의 배열 선언
		
		//////////////////////////////////////////////////////////////////////
		
		Gujikja gu1 = new Gujikja();		//Gujikja에 새로운 맴버 
		gu1.userid = "eomjh";
		gu1.passwd = "qwer1234$A";
		gu1.name = "엄정화";
		gu1.jubun = "9501172";
		
		guArr[Gujikja.count++] = gu1;		// 배열 count 증가 guArr애 저장 
		
		Gujikja gu2 = new Gujikja();
		gu2.userid = "leess";
		gu2.passwd = "abCd123$B";
		gu2.name = "이순신";
		gu2.jubun = "0101173";
		
		guArr[Gujikja.count++] = gu2;		// 배열 count 증가 guArr애 저장 
		
		Gujikja gu3 = new Gujikja();
		gu3.userid = "youks";
		gu3.passwd = "aSdf12345$C";
		gu3.name = "유관순";
		gu3.jubun = "8501172";
		
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

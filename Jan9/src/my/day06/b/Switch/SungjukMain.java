package my.day06.b.Switch;

import java.util.Scanner;		//scanner를 사용하기위해 import

public class SungjukMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		//키보드를 사용하기위해 scanner사용 
		
		Sungjuk Leess = new Sungjuk();  // 기본생성자이다.
		
		System.out.print("1. 학번 : ");
		Leess.hakbun = sc.nextLine();  // String타입으로 학번을 받아온다 "091234"
		
		System.out.print("2. 성명 : ");
		Leess.name = sc.nextLine();  // String타입으로 성명을 받아온다 "이순신"
		
		try {
					
			System.out.print("3. 국어 : ");
			byte kor = Byte.parseByte(sc.nextLine());  // String타입으로 국어을 받아온다 "90", " -80", "안녕하세요"
			//키보드로 입력받은 문자열을 byte형태로 변경해서 byte kor에 저장한다.
			// 우리가 원하는 숫자의 범위는 0~100
			// byte : -128 ~ 127

			if( Leess.checkJumsu(kor)) { // Leess의 국어 값을 checkJumsu에 돌림
				Leess.kor = kor;   //지역변수 kor을Leess.kor에 넣는다.
			}
			else {	// kor => -128 ~ -1 또는 101~127

				//System.exit(0); // 프로그램 강제 종료
				//또는
				sc.close();
				return;  //현재 실행중인 메소드(지금은(main())를 종료하라는 뜻이다.
			}


			System.out.print("4. 영어 : ");
			byte eng = Byte.parseByte(sc.nextLine());  // String타입으로 영어을 받아온다 "90", " -80", "안녕하세요"
			//키보드로 입력받은 문자열을 byte형태로 변경해서 byte eng에 저장한다.
			// 우리가 원하는 숫자의 범위는 0~100
			// byte : -128 ~ 127

			if( Leess.checkJumsu(eng)) { // Leess의 영어 값을 checkJumsu에 돌림
				Leess.eng = eng;   //지역변수 eng 을Leess.eng에 넣는다.
			}
			else {	// eng => -128 ~ -1 또는 101~127

				//System.exit(0); // 프로그램 강제 종료
				//또는
				sc.close();
				return;  //현재 실행중인 메소드(지금은(main())를 종료하라는 뜻이다.
			}


			System.out.print("5. 수학 : ");
			byte math = Byte.parseByte(sc.nextLine());  // String타입으로 수학을 받아온다 "90", " -80", "안녕하세요"
			//키보드로 입력받은 문자열을 byte형태로 변경해서 byte math에 저장한다.
			// 우리가 원하는 숫자의 범위는 0~100
			// byte : -128 ~ 127

			if( Leess.checkJumsu(math)) { // Leess의 수학 값을 checkJumsu에 돌림
				Leess.math = math;   //지역변수 math을 Leess.math에 넣는다.
			}
			else {	// math => -128 ~ -1 또는 101~127

				//System.exit(0); // 프로그램 강제 종료
				//또는
				sc.close();
				return;  //현재 실행중인 메소드(지금은(main())를 종료하라는 뜻이다.
			}
			
		}   //end of try


		catch(NumberFormatException e) //에러를 잡기위해 사용한다.
		{			
			System.out.println(" >> 정수 입력은 0 이상 100까지만 가능합니다. <<");
		} //end of catch
		
		// 성적 정보를 출력해주는 것 
		Leess.showInfo();
		
		
		
		
		
		sc.close();

	} // end of main(String[] args) ~~~~~~~~~~~~~~~~

}

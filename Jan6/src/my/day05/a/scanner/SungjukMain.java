package my.day05.a.scanner;

import java.util.Scanner;

public class SungjukMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // 키보드로 출력받기 위해 사용
		
		Sungjuk Leesj = new Sungjuk();  // 기본 생성자
		
		System.out.print("1. 학번 : ");
		
		Leesj.hakbun = sc.nextLine();  // 키보드로 hakbun이라는 인스턴스 변수에 넣는것 "091234"
		
		System.out.print("2. 성명 : ");
		
		Leesj.name = sc.nextLine();  // 키보드로 name이라는 인스턴스 변수에 넣는것 "이순신"
		
		int progress = 0;
		
		try {
			
		
			System.out.print("3. 국어 : ");
			
			// **************중요*************//
			String str_kor = sc.nextLine();  // 국어성적에 값을 넣기위해 먼저 문자열로 받음
			byte kor = Byte.parseByte(str_kor); // String 타입인 str_kor을 byte 타입으로 형변환 시켜줘서 Leesj필드에 넣으려한다. 
												 // "90"인 문자열을 byte롤 변환하여 Leesj 필드에 들어가기 위해 사용 => 90
												 // EX) "90" ==> 90 , "-80" ==> -80 (byte)의 범위는 -128~127이므로 정상
			                                     // 그외에는 NumberFormatEeception 오류
			// 하지만 우리가 원하는 숫자의 범위는 0 ~ 100 이다.
			
			/* 
			Byte.parseByte(str_kor); // String 타입인 str_kor을 byte 타입으로 형변환 시켜주는 것
			Short.parseShort(str_kor);  // String 타입인 str_kor을 Short 타입으로 형변환 시켜주는 것
			Integer.parseInt(str_kor);  // String 타입인 str_kor을 int 타입으로 형변환 시켜주는 것
			Long.parseLong(str_kor);    //String 타입인 str_kor을 long 타입으로 형변환 시켜주는 것
			*/
			
			if(Leesj.checkJumsu(kor)) {  // Sungjuk에 있는 checkJumsu를 불러온다. kor값이 검사받고 true, false를 판단
				
				Leesj.kor = kor;      // kor ==> 0~100 사이 , true일때 실행됨
			
			}// end of if
			else {   // kor ==> 음수, 100이상일 경우 (-128 ~ -1, 101 ~ 127) 
				
				//System.exit(0);//프로그램을 정상적으로 강제 종료, 0이 아닌 다른것으로 사용하면 비정상적인 강제 종료다
				// 또는 
				sc.close();
				return;   // return을 만나면 현재 실행중인 메소드 (지금은(main)메소드)의 실행을 종료시켜준다.
				
				
			}// end of else
			
			
			System.out.print("4. 영어 : ");
			String str_eng = sc.nextLine();  // 영어성적에 값을 넣기위해 먼저 문자열로 받음
			byte eng = Byte.parseByte(str_eng); 
			
			if(Leesj.checkJumsu(eng)) {  // Sungjuk에 있는 checkJumsu를 불러온다. eng값이 검사받고 true, false를 판단
				
				Leesj.eng = eng;      // eng ==> 0~100 사이 , true일때 실행됨
			
			}// end of if
			else {   // eng ==> 음수, 100이상일 경우 (-128 ~ -1, 101 ~ 127) 
				
				//System.exit(0);//프로그램을 정상적으로 강제 종료, 0이 아닌 다른것으로 사용하면 비정상적인 강제 종료다
				// 또는 
				sc.close();
				return;   // return을 만나면 현재 실행중인 메소드 (지금은(main)메소드)의 실행을 종료시켜준다.
			}
			
			System.out.print("5. 수학 : ");
			String str_math = sc.nextLine();  // 수학성적에 값을 넣기위해 먼저 문자열로 받음
			byte math = Byte.parseByte(str_math); 
			
			if(Leesj.checkJumsu(math)) {  // Sungjuk에 있는 checkJumsu를 불러온다. math값이 검사받고 true, false를 판단
				
				Leesj.math = math;      // math ==> 0~100 사이 , true일때 실행됨
			
			}// end of if
			else {   // math ==> 음수, 100이상일 경우 (-128 ~ -1, 101 ~ 127) 
				
				//System.exit(0);//프로그램을 정상적으로 강제 종료, 0이 아닌 다른것으로 사용하면 비정상적인 강제 종료다
				// 또는 
				sc.close();
				return;   // return을 만나면 현재 실행중인 메소드 (지금은(main)메소드)의 실행을 종료시켜준다.
			}	
			
			System.out.print("6. 나이 : ");
			progress = 1;
			String str_age = sc.nextLine();
			short age = Short.parseShort(str_age);   
			
			if(Leesj.checkAge(age)) {
				Leesj.age = age;
			} //end of if
			
			else {
				sc.close();
				return;
			} //end of else

			Leesj.ShowInfo();  // 성적정보를 출력해주는 메소드 호출
			/*
			    === "이순신"님의 성적결과 ===
			    1. 학번 : 
			    2. 성명 :
			    3. 국어 : 
			    4. 수학 : 
			    6. 총점 : 
			    7. 평균 :
			    8. 학점 : (A,B,C,D)
			    9. 나이 : 
			*/
			
			
			
		}	//end of try
		catch(NumberFormatException e) {
			
			if(progress == 0) {
				System.out.println(">> 점수 입력은 0이상 100까지만 가능합니다. << \n");
			} // end of if
			else {
				System.out.println(">> 나이 입력은 20이상 50까지만 가능합니다. << \n");
			}// end of else
		}   //end of catch
		
		sc.close();

	} //end of public static void main(String[] args)

} // end of public class SungjukMain
package my.day13.encapsulation;

import java.util.Scanner;

public class Ctrl_gujikja {

	// == 메인메뉴를 보여주는 메소드 생성하기 == //
	void main_mune() {
		System.out.println(" === 메인 메뉴 ===\n"
				+ " 1. 구직자 회원가입  2. 구직자 모두 보기  3. 검색   4. 프로그램 종료 \n");

		System.out.print("▷ 메뉴번호 선택 => ");
	}// end of void main_mune() {

	// == 구직자(Gujikja) 신규 회원가입시
	//    Gujikja 클래스의 field의 요구사항에 모두 맞으면
	//    Gujikja[] guArr 에 저장시켜주는 메소드 생성하기 == 
	void register(Scanner sc, Gujikja[] guArr) {
		
		if(Gujikja.count < guArr.length)		// 배열보다 적은 인원이 있다면 실행 
		{
			String userid;	
			
			// 아이디는 필수 입력사항 이면서 중복된 아이디로 입력하면 안된다.!!!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			
			boolean isUseID; 				// 흔적 남기기위해 선언 
			
			do {
				isUseID = true;		// 흔적 남기기위해 선언 (초기화)
				
				System.out.print("1. 아이디 : ");
				userid = sc.nextLine();					//키보드로부터 id를 받아온다.
				
				// == 가입된 회원들에 대해 중복아이디 검사하기 === //
				if(!userid.trim().isEmpty())		//공백을 제거해서 입력값 받은것이 있다면 
				{
					for (int i=0;i<Gujikja.count; i++ )
					{
						if(userid.equals(guArr[i].getUserid()))		//guArr에 있는 userid와 키보드로 입력받은 userid가 같다면 
						{
							System.out.println(">> 이미 사용중인 아이디 입니다. << \n");
							isUseID = false;			// 흔적 남기기 위한 것
							break; //for 문을 빠져나간다.
						}
					}// end of for 
				}
				else						//공백 제거후 입력값 받은것이 없다면 
				{							// "" 또는 "         "
					System.out.println(">> 아이디는 필수 입력사항입니다.!! << \n");
					isUseID = false;        // 흔적을 false로 흔적을 남긴다.
				}
				
			}while(!isUseID);	//end of do-while문
		

			// 비밀번호 
			// 비밀번호는 필수 입력사항이면서 비밀번호 조건에 맞을때 까지 반복해야 한다.
			System.out.print("2. 비밀번호 : ");
			String passwd = sc.nextLine();					//키보드로부터 비밀번호를 받아온다.

			// 성명
			// 성명는 필수 입력사항이면서 그냥 엔터나 공백만으로 된것이 아닐때 까지 반복해야 한다.
			System.out.print("3. 성명 : ");
			String name = sc.nextLine();					//키보드로부터 성명을 받아온다.


			System.out.print("4. 주민번호 : ");
			String jubun = sc.nextLine();					//키보드로부터 주민번호를 받아온다.

			
			Gujikja gu = new Gujikja();		// 객체(인스턴스)를 한개 만듬
			gu.setUserid (userid);		// 접근제한자 public에 값만 넣어준다
			gu.setPasswd(passwd);
			gu.setName(name);
			gu.setJubun(jubun);
			
			if(gu.getUserid() != null && gu.getPasswd() != null && gu.getName() != null && gu.getJubun() != null )
			{
				guArr[Gujikja.count++] = gu;		// 생성된 인스턴스를 배열속에 넣어주고 count를 한개 올린다.
			
												// 모든 필드가 Null이 아니라면 통과
				System.out.println(">> 구직자 회원가입 성공^^!! << \n");
			}
			else		//구직자 회원가입이 실패
			{
				System.out.println(">> 구직자 회원가입 실패ㅠㅠ!! << \n");
			}
			
			
			
		}// end of if
		else						// 구직자 회원 정원 배열보다 많은 수가 들어오게 되면 실행
		{
			System.out.println(">> [경고] 정원 " + guArr.length + "명이 초과하여 구직자 회원가입이 불가합니다!! << \n");
		}
	
	}//end of void register(Scanner sc, Gujikja[] guArr) 	

	
	//모든 회원의 정보를 보이기 위해 메소드 선언 
	// === 구직자 모두 보기 메소드 === //
	void showAll_info(Gujikja[] guArr) {
		
		/*
        --------------------------------------------------
         아이디    비밀번호       성명    성별    현재나이   가입일자 
        --------------------------------------------------
         eomjh   qWer*****    엄정화   여      27    2022,01,30 
         leess   abCd******   이순신   남      31	   2023,01,11
         chaew   aSdf*****    차은우   남      22	   2022,07,05
         */
		
		if(Gujikja.count == 0)	//구직자로 가입된 회원이 아무도 없는 경우
		{
			System.out.println(">>구직자로 가입된 회원이 아무도 없습니다 << \n");
		}
		else
		{
			title();		//title 호출 
			
			// 스트링 빌더를 사용해보자 
			StringBuilder sb = new StringBuilder();	//스트링 빌더
			
			for(int i=0;i<Gujikja.count; i++)
			{
				sb.append(guArr[i].getInfo() + "\n");		// getInfo를 하나씩 쌓아준다.
				
			}// end of for
			
			System.out.println(sb.toString()); // 스트링 빌더에 쌓아줬던 것을 스트링 타입으로 출력한다.
		}
		
		
	}  //end of void showAll_info(Gujikja[] guArr) {
	
	// ==타이틀을 나타내는 메소드 생성하기 ==//
	void title() {
		System.out.println("=====================================================================");
		System.out.println(" 아이디\t비밀번호\t\t성명\t성별\t현재나이\t가입일자");
		System.out.println("=====================================================================");
		
		
	}// end of void title()

	// == 검색 메뉴를 보여주는 메소드 생성하기 == //
	void search_menu(Scanner sc, Gujikja[] guArr) {
		
		String str_menuno = "";		// 변수 설정 
		do
		{
			System.out.println(" === 검색 메뉴 ===\n"
					+ " 1. 연령대검색  2. 성별검색  3. 연령대 및 성별 검색   4. 메인메뉴로 돌아가기 \n");

			System.out.print("▷ 메뉴번호 선택 => ");

			str_menuno = sc.nextLine();		// 키보드로 번호를 받아온다.

			switch (str_menuno) {
			case "1":	// 연령대 검색
				search_ageLine(sc, guArr);	// 연령대 찾기 메소드 생성, 키보드로 값을 받아와서 찾아야 하므로 Scanner와 저장소 guArr를 불러옴

				break;
			case "2":	// 성별검색
				search_gender(sc, guArr);	// 성별 찾기 메소드 생성, 키보드로 값을 받아와서 찾아야 하므로 Scanner와 저장소 guArr를 불러옴

				break;
			case "3":	// 연령대 및 성별 검색
				search_ageLine_gender(sc, guArr);		// 연련대, 성별 찾기 메소드 생성, 키보드로 값을 받아와서 찾아야 하므로 Scanner와 저장소 guArr를 불러옴

				break;
			case "4":	// 메인메뉴로 돌아가기 


				break;

			default:	// 1234를 제외한 나머지 
				System.out.println(">> [경고] 검색 메뉴에 존재하는 번호만 입력하세요!!\n");
				break;
			}	// end of switch
		}while(!("4".equals(str_menuno)));  //4 번이 아니면 계속 무한 반복이 된다.
		
	}	// end of void search_menu(Scanner sc, Gujikja[] guArr) {
	
	// == 연령대 검색해주는 메소드 ==//
	void search_ageLine(Scanner sc, Gujikja[] guArr) {
		
		System.out.print("▷ 검색하고자 하는 연령대 : ");
		String str_ageLine = sc.nextLine();	// 유저가 입력할 때  "20", "30", "40" 은 정상 "-30", "강아지" 는 오류 
		int search_ageLine;
		
		try 	// 오류 잡기위해 한번 시도해본다.
		{
			search_ageLine = Integer.parseInt(str_ageLine);		// String타입을 int로 변경한다.
			
			if(search_ageLine < 0)		// 음수라면 
			{
				System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! <<\n");
				return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
			}
		}
		catch(NumberFormatException e)	// 오류를 잡아준다.
		{
			System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! \n");
			return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
		}
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더로 출력해주기 위해 선언
		
		int cnt = 0;					// 출력받은 사람의 수가 몇명인지 보기 위해 cnt를 설정 
		
		for(int i=0; i< Gujikja.count; i++)	// 저장소에 가서 찾는다.
		{
			//guArr[i].getAge();		// 나이 	27		   22		  31		 39 
   							    // 연령대    27/10 *10   22/10*10   31/10*10   39/10*10
							    // 연령대		20		   20		  30		 30대로 변경하자 
			
			
			int ageLine = guArr[i].getAge()/10*10; 		// 연령대로 나타내게 해준다.
			
			if(search_ageLine == ageLine)
			{
				sb.append(guArr[i].getInfo()+"\n");	//스트링 빌더에 연령대별 사람을 쌓는다.
				cnt++;								// 입력받은 사람의 수를 나타내기위해 1씩 증가 
			}
		} // end of for
		
		if(cnt != 0 )			// cnt가 0이 아니라면 
		{
			title();	// 타이틀을 찍어주고 
			System.out.println(sb.toString()); 	//스트링 빌더 쌓아준것을 String 타입으로 변환해서 보여준다.
			System.out.println("[검색결과] " + search_ageLine +"대 구직자는 " + cnt + "명 입니다.");
		}
		else					// cnt가 0이라면 
		{
			System.out.println("[검색결과] " + search_ageLine + "대 구직자는 없습니다\n");
		}
	}	// end of void search_ageLine(Scanner sc, Gujikja[] guArr) {
	
	
	// == 구직자의 성별을 검색하는 메소드 ==//
	void search_gender(Scanner sc, Gujikja[] guArr)
	{
		
		System.out.print("▷ 검색하고자 하는 성별[남/여] : ");		// 출력
		String str_gender = sc.nextLine();					//키보드로부터 남, 여를 받아옴 
		str_gender = str_gender.trim();						//키보드를 받아와서 공백을 지운다
		
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더로 출력해주기 위해 선언
		int cnt = 0;							// 반복한 횟수를 사용하기 위해 선언 
		
		if("남".equals(str_gender) || "여".equals(str_gender))
		{
			for(int i=0; i< Gujikja.count; i++)	// 저장소에 가서 찾는다.
			{	
				if(str_gender.equals(guArr[i].getGender()))
				{
					sb.append(guArr[i].getInfo()+"\n");	//스트링 빌더에 성별 사람을 쌓는다.
					cnt++;								// 입력받은 사람의 수를 나타내기위해 1씩 증가 
				}
			} // end of for
			if(cnt != 0 )			// cnt가 0이 아니라면 
			{
				title();	// 타이틀을 찍어주고 
				System.out.println(sb.toString()); 	//스트링 빌더 쌓아준것을 String 타입으로 변환해서 보여준다.
				System.out.println("[검색결과] " + str_gender +"자 구직자는 " + cnt + "명 입니다.");
			}
			else					// cnt가 0이라면 
			{
				System.out.println("[검색결과] " + str_gender + "자 구직자는 없습니다\n");
			}
			
		}
		else		// "남" 또는 "여" 가 아닌 "강아지"와 같은 것을 입력한 경우 
		{
			System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!! \n");
		}
		
		
		// 내가 짜본 것 이다. 작동이 잘된다.
		/*for(int i =0; i< Gujikja.count; i++)	// 배열길이만큼 반복 
		{
			if(guArr[i].getGender().equals(str_gender))	// 만약 입력한 값과 guArr배열의 gender에 있는 값과 같다면 
			{
				sb.append(guArr[i].getInfo() + "\n");	// 결과값을 누적해준다.
				cnt++;									// 돌아간 만큼 1증가 
			}
		}
		if(cnt != 0)					// 카운트가 0이 아니라면 
		{
			title();					// title 출력하고 
			System.out.println(sb.toString()); 	//스트링 빌더 쌓아준것을 String 타입으로 변환해서 보여준다.
			System.out.println("[검색결과] " + str_gender +"구직자는 " + cnt + "명 입니다.");
		}
		else							// 카운트가 0이라면 
		{
			System.out.println("[경고]\"남\" 또는 \"여\" 만 입력하세요!!\n ");
		}*/
		
	}	// end of void search_gender(Scanner sc, Gujikja[] guArr)
	
	
	// == 연령대 및 성별을 검색해주는 메소드 ===//
	void search_ageLine_gender(Scanner sc, Gujikja[] guArr)
	{
		//연령대 부분 
		System.out.print("▷ 검색하고자 하는 연령대 : ");
		String str_ageLine = sc.nextLine();	// 유저가 입력할 때  "20", "30", "40" 은 정상 "-30", "강아지" 는 오류 
		int search_ageLine;
		
		try 	// 오류 잡기위해 한번 시도해본다.
		{
			search_ageLine = Integer.parseInt(str_ageLine);		// String타입을 int로 변경한다.
			
			if(search_ageLine < 0)		// 음수라면 
			{
				System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! <<\n");
				return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
			}
		}
		catch(NumberFormatException e)	// 오류를 잡아준다.
		{
			System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! \n");
			return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
		}
		
		// 성별 부분
		System.out.print("▷ 검색하고자 하는 성별[남/여] : ");		// 출력
		String str_gender = sc.nextLine();					//키보드로부터 남, 여를 받아옴 
		str_gender = str_gender.trim();						//키보드를 받아와서 공백을 지운다
		
		if( !("남".equals(str_gender) || "여".equals(str_gender)) )		// 남 또는 여 가 아니면은 
		{
			System.out.println("[경고]\"남\" 또는 \"여\" 만 입력하세요!!\n ");
			return;  	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
		}
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더로 출력해주기 위해 선언
		int cnt = 0;							// 반복한 횟수를 사용하기 위해 선언 
		
		for(int i=0; i< Gujikja.count; i++)		//구직자 수 만큼 반복
		{
			int ageLine = guArr[i].getAge()/10*10;	//연령대를 ageLine에 대입 
			
			if(search_ageLine == ageLine && str_gender.equals(guArr[i].getGender()))	// 찾고자하는 연령대와 성별이 같습니까?
			{
				sb.append(guArr[i].getInfo() + "\n");		// 누적한다.
				cnt++;										// 몇 명인지 확인하기 위해 1증가 
			}
		}	//end of for
		
		if(cnt != 0)		// cnt가 0이 아니라면 
		{
			title();		// 타이틀을 호출한다.
			System.out.println(sb.toString());	// 결과값을 보여준다.
			System.out.println("[검색결과] " + search_ageLine + "대 " + str_gender + "자는 " + cnt +"입니다.\n");
		}
		else		//cnt가 0이라면 
		{
			System.out.println("[검색결과] " + search_ageLine + "대 " + str_gender + "자 구직자는 없습니다.!! \n");
		}
		
		
		
		
	} //end of void search_ageLine_gender(Scanner sc, Gujikja[] guArr)
}

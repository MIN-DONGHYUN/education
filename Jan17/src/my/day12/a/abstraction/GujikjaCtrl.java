package my.day12.a.abstraction;

import java.util.Scanner;

import my.util.MyUtil;

public class GujikjaCtrl {

	// == 메인메뉴를 보여주는 메소드 생성하기 == //
	void main_mune() {
		System.out.println(" === 메인 메뉴 ===\n"
				+ " 1. 구직자 회원가입  2. 구직자 모두 보기  3 검색   4.프로그램 종료 \n");

		System.out.print("▷ 메뉴번호 선택 => ");
	}// end of void main_mune() {

	// == 구직자(Gujikja) 신규 회원가입시
	//    Gujikja 클래스의 field의 요구사항에 모두 맞으면
	//    Gujikja[] guArr 에 저장시켜주는 메소드 생성하기 == 
	void register(Scanner sc, Gujikja[] guArr) {
		
		if(Gujikja.count < guArr.length)		// 배열보다 적은 인원이 있다면 실행 
		{
			String userid;
			String passwd;	
			String name;	
			String jubun;	
			
			// 아이디는 필수 입력사항 이면서 중복된 아이디로 입력하면 안된다.!!!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			
			boolean isUseID; 				// 흔적 남기기위해 선언 
			
			do {
				isUseID = true;		// 흔적 남기기위해 선언 (초기화)
				
				System.out.print("1. 아이디 : ");
				userid = sc.nextLine();					//키보드로부터 id를 받아온다.
				
				
				if(!userid.trim().isEmpty())		//공백을 제거해서 입력값 받은것이 있다면 
				{
					for (int i=0;i<Gujikja.count; i++ )
					{
						if(userid.equals(guArr[i].userid))		//guArr에 있는 userid와 키보드로 입력받은 userid가 같다면 
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
					
			boolean isUsePasswd; 				// 흔적 남기기위해 선언 
						
			do {
				isUsePasswd = true;		// 흔적 남기기위해 선언 (초기화)

				System.out.print("2. 비밀번호 : ");
				passwd = sc.nextLine();					//키보드로부터 비밀번호를 받아온다.
				
				if(!MyUtil.isCheckPassed(passwd))		//MyUtil의 패스워드 검사가 거짓이라면 
				{
					System.out.println(">>[경고] 비밀번호는 8글자 이상 15글자 이하의 대,소문자,숫자, 특수문자가 혼합되어야만 합니다. \n");
					isUsePasswd = false;  	// 흔적을 남겨서 while문으로 다시 실행하게 하기 
					// 암호로 사용이 불가능하기 때문에 
				}
				
			}while(!isUsePasswd);	//end of do-while문
			
			
			// 성명
			// 성명는 필수 입력사항이면서 그냥 엔터나 공백만으로 된것이 아닐때 까지 반복해야 한다.

			boolean isUseName; 				// 흔적 남기기위해 선언 

			do {
				isUseName = true;		// 흔적 남기기위해 선언 (초기화)

				System.out.print("3. 성명 : ");
				name = sc.nextLine();					//키보드로부터 성명을 받아온다.

				// 입력받은 성명이 그냥 엔터인지 또는 공백만으로 이루어져 있는지 검사한다.
				if(name.trim().isEmpty())		//공백제거후에 비어있다면 
				{
					System.out.println(">>[경고] 성명은 공백만으로 된것이 아닌 데이터를 입력해야 합니다. \n");
					isUseName = false;  	// 흔적을 남겨서 while문으로 다시 실행하게 하기 
											
				}

			}while(!isUseName);	//end of do-while문
			
			
			boolean isUseJubun;
			
			do {
				isUseJubun = true;		// 흔적 남기기위해 선언 (초기화)

				System.out.print("4. 주민번호 : ");
				jubun = sc.nextLine();					//키보드로부터 주민번호를 받아온다.

				if(!MyUtil.isCheckJubun(jubun))		// MyUtil에서 주번이 거짓이라면 
				{
					System.out.println(">>[경고] 올바른 주민번호를 입력하세요 !! \n");
					isUseJubun = false;  	// 흔적을 남겨서 while문으로 다시 실행하게 하기 
				}

			}while(!isUseJubun);	//end of do-while문
			
			
			Gujikja gu = new Gujikja();		// 객체(인스턴스)를 한개 만듬
			gu.userid = userid;
			gu.passwd = passwd;
			gu.name = name;
			gu.jubun = jubun;
			
			guArr[Gujikja.count++] = gu;		// 생성된 인스턴스를 배열속에 넣어주고 count를 한개 올린다.
			
			System.out.println(">> 구직자 회원가입 성공!! << \n");
			
			
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
	
	
	void title() {
		System.out.println("=============================================");
		System.out.println(" 아이디\t비밀번호\t\t성명\t성별\t현재나이\t가입일자");
		System.out.println("=============================================");
		
		
	}// end of void title()
	
}

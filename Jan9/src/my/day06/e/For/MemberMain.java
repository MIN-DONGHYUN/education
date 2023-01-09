package my.day06.e.For;

import java.util.Scanner;		//scanner 사용위해 import

import my.day06.b.Switch.Sungjuk;
import my.util.MyUtil;

public class MemberMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);   // 키보드 사용을 위해 scanner
		
		System.out.println("=== 회원가입 하기(유효성 검사) ===\n");
		
		String userid = "";		// 전역변수 설정 지역변수는 다른 곳에 사용하기가 힘듬 
		String passwd = "";
		String name = "";
		
		
		for(;;)   // 무한반복
		{
			System.out.print("1. 아이디 => ");
			userid = sc.nextLine();  // userid를 키보드로부터 받아온다.
											// "          Leess"
											// ""
											// "             "
		
			/*	
			///////////////공백을 제외한 길이 구하기///////////////// 	
			userid.trim().length();   //trim은 공백을 없애주는 것이다.
			                 // "       Leess   " => .trim(); ==> 좌우 공백을 없애버린다. ==> "Leess"의 결과값으로 나옴  ==> .length ==> 5
							 // "     Lee  ss   " => .trim(); ==> "Lee  ss"으로 나옴, 안쪽 공백은 제거 불가능 ==> .length ==> 7
							 // "" .trim();                   ==>""   ==> .length ==> 0
							 // "     " .trim();              ==>""   ==> .length ==> 0
							 // "Leess".trim()            ==> "Leess" ==> .length ==> 5  
							 //.length()은 길이를 뜻함 
			*/
			if(userid.trim().length()==0)  //userid의 길이가 0일때
			{
				System.out.println(" >> [경고] 아이디는 필수 입력 사항입니다. << \n");  // 엔터나 공백만 하지 마라 
			}
			else		//userid의 길이가 0이 아닐때 
			{
				break;  // for무한 반복문을 탈출한다.
			}
		
		}
		

		for(;;)   // 무한반복
		{
			System.out.println("2. 암호 => ");
			passwd = sc.nextLine();  
			
			if( !MyUtil.isCheckPassed(passwd))  //passwd의 길이가 0일때 MyUtil의 static 을 가져온다 .isCheckPassed
			{
				System.out.println(" >> [경고] 암호는 8글자 이상 15글자 이하의 대,소문자, 숫자, 특수문자가 혼합되어져야만 한다. << \n");  // 엔터나 공백만 하지 마라 
			}
			else		//passwd의 길이가 0이 아닐때 
			{
				break;  // for무한 반복문을 탈출한다.
			}
		
		}
		
		
		for(;;)   // 무한반복
		{
			System.out.println("3. 성명 => ");
			name = sc.nextLine();  
			
			if(name.trim().length()==0)  //name의 길이가 0일때
			{
				System.out.println(" >> [경고] 성명은 필수 입력 사항입니다. << \n");  // 엔터나 공백만 하지 마라 
			}
			else		//name의 길이가 0이 아닐때 
			{
				break;  // for무한 반복문을 탈출한다.
			}
		}
		
		Member mbr = new Member(); //인스턴스 생성 
		mbr.userid = userid;
		mbr.passwd = passwd;
		mbr.name = name;
		
		mbr.showInfo();    // 출력   /// 요부분은 내가 임의로 사용한 곳
		
		
		sc.close();     //메모리 누수 방지
		

	}

}

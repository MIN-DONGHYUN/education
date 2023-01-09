package my.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

	// == 현재시각을 출력해주는 static 메소드 생성하기 == //
	public static void currentTime() {  //static을 안쓰면 인스턴스로 사용해야함 
        
		Date now = new Date(); // 현재시간 
		
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdfmt.format(now);
		
		System.out.println(">> 현재시각 : " + today );
		// >> 현재시각 : 2023-01-03 11:43:50 으로 바꾸려면
	}
	
	// === 비밀번호가 규칙에 맞는지 틀리는지 알려주는 static 메소드 생성하기 === // 
	// 비밀번호 규칙은 비밀번호의 길이는 8글자 이상 15글자 이하이어야 하고,
	// 또한 비밀번호는 영문대문자, 영문소문자, 숫자, 특수기호가 혼합되어야만 한다.
	// 우리는 규칙에 맞으면 true , 규칙에 틀리면  false 를 리턴해주도록 만든다.
	public static boolean isCheckPassed(String passwd) {
		
		// passwd ==> "Ab3$"는 글자가 이미 안맞기 때문에 검사할 필요X
		// passwd ==> "Ab3115616212615161@@@1561!!$"는 글자가 이미 안맞기 때문에 검사할 필요X
		
		int length = passwd.length();   //입력받은 passwd 문자열의 길이 
		
		if(length < 8 || length > 15)  //암호의 길이가 8자 미만, 15초과이면
		{
			return false;
		}
		else {  //암호의 길이가 8글자 이상 15글자 이하
			//passwd ==> "abcd12345" 실패
			//passwd ==> "Abcd12345$" 성공 
			//passwd ==> "Abcd12345"  실패
			
			boolean flagUpper = false;////////대문자임을 표시해주는것//////
			boolean flagLower = false;////////소문자임을 표시해주는것//////
			boolean flagDigit = false;////////숫자임을 표시해주는것//////
			boolean flagSpecial = false;////////특수문자임을 표시해주는것//////
			
			for(int i = 0; i < length; i++)
			{
				//"암호가 Abcd1234$" 이라면
				//index 012345678 이 된다.
				
				char ch = passwd.charAt(i);   // i의 위치의 글자를 나타낸다. 'A','b''c'...'$'
				
				if(Character.isUpperCase(ch))   //대문자라면 참이다.
				{
					flagUpper = true;		//대문자가 발견되었으면 true로 변경 
				}
				else if( Character.isLowerCase(ch))   //소문자라면 
				{
					flagLower = true;		//소문자가 발견되었으면 true로 변경 
				}
				else if( Character.isDigit(ch))   //숫자라면 
				{
					flagDigit = true;		//숫자가 발견되었으면 true로 변경 
				}
				else			//특수문자라면
				{
					flagSpecial = true;     //특수문자가 발견되었으면 true로 변경 
				}
				
			}// end of for
			
			return ( flagUpper && flagLower && flagDigit && flagSpecial); //전체가 true이면 true를 리턴함
																		  //아니라면 false로 리턴함
		}
		
		
	}//end of public static boolean isCheckPassed(String passwd)
}

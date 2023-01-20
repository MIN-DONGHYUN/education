package my.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	}

	public static String space_delete(String str) {
		
		if(str != null)			//null이 아니라면 
		{
			char[] chArr = str.toCharArray(); // 문자를 char타입의 배열로 변경 
			
			String result = "";
			
			
			for(int i = 0; i < chArr.length; i++)	// 배열만큼 반복
			{
				if(chArr[i] != ' ')   // 공백이 아니라면
				{
					result += chArr[i];	// 문자열을 누적(쌓아둔다.)
				}
			}// end of for
			return result;
		}
		else				// null이라면 
		{
			return null;
		}
	}// end of public static String space_delete(String str) {
	
	
	
	// === , 가 들어있는 숫자형태로 되어진 문자열을 , 를 제거해서 정수로 리턴시켜주는 메소드 생성하기 ===
	public static long delComma(String str) {
		
		do
		{
			int index_comma = str.indexOf(",");	//, 를 찾는다.
			
			if(index_comma == -1)// ,가 없으면 index값은 -1이 나온다,
			{
				break; // do-while문 탈출 
			}
			str = str.substring(0, index_comma) + str.substring(index_comma+1);	//str에 콤마 전과 후를 더한다.
			
		}while(true);		// 무한 반복
		
		return Long.parseLong(str);
		
	}// end of public static long delComma(String str) {

	public static String today() {
		
		// 내가 한 것 
		/*SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");	// 몇년 몇월 몇일 시각 표시를 새로 설정
		
		Date now = new Date();
		
		String str = today.format(now);
		*/
		
		Calendar currentDate = Calendar.getInstance();	// 현재 날자와 시간을 얻어온다.
		
		int year = currentDate.get(Calendar.YEAR);	//연도를 불러온다.
		int month = currentDate.get(Calendar.MONTH)+1;	//월을 불러온다. 하지만 0~11까지로 나타냄
		// +1 을 하면 1월부터 12월로 표시 가능하다.
		
		int day = currentDate.get(Calendar.DATE); //시간을 불러온다.
		
		int hour = currentDate.get(Calendar.HOUR_OF_DAY); // 10
		int minute = currentDate.get(Calendar.MINUTE); // 31
		int second = currentDate.get(Calendar.SECOND); // 49
		
		
		String dayname = ""; // dayname 저장을 위해 설정
		
		switch (currentDate.get(Calendar.DAY_OF_WEEK)) {	// 날자의 숫자가 어떤 case인지 보고 실행 
		case 1:
			dayname ="일요일";
			break;
		case 2:
			dayname ="월요일";
			break;
		case 3:
			dayname ="화요일";
			break;
		case 4:
			dayname ="수요일";
			break;
		case 5:
			dayname ="목요일";
			break;
		case 6:
			dayname ="금요일";
			break;
		case 7:
			dayname ="토요일";
			break;		
		default:
			break;
		}
		
		//삼항 연산자로 1-9라면 앞에 0을 붙이고 아니라면 String타입으로 변경  
		String str_month = (month<10)?"0"+month:String.valueOf(month);
		String str_day = (day<10)?"0"+month:String.valueOf(day);
		
		String str_hour = (hour<10)?"0"+month:String.valueOf(hour);
		String str_minute = (minute<10)?"0"+month:String.valueOf(minute);
		String str_second = (second<10)?"0"+month:String.valueOf(second);
		
		//리턴 출력 값 
		return year + "-" + str_month + "-" + str_day + " " + str_hour + ":" + str_minute + ":" + str_second + " " + dayname;
		
	}

	// == 주민번호 7자리를 입력받아서 올바른 주민번호 인지 아닌지를 검사해주는 메소드 생성 == //
	public static boolean isCheckJubun(String jubun) {
		
		if(jubun == null)		//null이면 
		{
			return false;
		}
		
		// 정규표현식(Regular Expression)이란?
		// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어
		
		// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		//Pattern p = Pattern.compile("^[0123456789][0-9][0-1][0-9][0-3][0-9][1-4]$");
		//^은 시작을 의미한다.
		//$는 끝을 의미한다.
		//[]는 글자 1개가 들어오는 것을 의미한다.
		//[0123456789] 은 0 또는 1 또는 2 또는 3... 8 또는 9만 들어온다는 뜻이다.
		//[0-9]은 [0123456789]와 같다.
		
		
		
		//Pattern p = Pattern.compile("^\\d\\d[0-1]\\d[0-3]\\d[1-4]$");
		//[0-9]와 \\d은 같은 것이다.
		
		
		Pattern p = Pattern.compile("^\\d{2}[0-1]\\d[0-3]\\d[1-4]$");	
		// \\d{2}는 연속적으로 두번나온다는 뜻이다. 즉, [0-9][0-9]와 같은말이다
		
		
		// == 2. 검사할 문자열이 주어진 정규식 패턴과 일치하는지 아닌지를 판별하는 객체를 생성한다. == //
		Matcher m = p.matcher(jubun);
		
		
		// == 3. 검사할 문자열을 판별하도록 한다. == //
		//입력받은 jubun 이 주어진 정규식 패턴과 일치하면 true, 일치하지 않으면 false를 리턴시켜준다.
		boolean bool = m.matches();   //return은 boolean타입이다.
		
		return bool;
	}	// end of public static boolean isCheckJubun(String jubun)
	
}

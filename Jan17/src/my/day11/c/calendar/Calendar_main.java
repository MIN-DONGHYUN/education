package my.day11.c.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import my.util.MyUtil;

public class Calendar_main {

	public static void main(String[] args) {
		
		// 자바에서 날짜를 나타낼때는 Date, Calendar를 사용한다.
		
		// === 1. Date 클래스를 사용하여 현재시간 나타내기 ===
		Date now = new Date();		// now라는 객체는 현재시각
		
		System.out.println("현재시각1 : " + now);		//현재시각 찍어내기 
		// 현재시각1 : Tue Jan 17 09:28:55 KST 2023
		
		
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");	// 몇년 몇월 몇일 시각 표시를 새로 설정
		
		System.out.println("현재시각2 : " + sdfmt.format(now));	 //테이트 클래스에 객체가 들어간다. now
		// 현재시각2 : 2023-01-17-09:31:40
		
		String cuurentTime = String.format("%tF %tT %tA %tZ" , now, now, now, now);		//String 클래스, %t는 날자와 관련이 있다.
		// %tF 는 연월일만 나온다. 2023-01-17
		// %tT는 시,분,초 가 나온다. 09:28:55
		// %tA는 요일명만 나온다. 화요일
		// %tZ는 한국시간인지 미국시간인지 나온다. KST
		// 리턴 타입이 String 타입으로 나온다.
		System.out.println("현재시간3 : " + cuurentTime);
		// 현재시간3 : 2023-01-17 09:37:31 화요일 KST
		
		
		/*
	       <참고>
	         날짜 타입 format         설명
	        --------------------------------------------------
	         %tF              날짜를 yyyy-mm-dd 형식으로 포맷해주는 것
	         %tT              날짜의 시각을 HH:mm:ss 형식으로 포맷해주는 것  
	         %tp              오전, 오후를 출력
	         %tA              요일명 출력
	         %tY              4자리 년도만 출력
	         %tB              월의 이름(January, February ...)출력
	         %tm              월의 01,02,03 ~~ 10,11,12 로 출력
	         %td              일수를 1~31 로 출력
	         %te              %td와 동일함
	         %tk              시간을 0~23 으로 출력
	         %tl              시간을 1~12 으로 출력
	         %tM              분을 00~59 으로 출력
	         %tS              초를 00~59 으로 출력
	         %tZ              타임존을 출력(한국은 KST로 나옴).
	      */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//연도를 나타내보자 
		/*
		    Date 클래스  보다 조금 더 향상시켜서 나온 것이 Calendar 클래스이다.
		    간단한 날짜표현에는 Date 클래스를 사용하는 것이 더 나을 수 있으나
		    두개 날짜사이의 날짜연산을 할 경우에는 메소드기능이 더 많이 추가된
		    Calendar 클래스를 사용하는 것이 나을 수 있다.
		*/
		
		Calendar currentDate = Calendar.getInstance();	// 현재 날자와 시간을 얻어온다.
		
		int year = currentDate.get(Calendar.YEAR);	//연도를 불러온다.
		System.out.println("올 해의 년도 : " + year);
		//올 해의 년도 : 2023
		
		
		// 월을 나타내보자
		/* 
        주의해야할 것은 get(Calendar.MONTH)로 얻어오는 값의 범위가 1~12가 아닌, 0~11 이라는 것이다. 
        그래서 get(Calendar.MONTH)로 얻어오는 값이 0이면 1월을 의미하고 11이면 12월을 의미한다.
        그러므로 현재월을 표현하려면 ( currentDate.get(Calendar.MONTH) + 1 ) 으로 해야한다. 
        괄호없이 currentDate.get(Calendar.MONTH) + 1로 하면 이상한 값이 나온다. (괄호유무조심!!) 
		 */
	
		int month = currentDate.get(Calendar.MONTH)+1;	//월을 불러온다. 하지만 0~11까지로 나타냄
														// +1 을 하면 1월부터 12월로 표시 가능하다.
		String str_month = (month < 10)?"0"+month:String.valueOf(month);	// 달이 10보다 작으면 앞에 0을 붙여주고 아니라면 int타입을 
																			//String.valueOf로 String타입으로 변경 
		System.out.println("월 : " + month); 
		// 월 : 1
		System.out.println("월 : " + str_month);
		// 월 : 01
		
		
		// 주를 나타내보자 
		System.out.println("이 해의 몇 째 주 : " + currentDate.get(Calendar.WEEK_OF_YEAR));	// 이 해의 주를 나타낸다.
		// 이 해의 몇 째 주 : 3
		System.out.println("이 달의 몇 째 주 : " + currentDate.get(Calendar.WEEK_OF_MONTH));// 이 달의 주를 나타낸다.
		// 이 달의 몇 째 주 : 3
		
		
		// 일을 나타내보자
		System.out.println("이 달의 몇 일 : " + currentDate.get(Calendar.DATE)); // 이 달의 일을 나타낸다.
		// 이 달의 몇 일 : 17
		System.out.println("이 달의 몇 일 : " + currentDate.get(Calendar.DAY_OF_MONTH)); // 이 달의 일을 나타낸다.
		// 이 달의 몇 일 : 17
		
		// 1일부터 9일까지 앞에 0을 붙이려면 
		int day = currentDate.get(Calendar.DATE);
		String str_day = (day<10)?"0"+day:String.valueOf(day);	// 1-9일 일때는 앞에 0을 붙이고 아니라면 String타입의 day가 나온다.
		System.out.println("이 달의 몇 일 : " + str_day);
		// 이 달의 몇 일 : 17
		
		System.out.println("이 달의 몇 일 : " + currentDate.get(Calendar.DAY_OF_YEAR)); // 이 해의 일을 나타낸다.
		// 이 해의 몇 일 : 17
		// 만약에 currentDate 값이 2023년 2월 1일 이라면 이 해의 몇 일 : 32 라고 나온다.
		
		//요일명을 나타내보자
		// 1:일요일 2:월요일 3:화요일 4:수요일 5:목요일 6:금요일 7:토요일 
		System.out.println("요일 (1-7, 1: 일요일) : " + currentDate.get(Calendar.DAY_OF_WEEK));	// 요일을 나타낸다.
		// 요일 (1-7, 1: 일요일) : 3
		
		String dayname = ""; // dayname 저장을 위해 설정
		
		switch (currentDate.get(Calendar.DAY_OF_WEEK)) {	// 날자의 숫자가 어떤 case인지 보고 실행 
		case 1:
			dayname ="일";
			break;
		case 2:
			dayname ="월";
			break;
		case 3:
			dayname ="화";
			break;
		case 4:
			dayname ="수";
			break;
		case 5:
			dayname ="목";
			break;
		case 6:
			dayname ="금";
			break;
		case 7:
			dayname ="토";
			break;		
		default:
			break;
		}
		
		
		System.out.println("오늘은 " + dayname + "요일 입니다.");
		// 오늘은 화요일 입니다.
		
		// 나머지를 알아보자 
		System.out.println("오전_오후(0:오전, 1:오후): " + currentDate.get(Calendar.AM_PM)); // 0
	    System.out.println("시간(0~11): " + currentDate.get(Calendar.HOUR)); //  10
	    System.out.println("시간(0~23): " + currentDate.get(Calendar.HOUR_OF_DAY)); // 10
	    System.out.println("분(0~59): " + currentDate.get(Calendar.MINUTE)); // 31
	    System.out.println("초(0~59): " + currentDate.get(Calendar.SECOND)); // 49
	    System.out.println("1000분의 1초(0~999): " + currentDate.get(Calendar.MILLISECOND)); // 424
		
	    
	    // 천분의 1초를 시간으로 표시하기 위해 3600000으로 나누었다.(1시간 = 60 * 60초)
	    System.out.println("TimeZone(-12~+12): " + (currentDate.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // 9 
	    
	    // 이 달의 마지막 일을 찾는다.
	    System.out.println("이 달의 마지막 날: " + currentDate.getActualMaximum(Calendar.DATE) ); // 31 
	   
	    System.out.println("");
		
		
	    ////////////////////퀴즈///////////////////////
	    // My.Util에 넣어두기
	    
	    System.out.println("현재는 " + MyUtil.today() + " 입니다.");
		// 현재는 2023-01-17일 10:40:35 화요일 입니다.
	    //현재는 2023-01-17 11:12:58 화요일 입니다.
		
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    SimpleDateFormat sdformt = new SimpleDateFormat (" yyyy-MM-dd HH:mm:ss");
	    
	    //시각을 표시하자 
	    Calendar cur_Date = Calendar.getInstance();		//시간을 받아옴 
	    // === 어제 시각 나타내기 ===//
	    cur_Date.add(Calendar.DATE, -1);   		//어떤 것을 더 할래? 오늘 날짜에서 하루 전으로 -1한다/
	    System.out.println("어제시간 => " + sdformt.format(cur_Date.getTime()));  // 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    //어제시간 =>  2023-01-16 11:35:38
	    
	    // === 현재 시각 나타내기 ===//
	    cur_Date = Calendar.getInstance();		//시간을 받아옴 
	    System.out.println("현재시간 => " + sdformt.format(cur_Date.getTime()));  // 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    //어제시간 =>  2023-01-17 11:35:38
	    
	    // === 내일 시각 나타내기 ===//
	    cur_Date.add(Calendar.DATE, 1);   		//어떤 것을 더 할래? 오늘 날짜에서 하루 다음날으로 1한다/
	    System.out.println("내일시간 => " + sdformt.format(cur_Date.getTime()));  // 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    //어제시간 =>  2023-01-18 11:35:38
	    
	    
	    // 달을 표시하자
	    cur_Date = Calendar.getInstance();		//시간을 받아옴 
	    
	    cur_Date.add(Calendar.MONTH, -1);   		//어떤 것을 더 할래? 오늘 날짜에서 한달 전으로 -1한다
	    System.out.println("한달 전 시간 => " + sdformt.format(cur_Date.getTime()));  // 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    //한달 전 시간 =>  2022-12-17 11:38:50
	    
	    // === 현재 시각 나타내기 ===//
	    cur_Date = Calendar.getInstance();		//시간을 받아옴 
	    System.out.println("현재시간 => " + sdformt.format(cur_Date.getTime()));  // 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    //현재시간 =>  2023-01-17 11:38:50
	    
	    // === 내일 시각 나타내기 ===//
	    cur_Date.add(Calendar.MONTH, 1);   		//어떤 것을 더 할래? 오늘 날짜에서 한달 뒤으로 1한다/
	    System.out.println("한달 뒤 시간 => " + sdformt.format(cur_Date.getTime()));  // 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    //한달 뒤 시간 =>  2023-02-17 11:38:50
	    
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~`\n");
	    
	    
	    /////////////////////////////////퀴즈/////////////////////////////////
	    cur_Date = Calendar.getInstance();		//시간을 받아옴 
	    System.out.println("현재시각으로 부터 1개월 2일 3시간 4분 5초 후 ");
	    // 2023-01-17 11:27:08
	    cur_Date.add(Calendar.MONTH, 1);   		//어떤 것을 더 할래? 오늘 날짜에서 한달 뒤으로 1한다/
	    cur_Date.add(Calendar.DATE, 2);   		//어떤 것을 더 할래? 오늘 날짜에서 2일 뒤로/
	    cur_Date.add(Calendar.HOUR, 3);   		//어떤 것을 더 할래? 현재 시각에 3시간 더한다 /
	    cur_Date.add(Calendar.MINUTE, 4);   		//어떤 것을 더 할래? 현재 시각에 4분 더한다/
	    cur_Date.add(Calendar.SECOND, 5);   		//어떤 것을 더 할래? 현재 시각에 5초 더한다/

	    System.out.println("=> " + sdformt.format(cur_Date.getTime()));	// 원래 date만 출력하는데 gitTime으로 현재시간을 나타냄
	    // 2023-02-19 14:48:50
	    
	}//end of  main

}

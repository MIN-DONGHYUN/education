package my.day20.a.Enum;

import java.util.Calendar;

public class Main_2 {

	public static void main(String[] args) {
		
		Calendar currentDate = Calendar.getInstance();// 현재 낳짜와 시간을 얻어온다.

		int currentMonth = currentDate.get(Calendar.MONTH)+1;   // 현재월
		
		System.out.println(currentMonth);
		// 1 
		
		String season = null;  // String타입 변수
		
		if( 1 <= currentMonth && currentMonth <= 2 || currentMonth == 12)
		{
			season = Season_1.WINTER;  	 //1,2,12월은 겨울이다.
		}
		else if( 3 <= currentMonth && currentMonth <= 5)
		{
			season = Season_1.SPRING;  	 //3,4,5월은 봄이다.
		}
		else if( 6 <= currentMonth && currentMonth <= 8)
		{
			season = Season_1.SUMMER;  	 //6,7,8월은 여름이다.
		}
		else if( 9 <= currentMonth && currentMonth <= 11)
		{
			season = Season_1.AUTUMN;  	 //9,10,11월은 가을이다.
		}
		
		System.out.println(season);
		// 겨울
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		if( 1 <= currentMonth && currentMonth <= 2 || currentMonth == 12)
		{
			season = "GOAT";
		}
		else if( 3 <= currentMonth && currentMonth <= 5)
		{
			season = "메시";
		}
		else if( 6 <= currentMonth && currentMonth <= 8)
		{
			season = "World class";
		}
		else if( 9 <= currentMonth && currentMonth <= 11)
		{
			season = "NALGANGDO OUT";
		}
		
		System.out.println(season);
		// GOAT
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
        위와 같이 우리가 기대하는 값인 4계절명(봄,여름,가을,겨울)이 아닌 String 타입만 되면 
        어떤 것이든지 들어올 수 있기 때문에 자바는 오류가 아니지만 사용자 측면에서는 오류가 발생될 수 있다.
        이러한 경우 "서로 연관된 상수들의 집합" 의미하는 enum(열거형)이라는 타입을 사용하여 해결할 수 있다.    
		 */
		
		// seasonType_3를 stpye에 넣지만 null 값이다. seasonType_3에 열거되어있지 않으면 절대 못들어온다.
		SeasonType_3 stype = null; 
		
		if( 1 <= currentMonth && currentMonth <= 2 || currentMonth == 12)
		{
			stype = SeasonType_3.겨울;
		}
		else if( 3 <= currentMonth && currentMonth <= 5)
		{
			stype = SeasonType_3.봄;
		}
		else if( 6 <= currentMonth && currentMonth <= 8)
		{
			stype = SeasonType_3.여름;
		}
		else if( 9 <= currentMonth && currentMonth <= 11)
		{
			stype = SeasonType_3.가을;
		}
		
		System.out.println(stype);
		// 겨울
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//stype 변수에는 enum 으로 열거된 seasonType_3.봄, seasonType_3.여름, seasonType_3.가을, seasonType_3.겨울 이외의 값은 들어올 수 없게 된다.
		// 그러므로 아래와 같이 할 수 없다.
		
		/*
		if( 1 <= currentMonth && currentMonth <= 2 || currentMonth == 12)
		{
			//stype = "GOAT"; 	// 오류 발생함
			//stype = "겨울";    // 오류 발생함 
		}
		*/
		
		switch (stype) {
		//case "GOAT:   // 오류발생함
			
		//case SeasonType_3.봄  // SeasonType_3.봄 이라고 하면 오류발생함 
			
		//case "봄"    // 오류 발생함  
		
		case 봄:			// enum 에 있는 것으로 가능 
			System.out.println("따스한 봄 입니다.");
		    break;
		    
		case 여름:			// enum 에 있는 것으로 가능 
			System.out.println("무더운 여름 입니다.");
		    break;
		    
		case 가을:			// enum 에 있는 것으로 가능 
			System.out.println("시원한 가을 입니다.");
		    break;
		    
		case 겨울:			// enum 에 있는 것으로 가능 
			System.out.println("추운 겨울 입니다.");
		    break;
		}
		// 추운 겨울 입니다.
		
		
	}

}

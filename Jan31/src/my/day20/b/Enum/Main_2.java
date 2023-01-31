package my.day20.b.Enum;

public class Main_2 {

	public static void main(String[] args) {
		
		// *** enum(열거형) 타입인 SeasonType_1에 열거되어진 데이터 값이 뭐가 있는지 확인하고자 한다 *** //
		SeasonType_1[] seasonArr = SeasonType_1.values();  	//values의 리턴 타입은 배열 
		// values() 메소드는 enum(열거형)의 모든 상수를 배열에 담아 반환해주는 것이다.
		
		System.out.println("1. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
		
		for(SeasonType_1 season : seasonArr) // 확장 for문
		{
			// 모든 enum(열거형)은 추상 클래스 Enum(미완성 클래스) 의 자손이다.
			// 즉, enum(열거형)의 조상은 java.lang.Enum 클래스이다.
			// 그러므로 enum(열거형)타입은 클래스이며 부모클래스인 java.lang.Enum 클래스에서 정의되어진 메소드들을 사용할 수 있게 된다.
			
			String seasonName = season.name(); 		// 주인이 Enum 클래스 
			// name() 메소드는 enum(열거형) 상수의 값을 문자열(String)으로 반환해주는 것이다.
			
			System.out.println(seasonName); 	//출력 
		}// end of for
		/*
			봄
			여름
			가을
			겨울
	    */
		
		System.out.println("\n2. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
		
		for(SeasonType_1 season : seasonArr) // 확장 for문
		{
			int order = season.ordinal(); 		// 나열되어진 순서를 알고 싶다.
			// ordinal() 메소드는 enum(열거형) 상수가 정의된 순서를 반환해주는 것이다.
			// 순서는 0부터 시작된다.
			
			String seasonName = season.name(); 		// 주인이 Enum 클래스 
			// name() 메소드는 enum(열거형) 상수의 값을 문자열(String)으로 반환해주는 것이다.
			
			System.out.println(order + "." + seasonName); 	//출력 
		}// end of for
		/*
			0.봄
			1.여름
			2.가을
			3.겨울
	    */

		System.out.println("\n3. ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
		
		String str = ""; 		// 지역변수 설정 
		try
		{
			str = "여름";
			
			SeasonType_1 season = SeasonType_1.valueOf(str); 	// 값에 여름이 있는지 없는지 알아본다.
			// valueOF() 메소드는 열거형 SeasonType_1 에서 문자열 "여름" 과 일치하는 열거형 상수를 반환해주는 것이다.
			// 리턴 타입은 SeasonType_1(열거형 타입)
			
			System.out.println(season);
			// 여름 
			
			str = "한겨울";
			
			season = SeasonType_1.valueOf(str);   // 한겨울은 SeasonType_1에 없기 때문에 오류가 발생한다.
		}
		catch(IllegalArgumentException e)
		{
			System.out.println(">> 열거형 상수에는" + str + "이 없습니다. << ");
		}
		// >> 열거형 상수에는한겨울이 없습니다. << 

		
		
		
	}// end of main

}

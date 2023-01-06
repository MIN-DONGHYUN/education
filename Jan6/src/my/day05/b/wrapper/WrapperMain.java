package my.day05.b.wrapper;

import java.util.Scanner;

public class WrapperMain {

	/*
	   === *** wrapper 클래스 *** ===
	   
	   ------------------------------------------------
	     기본자료형(원시형, primitive)     wrapper 클래스
	   ------------------------------------------------
	    byte                           Byte 
	    short                          Short
	    int                            Integer  **
	    long                           Long
	    char                           Character **
	    float                          Float
	    double                         Double
	    boolean                        Boolean 
	    ------------------------------------------------
	    다른건 대문자만 다른고 ** 은 같은 이름이 아님   
	    
	    기본자료형(원시형)은 데이터 저장 및 4칙연산 에서만 사용하는 것이고, 
	    wrapper 클래스는  데이터 저장 및 4칙연산 뿐만아니라 
	    아주 다양한 기능의 메소드가 제공되므로 다방면으로 사용되어진다. 
	*/
	
	public static void main(String[] args) {
		
		System.out.println(" === auto Boxing 과 auto UnBoxing에 대해서 알아 봅니다. ===");
		//*************중요*****************// 회사 면접에서 물어보았던 문제이다.
		// (auto Boxing 과 auto UnBoxing) 
		// 이런것을 물어보면 외워서 유창하게 하는것보단 말을 좀 못하더라도 예를들어~라는 것으로 편한하게 면접을 보자!
		
		// Boxing(박싱, 포장을 하는것) 이란 ?
	    // ==> 기본자료형(boolean, byte, short, int, long, char, float, double)으로 되어진 변수를 
	    //     객체타입인 Wrapper 클래스(Boolean, Byte, Short, Integer, Long, Character, Float, Double)   
	    //     타입의 객체로 만들어주는 것을 말한다.
	      
	      
	    // UnBoxing(언박싱, 포장을 푸는것) 이란?   
	    // ==> Wrapper 클래스(Boolean, Byte, Short, Integer, Long, Character, Float, Double)로 
	    //     되어져 있는 객체를 기본자료형(boolean, byte, short, int, long, char, float, double)으로 
	    //     만들어주는 것을 말한다.

		int a1 = 10;  //a1은 변수
		
		Integer a2 = new Integer(a1); //Boxing(박싱) a1을 a2객체로 변경
		
		System.out.println("a1 : " + a1); // a1 = 10;
		 
		System.out.println("a2 : " + a2.intValue()); // intValue는 int값을 돌려주는 것을 말한다. a2 = 10;
													 //unboxing 원래는 위에 a2.intValue()를 사용해야함
		
		System.out.println("a2 : " + a2);  // a2 = 10; ,  a2는 인스턴스(객체)
		                                   //auto unboxing 원래는 위에 a2.intValue()를 사용해야하지만 자동으로 풀어준다.

		
		
		int a3 = 20;
		
		Integer a4 = a3;  // 원래는 Integer a4 = new Integer(a3); 로 해야함
		                  //Boxing
		
		System.out.println("a3 : " + a3); // a3 = 20;
		 
		System.out.println("a4 : " + a4.intValue()); // intValue는 int값을 돌려주는 것을 말한다. a4 = 20;
													 //unboxing 원래는 위에 a2.intValue()를 사용해야함
		
		System.out.println("a4 : " + a4);  // a4 = 20; ,  a4는 인스턴스(객체)
		                                   //auto unboxing 원래는 위에 a2.intValue()를 사용해야하지만 자동으로 풀어준다.

		a4 = 30; //a4는 인스턴스(객체)인데 값을 찍으면 
		System.out.println("a4 : " + a4);  // a4 = 30;
		
		
		//**********중요**************//
		byte bt1 = a4.byteValue(); //인스턴스(객체)이므로 byte로 변경한 것이다. a4는 인스턴스이므로 a4.을 사용가능
		// byte bt2 = (byte) a4;는 안된다.
		byte bt2 = (byte)a3; //a3은 인스턴스가 아님
		
		
		System.out.println("bt1 = " + bt1);  //bt1 = 30
		System.out.println("bt1 = " + bt2);  //bt2 = 20
		
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		
		double db1 = 1.23456;
		Double db2 = new Double(db1);  // Boxing(박싱)
		// 또는 
		//Double db2 = db1;   // auto Boxing(오토 박싱)
		Double db3 = db1;
		
		System.out.println("db1 : " + db1);   // db1 : 1.23456
		System.out.println("db2 : " + db2);   // db2 : 1.23456
		System.out.println("db3 : " + db3);   // db3 : 1.23456
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//////////////////// 소문자 a를 대문자 a로 변경하는 것 /////////////////////////
		char ch1 = 'a';
		Character ch2 = new Character('a'); //Boxing
		Character ch3 = 'a';               // auto boxing 
		
		System.out.println("ch1 : " + ch1);  //ch1 : a
		System.out.println("ch1 : " + ch2);  //ch2 : a
		System.out.println("ch1 : " + ch3);  //ch3 : a
		
		//'A' ==> 65
		//'a' ==> 97
		//'0' ==> 48
		//' ' ==> 32
		
		///////////////////중요///////////////////////////////
		// .toUpperCase()는 대문자로 변환후 반환
		// .toLowerCase()는 소문자로 변환후 반환
		
		
		ch1 = (char)(ch1 - 32);  //byte  short char + - * / 를 만나면은 자동적으로 int 타입으로 변경된다. ()치는 것을 캐스팅 한다고 한다.
		                   //97 - 32 ==> 65
		System.out.println("ch1 : " + ch1);
		//Character.toUpperCase(ch1);  //ch1글자를 대문자로 변경하여 반환시켜준다.  
		
		char ch4 = 'b'; 
		System.out.println(Character.toUpperCase(ch4));  //대문자 B가 나온다.
		
		char ch5 = 'C';
		
		System.out.println((char)(ch5 + 32)); // 소문자 'c' 가 나온다.
		System.out.println(Character.toLowerCase(ch5));   //꼭 기억하기 
		
		
		Character.toLowerCase(ch5);  // 대문자 C를 소문자로 변경하여 반환시켜준다.
		
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(" >> 아무글자(영문 또는 숫자 또는 특수기호) 1개를 입력하세요 => ");
		
		String inputStr = sc.nextLine();   //"a",   "B"   "3"   "@"   "good"
		
		
		
		// "good"
		// index 란 위치순서이다.
		// index위치는 다음줄과 같다.
		//  0123
		
		
		/*
		System.out.println(inputStr.charAt(0));  // char타입의 'g' 첫번째 글자를 출력한다.
		System.out.println(inputStr.charAt(1));  // char타입의 'o' 두번째 글자를 출력한다.
		System.out.println(inputStr.charAt(2));  // char타입의 'o' 세번째 글자를 출력한다.
		System.out.println(inputStr.charAt(3));  // char타입의 'd' 네번째 글자를 출력한다.
		System.out.println(inputStr.charAt(4));  // good을 쓰면 5번째 글자는 없기 때문에 오류가 난다.
												 // 단어가 길면 출력함 
		*/
		
		String result = "";
		char ch_1 = inputStr.charAt(0);  // 첫번째 글자를 뽑아온다.
		
		if('A' <= ch_1 && ch_1 <='Z') { //(65 <= ch_1 && ch_1 <=90)도 됨  //대문자인지 알아본다.
			result = "대문자";
		} 
		else if('a' <= ch_1 && ch_1 <='z')	{		 // 소문자인지 알아본다.
			result = "소문자";
		} 		
		else if(48 <= ch_1 && ch_1 <=57) 	{	//('0' <= ch_1 && ch_1 <= '9')	 // 숫자인지 알아본다.
			result = "숫자";
		} 
		else  {// 특수문자인지 알아본다.
			result = "특수문자";
		}
		
		System.out.println("입력하신 글자" + ch_1 + "는" + result + "입니다. ");
		
		// 입력하신 글자 a 는 소문자입니다.
		// 입력하신 글자 B 는 대문자입니다.
		// 입력하신 글자 3 는 숫자입니다.
		// 입력하신 글자 @ 는 특수문자입니다.
		// 입력하신 글자 g 는 소문자입니다.
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		/////////////////////// 같은 거지만 wrapper로 해보기 /////////////////////////////////
		
		
		if(Character.isUpperCase(ch_1)) {  //대문자인지 알아본다. // 입력받은 문자가 대문자로 참이라면 실행
			result = "대문자";
		} 
		else if(Character.isLowerCase(ch_1))	{		 // 소문자인지 알아본다. 입력받은 문자가 소문자로 참이라면
			result = "소문자";
		} 		
		else if(Character.isDigit(ch_1)) 	{// 입력받은 문자가 숫자로 참이라면
			result = "숫자";
		} 
		else  {// 특수문자인지 알아본다.
			result = "특수문자";
		}
		
		System.out.println("입력하신 글자" + ch_1 + "는" + result + "입니다. ");
	
		sc.close();

	}

}

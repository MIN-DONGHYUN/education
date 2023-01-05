package my.day02.b.dataType;

// 성적처리 프로그램입니다.

public class Sungjuk {

	   /*
    === *** 자료형 *** ===

        ※ 자료형의 종류

    1. 원시형 타입(Primitive Type)

    1.1  정수형(byte, short, int, long)
     -- 자바에서 정수형의 기본타입은 int 이다.
      -- 그러므로 정수형의 값이 -2,147,483,648 ~ 2,147,483,647 범위를 벗어난 것이라면 반드시 숫자뒤에 소문자 l 또는 대문자  L 을 붙여야 한다.  
             
       byte (1byte == 8bit)  : -2^7(-2의 7승)  ~ 2^7-1(2의 7승 - 1)  ==> -128 ~ 127 
       short(2byte == 16bit) : -2^15 ~ 2^15-1 ==> -32,768 ~ 32,767
       int  (4byte == 32bit) : -2^31 ~ 2^31-1 ==> -2,147,483,648 ~ 2,147,483,647  
       long (8byte == 64bit) : -2^63 ~ 2^63-1 ==> -9,223,372,036,854,775,808 ~  9,223,372,036,854,775,807         
             
    
    1.2 실수형(float, double) 
        float(4byte)  : 단정밀도   소수점이하 7자리까지 표현됨.   135.3246235
       double(8byte) : 배정밀도   소수점이하 15~16자리까지 표현됨. 135.3246234502345642
     -- 자바에서 실수형의 기본타입은 double 이다. 
       그러므로 실수값을 float 형태로 나타내기 위해서는 실수뒤에 반드시 소문자 f 또는 대문자 F를 붙여야 한다. 
             
         
    1.3 문자형(char)  1byte로 만든것인 아스키코드 
       char : 자바는 유니코드 체계를 사용하므로
              문자형 타입인 char 는 2byte 이며, 범위는 0 ~ 65535 이다.
              그래서 char 타입에는 문자 1개 또는 숫자(0~65535)도 올 수 있다.              
                                
            UNICODE 표 참조 
            http://www.tamasoft.co.jp/en/general-info/unicode.html                     
         
         === !!! 꼭 기억합시다 !!! ===
         int(4byte) 아래의 크기인  byte(1byte), short(2byte), char(2byte) 타입이 
              사칙연산(+ - * /)을 만나면 자동적으로 int 타입으로 자동 형변환이 발생된다.
         
         'A' => 65     'a' => 97
         'B' => 66     'b' => 98
         'C' => 67     'c' => 99
         
         '대문자' + 32 => 소문자에 해당하는 숫자
         '소문자' - 32 => 대문자에 해당하는 숫자
         
         '0' => 48
         '1' => 49
         '2' => 50
         '9' => 57
         ' ' => 32
         
         
    1.4 참(true) 또는 거짓(false)을 담아주는 boolean 타입 
    -- 크기가 1byte 이다.
         
            
    2. 참조형 타입(Reference Type)
       --> 클래스 객체(==object ==instance) 타입   
       --> 메모리상에 저장되어진 객체의 메모리 주소를 참조하는 것이다.
       --> 참조형 타입(Reference Type) 메모리상에 크기는 4byte 를 차지한다.  
            
  */   
 
 
 // === 속성, property, attribute, field === //
 
 /*
      === 변수의 명명규칙 === 
      1. 변수명의 길이에는 제한이 없다.
      2. 대,소문자 구분이 있다.
      3. 첫글자는 숫자는 안된다.
      4. 특수문자는 '_' 와 '$' 만 사용이 가능하다. 
      5. 예약어(예 package, import, public, class, String, int, float ...)는 변수명으로 사용불가하다.
      6. 필수사항은 아니지만 변수명명규칙의 관례인데 카멜표기법과 스네이크표기법을 따른다.  
      (카멜표기법 : 단어와 단어가 결합된 경우이라면 두번째 단어는 대문자로 시작한다.)
      (스네이크 표기법 : 단어와 단어가 결합된 경우이라면 두번째 단어전에 _를 추가한다. (회사에서 자주사용))
             
 */
	
	String hakbun;  //학번 null --- int를 사용할 시 맨 앞에 0을 사용할 수 없다
	                //데이터 값이 숫자로만 이루어지도라도 맨 앞에 0이 올 수 있는 경우라면 
	                //String 타입으로 해야한다.
	String name;    //학생명 null
	
	byte korPoint;   //국어점수 0
	                //카멜표기법 : 단어와 단어가 결합된 경우이라면 두번째 단어는 대문자로 시작한다.
	byte eng_point;  //영어점수 0 
	                //스네이크 표기법 : 단어와 단어가 결합된 경우이라면 두번째 단어전에 _를 추가한다.
	byte mathpoint;  //수학점수 0
	
    char hakjum;   //학점 'A', 'B', 'C', 'D' 'F'
    
    long seedmoney;  // 자본금 long타입 실험 
    
    // === 기능, 행위, behavior, method === //
    //성적결과를 화면에 출력해주는 메소드(기능)를 만들고자 한다.
    void showSungjuk() {
    	
    	//int total = korPoint + eng_point + mathpoint;   //short는 밑에 주석 참고 
    	short total = (short) (korPoint + eng_point + mathpoint);    // short사용할때 사용
    	
    	
    	//자바에서 그 데이터 타입이 byte 또는 short 또는 char 인 변수가 사칙연사(+,-,*,/)을 만나면 
    	//자동적으로 그 변수의 데이터 타입은 int 타입으로 변경된다.!!!!!
    	// korPoint + eng_point + mathpoint ==> 자동적으로 int 타입으로 형변환(casting) 된다.
    	// int를 short로 바꿔 메모리를 아끼고 싶다면
    	// (short) (korPoint + eng_point + mathpoint); ==> int타입을 강제로 short 타입으로 강재 형변환(casting) 이라고 부른다.
    	
    	
    	// double avg = total/3;     // 정수/정수 ==> 정수(몫)만 나온다. 
    	//double avg = total/3.0;      // 정수/실수 ==> 실수값이 나온다.
    	                             // 실수/정수 ==> 실수값이 나온다.
    	                             // 실수/실수 ==> 실수값이 나온다.                            
    	double avg_double = (double)total/3;  // 토탈이 정수 타입이지만 실수로 변경 8byte
    	float avg_float = (float)total/3;  //4byte인 float사용해 메모리 아낌 
    	float avg_float2 = total/3.0F;   //3.0F는 double형이였던 3.0을 float형으로 변경한다. 
    	
    	
    	if(avg_double >= 90) {
    		
    		hakjum = 'A';
    		
    	}
    	else if(avg_double >= 80) {
    		
    		hakjum = 'B';
    	}
    	else if(avg_double >= 70) {
    		
    		hakjum = 'C';
    		
    	}
        else if(avg_double >= 60) {
    		
    		hakjum = 'D';
    		
    	}
        else {
        	hakjum = 'F';
        }
    	
    	
    	String star = "";
    	
    	switch (hakjum) {   // () 안에는 비교대상
		case 'A':           //A와 같니?
			
			star = "☆☆☆☆☆";
			break;          // 스위치문 탈출
			
		case 'B':
			
			star = "☆☆☆☆";
			break;

        case 'C':
			
			star = "☆☆☆";
			break;
			
        case 'D':
			
			star = "☆☆";
			break;
			
		default:
			star = "☆";
			break;
		}
    	
    	String diamond = "";
    	
    	
    	switch ((total/3)/10) {   //  300/3      299/3      288/3     270/3   268/3   260/3   240/3
    						      //   100         99         96        90      89      86     80
    						      //  100/10      99/10      96/10     90/10   89/10   86/10  80/10
    	                          //    10          9          9         9       8       8      8
    	
    	// 주의할 점 switch(비교대상) 에서 비교대상의 데이터 타입은 byte, short, int, char, string타입만 들어올 수 있다.
    	// 비교대상의 데이터타입에는 long, float, double은 들어올수 없다
			case 10:                      //비교대상이 10 또는 9일때
			case 9:
				diamond = "◆◆◆◆◆";
				break;
				
			case 8:
				diamond = "◆◆◆◆";
				break;
				
			case 7:
				diamond = "◆◆◆";
				break;
				
			case 6:
				diamond = "◆◆";
				break;
	
			default:
				diamond = "◆";
				break;
		}
    	
    	// =========문자형 타입=============
    	// 자바는 char 타입을 표현할 때 unicode (2byte)를 사용한다.
    	char ch1 = 'k';
    	char ch2 = 107;
    	char ch3 = 'k'+2;   // byte,shoet,char는 사치연산 만나면 int로 변환됨 
    	         // 즉 107+2 = 109라는 결과를 가진다 유니코드로는 m이다.
    	         // char타입에 사칙연산(+,-,*,/)이 붙으면 자동적으로 char타입은 int타입으로 형변환 된다.
    	char ch4 = '\u231B';  //8987,   \\u는 유니코드임을 말한다.
    	
    	// 'A' ==> 65
    	// 'a' ==> 97   
    	//대소문자 차이는 32이다.
    	// '0' ==> 48
    	// ''(공백) ==> 32
    	
    	
    	// === boolean 타입 === //
    	boolean bool_1 = false;// ture ==> 참, false ==> 거짓
    	// ctrl + shift + x는 대문자로 변화, ctrl + shift + y는 소문자로 변환 
    	
    	boolean bool_2 = (5-3 == 4);  // false ==> 거짓
    	boolean bool_3 = (5-3 != 4);  // true ==> 참 
    	
    	
    	// 출력부분 
    	System.out.println("=== " + name + "님의 성적결과 ===\n"
    						+ "1. 학번 : " + hakbun + "\n"
    						+ "2. 성명 : " + name + '\n'
    						+ "3. 국어 : " + korPoint + "\n"
    						+ "4. 영어 : " + eng_point + "\n"
    						+ "5. 국어 : " + mathpoint + "\n"
    						+ "6. 총점 : " + total + "\n"
    						+ "7. 평균1 : " + avg_double + "\n"
    						+ "8. 평균2 : " + avg_float + "\n"
    						+ "9. 평균3 : " + avg_float2 + "\n"
    						+ "10. 학점1 : " + hakjum + "\n"
    						+ "11. 학점2(☆) : " + star + "\n"
    						+ "12. 학점3(◆) : " + diamond + "\n"
    						+ "소문자 k : " + ch1 + "\n"
    						+ "소문자 k : " + ch2 + "\n"
    						+ "소문자 k : " + ch3 + "\n"
    						+ "모래시계 : " + ch4 + "\n"
    						+ "bool_1 : " + bool_1 + "\n"
    						+ "bool_2 : " + bool_2 + "\n"
    						+ "bool_3 : " + bool_3 + "\n"
    						+ "자본금 : " + seedmoney + "원\n"

    	);
    }

}

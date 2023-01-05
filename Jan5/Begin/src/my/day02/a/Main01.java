package my.day02.a;   //패키지 명은 반드시 소문자로 시작, 클래스명은 대문자

public class Main01 {

	String id;  // String은 문자열 타입
	String pwd;
	String name;
	String email;
	int age;  // 나이며 int는 숫자(정수)를 뜻함 
	double height;   // double은 실수 타입
	double weight = 58.6;  //weight 에 초기값(초기치)을 58.6으로 넣어줌 
	
	/*
        맴버변수 -> instance변수와 static 변수를 합친것을 맴버변수라고 부른다.
        instance 변수와 static 변수는 초기화를 하지 않더라고 자동적으로 초기화가 되어진다.
        정수형인 데이터타입(byte, short, int, long)은 자동적으로 0으로 초기화 된다.
        실수형인 데이터타입(float, double)은 자동적으로 0.0으로 초기화 된다. 	 
        문자형인 데이터타입(char)는 자동적으로 ' '으로 초기화 된다. (공백이 나옴)
        String을 포함한 클래스 타입은 자동적으로 null 로 초기화가 된다.
	*/
	
	
	void showInfo1() {     // 메소드 생성,  ()있는건 생성자나 메소드 
		
		int hopeMoney = 5000;    //지역변수 , 지역변수는 초기화가 안됨 그래서 아무것도 안 적을시 오류발생
		                   //어떤 메소드 안에서 선언되어진 변수를 지역변수(Local variable)라고 한다.
		                   //지역변수는 { } 내에서만 사용되어지기 때문에 { }을 벗어나는 순간 자동적으로 메모리(RAM) 상에서 삭제된다.
		                   //지역변수는 반드시 초기화(어떤 변수에 처음부터 값을 부여해주는것)을 해주어야 한다.!!!
		
		System.out.println(" === \n"
				          + "1. 아이디 : " + id + "\n"
				          + "2. 암호  : " + pwd + "\n"
				          + "3. 성명 : " + name + "\n"
				          + "4. 이메일 : " + email + "\n"
				          + "5. 나이 : " + age + "\n"        //age는 정수형이므로 + 인 문자열 결합으로 했을때 그냥 붙여줌
				          + "6. 신장 : " + height + "\n"
				          + "7. 몸무게 : " + weight + "\n"
				          + "8. 희망급여 : " + hopeMoney + "만원\n"
				); //+는 문자열 결합
		// 문자열과 문자열 사이의 +는 문자열 결합을 뜻하는 것이고 
		// 숫자와 숫자 사이의 + 는 더하기(Plus)를 뜻하는 것이고 
		// 문자열과 숫자 사이의 + 는 문자열 결합을 뜻하는 것이다.
	}
	
     void showInfo2() {     // 메소드 생성,  ()있는건 생성자나 메소드 
		
    	 int hopeMoney = 7000;
		
		System.out.println(" === \n"
				          + "1. 아이디 : " + id + "\n"
				          + "2. 암호  : " + pwd + "\n"
				          + "3. 성명 : " + name + "\n"
				          + "4. 이메일 : " + email + "\n"
				          + "5. 나이 : " + age + "\n"        //age는 정수형이므로 + 인 문자열 결합으로 했을때 그냥 붙여줌
				          + "6. 신장 : " + height + "\n"
				          + "7. 몸무게 : " + weight + "\n"
				          + "8. 희망급여 : " + hopeMoney + "만원\n"
				); //+는 문자열 결합
		// 문자열과 문자열 사이의 +는 문자열 결합을 뜻하는 것이고 
		// 숫자와 숫자 사이의 + 는 더하기(Plus)를 뜻하는 것이고 
		// 문자열과 숫자 사이의 + 는 문자열 결합을 뜻하는 것이다.
	}
	///////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		
		// id = "mindh" 은 오류가난다. 이유는 인스턴스가 없음
		
		// new Main01().id = "mindh";  이렇게 사용해도 됨 하지만 불편함 
        // new Main01().id = "leess";
		
		Main01 ma1 = new Main01();     //mal로 선언(부른다), 인스턴스화(==객체생성)
		ma1.id = "mindh";
		ma1.pwd = "abcd";
		ma1.name = "민동현";
		ma1.email = "mdh2057@naver.com";
		ma1.age = 28;
		ma1.showInfo1();
		
		System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Main01 ma2 = new Main01();     //ma2로 선언(부른다), 인스턴스화(==객체생성)
		ma2.showInfo1();
		
		System.out.println("\n ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		ma2.showInfo2();
		
		/*
		// 인스턴스에 할당되었던 메모리 공간을 비워야 한다.
		ma1 = null;  
		ma2 = null;
		
		System.gc();  // Garbage Collector (쓰레기 수집)
		*/
		//위의 인스턴스에 할당 되었던 메모리 공간을 비우는 것과 
		//Garbage Collector( 쓰레기 수집)을 하는 작업을 기술할 필요가 없다.
		// 왜냐하면 프로그램이 종료되는 순간 이런 작업이 자동적으로 해주기 때문이다.
	}

}

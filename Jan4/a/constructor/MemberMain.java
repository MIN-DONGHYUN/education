package my.day03.a.constructor;

public class MemberMain {

	public static void main(String[] args) {
		
		Member hongMbr = new Member();  // 파라미터(매개변수)가 없는 생성자를 기본 생성자(default constructor)라고 부른다.
		hongMbr.userid = "hongkd";
		hongMbr.passwd = "1234";
		hongMbr.name = "홍길동";
		hongMbr.age = 20;
		hongMbr.point = 100; 
		
		hongMbr.showInfo();
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 파라미터 생성자 
		Member iuMbr = new Member("iu", "abcd", "아이유", 29, 300);  // 파라미터(매개변수)가 있는 생성자이다.
		iuMbr.showInfo();
		
		
		System.out.println("\n========================\n");
		
		Member chaewMbr = new Member("chsew", "qwer", "차은우");
		chaewMbr.showInfo();

		System.out.println("\n########################\n");
		
	    //  == return 타입이 void인 메소드 호출 === //
			
		// hongMbr 인스턴스(객체)의 암호를 변경해주는 메소드 호출
		hongMbr.updatePasswd("wqrqwe", "0070$");   //()는 메소드 /// 클래스() 는 생성자 
												   //()안에 내용이 있으므로 parameter, argument, 매개변수, 인자라 부른다.
		
		// iuMbr 인스턴스(객체)의 암호를 변경해주는 메소드 호출
		iuMbr.updatePasswd("abcd", "adsf!");   //()는 메소드 /// 클래스() 는 생성자 
		
		System.out.println("\n++++++++++++++++++++++++++\n");
		
		
		
		// == return 타입이 있는 메소드 호출 == //
		int jangoPoint = hongMbr.pointPayment(30);   //홍길동 point에 30을 빼겠다. , 메소드 호출후 int에 정보를 넘기는 것을 말한다.
		System.out.println("\"" + hongMbr.name + "\"님의 현재 포인트는" + jangoPoint + "입니다.\n");  //잔고를 나타내기 위해 출력 
		// 홍길동님의 현재포인트는 100이므로 포인트 30 결제가 완료되었습니다.
		// 홍길동님의 남은 포인트는 현재 100-30인 70입니다 
		
		
		jangoPoint = chaewMbr.pointPayment(20);   //차은우 point에 20을 빼겠다. , 메소드 호출후 int에 정보를 넘기는 것을 말한다.
		System.out.println( "\"" + chaewMbr.name + "\"님의 현재 포인트는" + jangoPoint + "입니다.\n");  //잔고를 나타내기 위해 출력 
		// 차은우님의 현재 포인트는 0 이므로 포인트 20 결제가 불가합니다.
		// 차은우님의 남은 포인트는 0 입니다.
		
		
		jangoPoint = iuMbr.pointPayment(5000);   //아이유 point에 5000을 빼겠다. , 메소드 호출후 int에 정보를 넘기는 것을 말한다.
		System.out.println( "\"" + iuMbr.name + "\"님의 현재 포인트는" + jangoPoint + "입니다.\n");  //잔고를 나타내기 위해 출력 
		// 아이유님의 현재 포인트는 300 이므로 포인트 5000 결제가 불가합니다.
		// 아이유님의 남은 포인트는 300 입니다.
		
		
		
		System.out.println("\n-------------------------------\n");
		
		String info = hongMbr.changeInfo("5678", 30, 400);
		//                  암호   나이   포인트
		
		System.out.println(info);
		
		/*
		   === 홍길동님의 회원정보 수정하기전 ===
		   1. 아이디 : hongkd
		   2. 암호 : 1234
		   3. 성명 : 홍길동
		   4. 나이 : 20
		   5. 포인트 : 70
		   
		   === 홍길동님의 회원정보 수정후 ===
		   1. 아이디 : hongkd
		   2. 암호 : 5678
		   3. 성명 : 홍길동 
		   4. 나이 : 30
		   5. 포인트 : 400
		 */
		System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
		
		info = iuMbr.changeInfo("7777", "이지은", 35, 8000);  //회원정보 이름까지 변경하기 
		                        //암호     이름    나이   포인트
		
		System.out.println(info); //결과 출력
		
		
		
	}
}

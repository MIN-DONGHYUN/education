package my.day01;

public class Main {

	//콘솔 프로그램의 실행은 main(String[] args) 메소드에 실행한다.
	public static void main(String[] args) {
		
       // 1명의 새로운 회원이 필요하다.
    
       //디스크에서 ram으로 올라간 상태를 인스턴스화(객체화)라고 부른다.
	   Member mindhmbr = new Member();   // 인스턴스화 시킨것이다.  //민동현
	   // mindhmbr 을 Member 클래스의 객체(== 인스턴스)라고 부른다.
	   
	   System.out.println("mindhmbr : " + mindhmbr);
	   // mindhmbr : my.day01.Member@15db9742
	   // @다음 나오는 것은 16진수의 값은 메모리(RAM)상의 위치(주소)를 가리키는 것이다.
	   
	   mindhmbr.id = "mindh"; //문자열이니까 ""를 사용
	                          // = 은 어떤 값을 어떤 변수에 대입한다(넣어준다)라는 뜻이다.
	   mindhmbr.pwd = "abcd";
	   mindhmbr.name = "민동현";
	   mindhmbr.email = "mdh2057@naver.com";
	   
	   
	   //또 한명의 새로운 회원이 필요하다.
	   Member leembr = new Member();   // 이순신
	   
	   System.out.println("leembr : " + leembr);
	   // leembr : my.day01.Member@6d06d69c (메모리 주소)
	   
	   leembr.id = "leess"; // = 은 어떤 값을 어떤 변수에 대입한다(넣어준다)라는 뜻이다.
	   leembr.pwd = "qwer1234";
	   leembr.name = "이순신";
	   leembr.email = "leess@naver.com";
	   
	   ////////////////////////////////////////////////////////
	   
	   mindhmbr.showInfo();  // mindhmbr 인스턴스(객체)에 대한 회원 정보 출력하기
	   leembr.showInfo();  //leembr 인스턴스(객체)에 대한 회원 정보 출력하기
	   

	}

}


package my.day03.a.constructor;

public class Member {

	//field, attribute, property, 속성 
	String userid;
	String passwd;
	String name;
	int age;
	int point;
	
	//생성자(constructor) ==> 인스턴스(객체)화 항때 사용되어지는 일종의 메소드라고 보면 된다. 	
	/*
	 
	// 파라미터가 없는 생성자를 기본생성자(default constructor)라고 부른다. 
	// 모든 클래스는 아래와 같이 기본생성자(default constructor)를 명기하지 않으면
	// 기본 생성자가 없는 것이 아니라 생략되어져 안 보일 뿐이다.
	// 즉 파라미터 없는 기본생성자는 무조건 필요하다.
	
	public Member() {
		
	}
	*/
	 
	public Member() {    //public + 클래스 이름 
		System.out.println(">>> 기본생성자 Member()가 호출됨 <<<");
		
	} //end of public Member()
	
	
	// >>> 파라미터가 있는 생성자 
	// !!! 파라미터가 있는 생성자를 만들면 자동적으로 생략되어져 있던 기본 생성자가 삭제가 되어져 버린다.!!!
	// >>> 파라미터가 있는 생성자의 주 목적은 필드를 초기화시켜주는 것이다.
	
	
	public Member(String userid, String passwd, String name) {
		// 지역변수명과 맴버변수명이 동일할 경우에는 지역변수명이 더 우선한다.
		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		
		
		//this는 자기자신 클래스인 Member 클래스의 인스턴스를 뜻하는 것이다.
		System.out.println(">>> 파라미터 생성자 Member(String userid, String passwd, String name)가 호출됨 <<<");
		
	} //end of public Member(String userid, String passwd, String name)
	
	public Member(String userid, String passwd, String name, int age, int point) {
		// 지역변수명과 맴버변수명이 동일할 경우에는 지역변수명이 더 우선한다.
		//this.userid = userid;
		//this.passwd = passwd;
		//this.name = name;
		// 또는 
		this(userid, passwd, name);    //앞에 public Member의 id, passwd, name을 가져온다. (앞의 파라미터 생성자 가져옴)
		                               //또 다른 생성자를 호출한 것이다.
		
		this.age = age;
		this.point = point;
		
		//this는 자기자신 클래스인 Member 클래스의 인스턴스를 뜻하는 것이다.
		System.out.println(">>> 파라미터 생성자 Member(String userid, String passwd, String name, int age, int point)가 호출됨 <<<");
		
	}  //end of public Member(String userid, String passwd, String name, int age, int point)
	
	
	
	
	// behavior, operation, method, function, 행위, 기능, 함수 
	void showInfo() {
		
		System.out.println("===" + name + "님의 회원정보 ===\n"  
				          + "1. 아이디 : " + userid + "\n"
				          + "2. 암 호 : " + passwd + "\n"
				          + "3. 성명 : " + name + "\n"
				          + "4. 나이 : " + age + "\n"
				          + "5. 포인트 : " + point + "\n"
				);
	}  //end of showInfo()


	
	//  == return 타입이 void인 메소드 생성하기 === //
	// 암호를 변경하려는 기능 (메소드)를 만들것이다.


	void updatePasswd(String currentPasswd, String newPasswd) {  // 메소드 생성시 void는 리턴 타입이 없는 타입이다.

		// 현재 인스턴스의 암호인 passwd와 입력받은 currentPasswd 값이 서로 일치하지 않으면 꽝 
		if(!passwd.equals(currentPasswd))  //비교하고싶은대상.equals(비교할 대상) --> 결과가 같으면 true 아니면 false
		{								  //passwd.eq하면  String인지 int인지 알수 있음 
			System.out.println(">>" + name + "님 현재 사용중인 암호와 틀린 암호를 입력하셔서 암호 변경이 불가합니다.!! << \n");
			
		} //end of if
		// 현재 인스턴스의 암호인 passwd와 입력받은 currentPasswd 값이 서로 일치한다면 
		else {
			passwd = newPasswd;
			
			System.out.println(">>\"" + name + "\"님 현재 사용중인 암호는 성공적으로 변경되었습니다. << \n\n"); //쌍따옴표를 출력하고 싶으면 \"를 사용한다. 
			System.out.println("변경된 정보는 다음과 같습니다\n");  
			showInfo();   // showInfo 호출하기 
		} //end of else
	} // end of Void updataPasswd(String currentPasswd, String newPasswd)
	
	
	
	// == return 타입이 있는 메소드 생성하기 ==// 리턴을 int로 할시
	
	int pointPayment(int point) {
		
		int jangoPoint = 0;
		
		if( this.point == 0) { //포인트가 0이라면 
			
			System.out.println("\"" + name + "\"님의 현재 포인트는 0 이므로 결제가 불가합니다.");
			jangoPoint = this.point;
			
		}
		else if(this.point < point) { // 현재 가지고 있는 포인트보다 더 많이 필요할 경우
			
			System.out.println("\"" + name + "\"님의 현재 포인트는" + this.point + "이므로 포인트" + point + "결제가 불가합니다.");
			jangoPoint = this.point;
		}
		else {
			
			System.out.println("\"" + name + "\"님의 현재 포인트는" + this.point + "이므로 포인트" + point + "결제가 완료되었습니다.");
			jangoPoint = this.point - point;
		}
		
		return jangoPoint;
		
	}
	
	String memberInfo() { //회원정보를 나타내기위해 미리 만들어 놓은 메소드 
		
		
		return  "1. 아이디 : " + userid + " \n"  // return은 +로 문자열을 합칠수 있다.
		+ "2. 암호 : "+ passwd + "  \n"
		+ "3. 성명 : " + name + "  \n"
		+ "4. 나이 : " + age +"  \n"
		+ "5. 포인트 :" + point + "\n";
		
	}//end of String memberInfo()
	
	
	String changeInfo(String passwd, int age, int point) {  // Main클래스의 65번줄 String info = hongMbr.changeInfo("5678", 30, 400);를 뜻한다.
		
		String result = "===\"" + name + "\"님의 회원정보 수정하기전 ===\n" + memberInfo();  // 회원정보 바꾸기 전에 회원정보 출력 133줄로 
		
		this.passwd = passwd;		// 변경하기
		this.age = age;
		this.point = point;
		
		return result + "\n===\"" + name + "\"님의 회원정보 수정후 ===\n" + memberInfo();// 회원정보 수정 후에 회원정보 출력 133줄로 
			
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

		
	} // end of changeInfo(String passwd, int age, int point)
	
	
	
	
	
	// !!!! 메소드의 오버로딩(overloading) !!!!
	// 1. 메소드의 이름은 같더라도 파라미터의 개수가 다르면 다른 메소드로 취급 하므로 메소드 중복이 아니다.
	// 2. 메소드의 이름은 같고, 파라미터의 개수도 같더라도 파라미터의 데이터타입의 순서가 다르면 다른 메소드로 취급 하므로 메소드 중복이 아니다.
	// 3. 메소드의 이름은 같고, 파라미터의 개수도 같고, 파라미터의 데이터타입의 순서도 같고, 단 return 타입은 다를 경우라도 메소드 중복이라고 본다. 
	// 그러므로 메소드의 이름이 같지만 메소드가 중복이 안되려면 리턴타입은 필요가 없고 오로지 파라미터가 달라야 한다.  
	// ex) 위에 changeinfo(String passwd, String name, int age, int point)이 있는데
	// changeinfo(String a, String b, int c, int d)가 있다면 오버로딩으로 중복되어 오류가난다.
    // 하지만 changeinfo(int passwd, String name, int age, int point) 이렇게 되어있다면 앞 int가 다르기 때문에 오버로딩이 아니다.	

	
	String changeInfo(String passwd, String name, int age, int point){
		
		String result = "===\"" + name + "\"님의 회원정보 수정하기전 ===\n" + memberInfo();  // 회원정보 바꾸기 전에 회원정보 출력 133줄로 
		this.passwd = passwd;		// 변경하기
		this.name = name;
		this.age = age;
		this.point = point;
		
		
		return result + "\n===\"" + name + "\"님의 회원정보 수정후 ===\n" + memberInfo();// 회원정보 수정 후에 회원정보 출력 133줄로 

		
	} // end of String changeInfo(String passwd, String name, int age, int point)
	
}//end of class Member


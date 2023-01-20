package my.day14.inheritance;

import java.text.DecimalFormat;
import java.util.Calendar;


import my.util.MyUtil;

//=== 객체지향프로그래밍(Object oriented Programming) === //
	// 어떤 프로그램이냐에 따라 그 목적에 맞도록 필요한 데이터(필드)를 추상화(필요한 것만 추출하는 것, 반대가 정밀화)
	// 또한 그 목적에 맞는 기능(메소드)만 부여한 클래스를 생성하여 프로그램 하는 것이다.
	
	// === 객체지향프로그래밍(Object oriented Programming) 의 4가지 특징 === //
	/*
		1. 상속성(Inheritance) : 클래스의 재사용과 소스 코드의 중복제거를 목적으로 하는 기술
     2. 추상화(Abstraction) : 프로그램이 필요로 하는 실제 데이터들을 모델링하는 기술 
     3. 캡슐화(EnCapsulation == 은닉화) : 객체지향의 가장 중요한 데이터 보호 기술
     4. 다형성(Polymorphism) : 상속을 이용하여 여러 클래스 타입을 하나의 클래스 타입으로 다루는 기술 
     
    구인구직 어플리케이션 프로그래밍 제작시
    필요한 요소(부품)가 무엇이 있는지 생각해보자.
    아주 다양하고, 많은 요소들이 필요할 것이다.
    
    예를 들어,
    구직자, 구인회사, 채용 ..... 등등등 많이 있다.
    이러한 요소(부품)들이 바로 객체인데 이 객체를 만드는 설계도면이 클래스이다.

    위와(구인구직 어플리케이션 프로그래밍 제작) 같이 현실세계에 존재하는 
    다양한 객체들을 각각 하나하나 추상화 시켜서 클래스로 옮기는 것을 객체지향 프로그래밍(OOP)이라고 한다.
    
   ※ 여기서 추상화(abstraction)란?
   --> 일반적인 의미의 추상화란 어떤 물체(object)에서 주된
       특징을 부각시켜 표현하고, 나머지 부분은 과감하게 생략하는것을 말한다.
       추상화의 반대는 아주 시시콜콜한것(세세한 것)까지 전부 몽땅
       다 묘사하는 것을 말하는데 이것을 정밀화 라고 말한다.
    
    객체지향 프로그래밍(OOP)에서 사용되는 추상화도 이와 비슷하다.
    어떤 하나의 물체를 대표하는 속성(명사, 멤버변수)과 기능(동사, 메소드)을 추출해내는 것을 
    객체지향 프로그래밍(OOP)에서 "추상화" 라고 한다. 

   >>> 예를 들어, 구인구직 어플리케이션 프로그래밍 제작시
        필요한 부품(요소)중 하나인 "구직자" 에 대해서 알아보자.
        "구직자" 가 가지고 있는 속성(명사, 멤버변수)과 행동양식(기능, 동사, 메소드)을 뽑아보자.
    1). 속성(property, attribute, field)은 멤버변수가 되고,
    2). 행동양식(기능)은 메소드가 되는 것이다.

    Gujikja(클래스)
       |
       |-- 속성(property, attribute, field) : 아이디, 암호, 성명, 연락처, 이메일, 주소, 학력, 희망구직직종, 희망연봉.....  
       |-- 행동양식(기능, 메소드) : 구직자로 접속(로그인)할수 있는 기능, 구직자정보를 조회해주는 기능, 구직자정보를 변경해주는 기능, ....... 

	*/
	

public class Gujikja extends Member {		// extends Member을 쓰면 Member에 있는 필드를 상속받는다.
// Member ==> 부모 클래스
// Gujikja ==> 자식 클래스 
// 자식 클래스는 부모 클래스의 모든 필드를 사용이 가능하다.
// 부모클래스의 기본 생성자를 먼저 불러낸다. (Gujikja gu = new Gujikja 라고 했을 때)
	
	/*
	    ---------------------------------------------------------------------------------------------------------------------------
	   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스        그외의영역  
	   --------------------------------------------------------------------------------------------------------------------------- 
	   public                                    O                    O                         O                        O  
	   protected                                 O                    O                         O                        X
	   default                                   O                    O                         X                        X
	   private                                   O                    X                         X                        X
	*/   
	
	
	// field(속성) 생성 (Gujikja 클래스 만의 필드)
	private String jubun;	// 주민번호 앞의 7자리 까지만
				 // 예 "9512201" 남자, "01122203" 남자
				 // 예 "9512202" 여자, "01122204" 여자
	
	private int hope_money;		//희망 연봉 
	
	static int count;  // Gujikja 객체(인스턴스)의 개수를 알아오려는 용도
	
	
	//기본생성자
	public Gujikja() {
		//System.out.println("####확인용 자식클래스인 Gujikja 클래스 생성자 호출됨 !!!\n");
	}
	
	

	//method(메소드) 생성 (주민번호 ) 
	public void setJubun(String jubun) 
	{
		if(MyUtil.isCheckJubun(jubun))
		{
			this.jubun = jubun;
		}
		else
		{
			System.out.println("[경고] 주민번호를 올바르게 입력하세요!! \n 예 > 8402082");
		}
	}	//end of public void setJubun(String jubun)
	
	//메소드 생성 
	public String getJubun() {
		return jubun;
	}



	//method(메소드) 생성
	public int getHope_money() {
		return hope_money;
	}
	
	//method(메소드) 생성
	public void setHope_money(int hope_money) {
		if(hope_money > 0)
		{
			this.hope_money = hope_money;
		}
		else
		{
			System.out.println("[경고] 희망 연봉은 0보다 커야한다.!!\n");
		}
	}
	
	// method(메소드) 생성 
	
	//== 구직자의 성별을 알려주는 메소드 생성하기 ===
	String getGender() {
		
		String gender = ""; 	// 저장하기 위해 변수선언
		
		switch (jubun.substring(6)) {		// 주번필드에서 문자열 비교 인덱스 번호 6번 비교  
			case "1":				//1,3일때 남성이라는 성별을 넣어줌
			case "3":
				gender = "남";
				break;
	
			default:				// 1,3 제외한 2,4는 성별에 여를 넣어줌 
				gender = "여";
				break;
		}
		return gender;
	}// end of String getGender() 
	
	


	// === 구직자의 현재 나이를 알려주는 메소드 생성하기 ==
	int getAge() {
		
		// 현재나이 = 현재년도 - 태어난 년도 + 1;
		Calendar currentDate = Calendar.getInstance();		// 현재 날짜와 현재 시간을 얻어온다.
		int currentYear = currentDate.get(Calendar.YEAR);	//현재연도를 나타낸다 ex)2023
		
		// 삼항연산자 주민필드의 맨 끝자리가 1,2면은 이 사람은 1900연도 사람, 나머지는 2000년도 사람이다.
		int centry = ("1".equals(jubun.substring(6)) || "2".equals(jubun.substring(6)))?1900:2000;	 
		
		int birthYear = Integer.parseInt(jubun.substring(0, 2)) + centry;  //주번 필드의 숫자를 처음부터 2개 뽑아온다.
																		   //태어난 연도 
		
		return currentYear - birthYear + 1;	// 나이를 리턴시킨다.

	} // end of int getAge() 메소드 
	
	
	// === 구직자의 정보를 한줄로 리턴시켜주는 메소드 생성하기 ===
	String getInfo()
	{
		// eomjh   qwer******    엄정화    여    29    2023-01-17
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더 사용 
		
		/*
		//3가지 방식 모두 가능 
		sb.append(getId() + "\t");    //id라는 필드는 부모클래스에 있기 때문에 부모것을 물려 받기 위해 super를 사용한다.
								      //super 생략해도됨 
		
		String star = "";    // 별을 붙이기 위해서 설정 
		for(int i=0; i<super.getPasswd().length()-4; i++)	//passwd의 길이의 -4를 뺀것만큼 반복 
		{
			star += "*";
		}
		sb.append(super.getPasswd().substring(0,4) + star +"\t");    //Passwd라는 필드는 부모클래스에 있기 때문에 부모것을 물려 받기 위해 super를 사용한다.
	      														//super 생략해도됨,  *을 찍는다.
		*/
		
		sb.append(this.getName() + "\t");	//Name라는 필드는 부모클래스에 있기 때문에 부모것을 물려 받기 위해 super를 사용한다.
											//super 생략해도됨 
		sb.append(getGender() + "\t");		// 성별
		
		sb.append(getAge() + "\t");			// 나이
		
		sb.append(super.getRegister_day() + "\t");	// 부모클래스의 가입일자 
		
		
		DecimalFormat df = new DecimalFormat("#,###");  // 3자리 마다 콤마를 찍어주는 것이다.
		
		sb.append(df.format(hope_money) + "만원");		// 희망연봉을 3자리마다 콤마로 찍어준다.
				

		
		return sb.toString();		// 스트링 타입으로 변경 
		
		
		
	}// end of String getInfo()

////////////////////////////////////////////////////////////////
	
	//===========메소드의 오버라이딩 ============//
	@Override					// 부모로 부터 받은것을 재정의 함 
	public String toString() {		// 최상단 부모클래스인object의 tostring을 재정의 한다.
		
		DecimalFormat df = new DecimalFormat("#,###");		// 3자리 마다 콤마를 찍어주는 것이다.
		
		return "1. 아이디 : "+ super.getId() +"\n"
			+  "2. 비밀번호 : " + super.getPasswd() + "\n"
			+  "3. 성명 : " + super.getName() + "\n"
			+  "4. 주민번호 : " + jubun + "\n"
			+  "5. 희망연봉 : " + df.format(hope_money) + "만원\n";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}

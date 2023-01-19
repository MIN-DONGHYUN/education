package my.day14.a.inheritance;

import java.text.DecimalFormat;


import java.util.regex.Matcher;
import java.util.regex.Pattern;



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
	

public class Company extends Member {		// extends Member을 쓰면 Member에 있는 필드를 상속받는다.
// Member ==> 부모 클래스
// Gujikja ==> 자식 클래스 
// 자식 클래스는 부모 클래스의 모든 필드를 사용이 가능하다.
// 부모클래스의 기본 생성자를 먼저 불러낸다. (company comp = new company 라고 했을 때)
	
	/*
	    ---------------------------------------------------------------------------------------------------------------------------
	   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스        그외의영역  
	   --------------------------------------------------------------------------------------------------------------------------- 
	   public                                    O                    O                         O                        O  
	   protected                                 O                    O                         O                        X
	   default                                   O                    O                         X                        X
	   private                                   O                    X                         X                        X
	*/   
	
	
	// field(속성) 생성 (company 클래스 만의 필드)
	private String business_number;	// 사업자 등록번호 
	private String jobType; 		// 회사 직종 타입(제조업, 서비스업, IT 등등)
	private long seedMoney;			// 자본금 
	
	
	static int count;  // Gujikja 객체(인스턴스)의 개수를 알아오려는 용도


	// method생성
	// getter, setter 하기 
	public String getBusiness_number() {
		return business_number;
	}


	public void setBusiness_number(String business_number) {
		//사업자 등록번호는 오로지 숫자로만 들어와야 하며, 사업자 등록번호의 길이는 10글자로 하겠습니다.
		
		// 정규표현식을 사용한다.
		// 정규표현식(Regular Expression)이란?
		// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어
				
		// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		Pattern p = Pattern.compile("^[0-9]{10}$");
		//^은 시작을 의미한다. , $는 끝을 의미한다. , []는 글자 1개가 들어오는 것을 의미한다.
		//[0123456789] 은 0 또는 1 또는 2 또는 3... 8 또는 9만 들어온다는 뜻이다.
		//[0-9]은 [0123456789]와 같다.
		//뒤에 {}는 몇번 반복하는지 나타내는 것으로 {10}은 10번 반복을 뜻한다.
		
		// == 2. 검사할 문자열이 주어진 정규식 패턴과 일치하는지 아닌지를 판별하는 객체를 생성한다. == //
		Matcher m = p.matcher(business_number);
		
		// == 3. 검사할 문자열을 판별하도록 한다. == //
		//입력받은 jubun 이 주어진 정규식 패턴과 일치하면 true, 일치하지 않으면 false를 리턴시켜준다.
		boolean bool = m.matches();   //return은 boolean타입이다.
		
		if(bool)		// bool이 true라면 
		{
			this.business_number = business_number;
		}
		else			// bool이 false라면
		{
			System.out.println("[경고] 사업자 등록번호는 숫자로만 10글자 입력해야 합니다.\n");
		}
	}


	public String getJobType() {
		return jobType;
	}


	public void setJobType(String jobType) {
		
		if(!jobType.trim().isEmpty())	// 만약 jobtype이 공백이 아니라면
		{
			this.jobType = jobType;
		}
		else
		{
			System.out.println("[경고] 회사직종군은 공백이 아닌 글자로 입력하셔야 합니다. \n");
		}
	}


	public long getSeedMoney() {
		return seedMoney;
	}


	public void setSeedMoney(long seedMoney) {
		if(seedMoney > 0)	// 자본금이 0이상일때 
		{
			this.seedMoney = seedMoney;
		}
		else		//자본금이 0이나 음수일때 
		{
			System.out.println("[경고] 자본금은 0 보다 커야 합니다.\n");
		}
	}	
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	// 부모로부터 물려받은 이름을 고치기 위해 오버라이딩을 하자 !!!!!!!!!!!!!!!!!!!!!!!!
	////////////////////////////////////////////////////////////////////////////////////////
	
	
	// method 생성
	// !!!!!!!!!!!!!!!!!입사시 면접 가능성이 있다.!!!!!!!!!!!!!!!!!!!!//
	
	/// === 메소드 오버라이딩 === (=== 메소드 재정의 ===) *******
	@Override  // @를 이노테이션(애노테이션) 이라고 부른다.
			   //  Override 이노테이션(애노테이션)은 부모클래스로 부터 상속받은 메소드의 내용물을 싹 바꿀때 쓰이는 것이다.
	
	// 메소드 오버라이딩(메소드 재정의)시 접근제한자는 부모클래스의 접근제한자와 같거나 커야한다.
	// 리턴 타입도 같아야 한다.
	public void setName(String name) {
	
		//System.out.println("@@@@@@@@[확인용] 이것은 이 setName메소드는 Company 클래스에서 오버라이딩 한것입니다.\n");
		
		if(name != null && !name.trim().isEmpty())	// 이름이 null이 아니고 공백이 아니라면
		{
			super.input_name(name);  			// 부모클래스의 Name을 불러온다. 
												// 즉 부모로부터 받아온것을 바꾸기 위해 
		}
		else			// 이름이 공백이나 null이면 
		{
			System.out.println("[경고] 회사명은 공백만으로는 안됩니다.\n");
		}
	}
	/// ==== 메소드의 오버로딩 ==== ///
	//1번
	public void test1()  {
		System.out.println("헤헤헤헤");
	}

	//2번
	// 파라미터가 다르기 때문에 다른 메소드로 본다.
	public void test1(int no) {
		System.out.println("superman");
	}

	//3번
	public void test1(int a, int b) {
		System.out.println("하하하호호호호");
	}

	//4번 
	//파라미터가 다르기 때문에 다른 메소드이다.
	public void test1(String a, int b) {
		System.out.println("java");
	}

	//5번
	public void test1(String str, byte num) {
		System.out.println("java");
	}
	/*
		//6번
		public void test1(byte str, String b) {
			System.out.println("자바");
		}

		//7번 
		// 6번과 7번 리턴타입과 관계없이 파라미터가 같으면 같은 메소드인것이다.
		public String test1(byte str, String b) {
			return "이클립스";
		}
		//8번
		protected void test1(String abc, byte no3) {
		System.out.println("java");
		}
	 */

	//위의 세개의 메소드는 중복된 것이다. 
	//왜냐하면 메소드의 오버로딩은 리턴타입과는 관계가 없고 오로지 메소드명과 메소드의 파라미터만 따지기 때문이다.

	
	//메소드 오버라이딩 (재정의)
	@Override
	public String toString() {
		
		// 회사명    업종    사업자등록번호        자본금
		DecimalFormat df = new DecimalFormat("#,###");		// 3자리마다 콤마 추가 
		
		return super.getName() + "\t" + jobType + "\t" + business_number + "\t" + df.format(seedMoney) + "원";
		
	}
	
	
}
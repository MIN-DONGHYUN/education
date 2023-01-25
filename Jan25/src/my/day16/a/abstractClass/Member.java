package my.day16.a.abstractClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public abstract class Member {   // 미완성 메소드(== 추상 메소드)를 가지는 클래스는 반드시 미완성 클래스로 되어야 한다.
	
	// field 생성 (집합으로 말하면 교집합이다 company와 gujikja 클래스에서 똑같이 받음)
	private String id;	// 아이디
	private String passwd;	// 비밀번호
	private String name;	// 성명(개인성명, 회사명)
	private String register_day; 	// 가입 일자를 넣어줄것이다.
	
	static int count;		//Gujikja 객체(인스턴스) 및 Company 객체(인스턴스)의 개수를 알아오려는 용도
	
	//기본생성자는 생략되어 있다.
	// 기본 생략자
	public Member() 
	{
		//System.out.println(">>> 확인용 부모클래스인 Member 클래스 생성자 호출됨 !!");
		
		Date now = new Date();		// 현재시간을 알려주는 것이다.
		
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");	// 몇년 몇월 몇일 시각 표시를 새로 설정
		
		register_day = sdfmt.format(now);		// 시간을 출력해주는 것을 register_day의 필드에 넣어준다. 

	}
	
	
	// method 생성
	public String getId() {
		return id;
	}
	// method 생성
	public void setId(String id) {
		if(id != null && !id.trim().isEmpty())		//입력받은 유저 아이디가 null이 아닐때 그리고 유저 아이디가 텅 비어있지 않는다면 
		{
			this.id = id;	// 지역변수 id에 id를 넣어준다.
		}
		else
		{
			System.out.println(">>[경고] 아이디는 공백이 아닌 글자로 입력하셔야 합니다.<<\n");
		}
	}
	// method 생성
	public String getPasswd() {
		return passwd;
	}
	// method 생성
	public void setPasswd(String passwd) {
		if(MyUtil.isCheckPassed(passwd))		 //패스워드 검사가 조건이 참이라면 true 거짓이라면 false 
		{
			this.passwd = passwd;	// 지역변수 passwd 필드에 passwd를 넣어준다.
		}
		else
		{
			System.out.println(">>[경고] 비밀번호는 8글자 이상 18글자 이하의 대,소문자,숫자, 특수문자가 혼합되어야만 한다.<<\n");
		}
	}
	// method 생성
	public String getName() {
		return name;
	}	
	// method 생성
	public void setName(String name) {
		//name 에는 한글만 허용하겠다.

		//System.out.println("======[확인용] 이 setNAme 메소드는 부모인 Member 클래스에서 생성한 것입니다.\n");
		
		if(name != null)			// 이름이 null이 아닐때만  
		{
			// 정규표현식(Regular Expression)이란?
			// ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어

			// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //

			Pattern p = Pattern.compile("^[가-힇]{2,5}$");		// 가부터 힇까지 한글만 하도록 패턴을 설정 
			//^은 시작을 의미한다.
			//$는 끝을 의미한다.
			//[]는 글자 1개가 들어오는 것을 의미한다.
			//{}는 최소 몇글자 입력하고 최대 몇글자 입력할 수 있을지 말한다.
			// 즉 {2,5}은 반복되어지는 회수를 말하는데 2번 또는 3번 또는 4번 또는 5번 까지를 허용한다는 말이다.

			// == 2. 검사할 문자열이 주어진 정규식 패턴과 일치하는지 아닌지를 판별하는 객체를 생성한다. == //
			Matcher m = p.matcher(name);

			// == 3. 검사할 문자열을 판별하도록 한다. == //
			//입력받은 jubun 이 주어진 정규식 패턴과 일치하면 true, 일치하지 않으면 false를 리턴시켜준다.
			boolean bool = m.matches();   //return은 boolean타입이다.

			if(bool)		// bool이 참이라면 
			{
				this.name = name;		// 필드에 넣는다.
			}
			else
			{
				System.out.println(">>성명은 공백 없이 한글로만 2글자 ~ 5글자 이내로만 가능합니다. << \n");
			}

		}
		else						// 이름이 null일 경우 !!
		{
			System.out.println("[경고] 성명은 필수로 공백이 아닌 것으로 입력하셔야 합니다. \n");
		}
	}
	// method 생성
	public String getRegister_day() {
		return register_day;
	}

	// method 생성
	public void input_name(String name)
	{
		this.name = name;
	}
	
	// == 구직자(Gujikja) 또는 구인회사(Company)의 정보를 보여주는 미완성 메소드 (추상 메소드) 생성하기 ===
	public abstract String view_info();
	
	
}

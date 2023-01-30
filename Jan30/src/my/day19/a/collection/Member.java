package my.day19.a.collection;

import java.text.SimpleDateFormat;
import java.util.Date;


import my.util.MyUtil;

public abstract class Member implements InterMember{   // 미완성 메소드(== 추상 메소드)를 가지는 클래스는 반드시 미완성 클래스로 되어야 한다.
	
	// field 생성 (집합으로 말하면 교집합이다 company와 gujikja 클래스에서 똑같이 받음)
	private String id;	// 아이디
	private String passwd;	// 비밀번호
	private String name;	// 성명(개인성명, 회사명)
	private String register_day; 	// 가입 일자를 넣어줄것이다.
	
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
	
	// public을 사용하면 interMember에서 void setName(String name);과 오류가 나지 않지만 우리는 setName_2로 새롭게 메소드를 생성한다.
	protected void setName_2(String name) {
		this.name = name;
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

}

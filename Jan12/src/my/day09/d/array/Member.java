package my.day09.d.array;

public class Member {

	// 인스턴스 field
	String id;
	String passwd;
	String name;
	int point;
	
	//static fieid(스테틱 필드) 배열안에 null때문에 오류가 나면 static을 사용
	// count라는 필드는 인스턴스 객체를 사용해야만 쓸 수 있다.
	static int count;  // 처음에는 값 0 
	
	//method
	// 특정 사용자의 개인 정보를 보여주도록 하는 메소드 
	public String showMyInfo() {
		
		return "1. 아이디 : " + id + "\n"
			 + "2. 비밀번호 : " + passwd + "\n"
			 + "3. 성명 : " + name + "\n"
			 + "4. 포인트 : " + point;
	}

	//모든 사용자의 비밀번호를 제외한 개인정보를 보여주도록 하는 메소드 
	public String showInfo() {
		return id + "\t" + name + "\t" + point;
	}
}

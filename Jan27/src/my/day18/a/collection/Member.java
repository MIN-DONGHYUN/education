package my.day18.a.collection;

public class Member {

	//field
	String id;
	String passwd;
	String name;
	
	// 기본생성자 
	public Member() {}
	
	public Member(String id, String passwd, String name) {
		//super();      //이거 없어도 부모클래스를 호출함 
		this.id = id;
		this.passwd = passwd;
		this.name = name;
	}
	
	public void infoPrint() {
		System.out.println("== " + name + "님의 회원정보 == \n"
						+ "1. 아이디 : " + id + "\n"
						+ "2. 암호 : " + passwd + "\n"
						+ "3. 성명 : " + name + "\n");
		
	}

}

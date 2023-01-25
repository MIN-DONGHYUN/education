package my.day16.b.superConstructor;

public class Child extends Parent{

	//field
	String name;

	//기본생성자
	public Child() {
		super();	// 이것이 생략되더라도 super();를 항상 불러온다.
					// super()는 부모클래스의 기본생성자를 말하는 것이다.
					// 부모클래스의 기본생성자를 생략하더라도 무조건 호출 되어진다.
		
		name = "엄정화";
		System.out.println("=== 확인용 child클래스의 기본생성자 호출함 ===");
		
	}
	
	//method
	void childInfo() {
		
		System.out.println("아이디 : " + super.id + "\n"
						+ "암 호 : " + this.passwd + "\n"
						+ "성 명 : " + name);
	}
	
	
}

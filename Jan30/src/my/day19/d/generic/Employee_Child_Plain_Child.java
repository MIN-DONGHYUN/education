package my.day19.d.generic;

public class Employee_Child_Plain_Child extends Employee_Child_Plain {
// 부모 클래스는 Employee_Child_Plain 이다.
	
	int month;   // 계약기간 개월 수 

	// 기본생성자 
	public Employee_Child_Plain_Child() {}
	
	// 생성자 생성 
	public Employee_Child_Plain_Child(String userid, String passwd, String name, String jik, int salary , int month) {
		super(userid, passwd, name, jik, salary);				// 부모클래스의 생성자를 부른다.
		this.month = month;
	}

	@Override
	public String toString() {
		return super.toString() 
				+"6. 계약 개월수 : " + month + "개월\n";
	}
}

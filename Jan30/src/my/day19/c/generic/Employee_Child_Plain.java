package my.day19.c.generic;

public class Employee_Child_Plain extends Employee {

	int salary;      // 연봉 

	//기본생성자 
	public Employee_Child_Plain() {}
	
	//파라미터가 있는 생성자를 만들었다.(5개 파라미터)
	public Employee_Child_Plain(String userid, String passwd, String name, String jik, int salary) {
		super(userid, passwd, name, jik);		// 부모클래스인 Employee 이다.(파라미터 있는 생성자를 호출)	부모클래스 필드에 다 넣어줌 
		this.salary = salary;		// 자기 클래스의 cardNo에 넣어줌 
	}

	@Override
	public String toString() {
		return "== 일반직원 ==\n"
			 + super.toString()  			//부모클래스의 toString을 호출 
			 + "5. 연봉 : " + salary + "만원\n";
	}
}

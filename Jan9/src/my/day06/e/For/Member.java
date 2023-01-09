package my.day06.e.For;

public class Member {

	String userid;     // userid 선언
	String passwd;		// 암호 선언
	String name;   // name 선언
	
	
	void showInfo() {			// 출력을 위해 MemberMain값에 출력
		System.out.println("\n ===" + name + "님릐 회원정보 ===\n"
									+ "1. 아이디 : " + userid + "\n"
									+ "2. 성명 : " + passwd + "\n"
									+ "3. 병명 : " + name + "\n"
				);
	}
}

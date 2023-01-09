package my.day06.a.If;

public class Member {

	String id;     // id선언
	String name;   // name 선언
	String nickName;	// 닉네임 선언
	
	void showInfo() {			// 출력을 위해 MemberMain값에 출력
		System.out.println("\n ===" + name + "님릐 회원정보 ==="
									+ "1. 아이디 : " + id + "\n"
									+ "2. 성명 : " + name + "\n"
									+ "3. 병명 : " + nickName + "\n"
				);
	}
}

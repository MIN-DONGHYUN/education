package my.day17.d.exceptionThrows;

public class Member {

	//field 
	String name;
	String kor;			//국, 영, 수 점수 String으로 받아옴 
	String eng;
	String math;
	
	//method
	void info() throws Exception  {//자바에서 어떤 오류이든 이것으로 오류가 있다고 할 수 있다.
	// 원래는 info() 메소드내에서 익셉션 처리를 해야 하지만
	// 여기서는 info() 메소드 다음에 throws Exception 을 썼으므로
	// info() 메소드내에서 익셉션 처리를 하지 않고 
	// info() 메소드를 호출하는 쪽에서  Exception 을 처리해라는 뜻이다. 

		int n_kor = Integer.parseInt(kor);		//문자열을 숫자로 변경 
		int n_eng = Integer.parseInt(eng);
		int n_math = Integer.parseInt(math);
		
		int total = n_kor + n_eng + n_math;		// 총 점수를 나타냄
		
		String info = "1. 학생명 : " + name + "\n"	// 출력하기 위해 세팅함 
				    + "2. 국어 : " + kor + "점\n" 
				    + "3. 영어 : " + eng + "점\n" 
				    + "4. 수학 : " + math + "점\n"
					+ "5. 총점 : " + total + "점\n";
		
		System.out.println(info);				// 출력
	}
	
}

package my.day05.a.scanner;

public class Sungjuk {

	String hakbun;    // 학번 "091234"  숫자로 되어 있어도 맨앞 0이 들어갈 수 있으므로 String 사용
	String name;      // 성명
	byte kor;         // 국어  byte는 -128 ~ 127         0~100 로 제한 
	byte eng;         // 영어  byte는 -128 ~ 127         0~100 로 제한
	byte math;        // 수학  byte는 -128 ~ 127         0~100 로 제한
	short age;        // 나이  short -32768 ~ 32767 까지          20~50 로 제한   
	
	//public Sungjuk() { }  // 기본 생성자를 뜻한다. 기본 생성자는 안적더라도 생략이 되어있음 
		
	// 메소드 생성
	// 입력받은 점수가 0 ~ 100 사이의 정수인지 아닌지를 판결해주는 메소드를 생성한다.
	boolean checkJumsu(byte jumsu) {
		 
		if(0 <= jumsu && jumsu <= 100 ) {   // 0과 100 사이의 값을 가진다면 
			return true;  // 메소드에서 return을 만나면 메소드 실행이 종료가 된다.
		}// end of if
		else {    // 음수 또는 100보다 크다면 
			System.out.println("### 정수 입력은 0이상 100까지만 가능합니다. ###");
			return false;
		}// end of else
		
	}// end of boolean checkJumsu
	
	// 입력받은 나이가 20 ~ 50 사이의 나이인지 아닌지를 판결해주는 메소드를 생성한다.
	boolean checkAge(short age) {
		
		if( 20 <= age && age <=50 ) {
			return true;
		} //end of if
		
		else {
			System.out.println("### 나이 입력은 20이상 50까지 가능합니다. ###");
			return false;
		} //end of else	
	}
	
	//입력되어진 필드값을 화면에 출력해주는 메소드 생성하기 
	void ShowInfo() {
		
		System.out.println("\n=== \"" + name + "\"님의 성적결과 ===" );	
		
		short result = (short)(kor + eng + math); 
		float avg = result/3.0F;
		String hakjum = "";
		
		if(avg >= 90) {
			hakjum = "A";
		}
		else if(avg >= 80)
		{
			hakjum = "B";
		}
		else if(avg >= 70)
		{
			hakjum = "C";
		}
		else 
		{
			hakjum = "D";
		}
		
		
		System.out.println("1. 학번 : " + hakbun + "\n" 
				       + "2. 성명 : " + name + "\n"
				       + "3. 국어 : " + kor + "\n" 
				       + "4. 영어 : " + eng + "\n"
				       + "5. 수학 : " + math + "\n" 
				       + "6. 총점 : " + result + "\n"
				       + "7. 평균 : " + avg + "\n" 
				       + "8. 학점 : " + hakjum + "\n"
				       + "9. 나이 : " + age + "\n" 
				       );
	
	}
	
}

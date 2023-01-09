package my.day06.b.Switch;

public class Sungjuk {
	
	String hakbun;  // 학번 "091234"
	String name;    // 성명
	byte kor;   //국어  byte -128~ 127임  우리는 0~100으로 제한 할 것임
	byte eng;   //영어
	byte math;  //수학

	//public Sungjuk() {} // 기본생성자 생략되어 있음
	
	// 입력받은 점수가 0에서 100사이의 정수인지 아닌지를 판별해주는 메소드 생성하기 
	boolean checkJumsu(byte jumsu) {  // boolean으로 점수가 0~100사이이면 true 아니면 false
		
		if(0 <= jumsu && jumsu <= 100)			//점수가 0이상 100이하라면
		{
			return true;						//boolean값을 true로 돌려준다.
		}
		else									// -128 ~ -1, 101 ~ 127일때
		{
			System.out.println("### 점수 입력은 0이상 100 까지만 가능합니다. ###"); 
			return false;						//boolean값을 false로 돌려준다.
		}
		
	} // end of boolean checkJumsu(byte jumsu)
	
	//성적정보를 화면에 출력해주는 메소드 생성하기
	void showInfo() {
		
		short total = (short)(kor + eng + math); //byte가 사칙연산을 받으면 int로 변경됨  "269"
		float avg = Math.round(total/3.0F * 10)/10.0F;	// total/3.0이면 double형 타입임, total/3.0F이면 float타입 "89.6666667"
		// 평균을 반올림하여 정수값으로 맞추고 싶다면 
		//*10을 하고 Math.round를 사용한다. 그리고 원상태로 복귀 위해 나누기 10.0F---> 89.666667 -> 896.66667 -> Math.round -> 897 -> 89.7
		// 소수부 첫째자리가지만 보여주는 것 이다.
		
		
		String hakjum = "";					// 학점이란 변수 설정 
		if(avg >= 90)						// 평균이 90이상이라면 
		{
			hakjum = "A";
		}
		else if(avg >= 80)					// 평균이 80이상이라면 
		{
			hakjum = "B";
		}
		else if(avg >= 70)					// 평균이 70이상이라면 
		{
			hakjum = "C";
		}
		else if(avg >= 60)					// 평균이 60이상이라면 
		{
			hakjum = "D";
		}
		else								// 평균이 60미만이라면 
		{
			hakjum = "F";
		}
		
		//학점에 따라서 선물을 주고싶다.
		// 학점이 "A라면 "놀이공원이용권, 치킨, 피자, 아이스크림"
		// 학점이 "B라면 "치킨, 피자, 아이스크림"
		// 학점이 "C라면 "피자, 아이스크림"
		// 학점이 "D라면 "아이스크림"
		// 학점이 "F라면 "꿀밤 3대"
		
		String gift = "";
		
		switch (hakjum) {		//switch()속애 들어올수 있는 타입은 byte, short, int, char, String만 가능하다.
		case "A":
			gift += "놀이공원이용권,"; // 같다. == gift = gift + "놀이공원이용권";
		
		case "B":
			gift += "치킨,"; // 같다. == gift = gift + "치킨";

		case "C":
			gift += "피자,"; // 같다. == gift = gift + "피자";
			
		case "D":
			gift += "아이스크림"; // 같다. == gift = gift + "아이스크림";
			break;		//break가 이제 있으므로 학점 A는 학점 D까지 출력을 한 후에 나갈수 있다. 
			
		default:			//학점이 A,B,C,D 가 아니라면 
			gift += "꿀밤 3대"; // 같다. == gift = gift + "꿀밤 3대";
			break;		//switch문 탈출 !
		}
		
		
		System.out.println("\n===" + name+ "님의 성적결과 ===\n"			//출력 
								   + "1. 학번 :" + hakbun + "\n"
								   + "2. 성명 :" + name + "\n"
								   + "3. 국어 :" + kor + "\n"
								   + "4. 영어 :" + eng + "\n"
								   + "5. 수학 :" + math + "\n"
								   + "6. 총점 :" + total + "\n"
								   + "7. 평균 :" + avg + "\n"
								   + "8. 학점 :" + hakjum + "\n"
								   + "9. 선물 :" + gift + "\n"
				);
		
		
	}// end of void showInfo
}

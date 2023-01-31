package my.day20.c.NoEnum;

import java.util.Calendar;

public class Member_1 {

	private String name;
	private String jubun;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJubun() {
		return jubun;
	}
	public void setJubun(String jubun) {
		this.jubun = jubun;
	}
	
	public int getAge() {
		
		Calendar currentDate = Calendar.getInstance();  // 현재 날짜와 시간을 얻어온다.
		int currentYear = currentDate.get(Calendar.YEAR); 	// 연도를 뽑아서 currentyear에 저장 
		
		String gender = jubun.substring(6);   // " 9710201" , "9601312" , "1010213" , "0112264"
		// 주민 번호 필드에서 6번째 인덱스부터 끝까지 나타낸다. "1","2","3","4"
		
		int birthYear = 0; 		// 변수 설정
		
		switch (gender) { 		// gender의 값을 받아와서 switch문을 돌린다.
			case "1": 		//1,2일때 2000년대 이전 출생
			case "2":
				birthYear = 1900 + Integer.parseInt(jubun.substring(0, 2));
				
				break;
			case "3":		// 3,4일때 2000년대 출생 
			case "4":
				birthYear = 2000 + Integer.parseInt(jubun.substring(0, 2));
				
				break;
		} // end of switch
		
		return currentYear - birthYear +1; 	// 현재 나이가 나온다.
	
		}
		
		@Override
		public String toString() {
			return "1.성명 : " + name +"\n"
				+  "2.주민번호 : " + jubun + "\n"
				+  "3.현재나이 : " + getAge() + "세";
		
		
		
	}
}

package my.day20.d.Enum;

import java.util.*;

public class Main_3 {

	public static void main(String[] args) {
		
		Member_1 mbr1 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
		mbr1.setName("어린이");
		mbr1.setJubun("2201314");
		
		Member_1 mbr2 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
		mbr2.setName("청소년");
		mbr2.setJubun("1002274");
		
		Member_1 mbr3 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
		mbr3.setName("성년");
		mbr3.setJubun("8903052");
		
		Member_1 mbr4 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
		mbr4.setName("어르신");
		mbr4.setJubun("4507181");

		// 리스트 사용 <제네릭에는 내가 쓸것>
		List<Member_1> mbrList = new ArrayList<>();
		mbrList.add(mbr1);  	// 추가
		mbrList.add(mbr2);
		mbrList.add(mbr3);
		mbrList.add(mbr4);
		
		for(Member_1 mbr : mbrList) // 확장 for문
		{
			System.out.println(mbr);
			//또는 
			//System.out.println(mbr.toString());
			
			int age = mbr.getAge();  // 나이를 age에 저장 
			EntranceFee_2 fee = null;  // 요금을 받기 위해 설정 
			
			if(age < 10)
			{
				// Static으로 받아왔던 CHILD를 받아옴 
				fee = EntranceFee_2.CHILD; 		// 아이의 요금을 fee에 넣는다.
			}
			else if(10 <= age && age < 20)
			{
				// Static으로 받아왔던 TEENAGER를 받아옴 
				fee = EntranceFee_2.TEENAGER; 		// 청소년의 요금을 fee에 넣는다.
			}
			else if(20 <= age && age < 70)
			{
				// Static으로 받아왔던 ADULT를 받아옴 
				fee = EntranceFee_2.ADULT; 		// 성년의 요금을 fee에 넣는다.
			}
			else
			{
				// Static으로 받아왔던 OLD를 받아옴 
				fee = EntranceFee_2.OLD; 		// 어르신의 요금을 fee에 넣는다.
			}
			System.out.println("4. 입장료 : " + fee.getFee() + "원");
			System.out.println("5. 기념품 : " + fee.getGoods() + "\n");
			
		}// end of for 
		/*
			1.성명 : 어린이
			2.주민번호 : 2201314
			3.현재나이 : 2세
			4. 입장료 : 0원
			5. 기념품 : 과자_2
			
			1.성명 : 청소년
			2.주민번호 : 1002274
			3.현재나이 : 14세
			4. 입장료 : 150원
			5. 기념품 : 브로마이드_2
			
			1.성명 : 성년
			2.주민번호 : 8903052
			3.현재나이 : 35세
			4. 입장료 : 300원
			5. 기념품 : USB_2
			
			1.성명 : 어르신
			2.주민번호 : 4507181
			3.현재나이 : 79세
			4. 입장료 : 100원
			5. 기념품 : 홍삼_2
		*/
		
		
	}// end of main

}

package my.day20.e.Enum;

import java.text.DecimalFormat;
import java.util.*;

public class Main_3 {

	public static void main(String[] args) {
		
		// 리스트 사용 <제네릭에는 내가 쓸것>
		List<Member_1> mbrList = new ArrayList<>();
		
		for(int i = 0; i <10; i++) 	// 10명만 받아오자 
		{
			Member_1 mbr1 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr1.setName("어린이"+(i+1));
			mbr1.setJubun("2201314");
			mbrList.add(mbr1);  	// 추가
			
			Member_1 mbr2 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr2.setName("청소년"+(i+1));
			mbr2.setJubun("1002274");
			mbrList.add(mbr2);
			
			Member_1 mbr3 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr3.setName("성년"+(i+1));
			mbr3.setJubun("8903052");
			mbrList.add(mbr3);
			
			Member_1 mbr4 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr4.setName("어르신"+(i+1));
			mbr4.setJubun("4507181");
			mbrList.add(mbr4);
			
		}//end of for
		
		// 모든 사람들을 0으로 초기화 선언
		int child_cnt =0, teenager_cnt = 0, adult_cnt =0, old_cnt=0;
		
		for(Member_1 mbr : mbrList) // 확장 for문
		{
			if(mbr.getAge() < 10)
			{
				child_cnt++;
			}
			else if(mbr.getAge() < 20)
			{
				teenager_cnt++;
			}
			else if(mbr.getAge() < 70)
			{
				adult_cnt++;
			}
			else
			{
				old_cnt++;
			}
		}// end of for
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		// 어린이 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("어린이 총 인원수 %d명, 총입장료 %s원, 기념품 %s %d개 \n"
				, child_cnt
				, df.format(EntranceFee_2.CHILD.getRealFee(child_cnt))
				, EntranceFee_2.CHILD.getGoods()
				, child_cnt );

		// 청소년 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("청소년 총 인원수 %d명, 총입장료 %s원, 기념품 %s %d개 \n"
				, teenager_cnt
				, df.format(EntranceFee_2.TEENAGER.getRealFee(teenager_cnt))
				, EntranceFee_2.TEENAGER.getGoods()
				, teenager_cnt );

		// 성년 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("성년 총 인원수 %d명, 총입장료 %s원, 기념품 %s %d개 \n"
				, adult_cnt
				, df.format(EntranceFee_2.ADULT.getRealFee(adult_cnt))
				, EntranceFee_2.ADULT.getGoods()
				, adult_cnt );

		// 어르신 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("어르신 총 인원수 %d명, 총입장료 %s원, 기념품은 %s %d개 \n"
				, old_cnt
				, df.format(EntranceFee_2.OLD.getRealFee(old_cnt))
				, EntranceFee_2.OLD.getGoods()
				, old_cnt );
		
		/*
			어린이 총 인원수 10명, 총입장료 0원, 기념품은 과자_2 10개 
			청소년 총 인원수 10명, 총입장료 1,500원, 기념품은 브로마이드_2 10개 
			성년 총 인원수 10명, 총입장료 3,000원, 기념품은 USB_2 10개 
			어르신 총 인원수 10명, 총입장료 1,000원, 기념품은 홍삼_2 10개 
		*/
		
		System.out.println("\n~~~~~~~~~~~~30명이라면~~~~~~~~~~~~~~~~~~~\n");
		
		
		mbrList.clear();		// 리스트 초기화 mbrList에 저장된 모든 객체를 삭제하는 것이다.
		

		for(int i = 0; i <30; i++) 	// 30명만 받아오자 
		{
			Member_1 mbr1 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr1.setName("어린이"+(i+1));
			mbr1.setJubun("2201314");
			mbrList.add(mbr1);  	// 추가
			
			Member_1 mbr2 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr2.setName("청소년"+(i+1));
			mbr2.setJubun("1002274");
			mbrList.add(mbr2);
			
			Member_1 mbr3 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr3.setName("성년"+(i+1));
			mbr3.setJubun("8903052");
			mbrList.add(mbr3);
			
			Member_1 mbr4 = new Member_1(); 	// Member에는 기본생성자가 생략되어 있으므로 가능하다.
			mbr4.setName("어르신"+(i+1));
			mbr4.setJubun("4507181");
			mbrList.add(mbr4);
			
		}//end of for
		
		// 모든 사람들을 0으로 초기화 선언
		child_cnt =0;
		teenager_cnt = 0;
		adult_cnt =0;
		old_cnt=0;
		
		for(Member_1 mbr : mbrList) // 확장 for문
		{
			if(mbr.getAge() < 10)
			{
				child_cnt++;
			}
			else if(mbr.getAge() < 20)
			{
				teenager_cnt++;
			}
			else if(mbr.getAge() < 70)
			{
				adult_cnt++;
			}
			else
			{
				old_cnt++;
			}
		}// end of for
		
		
		
		// 어린이 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("어린이 총 인원수 %d명, 총입장료 %s원, 기념품 %s %d개 \n"
				, child_cnt
				, df.format(EntranceFee_2.CHILD.getRealFee(child_cnt))
				, EntranceFee_2.CHILD.getGoods()
				, child_cnt );

		// 청소년 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("청소년 총 인원수 %d명, 총입장료 %s원, 기념품 %s %d개 \n"
				, teenager_cnt
				, df.format(EntranceFee_2.TEENAGER.getRealFee(teenager_cnt))
				, EntranceFee_2.TEENAGER.getGoods()
				, teenager_cnt );

		// 성년 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("성년 총 인원수 %d명, 총입장료 %s원, 기념품 %s %d개 \n"
				, adult_cnt
				, df.format(EntranceFee_2.ADULT.getRealFee(adult_cnt))
				, EntranceFee_2.ADULT.getGoods()
				, adult_cnt );

		// 어르신 수와 어린이의 총 입장료를 나타낸다.
		System.out.printf("어르신 총 인원수 %d명, 총입장료 %s원, 기념품은 %s %d개 \n"
				, old_cnt
				, df.format(EntranceFee_2.OLD.getRealFee(old_cnt))
				, EntranceFee_2.OLD.getGoods()
				, old_cnt );
		/*
			어린이 총 인원수 30명, 총입장료 0원, 기념품 과자_2 30개 
			청소년 총 인원수 30명, 총입장료 3,600원, 기념품 브로마이드_2 30개 
			성년 총 인원수 30명, 총입장료 8,100원, 기념품 USB_2 30개 
			어르신 총 인원수 30명, 총입장료 2,100원, 기념품은 홍삼_2 30개 
		*/
		
	}// end of main

}

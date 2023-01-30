package my.day19.collection18.copy18;

import java.util.*;

/*
== HashSet == 
1. 출력시 저장된 순서가 유지되지 않는다.
2. 중복된 데이터를 저장할 수 없다.
          그러므로 Collection 내의 중복된 요소들을 저장하지 않고자 할때 많이 사용된다.
          
== LinkedHashSet ==
1. 출력시 저장된 순서가 유지된다.
2. 중복된 데이터를 저장할 수 없다.
          그러므로 Collection 내의 중복된 요소들을 저장하지 않고자 할때 많이 사용된다.        
*/

public class Set_main_5 {
	
	public static void main(String[] args) {
		
		System.out.println("\n ==== Hashset ==== \n");
		
		// 1. Member 클래스의 객체만을 저장할 수 있는 Hashset객체 mbrHashset을 생성하기 
		Set<Member> mbrHashSet = new HashSet<>(); 			// Set에 Member만 받겠다.
		
		//2. Member 클래스의 객체 6개를 생성하여 mbrList에 저장하세요
		mbrHashSet.add(new Member("youjs", "qwer1234$", "유재석"));
		mbrHashSet.add(new Member("eom","qwer1234$","엄정화"));
		mbrHashSet.add(new Member("kanghd","qwer1234$","강호동"));
		mbrHashSet.add(new Member("leess","qwer1234$","이순신"));
		//mbrHashSet.add(new Member("kimth","qwer1234$",null));
		mbrHashSet.add(new Member("kimth","qwer1234$","김태희"));
		mbrHashSet.add(new Member("kangkc","qwer1234$","강감찬"));
		
		
		// 3. mbrHashSet 에 저장되어진 모든 Member 들의 정보를 출력한다.
		// Set계열은 저장된 데이터 (요소)에 접근해서 읽어오기 위해서는 Iterator를 통해서만 가능하다.
		
		Iterator<Member> it = mbrHashSet.iterator();  // return 타입은 Member 
		//Iterator는 저장소가 아니라 Collection에 저장되어진 요소(Element)를 읽어오는 용도로 사용한다.
		
		while(it.hasNext()) {
			// it.hasNext 는 it에서 현재 it가 가지고 있는 여러 Member 데이터중 하나를 끄집어 내서 존재하는지 알아보는 것이다.
			// 존재하면 true, 존재하지 않으면 false.
			
			Member mbr = it.next();		// Member이고 boolean타입
			// 실제로 Member를 it에서 끄집어 낸다.
			// 그러면 끄집어 낸 Member 는 더 이상 it 에는 남아있지 않게 된다.
			
			mbr.infoPrint(); 		// 한명씩 출력을 해보자 			
		}// end of while
		/*  출력시에는 순서가 유지되지 않는다.
		 	==== Hashset ==== 
	
			== 강호동님의 회원정보 == 
			1. 아이디 : kanghd
			2. 암호 : qwer1234$
			3. 성명 : 강호동
			
			== 강감찬님의 회원정보 == 
			1. 아이디 : kangkc
			2. 암호 : qwer1234$
			3. 성명 : 강감찬
			
			== 김태희님의 회원정보 == 
			1. 아이디 : kimth
			2. 암호 : qwer1234$
			3. 성명 : 김태희
			
			== 유재석님의 회원정보 == 
			1. 아이디 : youjs
			2. 암호 : qwer1234$
			3. 성명 : 유재석
			
			== 엄정화님의 회원정보 == 
			1. 아이디 : eom
			2. 암호 : qwer1234$
			3. 성명 : 엄정화
			
			== 이순신님의 회원정보 == 
			1. 아이디 : leess
			2. 암호 : qwer1234$
			3. 성명 : 이순신
		*/

		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 4. mbrHashSet 에 중복된 데이터를 입력해봅시다.
		// Set 계열은 중복된 데이터를 저장할 수 없다.
		mbrHashSet.add(new Member("leess", "qwer1234$", "이순신"));
		
		it = mbrHashSet.iterator();			// 키 값을 돌려준다.
		
		while(it.hasNext()) {

			Member mbr = it.next();		// Member이고 boolean타입
			System.out.println(mbr); 		// 한명씩 출력을 해보자 			
		}// end of while
		
		/*
		my.day19.collection.Member@7852e922
		my.day19.collection.Member@5c647e05
		my.day19.collection.Member@33909752
		my.day19.collection.Member@70dea4e
		my.day19.collection.Member@15db9742
		my.day19.collection.Member@6d06d69c
		my.day19.collection.Member@4e25154f
		==> 7개 저장 
		*/
				
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Member mbr1 = new Member("suji", "qwer1234$", "수지");
		Member mbr2 = mbr1;   // mbr1과 mbr2는 동일한 메모리 주소를 가지므로 동일한 것이다.
		
		mbrHashSet.add(mbr1);
		mbrHashSet.add(mbr2);
		
		it = mbrHashSet.iterator();			// 키 값을 돌려준다.
		
		while(it.hasNext()) {

			Member mbr = it.next();		// Member이고 boolean타입
			System.out.println(mbr); 		// 한명씩 출력을 해보자 			
		}// end of while
		
		/*
			my.day19.collection.Member@7852e922
			my.day19.collection.Member@5c647e05
			my.day19.collection.Member@33909752
			my.day19.collection.Member@70dea4e
			my.day19.collection.Member@15db9742
			my.day19.collection.Member@6d06d69c
			my.day19.collection.Member@4e25154f
			my.day19.collection.Member@55f96302
			==> 8개 저장
		*/
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 5. mbrHashSet에 저장되어진 회원(Member)를 중에 id가 "leess"인 회원의 정보를 출력하세요
		
		it = mbrHashSet.iterator();			// 키 값을 돌려준다.
		
		while(it.hasNext())
		{
			Member mbr = it.next();		// Member이고 boolean타입
			// 실제로 Member를 it에서 끄집어 낸다.
			// 그러면 끄집어 낸 Member 는 더 이상 it 에는 남아있지 않게 된다.
			if("leess".equals(mbr.id))
			{
				mbr.infoPrint(); 		// leess일때만 출력한다.
			}
		}  //end of while
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 6. mbrHashSet에 저장되어진 회원(Member)를 중에 id가 "leess"인 회원의 정보를 삭제하세요
		
		it = mbrHashSet.iterator(); 		// it에 mbrHashSer.iterator에 있습니까??			// 키 값을 돌려준다.
		
		while(it.hasNext())
		{
			Member mbr = it.next();
			if("leess".equals(mbr.id))
			{
				it.remove(); 			//leess을 가지고 있는 id를 삭제해라 
				// mbrHashSet 에 저장된 요소(Element)를 삭제하려면 
				//Iterator 를 이용한 it.remove(); 을 사용하여 삭제한다.
				
			}
		}  //end of while
		
		
		it = mbrHashSet.iterator();
		
		while(it.hasNext())
		{
			Member mbr = it.next();		// Member이고 boolean타입
			// 실제로 Member를 it에서 끄집어 낸다.
			// 그러면 끄집어 낸 Member 는 더 이상 it 에는 남아있지 않게 된다.
			mbr.infoPrint(); 		// leess 없는것을 출력한다.
			
		}  //end of while
		/*
		
			== 강호동님의 회원정보 == 
			1. 아이디 : kanghd
			2. 암호 : qwer1234$
			3. 성명 : 강호동
			
			== 강감찬님의 회원정보 == 
			1. 아이디 : kangkc
			2. 암호 : qwer1234$
			3. 성명 : 강감찬
			
			== 김태희님의 회원정보 == 
			1. 아이디 : kimth
			2. 암호 : qwer1234$
			3. 성명 : 김태희
			
			== 유재석님의 회원정보 == 
			1. 아이디 : youjs
			2. 암호 : qwer1234$
			3. 성명 : 유재석
			
			== 엄정화님의 회원정보 == 
			1. 아이디 : eom
			2. 암호 : qwer1234$
			3. 성명 : 엄정화
			
			== 수지님의 회원정보 == 
			1. 아이디 : suji
			2. 암호 : qwer1234$
			3. 성명 : 수지
		*/
		
		////////////////////////////////////////////////////////////////////////////////////
		
		
		System.out.println("\n ==== LinkedHashset ==== \n\n");
		
		// 1. Member 클래스의 객체만을 저장할 수 있는 LinkedHashset객체 mbrLinkedHashset을 생성하기 
		Set<Member> mbrLinkedHashSet = new LinkedHashSet<>(); 			// Set에 Member만 받겠다.
		
		//2. Member 클래스의 객체 6개를 생성하여 mbrList에 저장하세요
		mbrLinkedHashSet.add(new Member("youjs", "qwer1234$", "유재석"));
		mbrLinkedHashSet.add(new Member("eom","qwer1234$","엄정화"));
		mbrLinkedHashSet.add(new Member("kanghd","qwer1234$","강호동"));
		mbrLinkedHashSet.add(new Member("leess","qwer1234$","이순신"));
		//mbrLinkedHashSet.add(new Member("kimth","qwer1234$",null));
		mbrLinkedHashSet.add(new Member("kimth","qwer1234$","김태희"));
		mbrLinkedHashSet.add(new Member("kangkc","qwer1234$","강감찬"));
		
		
		// 3. mbrLinkedHashSet 에 저장되어진 모든 Member 들의 정보를 출력한다.
		// Set계열은 저장된 데이터 (요소)에 접근해서 읽어오기 위해서는 Iterator를 통해서만 가능하다.
		
		Iterator<Member> it2 = mbrLinkedHashSet.iterator();  // return 타입은 Member 
		//Iterator는 저장소가 아니라 Collection에 저장되어진 요소(Element)를 읽어오는 용도로 사용한다.
		
		while(it2.hasNext()) {
			// it2.hasNext 는 it2에서 현재 it2가 가지고 있는 여러 Member 데이터중 하나를 끄집어 내서 존재하는지 알아보는 것이다.
			// 존재하면 true, 존재하지 않으면 false.
			
			Member mbr = it2.next();		// Member이고 boolean타입
			// 실제로 Member를 it2에서 끄집어 낸다.
			// 그러면 끄집어 낸 Member 는 더 이상 it2 에는 남아있지 않게 된다.
			
			mbr.infoPrint(); 		// 한명씩 출력을 해보자 			
		}// end of while
		/*  출력시에는 저장한 대로 한다.
		 	
			 ==== LinkedHashset ==== 
			
			
			== 유재석님의 회원정보 == 
			1. 아이디 : youjs
			2. 암호 : qwer1234$
			3. 성명 : 유재석
			
			== 엄정화님의 회원정보 == 
			1. 아이디 : eom
			2. 암호 : qwer1234$
			3. 성명 : 엄정화
			
			== 강호동님의 회원정보 == 
			1. 아이디 : kanghd
			2. 암호 : qwer1234$
			3. 성명 : 강호동
			
			== 이순신님의 회원정보 == 
			1. 아이디 : leess
			2. 암호 : qwer1234$
			3. 성명 : 이순신
			
			== 김태희님의 회원정보 == 
			1. 아이디 : kimth
			2. 암호 : qwer1234$
			3. 성명 : 김태희
			
			== 강감찬님의 회원정보 == 
			1. 아이디 : kangkc
			2. 암호 : qwer1234$
			3. 성명 : 강감찬
		*/

		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 4. mbrLinkedHashSet 에 중복된 데이터를 입력해봅시다.
		// Set 계열은 중복된 데이터를 저장할 수 없다.
		mbrLinkedHashSet.add(new Member("leess", "qwer1234$", "이순신"));
		
		it2 = mbrLinkedHashSet.iterator();			// 키 값을 돌려준다.
		
		while(it2.hasNext()) {

			Member mbr = it2.next();		// Member이고 boolean타입
			System.out.println(mbr); 		// 한명씩 출력을 해보자 			
		}// end of while
		
		/*
		my.day19.collection.Member@3d4eac69
		my.day19.collection.Member@42a57993
		my.day19.collection.Member@75b84c92
		my.day19.collection.Member@6bc7c054
		my.day19.collection.Member@232204a1
		my.day19.collection.Member@4aa298b7
		my.day19.collection.Member@7d4991ad

		==> 7개 저장 
		*/
				
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Member mbr3 = new Member("suji", "qwer1234$", "수지");
		Member mbr4 = mbr3;   // mbr3과 mbr4는 동일한 메모리 주소를 가지므로 동일한 것이다.
		
		mbrLinkedHashSet.add(mbr3);
		mbrLinkedHashSet.add(mbr4);
		
		it2 = mbrLinkedHashSet.iterator();			// 키 값을 돌려준다.
		
		while(it2.hasNext()) {

			Member mbr = it2.next();		// Member이고 boolean타입
			System.out.println(mbr); 		// 한명씩 출력을 해보자 			
		}// end of while
		
		/*
			my.day19.collection.Member@3d4eac69
			my.day19.collection.Member@42a57993
			my.day19.collection.Member@75b84c92
			my.day19.collection.Member@6bc7c054
			my.day19.collection.Member@232204a1
			my.day19.collection.Member@4aa298b7
			my.day19.collection.Member@7d4991ad
			my.day19.collection.Member@28d93b30

			==> 8개 저장
		*/
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 5. mbrLinkedHashSet에 저장되어진 회원(Member)를 중에 id가 "leess"인 회원의 정보를 출력하세요
		
		it2 = mbrLinkedHashSet.iterator();			// 키 값을 돌려준다.
		
		while(it2.hasNext())
		{
			Member mbr = it2.next();		// Member이고 boolean타입
			// 실제로 Member를 it에서 끄집어 낸다.
			// 그러면 끄집어 낸 Member 는 더 이상 it 에는 남아있지 않게 된다.
			if("leess".equals(mbr.id))
			{
				mbr.infoPrint(); 		// leess일때만 출력한다.
			}
		}  //end of while
		/*
			 == 이순신님의 회원정보 == 
			1. 아이디 : leess
			2. 암호 : qwer1234$
			3. 성명 : 이순신
			
			== 이순신님의 회원정보 == 
			1. 아이디 : leess
			2. 암호 : qwer1234$
			3. 성명 : 이순신
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// 6. mbrLinkedHashSet에 저장되어진 회원(Member)를 중에 id가 "leess"인 회원의 정보를 삭제하세요
		
		it2 = mbrLinkedHashSet.iterator(); 		// it에 mbrHashSer.iterator에 있습니까??			// 키 값을 돌려준다.
		
		while(it2.hasNext())
		{
			Member mbr = it2.next();
			if("leess".equals(mbr.id))
			{
				it2.remove(); 			//leess을 가지고 있는 id를 삭제해라 
				// mbrHashSet 에 저장된 요소(Element)를 삭제하려면 
				//Iterator 를 이용한 it.remove(); 을 사용하여 삭제한다.
				
			}
		}  //end of while
		
		it2 = mbrLinkedHashSet.iterator();
		
		while(it2.hasNext())
		{
			Member mbr = it2.next();		// Member이고 boolean타입
			// 실제로 Member를 it에서 끄집어 낸다.
			// 그러면 끄집어 낸 Member 는 더 이상 it 에는 남아있지 않게 된다.
			mbr.infoPrint(); 		// leess 없는것을 출력한다.
			
		}  //end of while
		/*
		
			== 유재석님의 회원정보 == 
			1. 아이디 : youjs
			2. 암호 : qwer1234$
			3. 성명 : 유재석
			
			== 엄정화님의 회원정보 == 
			1. 아이디 : eom
			2. 암호 : qwer1234$
			3. 성명 : 엄정화
			
			== 강호동님의 회원정보 == 
			1. 아이디 : kanghd
			2. 암호 : qwer1234$
			3. 성명 : 강호동
			
			== 김태희님의 회원정보 == 
			1. 아이디 : kimth
			2. 암호 : qwer1234$
			3. 성명 : 김태희
			
			== 강감찬님의 회원정보 == 
			1. 아이디 : kangkc
			2. 암호 : qwer1234$
			3. 성명 : 강감찬
			
			== 수지님의 회원정보 == 
			1. 아이디 : suji
			2. 암호 : qwer1234$
			3. 성명 : 수지
		*/

	}	// end of main

}

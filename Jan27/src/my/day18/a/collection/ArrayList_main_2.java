package my.day18.a.collection;

import java.util.*;

/*
== ArrayList == 
1. 출력시 저장된 순서대로 나온다.
2. 중복된 데이터를 저장할 수 있다.
3. 데이터를 읽어오는 속도는 ArrayList 가 LinkedList 보다 상대적으로 빠르다.
4. 순차적으로 데이터를 추가/삭제하는 경우에는 ArrayList 가 LinkedList 보다 상대적으로 빠르다.
5. 일반적인 데이터 추가/삭제는 데이터 중간 중간마다 발생하므로 이러한 경우에는 ArrayList 가 LinkedList 보다 상대적으로 느리다.
6. 결과값은 ArrayList 를 사용하든지 LinkedList 를 사용하든지 동일한 결과값을 가진다.
7. LinkedList 보다는 ArrayList 를 사용하도록 하자.
*/


public class ArrayList_main_2 {

	public static void main(String[] args) {
		
		//1. Member 클래스의 객체만을 저장할 수 있는 ArrayList 객체 mbrList를 생성하세요
		List<Member> mbrList = new ArrayList<>();			// List에 Member만 받겠다.
		
		//2. Member 클래스의 객체 6개를 생성하여 mbrList에 저장하세요
		mbrList.add(new Member("youjs", "qwer1234$", "유재석"));
		mbrList.add(new Member("eom","qwer1234$","엄정화"));
		mbrList.add(new Member("kanghd","qwer1234$","강호동"));
	    mbrList.add(new Member("leess","qwer1234$","이순신"));
	    //mbrList.add(new Member("kimth","qwer1234$",null));
	    mbrList.add(new Member("kimth","qwer1234$","김태희"));
	    mbrList.add(new Member("kangkc","qwer1234$","강감찬"));
	
	    //3. mbrList에 저장되어진 모든 회원들의 정보를 출력하도록 
	    //   member 클래스에 정의된 infoPrint() 메소드를 실행하세요
	    
	    System.out.println(mbrList.size());  //6
	    for(int i=0; i< mbrList.size(); i++)	// size 잘 기억하자 6번 반복
	    {
	    	mbrList.get(i).infoPrint(); 	//mbrList객체를 가져오면서 infoPrint을 수행해라
	    }
	    
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    // 위에꺼와 아래꺼와 같다. for문과 확장 for문 만 다르다.
	    for( Member mbr : mbrList) {		//확장 for문
	    									// mbrList.size() 만큼 반복한다.
	    	mbr.infoPrint();
	    }
	    
	    
	    
	    System.out.println("\n~~~~~~~~~~~~~~[퀴즈1] 확장 for문 ~~~~~~~~~~~~~~\n");
	    
	    /*
	       [퀴즈1]
	       mbrList에 저장되어진 Member 객체 중에서 
	       id 값이 "leess"인 회원만 그 회원의 정보를 출력하세요
	    */
	    for(Member mbr : mbrList)
	    {
	    	if("leess".equals(mbr.id))			// leess과 같은 아이디일대 		
	    	{
	    		mbr.infoPrint();				// 출력
	    	}
	    }
	    
	    
	    //또는
	    System.out.println("\n~~~~~~~~~~~~~~[퀴즈1] for문 다른방법~~~~~~~~~~~~~~\n");
	    
    	for(int i = 0; i < mbrList.size(); i++)
    	{
    		if("leess".equals(mbrList.get(i).id))		// leess과 같은 아이디일대 
    		{
    			mbrList.get(i).infoPrint();			// 출력
    		}
    	}
	    
	    
    	
    	
	    System.out.println("\n~~~~~~~~~~~~~~[퀴즈2] for문 ~~~~~~~~~~~~~~\n");
	    /*
	       [퀴즈2]
	       mbrList에 저장되어진 Member 객체 중에서 
	       name 이 "강" 씨인 회원만 그 회원의 정보를 출력하세요 
	       
	       name 이 "서" 씨인 회원만 그 회원의 정보를 출력하세요
	       >> 회원중 "서"씨는 없습니다 <<
	    */
	    //String first_name = "강";
	    String first_name = "서";
	    
	    boolean flag = false;
	    for(int i=0; i<mbrList.size(); i++)			// mbrList사이즈 만큼 반복 
	    {
	    	String name = mbrList.get(i).name;	// 유재석, 엄정화, 강호동, 이순신, null, 강강찬	
	    	if(name != null && name.startsWith(first_name))			// 서씨로 시작할때 
	    	{
	    		mbrList.get(i).infoPrint();			// 서씨만 출력 
	    		flag = true;						// 흔적을 남기기 위해 
	    	}	
	    }// end of for
	    
	    if(!flag)		//flag가 false일때 
	    {
	    	System.out.println("회원중 \"" + first_name + "\"씨는 없습니다 ");
	    }
	   
	    
	    System.out.println("\n~~~~~~~~~~~~~~[퀴즈2] 확장 for문(내것) ~~~~~~~~~~~~~~\n");
	    
	    first_name = "강";
	    
	    for(Member mbr : mbrList)
	    {
	    	if(mbr.name != null && mbr.name.startsWith(first_name))	//이름이null이 아니고 시작 이름이 "강"시라면
	    	{
	    		mbr.infoPrint();			// 출력
	    		flag = true;				// 흔적을 남기기 위해 
	    	}
	    }
	    if(!flag)		//flag가 false일때 
	    {
	    	System.out.println("회원중 \"" + first_name + "\"씨는 없습니다 ");
	    }
	    
	    
	    
	    
	    //*** ArrayList 타입인 mbrList 에 새로운 Member 객체 추가시 ***
	    //    특정 index(위치)에 들어가도록 할 수 있다.
	    
	    System.out.println("\n ~~~~~ mbrList 에 새로운 Member 객체 추가하기 ~~~~~");
	    
	    mbrList.add(new Member("seolh", "qwer1234$", "설현"));
	    //index 값이 없으면 mbrList 의 맨 뒤에 추가한다.
	    //       유재석, 엄정화, 강호동, 이순신, 김태희, 강강찬, 설현	 순으로 된다.
	    //index   0     1      2     3     4     5     6
	    
	    System.out.println(mbrList.get(3).name);	// 이순신
	    System.out.println(mbrList.get(4).name);	// 김태희
	    System.out.println(mbrList.get(6).name); // 설현 
	    
	    System.out.println("\n ##############################");
	    
	    mbrList.add(3, new Member("sonyj", "qwer1234$", "손연재"));
	    //		    3이 	특정 인덱스이다.			
	    //      유재석, 엄정화, 강호동,  손연재, 이순신, 김태희, 강강찬  설현 	 순으로 된다.
	    //index   0     1      2     3     4     5     6     7
	    
	    System.out.println(mbrList.get(3).name);	// 손연재
	    System.out.println(mbrList.get(4).name);	// 이순신
	    System.out.println(mbrList.get(6).name);	// 강감찬
	    System.out.println(mbrList.get(7).name); // 설현 
	    
	    
	    
	    
	  //*** ArrayList 타입인 mbrList 에 저장되어진 Member 객체 삭제하기 ***
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("*** ArrayList 타입인 mbrList 에 저장되어진 Member 객체 삭제하기 ***");
	    
	    System.out.println(">> 삭제하기 전 mbrList.size() => " + mbrList.size() );
	    // >> 삭제하기 전 mbrList.size() => 8
	    
	    mbrList.remove(3);			// remove는 삭제하는 것이고 ()안에는 인덱스 번호를 뜻한다.
	    							// 즉 손연재가 빠질것이다.
	    
	    //      유재석, 엄정화, 강호동,  이순신, 김태희, 강강찬  설현 	 순으로 된다.
	    //index   0     1      2     3     4     5     6   
	     
	    System.out.println(">> 삭제한 후 mbrList.size() => " + mbrList.size() );
	    // >> 삭제한 후 mbrList.size() => 7
	    
	    System.out.println(mbrList.get(3).name);	// 이순신
	    
	    
	    //////////////////////////////////////////////////////////////////////////////////////
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    mbrList.add(new Member("iu","qwer1234$","이지은"));
	    mbrList.add(new Member("leejy","qwer1234$","이재용"));
	    
	    //      유재석, 엄정화, 강호동,  이순신, 김태희, 강강찬,  설현,  이지은, 이재용	 순으로 된다.
	    //index   0     1      2     3     4     5      6     7      8 
	    
	    System.out.println("\n~~~~~~~~~~~~~~[퀴즈3]~~~~~~~~~~~~~~\n");
	    /*
	       [퀴즈3]
	       mbrList  에 저장되어진 Member 객체들 중에서 
	       name이 "이" 씨인 회원들을 모두 삭제하고 
	       삭제한 후 mbrList에 저장되어진 모든 Member 객체들의 정보를 출력해라
	    */
	    
	    /*
	    System.out.println("내가 풀이한 퀴즈 3이다.!!!!!!!!!!!!");
	    for(int i =0; i< mbrList.size(); i++)		// size 만큼 반복
	    {
	    	if(mbrList.get(i).name.startsWith("이"))		// 이름이 이로 시작한다면 
	    	{
	    		if(!(mbrList.get(i+1).name.startsWith("이")))	// 다음것이 이로 시작된 이름이 아니라면 
	    		{
	    			mbrList.get(i+1).infoPrint();			// i+1번째를 출력해준다.
	    		}
	    		mbrList.remove(i);				// i번째를 제거한다.
	    		
	    	}
	    	else				// 이름이 이로 시작하지 않으면 
	    	{
	    		mbrList.get(i).infoPrint();			//출력
	    	}
	    }*/
	    // 결과 
	    //      유재석, 엄정화, 강호동,  김태희, 강강찬,  설현,   순으로 된다.
	    //index   0     1      2     3     4     5     
	    
	    /*
	    System.out.println("\n >>>아래의 것은 틀린 풀이이다.<<< \n");
	    // >>> 아래의 것은 틀린 풀이이다. !!! <<<
	    
	    first_name = "이";
	    for(int i=0; i < mbrList.size(); i++)
	    {
	    	String name = mbrList.get(i).name;
	    	if(name != null && name.startsWith(first_name))
	    	{
	    		System.out.println("i => " + i);   //3
	    		//	    유재석, 엄정화, 강호동,  이순신, 김태희, 강강찬,  설현,  이지은, 이재용	 순으로 된다.
	    	    //index   0     1      2     3     4     5      6     7      8 
	    		
	    		mbrList.remove(i);
	    		//	    유재석, 엄정화, 강호동,  김태희, 강강찬,  설현, 이재용 	 순으로 된다.
	    	    //index   0     1      2     3     4     5     6     
	    	}
	    	
	    	System.out.println("mbrList.size() => " + mbrList.size());
	    	//9
	    	//9
	    	//9
	    	//8
	    	//8
	    	//8
	    	//7
	    } //end of for
	    
	    for(Member mbr : mbrList) {  //확장 for문 출력부분 
	    	mbr.infoPrint();
	    }
	    
	    // 즉 이재용이 빠지지 않고 출력이 된다.
	    */
	    
	    ///////////////////////////////////////////////////////////////////////////////////
	    System.out.println("\n >>>아래의 것은 올바른 강사님 풀이이다.<<< \n");
	    // >>> 아래의 것은 올바른 풀이이다. !!! <<<
	    
	    first_name = "이";
	    for(int i = mbrList.size()-1; i >=0; i--)		//size는 9이기때문에 뒤에서 부터 빼주기 위해 index번호 맞춰줌
	    {
	    	//      유재석, 엄정화, 강호동,  이순신, 김태희, 강강찬,  설현,  이지은, 이재용	 순으로 된다.
    	    //index   0     1      2     3     4     5      6     7      8 
	    	
	    	String name = mbrList.get(i).name;		//이름 얻어옴
	    	if(name != null && name.startsWith(first_name))
	    	{
	    		System.out.println("i => " + i);    //8
	    		mbrList.remove(i);
	    		//      유재석, 엄정화, 강호동,  김태희, 강강찬,  설현, 순으로 된다.
	    	    //index   0     1      2     3     4     5               
	    	}
	    	
	    	System.out.println("mbrList.size() => " + mbrList.size());
	    	//8
	    	//7
	    	//7
	    	//7
	    	//7
	    	//6
	    	//6
	    	//6
	    	//6
	    }
	    for(Member mbr : mbrList) {  //확장 for문 출력부분 
	    	mbr.infoPrint();
	    }
	    
	    
	    System.out.println("\n ==== mbrList 에 저장된 모든 객체 삭제하기 ====\n");
	    mbrList.clear();   //mbrList에 있건 모든 객체들을 지워버린다.
	    
	    System.out.println(">> 삭제한 후 mbrList.size() => " + mbrList.size());
	    // >> 삭제한 후 mbrList.size() => 0
	    
	    System.out.println("\n ==== mbrList 에 중복된 데이터 입력하기====\n");
		Member mbr_1 = new Member("sin", "qer1234$", "신사임당");
		Member mbr_2 = mbr_1;		//데이터 중복 (주소가 같다.)
		Member mbr_3 = new Member("sin", "qer1234$", "신사임당");
		
		mbrList.add(mbr_1);
		mbrList.add(mbr_2);
		mbrList.add(mbr_3);
		
		for(Member mbr : mbrList)	//확장 for문
		{
			System.out.println(mbr.name + " , " + mbr);
		}
		/*
			신사임당 , my.day18.a.collection.Member@15db9742
			신사임당 , my.day18.a.collection.Member@15db9742
			신사임당 , my.day18.a.collection.Member@6d06d69c
		*/
		
		System.out.println("mbrList.size() => " + mbrList.size());
		// mbrList.size() => 3
	}

}

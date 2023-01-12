package my.day09.c.array;

public class MemberMain {

	public static void main(String[] args) {
		
		Member[] mbrArr = new Member[4];  // 인스턴스 배열 4개 저장소 
		
		for(int i = 0; i<mbrArr.length; i++)	// 배열 길이까지 반복
		{
			System.out.println("mbrArr["+i+"] => " + mbrArr[i]);
		}
		/*
			mbrArr[0] => null
			mbrArr[1] => null
			mbrArr[2] => null
			mbrArr[3] => null

		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		Member mbr1 = new Member();			// member 에 있는것 가져다 씀
		mbr1.id = "Leess";
		mbr1.passwd = "qWer1234$"; 
		mbr1.name = "이순신";
		
		Member mbr2 = new Member();			// member 에 있는것 가져다 씀
		mbr2.id = "eomjh";
		mbr2.passwd = "qWer1234@"; 
		mbr2.name = "엄정화";
		
		

		/*
		  mbrArr[0] = mbr1;		이건 배열에 직접 넣는것이다.
		  mbrArr[1] = mbr2;
		  
		  for(int i=0; i< mbrArr.length; i++)		
		  {
				System.out.println(mbrArr[i].showInfo());
		  }
		  // java.lang.NullPointerException 이 오류는 배열 중 null.으로 시작해서 안돌아간다는 뜻 
		  // 지금은 mbrArr[2], [3]은 null 이므로 오류가 나는 것이다.
		*/
		
		// 배열에 대입  스테틱 필드에 있는 것을 넣는 부분이다.!!!!!!!!!!!!!!!!!!!!//
		mbrArr[Member.count++] = mbr1;
		mbrArr[Member.count++] = mbr2;
		
		for(int i=0; i< Member.count; i++)		// 스테틱 필드에 있는 것을 가져오면 배열 길이보다 적어도 가능하기 때문에 이것으로 쓰자 
		{
			System.out.println(mbrArr[i].showInfo());
		}
		 // 이럴때는 스테틱 필드를 사용한다. 스테틱 필드는 Member에 있다.

	}// end of main

}

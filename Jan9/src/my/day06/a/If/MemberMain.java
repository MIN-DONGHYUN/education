package my.day06.a.If;

public class MemberMain {

	public static void main(String[] args) {
		
		Member mbr1 = new Member();	//맴버 클래스의 mbr1을 설정 
		
		mbr1.id = "Leess";
		mbr1.name = "이순신";
		mbr1.nickName = new String("장군");
		
		Member mbr2 = new Member();  	//맴버 클래스의 mbr2을 설정 
		mbr2.id = "Eomjh";
		mbr2.name = "엄정화";
		mbr2.nickName = new String("가수");
		
		Member mbr3 = new Member();  //새로 new를 해왔기 때문에 mbr1과 메모리 주소 값이 다르다.
		mbr3.id = "Leess";
		mbr3.name = "이순신";
		mbr3.nickName = new String("장군");
	
		if(mbr1 == mbr2)    //인스턴스와 인스턴스 비교한다.
		{		// 인스턴스(객체) 와 인스턴스(객체)를 비교(==)할 때는 메모리 상에 올라가 있는 인스턴스(객체)의 메모리 주소를 비교하는 것이다.
			System.out.println("인스턴스 mbr1과 인스턴스 mbr2는 동일한 메모리 주소를 참조하고 있습니다.");
		}
		else if(mbr1 == mbr3)
		{       // 인스턴스(객체) 와 인스턴스(객체)를 비교(==)할 때는 메모리 상에 올라가 있는 인스턴스(객체)의 메모리 주소를 비교하는 것이다.
			System.out.println("인스턴스 mbr1과 인스턴스 mbr3는 동일한 메모리 주소를 참조하고 있습니다.");
		}
		else 
		{
			System.out.println("인스턴스 mbr1과 인스턴스 mbr2와 인스턴스 mbr3은 모두 다른 메모리 주소를 참조하고 있습니다.");
			//System.out.println("인스턴스 mbr1과 인스턴스 mbr2와 인스턴스 mbr3은 모두 다른 메모리 주소를 참조하고 있습니다.");
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		/////// new한것과 new 안한것을 비교해보자 ////////
		
		String passwd_1 = new String("abcd");
		String passwd_2 = new String("abcd");
		//new를 해왔기 때문에 객체를 생성한것 
		//즏 메모리를 공유하지 않고 다른 메모리에 저장해서 else가 나올 것이다.
		
		
		if(passwd_1 == passwd_2)
		{   // 인스턴스(객체) 와 인스턴스(객체)를 비교(==)할 때는 메모리 상에 올라가 있는 인스턴스(객체)의 메모리 주소를 비교하는 것이다.
			System.out.println("패스워드 passwd_1 과 패스워드 passwd_2는 동일한 메모리 주소를 참조하고 있습니다.");
			
		}
		else
		{
			System.out.println("패스워드 passwd_1 과 패스워드 passwd_2는 서로 다른 메모리 주소를 참조하고 있습니다.");
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//new를 안한 것은 //String은 클래스
		String passwd_3 = "abcd";
		String passwd_4 = "abcd";
		//new가 없기 때문에 동일한 메모리에 저장되어서 나올것이다. ("abcd")
		
		// passwd_3에 저장된 값 ("abcd")과 passwd_4 에 저장된 값("abcd")를 비교하는 것이다.
		if(passwd_3 == passwd_4)
		{   // 인스턴스(객체) 와 인스턴스(객체)를 비교(==)할 때는 메모리 상에 올라가 있는 인스턴스(객체)의 메모리 주소를 비교하는 것이다.
			System.out.println("패스워드 passwd_3 과 패스워드 passwd_4는 동일한 값을 갖습니다.");
			
		}
		else
		{
			System.out.println("패스워드 passwd_3 과 패스워드 passwd_4는 서로 값을 갖습니다.");
		}
		
		
		System.out.println("\n~~~~>>>문자열 값을 비교시 .equals() 메소드를 사용하자<<< ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// equals로 값을 비교할때 
		if(passwd_1.equals(passwd_2))  // equals는 패스워드 1,2의 저장된 값을 비교한다,
			//passwd_1에 저장된 값("abcd")과 passwd_2에 저장된 값("abcd")을 비교하는 것이다. 
		{   
			System.out.println("패스워드 passwd_3 과 패스워드 passwd_4는 동일한 값을 갖습니다.");
			
		}
		else
		{
			System.out.println("패스워드 passwd_3 과 패스워드 passwd_4는 서로 값을 갖습니다.");
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// equals로 값을 비교할때 
		if(passwd_3.equals(passwd_4))  // equals는 패스워드 3,4의 저장된 값을 비교한다,
			//passwd_3에 저장된 값("abcd")과 passwd_4에 저장된 값("abcd")을 비교하는 것이다.
		{   
			System.out.println("패스워드 passwd_3 과 패스워드 passwd_4는 동일한 값을 갖습니다.");
			
		}
		else
		{
			System.out.println("패스워드 passwd_3 과 패스워드 passwd_4는 서로 값을 갖습니다.");
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//mbr1과 mbr3아이디 비교
		//if(mbr1.id == mbr3.id) // 이렇게 하지 마세요~~~~~~~~~~~~~!!!!!!!!!!!!
		// 이것은 메모리 주소 비교 
		if(mbr1.id.equals(mbr3.id))	//이렇게 하세요 이것은 값비교
		{
			System.out.println(mbr1.id + " 와 " +  mbr3.id + "은 같습니다.");
		}
		else
		{
			System.out.println(mbr1.id + " 와 " +  mbr3.id + "은 같지 않습니다..");
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		//mbr1과 mbr3닉네임 비교
		//new를 해왔기 때문에 메모리 주소를 비교하므로 "장군","장군"이 같더라도 메모리 주소가 달라 같지 않는다고 나온다.
		////////////즉 문자열을 비교하려면 equals를 사용해서 햇갈림을 방지하자.!!!!!!!!!!!!!!!!/////////
		
		//if(mbr1.nickName == mbr3.nickName) // 이렇게 하지 마세요~~~~~~~~~~~~~!!!!!!!!!!!!
		// 이것은 메모리 주소 비교
		if(mbr1.nickName.equals(mbr3.nickName))	//이렇게 하세요 이것은 값비교 
		{
			System.out.println(mbr1.nickName + " 와 " +  mbr3.nickName + "은 같습니다.");
		}
		else
		{
			System.out.println(mbr1.nickName + " 와 " +  mbr3.nickName + "은 같지 않습니다.");
		}
	}
}

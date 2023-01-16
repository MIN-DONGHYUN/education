package my.day11.b.stringbulider;

public class Stringbuilder_main {

	public static void main(String[] args) {
		
		String name = "일순신";  // 메모리 상에 name 1개 소모 
		name += ",이순신";  	   // 메모리 상에 name 1개 소모 
		name += ",삼순신";  	   // 메모리 상에 name 1개 소모 
		name += ",사순신";  	   // 메모리 상에 name 1개 소모 
		name += ",오순신";  	   // 메모리 상에 name 1개 소모 
		name += ",육순신";  	   // 메모리 상에 name 1개 소모 
		name += ",칠순신";  	   // 메모리 상에 name 1개 소모 
		name += ",팔순신";  	   // 메모리 상에 name 1개 소모 
		name += ",구순신";  	   // 메모리 상에 name 1개 소모 
		
								// 누적되어진 메모리 상의 name은 9개가 소모된다고 한다.
		
		System.out.println(name);
		// 일순신,이순신,삼순신,사순신,오순신,육순신,칠순신,팔순신,구순신

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		StringBuilder sb = new StringBuilder();
		// StringBulider 가 StringBuffer 보다 가볍고 빠르다.
		// StringBulider 는 단일 쓰레드에서만 사용 가능하다.
		// 단일 쓰레드 ==> 웹용
		
		//StringBuffer sbf = new StringBuffer();
		// StringBuffer 는 StringBulider 보다 무겁고 느리다.
		// StringBuffer 는 단일 쓰레드 및 다중 쓰레드 둘 모두에서 사용가능하다.
		// 다중 쓰레드 ==> 게임용
		
		sb.append("일순신");	//append는 추가하다의 의미이다.
		sb.append(",이순신");
		sb.append(",삼순신");
		sb.append(",사순신");
		sb.append(",오순신");
		sb.append(",육순신");
		sb.append(",칠순신");
		sb.append(",팔순신");
		sb.append(",구순신");
		
		System.out.println(sb.toString());		// toString은 append의 쌓여있는 것을 String타입으로 바꿔주는것 
		

	}// end of main

}

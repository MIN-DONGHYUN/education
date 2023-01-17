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
		
		
		// StringBuilder sb 의 초기화 방법 1
		sb.setLength(0);		// 길이를 0으로 허면 초기화가 된다.
		sb.append("초기화1");
		// 초기화1
		
		System.out.println(sb.toString());		// toString은 append의 쌓여있는 것을 String타입으로 바꿔주는것 
		
		// StringBuilder sb 의 초기화 방법 2
		sb = new StringBuilder(); 		// 새롭게 new를 해주면 초기화가 된다.
		sb.append("초기화2");
		
		System.out.println(sb.toString());		// toString은 append의 쌓여있는 것을 String타입으로 바꿔주는것 
		// 초기화2
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		StringBuilder sb1 = new StringBuilder("Programming");	// 파라미터에 넣으면 append를 한 상태로 시작 
		
		System.out.println("sb1.toString() =>" + sb1.toString());		// toString은 append의 쌓여있는 것을 String타입으로 바꿔주는것 
		//sb1.toString() =>Programming
		
		System.out.println("sb1 =>" + sb1);		// toString은 append의 쌓여있는 것을 String타입으로 바꿔주는것이 없더라도 똑같이 결과가 나온다. 
												// 오버라이딩이 되어있어서 나온다.
		//sb1 =>Programming
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		StringBuilder sb2 = sb1.replace(2, 6, "AAA");
		// sb1 인 "Programming" 에서 2 번째 index 인 "o" 부터 6 번째 index인 "m" 앞까지 지운다
		// 즉, "ogra" 를 지우고 그자리에 "AAA"를 넣어서 바꾸어라 
		// 그래서 sb1 은 "prAAAmming" 으로 변경된다.
		
		System.out.println("sb1 => " + sb1);
		// sb1 => PrAAAmming
		System.out.println("sb2 => " + sb2);
		// sb2 => PrAAAmming
		System.out.println("sb1.toString() => " + sb1.toString());
		// sb1.toString() => PrAAAmming
		System.out.println("sb2.toString() => " + sb2.toString());
		// sb2.toString() => PrAAAmming
		

	}// end of main

}

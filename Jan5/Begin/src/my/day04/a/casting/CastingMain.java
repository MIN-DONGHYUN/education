package my.day04.a.casting;

public class CastingMain {

	//=== casting 연산자에 대해서 알아본다. ===

	/*
	   === 데이터형 변환하기 ===
	   1. 자동 형변환(묵시적 형변환)
	   --> 데이터타입의 크기가 작은 것에서 크기가 큰쪽으로는 자동적으로 형변환이 발생된다. 
	   
	    byte(1byte) --> short(2byte) --> int(4byte) --> long(8byte)
	       개미             병아리            강아지           사람   
	      개미집            병아리집           강아지집          안방
	    
	    float(4byte) --> double(8byte) 
	    
	    --> 정수타입은 실수타입으로 자동형변환이 발생한다.
	    
	    char(2byte)
	    --> char타입은 int형으로 자동형변환이 발생한다.
	   
	   
	   2. 강제 형변환(casting)
	   --> 데이터타입의 크기가 큰것을 작은것으로 강제적으로 형변환 시키는 것을 말한다.
	            크기가작은타입 = (크기가작은타입)크기가큰타입
	                
	            실수를 정수로 강제적으로 형변환하는 것을 말한다.
	            소수부는 무조건 절삭을 해버리고 정수만 나온다.
	            정수 = (정수)실수 
	            
	            실수 1.0    2.0 사이에는 무한대의 수가 있다.

	*/
	
	public static void main(String[] args) {
		
		/////// 자동 형변환을 알아보자 //////////
		byte no1 = 100;  // byte => 1byte - 128 ~ 127
		
		short sh = no1;  // 자동으로 byte였던 no1은 short가 되어진다.
		                 // short => 2byte - 32,768 ~ 32,767
		//위의 것은 short sh = (short)no1; 과 마찬가지 이다.
		
		System.out.println("sh => " + sh);   //sh => 100
		
		
		int in = sh;  // int => 4byte   -2,147,483,648 ~ 2,147,483,647
		//위의 것은 int in = (int)sh;
		
		System.out.println("int in => " + in);   //in => 100
		
		
		long In = in;   // long => 8byte -9,223,372,036,854,775,808 ~  9,223,372,036,854,775,807
		//위의 것은 long In = (long)in;
		System.out.println("In => " + In);
		
		float ft = 1.234F;  // F는 플롯으로 바꾸는 것
		System.out.println("ft => " + ft); // float 단정밀도   소수점이하 7자리까지 표현됨 
		// ft => 1.234
		
		double db = ft;  // double 배정밀도 소수점이하 15~16자리까지 표현됨
		//위의 것은 double db = (double)ft;와 같다.
		System.out.println("db => " + db);
		// db => 1.2339999675750732
		
		
		System.out.println("\n ~~~~~~~~~~~~강제 형변환~~~~~~~~~~~~~~\n");
		
		/////// 강제 형변환을 알아보자 ///////
		
		double db2 = 1.23456789;
		System.out.println("db2 => " + db2);
		// db2 = 1.23456789
		
		float ft2 = (float) db2;   // 강제 형변환이다. float을 (작은 사이즈의 형태)로 변경하는 것을 말한다.
		System.out.println("ft2 => " + ft2);
		//ft2 => 1.2345679
		
		int in2 = 30000;   
		System.out.println("in2 => " + in2);
		// in2 => 30000
		
		short sh2 = (short) in2;   //int를 short로 강제 형변환
		System.out.println("sh2 => " + sh2);
		//sh2 => 30000
				
				
		in2 = 50000;
		sh2 = (short)in2;   //short 는- 32,768 ~ 32,767
		System.out.println("sh2 => " + sh2); //형 형태에 벗어난 강제 형변환을 해버리면 이상한 값이 나온다.
		//sh2 => -15536 엉꿍한 값
		
		long In2 = 3000000000L;  // L은 롱타입임을 나타낸다.
		                         // long 8byte
		float ft3 = In2;         // float 4byte
		// 위의 것은 float ft3 = (float)In2;와 같다.
		// 정수와 실수는 크기를 따지지 않는다.
		// 실수가 훨씬 클 범위로 이해하자
		System.out.println("In2 => " + In2);
		// In2 => 3000000000
		
		System.out.println("ft3 => " + ft3);
		// ft3 => 3.0E9 는 3.0 * 10의9승이다. 
		
		
		//실수
		double db3 = 123.98765;
		int in3 = (int)db3;  // 실수형인 double을 강제 형변환해 정수로 변경
		                     // 결과는 정수만 나옴, 소수부분은 없어진다.
							 // 즉 실수를 정수로 강제형변환 하면 소수부를 잘라버리는 절삭의 효과를 가진다. (반올림 아님)
		System.out.println("db3 => " + db3); // 실수부분 보기
		// db3 => 123.98765
		System.out.println("in3 => " + in3); // 실수에서 정수로 
		// in3 => 123
	
	}

}

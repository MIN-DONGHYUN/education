package my.day07.e.Dowhile;

public class _1DoWhileMain {

	/*
	   === do ~ while() ===
	   
	   변수초기화;
	   
	   do{
	       반복해서 실행할 명령문;
	       증감식;
	   } while(조건식);
	   
	   while 문의 경우 조건식이 true 일때만 반복 실행하지만,
	   do ~ while 문의 경우는 조건식이 false 일지라도
	   무조건 do{ } 속에 있는 명령문은 1번은 실행하고서 반복문을 벗어난다.
	       
	   그러므로 do ~ while 문은 무조건 do{ } 속에 있는 명령문을 실행하고서
	   while(조건식) 속의 조건에 따라 참(true)이라면 계속 반복하고,
	   조건이 거짓(false)이라면 중지한다.  
	*/   	
	//do-while은 무조건 한번은 실시한 후에 조건이 맞으면 계속 반복 
	//한번은 실행한 후 조건이 맞지 않으면 반복하지 않음 
	
	public static void main(String[] args) {
		
		do {  // while문 들어가기전 한번 실행해보고 while문이 참이면 계속 반복
			System.out.println("안녕 자바~~~~");
		} while (false);
		// 안녕 자바~~~~
		
		System.out.println("\n~~~~~~~~~~~~~~~\n");
		

		int cnt = 5, loop = 0;
		do {
			System.out.println( ++loop + ". Hello java~~");
		} while (loop < cnt);  //이게 참이라면 계속 반복, 거짓이라면 while문 빠져나간다.
		/*
		   1. Hello java~~ 
		   2. Hello java~~ 
		   3. Hello java~~ 
		   4. Hello java~~ 
		   5. Hello java~~
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~\n");
		

		cnt = 5;
		loop = 0;
		do {
			System.out.println( ++loop + ". Hello 자바~~");
		} while (!(loop == cnt));  //이게 참이라면 계속 반복, 거짓이라면 while문 빠져나간다.
						//!()은 괄호()속에는 do-while 반복문을 탈출할 조건을 입력해주는 것이다.
						//loop가 cnt가 되면 while문은 false가 되므로 빠져나간다.
		/*
		   1. Hello 자바~~ 
		   2. Hello 자바~~ 
		   3. Hello 자바~~ 
		   4. Hello 자바~~ 
		   5. Hello 자바~~
		*/
	
	}// end of main

}

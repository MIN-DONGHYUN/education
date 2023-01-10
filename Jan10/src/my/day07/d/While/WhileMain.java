package my.day07.d.While;

public class WhileMain {

	public static void main(String[] args) {

		/*
	      === while 문 형식 ===
	      
	      변수의 초기화;
	         
	      while(조건식) {
	         조건식이 참(true)이라면 반복해서 실행할 명령문을 실행하고,
	         조건식이 거짓(false)이라면 while의 { } 이부분을 빠져나간다. 
	         
	         반복해서 실행할 명령문;
	         증감식;
	      }
	    */   
		
		int cnt = 5, loop = 0;
		while(loop < cnt) // while 조건식 이므로 0 부터 4까지 (참)이므로 반복된다
		{
			System.out.println((loop+1) + ".안녕자바~~");
			loop++;
		}// end of while~~~~~~~~~
		
		/*
		 	1. 안녕자바~~
		 	2. 안녕자바~~
		 	3. 안녕자바~~
		 	4. 안녕자바~~
		 	5. 안녕자바~~
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		cnt = 5; 
		loop = 0;
		while(loop++ < cnt) // while 조건식 이므로 0 부터 4까지 (참)이므로 반복된다
		{
			System.out.println(loop + ".Hello java~~");
							//   1    2   3   4   5
		}// end of while~~~~~~~~~
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		
		cnt = 5; 
		loop = 0;
		while(loop < cnt) // while 조건식 이므로 0 부터 4까지 (참)이므로 반복된다
		{
			System.out.println( ++loop + ".안녕 이클립스~~");
								//   1    2   3   4   5	
		}// end of while~~~~~~~~~
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		
		loop = 0;
		while(true) // 무조건 참이기 때문에 무한루프가 된다.
		{
			System.out.println( ++loop + ".안녕 Eclispse~~");
			if(loop == 5)
			{
				break;   // loop가 5가 되면 빠져나온다.
			}
								
		}// end of while~~~~~~~~~
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

		
		loop = 0;
		while( !(++loop > 5) ) // 괄호() 속에는 while 반복문을 빠져나갈 조건식의 정의를 내려주는 것이다. 
		{					    // 루프가 전위증감식으로 5와 같거나 크면 false가 되어서 while문을 빠져나간다.
			System.out.println( loop + ".안녕 오라클~~");
								
		}// end of while~~~~~~~~~
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		loop = 0;
		while(true) {  // 무한루프
			
			if(++loop > 10)  // 탈출조건 
			{
				break;
			}
			if(loop%2 == 0)
			{
				continue;   // 아래로 내려가지 않고 while()의 괄호()속의 조건식으로 이동한다.
			}
			
			System.out.println(loop + ". Hi oracle~~");
			
			
		}// end of while
		/*
		 	1. Hi oracle~~
		 	3. Hi oracle~~
		 	5. Hi oracle~~
		 	7. Hi oracle~~
		 	9. Hi oracle~~
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("\n=== 5단 ===");
		loop=0;   // 초기화
		while(++loop < 10) 
		{
			System.out.println("5 * " + loop + " = " + (5*loop));
		}
		
		System.out.println("\n=== 6단 ===");
		loop = 0; // 초기화
		while(true)
		{
			if(++loop > 9)
			{
				break;   // loop가 9와 같거나 큰경우 for문을 빠져나가자 
			}
			System.out.println("6 * " + loop + " = " + (6*loop));
			
		}
		
		
		System.out.println("\n=== 7단 ===");
		loop = 0;  // 초기화
		while( !(++loop > 9)) {  // while 문의 탈출조건을 쓴다.
			System.out.println("7 * " + loop + " = " + (7*loop));
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.printf("%35s\n", "=== 구구단 ===");  //들여쓰기
		
		// 9행  8열
		// jul dan
		
		int jul = 0, dan = 1;
		
		while(!(++jul>9)) { // 9행이기 때문에 전위연산자 후 9보다 크면 false로 빠져나감
			
			while(!(++dan > 9)) {  // 8열이기 때문에 전위연산자 후 9보다 크면 false로 빠져나감 
				
				String str= (dan<9)?"\t":"\n";   // 삼항연산자 잘 기억하자!!!!!!
												 // dan이 9보다 작으면 \t하고 아니라면 \n을 한다.
				System.out.print( dan + "*" + jul + "=" + (dan*jul) + str);  // 출력 str은 3항 연산자
				
			} // end of while
			
			dan = 1; // dan을 초기화 해서 jul돌아갈때 dan이 또 돌아가도록 하자 
					 // 다시 한번 초기화 
			
		}// end of while
		
		System.out.println("\njul => " +  jul + ",dan ==> " + dan);  // jul = 10; dan = 1
		/*
				  == 구구단 ==
			      2*1=2   3*1=3   4*1=4   ....   9*1=9
			      2*2=4   3*2=6   4*2=8   ....   9*2=18
			      2*3=6   3*3=9   4*3=12   ....   9*3=27
			      2*4=8   3*4=12   4*4=16   ....   9*4=36
			      2*5=10   3*5=15   4*5=20   ....   9*5=45
			      2*6=12   3*6=18   4*6=24   ....   9*6=54
			      2*7=14   3*7=21   4*7=28   ....   9*7=63
			      2*8=16   3*8=24   4*8=32   ....   9*8=72
			      2*9=18   3*9=27   4*9=36   ....   9*9=81
			      */
		
		
		System.out.println("\n=== 프로그램 종료 ===\n");
	}// end of main

}

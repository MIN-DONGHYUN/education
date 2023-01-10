package my.day07.a.multifor;

public class MultiForMain {

	public static void main(String[] args) {
		
		// ==== 다중 for문에 대해서 알아봅니다. ====
		// 다중 for문이라 함은 for문 속에 또 다른 for문이 있는 것을 말한다.
		
		/*
		   === 출력결과 ===
		   
		   abcdefg
		   hijklmn
		   opqrstu
		*/
		
		
		char ch = 'a';				// char로 a부터 가지고 옴
		for(int i =0; i<'u' - 'a' + 1 ; i++)   // 0부터 'u' -'a' +1 까지 (알파벳 a부터 u까지 나타냄)
		{
			System.out.print(ch++); // 한번 돌아갈때마다 알파벳 뒤자리 나올수 있도록 
			if( (i+1)%7 == 0)
			{
				System.out.print("\n");    // 줄바꿈 
			}
			
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		ch = 'a';				// char로 a부터 가지고 옴
		for(int i =0; i<'u' - 'a' + 1 ; i++)   // 0부터 'u' -'a' +1 까지 (알파벳 a부터 u까지 나타냄)
		{
			String str = ((i+1)%7 == 0)?"\n":"";		// 삼항 연산자로도 나타낼수있다.
			System.out.print(ch++ + str); // 한번 돌아갈때마다 알파벳 뒤자리 나올수 있도록 
			
		}
		
		System.out.println("\n~~~~ 다중 for 문 사용 결과 ~~~~\n");
		
		
		/*
		   === 다중 for문 출력결과 ===
		   
		   abcdefg   3행(가로), 7열(세로)
		   hijklmn
		   opqrstu
		*/
		
		ch = 'a';				// char로 a부터 가지고 옴
		for(int i = 0; i < 3; i++)   // 3행을 나타냄
		{
			 for(int j = 0; j < 7; j++)	// 7열을 나타낸다.
			 {
				 System.out.print(ch++);   // 알파벳 나타내는 것
			 }//end of for
			 System.out.print("\n");  // 줄바꿈 
			
		}//end of for
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
		
		/*
		    이중 for문을 사용하여 아래처럼 나오도록 하세요
		    
		    === 출력결과 ===
		    
		    [0,0][0,1][0,2]   4행 3열 
		    [1,0][1,1][1,2]
		    [2,0][2,1][2,2]
		    [3,0][3,1][3,2]
		    
		*/
		
		for(int i = 0; i < 4 ; i++)			// 행을 나타냄 
		{
			for (int j = 0; j<3; j++)		// 열을 나타냄 
			{
				System.out.print("[" + i +"," + j +"]");	// 출력해주기 
			}
			System.out.print("\n");		// 줄바꿈 
		}		//end of for 
		
		/*
	    이중 for문을 사용하여 아래처럼 나오도록 하세요
	    
	    === 출력결과 ===
	    
	    [0,0][0,1][0,2]
	    [1,0][1,1][1,2]
	    [3,0][3,1][3,2]
	    
	    */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		for(int i = 0; i < 4 ; i++)		// 행을 나타냄 
		{
			if(i == 2)				// i가 2라면 
			{
				continue;			// 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다.
				//또는 
				//i = 3;				// i는 3으로 변경한다.
			}
			
			for (int j = 0; j<3; j++)	// 열을 나타냄 
			{
				System.out.print("[" + i +"," + j +"]");	// 출력
				
			}
			System.out.print("\n");		// 줄바꿈 
		}		//end of for 
		
		/*
	    이중 for문을 사용하여 아래처럼 나오도록 하세요
	    
	    === 출력결과 ===
	    
	    [0,0][0,2]
	    [1,0][1,2]
	    [3,0][3,2]
	    
	    */

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
				
		
		for(int i = 0; i < 4 ; i++)	// 행을 나타냄 	
		{
			if(i == 2)		// i가 2라면
			{
				continue;       // 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다.
				//또는 
				//i = 3;		// i는 3으로 변경한다.
			}
			
			for (int j = 0; j<3; j++)	// 열을 나타냄
			{
				if(j == 1)		// j가 1이라면 
				{
					continue;    // 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다.
					//또는
					//j = 2;		// j는 2로 변경한다.
				}
				System.out.print("[" + i +"," + j +"]");		//출력
				
			}
			System.out.print("\n");		//줄바꿈 
		}		//end of for 
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		System.out.println("\n안녕하세요\t\"좋은아침\"\t입니다. \n ");  // \t는 탭을 나타내고 \"는 "를 나타낸다.
		//      \n 줄바꿈   \"는 실제 "    \t는 tab
		
		System.out.println(">>> [퀴즈] 2중 for문을 사용하여 아래처럼 나오도록 하세요 ");
		
		
		/*------------------------
		     501호	502호	503호	505호	5행 5열인데 4층은 빼고 4호도 제외한다.
		     301호	302호	303호	305호 
		 	 201호	202호	203호	205호
		 	 101호	102호	103호	105호
		*/
		
		// 내가 풀어본 퀴즈 ///
		int B = 501;		// 501호로 B를 초기값 설정 
		for (int i = 0; i < 5; i++)		// 5행을 나타냄 
		{
			if(i == 1)					//1행일때 제외 
			{
				B = B - 100;			// B는 B-100해서 4층을 제외
				continue;	    		// 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다. 
			}
			for(int j = 0; j < 5; j++ ) // 5열을 나타냄 
			{
				if(j == 3)				// 004호일때 
				{
					continue;	    // 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다.
				}
				System.out.print(B + j +"호\t");	//출력
				
			}
			B = B - 100;			//호를 나타내기 위해 
			System.out.print("\n");	// 줄바꿈 
		}
		
		
		
		// 수업때 찍어본 퀴즈 //
		System.out.println("\n~~~수업때 찍어본 퀴즈~~~\n");
		
		for (int i = 5; i > 0; i--)		// 5행을 나타냄 
		{
			if(i == 4)					//1행일때 제외 
			{
				continue;	    		// 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다. 
			}
			for(int j = 0; j < 5; j++ ) // 5열을 나타냄 
			{
				if(j == 3)				// 004호일때 
				{
					continue;	    // 밑으로 내려가지않고 가장 가까운 증감식으로 돌아간다.
				}
				System.out.print(i+ "0" + (j+1) + "호\t");	//출력
				
			}
			System.out.print("\n");	// 줄바꿈 
		}
		

		
	}// end of main

} // end of MultiForMain

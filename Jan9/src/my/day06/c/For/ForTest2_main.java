package my.day06.c.For;

public class ForTest2_main {

	public static void main(String[] args) {
		
		
		System.out.println(">> 1. break << "); 
		//////////////////break에 대해 알아보자 ///////////////
		
		for(int i = 0 ; i<10; i++)
		{
			
			if(i == 5)
			{
				break;  //for문을 빠져나가기 위해 break하면 i가 5일때 반복문을 빠져나간다.
						// 반복문에서 break;를 만나면 가장 가까운 반복문을 벗어나는 것이다.
			}
			System.out.println(i+1);	// 0 ~ 4 까지 출력한다.
		} //end of for
		/*
		    1
		    2
		    3
		    4
		    5 
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");

		int cnt = 0;
		for(;;) {		// 무조건 반복으로 for문을 빠져나갈수 없음 
			System.out.println(++cnt + "번째 반복");
			if(cnt ==5) // cnt가 5가 된다면 
			{
				break; //for문을 빠져나가기 위해 break하면 cnt가 5일때 반복문을 빠져나간다.
						// 반복문에서 break;를 만나면 가장 가까운 반복문을 벗어나는 것이다.
			}
		}
		
		System.out.println("\n>> 2. continue <<");
		///////////////continue에 대해 알아보자/////////////////////
		
		// 반복문에서 continue;를 만나면 실행순서가 아래(밑)로 내려가지 않고 가장 가까운 반복문의 증감식으로 이동해 버린다.
		
		for(int i = 0; i <10; i++) {
		
			if( (i+1) %2 == 0) {  //출력하고자 하는 값(i+1)이 짝수이라면
				continue;		// 반복문에서 continue;를 만나면 실행순서가 아래(밑)로 내려가지 않고 가장 가까운 반복문의 증감식으로 이동해 버린다.
			}
			
			System.out.println((i+1) + " ");
			// 1 3 5 7 9
		}//end of for
		
		
		
	}// end of main()------------------------

}

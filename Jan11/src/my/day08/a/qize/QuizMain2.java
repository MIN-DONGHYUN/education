package my.day08.a.qize;

public class QuizMain2 {
	/*


	== 입사문제 == 

	*********1
	********2
	*******3
	******4
	*****5
	****6
	***7
	**8
	*9

	위와같이 나오도록 하세요.
	1. for 문을 사용해서 출력
	2. while 문을 사용해서 출력
	3. do~while 문을 사용해서 출력
*/	

	// 1. for 문 사용 
	/*
	public static void main(String[] args) {
				
		int num=10;
		String str_star="";
		
		for (int i = 0 ; i < 9; i++)	// 9번 돌아가도록 반복
		{
			for(int k = i; k < 9; k++)	// i번부터 9전까지 돌아가라
			{
				String str = (" ".equals(str_star))?"":"*";	//삼항연산자 
				
				str_star += str;	// 삼항연산자를 찍어주기 위해
				num -= 1;		//num을 10에서 돌아가는 만큼 1씩 뺌
			}
			System.out.print(str_star + num );	// 찍어주기 
			System.out.print("\n");			// 줄바꿈
			str_star="";	//초기화
			num = 10;		//초기화
		} // end of for
	}// end of main
}
*/
	
/*	
	//2. while문
	public static void main(String[] args) {
		int num=10;   // 변수설정
		int i = 0;   
		String str_star="";
		
		while(i<9)	// 9번 돌아가도록 반복
		{
			int k = 8;   // k를 반복할때마다 8로 초기화
			while(k>=i)	// k보다 i가 작을 때 돌아가라
			{
				String str = (" ".equals(str_star))?"":"*";	//삼항연산자 
				k--;				//k를 1씩 빼줘서 반복문 빠져나올수 있도록 설정
				str_star += str;	// 삼항연산자를 찍어주기 위해
				num -= 1;		//num을 10에서 돌아가는 만큼 1씩 뺌
			}
			System.out.print(str_star + num );	// 찍어주기 
			System.out.print("\n");			// 줄바꿈
			str_star="";	//초기화
			num = 10;		//초기화
			i++;   // i값을 1더해서 두번째 while문을 한번 덜 반복하자
		} // end of while
	}// end of main
}
*/
	
	//3. do - while문
	public static void main(String[] args) {
		int num=10;   // 변수설정
		int i = 0;   
		String str_star="";
		
		do		// 먼저 실행해보거라 
		{
			int k = 8;   // k를 반복할때마다 8로 초기화
			do			// 두번째 do 먼저 실행하거라 
			{
				String str = (" ".equals(str_star))?"":"*";	//삼항연산자 
				k--;			//k를 1씩 빼줘서 반복문 빠져나올수 있도록 설정 
				str_star += str;	// 삼항연산자를 찍어주기 위해
				num -= 1;		//num을 10에서 돌아가는 만큼 1씩 뺌
			}
			while(k>=i);	// 조건문 k보다 i가 작을 때 돌아가라
			
			System.out.print(str_star + num );	// 찍어주기 
			System.out.print("\n");			// 줄바꿈
			str_star="";	//초기화
			num = 10;		//초기화
			i++;   // i값을 1더해서 두번째 while문을 한번 덜 반복하자
		} //end of do
		while(i<9);   // 9번 돌아가도록 반복
	}// end of main
}




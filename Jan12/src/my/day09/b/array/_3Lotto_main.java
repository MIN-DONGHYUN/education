//Random을 받으려면 인덱스 값으로 실행하는 것이 가장 좋다.

package my.day09.b.array;

import java.util.Random;

public class _3Lotto_main {

	public static void main(String[] args) {
		
		//  1 부터  45 까지의 숫자 중 랜덤하게 6개의 숫자를 추출하도록 한다.
		//101 부터 145 까지의 숫자 중 랜덤하게 6개의 숫자를 추출하도록 한다.

		/*
		   int ball ==>   1   2   3 ...  45
		   int ball ==> 101 102 103 ... 145

		   int[] ballArr = new int[45];
		   
		   그림 
		   				-------------------------
		   데이터 값      |1|2|3|4| ...........|45|
		   				-------------------------
		   index        0 1 2 3   ..........  44
		   
		   				----------------------------------
		   데이터 값      |101|102|103|104| ...........|145|
		   				----------------------------------
		   index         0   1   2    3   ..........  44
		*/
		
		int[] ballArr = new int[45];  // 45개의 배열을 생성 
		
		for(int i = 0; i<ballArr.length; i++)
		{
			ballArr[i] = i + 1;   //배열의 방마다 데이터값 입력하기 (초기화) 
							      // 데이터 값은 1 ~ 45
			 					  // 데이터 값 101 ~ 145 하고 싶으면 i + 101을 해주면 된다.
		}	// end of for
		
		
			/*
			   그림
			   			  tempArr
			   			  ---------------------
			   데이터 값 => | -1 | -1 | -1 | -1 | -1 |
			 			  ---------------------
			 	index       0    1    2    3     4
			*/
			// 공의 방번호(index) (ballArr 배열의 index)를 꺼내는 작업을 6번 반복
			// 0번 방 부터 44번 방까지 랜덤하게 6번 뽑아야 한다.
			// 즉, 0 ~ 44 까지 난수를 발생.
			
			// 기존에 뽑았던 방번호(index번호)를 기억시켜주는 저장소 필요 (중복은 불가능하니)
		int[] tempArr = new int[5];  // 임시 index(방번호)를 입력받을 곳 (기억하기 위해)
		
		for(int i = 0; i<tempArr.length; i++)
		{
			tempArr[i] = -1;   //배열의 방마다 데이터값 입력하기 (초기화) 
							      // 데이터 값은 1 ~ 45
		}	// end of for
		
		
		
		Random rnd = new Random();  //Random클래스 생성 
		
		String result = "";  // 결과값 담는 문자열
		
		
		outer:   //레이블 
		for(int i = 0; i < 6; i++)	// 6번 반복한다 6개의 숫자를 뽑기 위해
		{
			
			// 0 ~ 44\
			int idx = rnd.nextInt((44-0+1)+0);   // 랜덤함수 공식이다.
			
			
			for(int j = 0; j < tempArr.length; j++) // tempArr(5)번 반복한다.		// 이것은 비교하는 것이다.
			{
				
				if( idx == tempArr[j])  // 전에 뽑은것과 새로 뽑은것과 같은가??
				{						// 새로이 뽑아온 방번호(index)가 기본에 뽑은것(tempArr[j])과 같다라면 다시 뽑아야 한다.
										//  i =>    0  1  2   3       4    5
										// idx =>   2  5  0   5(꽝)   10   15	
					i--;     			// 전에 뽑은 것과 같다면 i를 증가시키지 않기 위해 i--를 해준다. ///////중요부부///////
					continue outer; 	// 새로운 공 뽑을때까지 하기 위해 레이블로 이동            
				}
				
			}		// end of for
			
			
			if(i < 5)  // 5이상은 배열값에서 없기에 조건을 사용
			{
						// 2를 뽑았다면 기억시키기 위해 밑을 사용
				tempArr[i] = idx;
			    		// 뽑은 방번호(index 번호)를 저장시켜둔다. 
				
						/*
						   그림
						   			  tempArr
						   			  ---------------------
						   데이터 값 => | 2 | 5 | 0 | -1 | -1 |
						 			  ---------------------
						   index       0   1   2   3   4
						*/
			}
			
			String str_add = (i<5)?",":"";    //삼항 연산자 i가 5보다 작으면 , 찍고 넘어가면 공백  
			result += ballArr[idx] + str_add;  // ballArr의 인덱스 번호를 결과에 저장한다. 

		}// end of for 

		System.out.println("로또 \n1등 당첨번호 : " + result);
		
		
	} // end of main()

}



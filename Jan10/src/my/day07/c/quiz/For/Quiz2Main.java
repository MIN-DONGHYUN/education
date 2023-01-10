package my.day07.c.quiz.For;

public class Quiz2Main {

	public static void main(String[] args) {
		
		char ch = 'A';					//초기값 설정 
		for(int i = 0; i < 26; i++)		// 알파벳 숫자는 26개
		{
			if(i%2==0)				// 만약 i/2가 나머지가 0이라면 
			{
				System.out.print((char)(ch+i));		// 대문자
			}
			else						// 만약 i/2가 나머지 0이 아니라면 
			{
				System.out.print((char)(ch+i+32));	//소문자
			}
			if(i == 25)					// 마지막 i가 돌아가는중이라면 ,를 안찍기 위해 break
			{
				break;  				// for문 빠져나감
			}
			System.out.print(",");		// , 를 출력
			
		}// end of for

	}//end of main

}

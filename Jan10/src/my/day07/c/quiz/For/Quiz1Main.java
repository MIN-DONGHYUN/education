package my.day07.c.quiz.For;

import java.util.Scanner;			// scanner을 사용하기 위해 쓴다

public class Quiz1Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		// 키보드로 입력을 받아온다.

		System.out.print(" > 문자열을 입력하세요 : ");	// 출력
		
		String str = sc.nextLine();			//str에 키보드 입력을 받아온다
		
		System.out.println("입력한 문자열 : " + str);	// 출력
		
		System.out.println("입력한 문자열의 길이 : " + str.length());		// 길이 출력 .length는 길이를 출력
		
		
		char ch;						// 변수 선언
		int upper = 0;
		int lower = 0;
		int num = 0;
		int sp = 0;
		for(int i = 0; i <str.length(); i++)		//반복문 문자열 길이 번 까지 반복
		{
			ch = str.charAt(i);							// ch에 문자를 하나씩 대입
			if('A' <= ch && ch < 'Z' )					// 대문자라면
			{
				upper = upper + 1;						//대문자 카운트 1개 추가 
			}
			else if('a' <= ch && ch<='z')				// 소문자라면 
			{
				lower = lower + 1;						//소문자 카운트 1개 추가
			}
			else if('0' <= ch && ch <= '9')				// 숫자라면
			{	
				num = num +1;							//숫자 카운트 1개 추가
			}
			else										//특수문자라면
			{
				sp = sp +1;								//특수문자카운트 1개 추가
			}
		}
		//출력
		System.out.println("대문자 개수 : " + upper + "개");

		System.out.println("소문자 개수 : " + lower + "개");
		
		System.out.println("숫자 개수 : " + num + "개");
		
		System.out.println("특수문자 개수 : " + sp + "개");
		
		
		sc.close();	// 메모리 누수 방지 
	}

}

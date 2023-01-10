package my.day07.c.quiz.For;

import java.util.Scanner;    // util패키지의 scanner 사용

public class Quiz3Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);			// 키보드 입력을 위해 사용 
		
		System.out.print("> 휴대폰 번호를 입력하세요 (예> 010-2345-6789)");		//출력
		
		String str = sc.nextLine();				//문자열 타입으로 키보드 입력한것을 받음 
		
		char ch;								// char 초기화 
		
		for(int i =0; i < str.length() ; i++)	// 문자열 길이까지 반복 
		{
			ch = str.charAt(i);					// 한글자씩 빼서 보기 
			if('0' <= ch && ch <= '9')			// 0~9까지라면 
			{
				System.out.print(ch);			// 문자를 찍어준다.
			}
		}

		sc.close();				// 메모리 누수 방지 

	} // end of main

}

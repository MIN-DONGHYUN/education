package my.day09.b.array;

import my.util.MyUtil;

public class _1SpaceDelete_main {

	public static void main(String[] args) {
		
		// 공백 제거하기
		String str = "  korea   seou l 쌍용 강북 교육센터  ";
		
		System.out.println("시작" + str + "끝");
		//시작  korea   seou l 쌍용 강북 교육센터  끝
		// 기대치 시작koreaseoul쌍용강북교육센터끝
		
		char[] chArr = str.toCharArray(); // tocharArray은 char타입의 배열로 선언 
		
		/*
	   --------------------------------------------------------------------------------------------------------------------------
       |' '|' '|'k'|'o'|'r'|'e'|'a'|' '|' '|' '|'s'|'e'|'o'|'u'|' '|'l'|' '|'쌍'|'용'|' '|'강'|'북'|' '|'교'|'육'|'센'|'터'|' '|' '| 
       --------------------------------------------------------------------------------------------------------------------------  
		*/

		str = "";  // str 초기화 
		for(int i = 0; i <chArr.length; i++)  // chArr배열 길이만큼 반복한다.
		{
			if(chArr[i] != ' ')		// 공백이 아니라면
			{
				str += chArr[i];	// str에 쌓아놓는다.
			}
		}
		System.out.println("시작" + str + "끝");
		//시작koreaseoul쌍용강북교육센터끝
		
		str = "  korea   seou l 쌍용 강북 교육센터  ";
		System.out.println("시작" + str + "끝");
		//시작  korea   seou l 쌍용 강북 교육센터  끝
		
		//my.util 패키지안에 있는 것을 불러온다.
		System.out.println("시작" + MyUtil.space_delete(str) + "끝");
		//시작koreaseoul쌍용강북교육센터끝
		
		
		// null값으로 초기값을 설정한다면 
		str = null;
		System.out.println("시작" + str + "끝");
		//시작null끝
		
		//my.util 패키지안에 있는 것을 불러온다.
		System.out.println("시작" + MyUtil.space_delete(str) + "끝");
		//기대치 : 시작null끝   but 실제 실행시 오류가 발생한다.  java.lang.NullPointerException
		//NULL은 존재하지 않기 때문에 null.을 찍어도 나오지 않는다.(str이나 ""은 .을 찍으면 나온다.)
		// 이유는 str에 null이 들어가면 MyUtil에 null.~~~가 되므로 안된다.
		// 그렇기 때문에 null을 예외처리하기 위해 if문을 사용한다.
		
	
		
	}// end of main

}

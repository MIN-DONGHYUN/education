//2차원 배열을 해보겠다!

package my.day10.a.multiDimension;

public class _1TwoDimensionArray_main {

	public static void main(String[] args) {
		
		// === 1차원 배열 ===
		//int[] subjectArr = new int[5];  // 1행 5열
		/*
					 -----------------------
					 | 0 | 0 | 0 | 0 | 0 | 
					 -----------------------
		    index ==>  0   1   2   3   4 
		*/
		
		// === 2차원 배열 ===
		int [][] pointArr = new int [4][3];	//4행 3열
		/*
			데이터 값
			--------------
			| 0 | 0 | 0 | 
			-------------- 
			| 0 | 0 | 0 |
			--------------
			| 0 | 0 | 0 |
			--------------
			| 0 | 0 | 0 |
			--------------
		    
		    
		    index
			----------------------------
			| [0][0] | [0][1] | [0][2] | 
			---------------------------- 
			| [1][0] | [1][1] | [1][2] | 
			----------------------------
			| [2][0] | [2][1] | [2][2] | 
			----------------------------
			| [3][0] | [3][1] | [3][2] | 
			----------------------------
		*/
		pointArr[0][0] = 10;	//배열 0,0에 10을 저장
		pointArr[0][1] = 20;	//배열 0,1에 20을 저장
		pointArr[0][2] = 30;	//배열 0,2에 30을 저장
		
		pointArr[1][0] = 40;	//배열 1,0에 40을 저장
		//pointArr[1][1] = 50;	//배열 1,1에 50을 저장
		pointArr[1][2] = 60;	//배열 1,2에 60을 저장
		
		//pointArr[2][0] = 70;	//배열 2,0에 70을 저장
		//pointArr[2][1] = 80;	//배열 2,1에 80을 저장
		//pointArr[2][2] = 90;	//배열 2,2에 90을 저장
		
		pointArr[3][0] = 100;	//배열 3,0에 100을 저장
		pointArr[3][1] = 110;	//배열 3,1에 110을 저장
		pointArr[3][2] = 120;	//배열 3,2에 120을 저장
		
		/*
		데이터 값
		--------------------
		| 10  | 20  | 30  | 
		-------------------- 
		| 40  | 50  | 60  |
		--------------------
		| 0   | 0   | 0   |
		--------------------
		| 100 | 110 | 120 |
		--------------------
	    */
		System.out.println("pointArr.length => " + pointArr.length);
		// pointArr.length => 4
		// 2차원배열명.length 은 행의 길이가 나온다.
		
		
		//행에 있는 열의 개수를 나타낸다.
		System.out.println("pointArr[0].length => " + pointArr[0].length);
		// pointArr[0].length => 3
		// 2차원배열명[행인덱스].length 은 그 행에 존재하는 열의 길이가 나온다.
		
		System.out.println("pointArr[1].length => " + pointArr[1].length);
		// pointArr[1].length => 3
		
		System.out.println("pointArr[2].length => " + pointArr[2].length);
		// pointArr[2].length => 3
		
		System.out.println("pointArr[3].length => " + pointArr[3].length);
		// pointArr[3].length => 3
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		for(int i = 0; i < pointArr.length; i++)		// 행의 개수만큼 반복하자
		{
			for(int j = 0; j < pointArr[i].length; j++)	// 열의 개수만큼 반복하자 
			{
				System.out.print(pointArr[i][j] + "\t");
			}
			System.out.print("\n");
		}// end of for
		
		/*
		10  20  30
		40  0   60
		0   0   0
		100 110 120
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i = 0; i < pointArr.length; i++)		// 행의 개수만큼 반복하자
		{
			for(int j = 0; j < pointArr[i].length; j++)	// 열의 개수만큼 반복하자 
			{
				String str_add = (j < pointArr[i].length-1)?"\t":"\n";	// 반복하는중 마지막 이라면 줄바꿈 
				System.out.printf("%3d%s", pointArr[i][j], str_add);	//%3d는 3자리확보후 오른쪽부터 채운다
			}
		}// end of for
		
		/*
		  10	 20	 30
		  40	  0	 60
	  	   0	  0	  0
		 100	110	120
		 */
		
		System.out.println("\n======= 학생별 성적결과 ======\n");
		
							 //국어 영어 수학
		int [][] jumsuArr = { {90, 80, 70},// 이순신점수
							  {80, 85, 76},// 엄정화점수
							  {85, 70, 90},// 서강준점수
							  {60, 80, 50} // 이혜리점수 
							};			
					
		// 1. 각 학생별로 총점을 나타내어 보자.
		for(int i = 0; i < jumsuArr.length; i++)	//행의 개수만큼 반복
		{
			int sum = 0;
			for(int j = 0; j<jumsuArr[i].length; j++)	// 열의 개수만큼 반복 
			{
				sum += jumsuArr[i][j];
			}	//end of for
			
			System.out.println(sum);
		}//end of for
		/*
		  총점 
		  240
		  241
		  245
		  190
		*/
		
		// 2. 각 과목별로 총점을 나타내어 보자.
		System.out.println("\n======= 과목별 성적결과 ======\n");
		for(int i = 0; i < jumsuArr[0].length; i++)	//열의 개수만큼 반복
		{
			int sum = 0;
			for(int j = 0; j<jumsuArr.length; j++)	// 행의 개수만큼 반복 
			{
				sum += jumsuArr[j][i];
			}	//end of for
			
			System.out.println(sum);
		}//end of for
		/*
		  과목
		  315
		  315
		  286
		*/

		
		String[] nameArr = {"이순신","엄정화","서강준","이혜리"};
		
		System.out.println("\n===학생별 총점 ===");
		
		
		
		for(int i = 0; i < jumsuArr.length; i++)	//행의 개수만큼 반복
		{	
			int sum = 0;
			for(int j = 0; j<jumsuArr[i].length; j++)	// 열의 개수만큼 반복 
			{
				sum += jumsuArr[i][j];
			}	//end of for
			
			System.out.println( (i+1) + "." + nameArr[i] + " : " + sum);
		}//end of for
		
		/*
		  === 학생별 총점 ===
		  1.이순신 : 240
		  2.엄정화 : 241
		  3.서강준 : 245
		  4.이혜리 : 190
		*/
		
		System.out.println("\n==== 학생별 점수 집계 ====");
		
		System.out.println("----------------------------------------------\n"
				+ "학생명\t국어\t영어\t수학\t총점\t평균\n"
			    + "----------------------------------------------");
		
		for(int i = 0; i < jumsuArr.length; i++)	//행의 개수만큼 반복
		{			
			String str ="";    //변수설정 
			str += nameArr[i];		// str에 이름 누적 
			int sum = 0;			//숫자 변수 설정 
			
			for(int j = 0; j<jumsuArr[i].length; j++)	// 열의 개수만큼 반복 
			{
				str += "\t" + jumsuArr[i][j];		// 점수 나온것을 str에 누적 
				sum += jumsuArr[i][j];				//숫자를 모두 더한다.
			}	//end of for
			
			str += "\t" + sum + "\t" + (Math.round(sum/3.0*10)/10.0);		//소수부 첫째자리까지 반올림 해서 나타냄 
			
			System.out.println(str);		//출력 
			
			
		}//end of for
		
		
		
		/*
		  
		  ==== 학생별 점수 집계 ====
		  
		  ----------------------------------------------
		  학생명		국어		영어		수학		총점		평균
		  ----------------------------------------------
		  이순신		90		80		70		240		80.0
		  엄정화		80		85		76		241		80.3
		  서강준		85		70		90		245		81.7
		  이혜리		60		80		50		190		63.3	
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("\n==== 과목별 평균 ====\n");
		
		System.out.println("------------------\n"
						 + "국어\t영어\t수학\n"
						 + "------------------"
							);
		
		String result=""; //누적하기위해
		
		for(int i = 0; i < jumsuArr[0].length; i++)	//열의 개수만큼 반복
		{
			int sum = 0;
			for(int j = 0; j<jumsuArr.length; j++)	// 행의 개수만큼 반복 
			{
				sum += jumsuArr[j][i];
			}	//end of for
			
			result += (Math.round((double)sum/jumsuArr.length*10)/10.0) + "\t";  // 평균을 누적
		}//end of for
		
		System.out.println(result);		//출력
		
		/*
			==== 과목별 평균 ====
			
			------------------
			국어    영어    수학
			------------------
			78.8   78.8   71.5
		*/
		
		
					
		
	} // end of main

}

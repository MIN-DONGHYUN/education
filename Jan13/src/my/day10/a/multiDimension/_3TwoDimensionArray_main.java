//2차원 배열을 해보겠다!

package my.day10.a.multiDimension;

public class _3TwoDimensionArray_main {

	public static void main(String[] args) {
		
		// === 2차원 배열 ===
		int [][] pointArr = new int [4][];	//4행 null열
		
		/*
		 
		// 얄의 크기를 설정하지 않았으므로 java.lang.NullPointerException 발생함.
		  
		  
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
		*/
		
		pointArr[0] = new int[3];  // 0행은 3열로 설정한다.
		pointArr[1] = new int[2];  // 1행은 2열로 설정한다.
		pointArr[2] = new int[4];  // 2행은 4열로 설정한다.
		pointArr[3] = new int[3];  // 3행은 3열로 설정한다.
		
		pointArr[0][0] = 10;	//배열 0,0에 10을 저장
		pointArr[0][1] = 20;	//배열 0,1에 20을 저장
		pointArr[0][2] = 30;	//배열 0,2에 30을 저장
		
		pointArr[1][0] = 40;	//배열 1,0에 40을 저장    //1행은 2개의 배열뿐인데 3개가 들어가면 오류가 생긴다.
		pointArr[1][1] = 50;	//배열 1,1에 50을 저장
		//pointArr[1][2] = 60;	//배열 1,2에 60을 저장    //java.lang.ArrayIndexOutOfBoundsException: 2 발생한다

		pointArr[2][0] = 70;	//배열 2,0에 70을 저장    //2행은 4열까지 배열이 있는데 그보다 작은 수를 받아오므로 오류 안생긴다.
		pointArr[2][1] = 80;	//배열 2,1에 80을 저장
		pointArr[2][2] = 90;	//배열 2,2에 90을 저장
		pointArr[2][3] = 100;	//배열 2,3에 100을 저장
		
		/*
		데이터 값
		--------------
		| 0 | 0 | 0 | 
		-------------- 
		| 0 | 0 |
		------------------
		| 0 | 0 | 0 | 0 |
		------------------
		| 0 | 0 | 0 |
		--------------
	    
	    
	    index
		----------------------------
		| [0][0] | [0][1] | [0][2] | 
		---------------------------- 
		| [1][0] | [1][1] | 
		---------------------------------------
		| [2][0] | [2][1] | [2][2] | [2][3] | 
		---------------------------------------
		| [3][0] | [3][1] | [3][2] | 
		----------------------------
		
		실제값
		--------------
		| 10 | 20 | 30 | 
		-------------- 
		| 40 | 50 |
		-----------------------
		| 70 | 80 | 90 | 100 |
		-----------------------
		| 0 | 0 | 0 |
		--------------
	*/
		
		for(int i = 0; i < pointArr.length; i++)	//행 개수만큼 반복
		{
			for(int j = 0; j < pointArr[i].length; j++)	//열 개수만큼 반복
			{
				String str_add = (j<pointArr[i].length-1)?"\t":"\n";		//삼항연산자
				System.out.printf("%3d%s",pointArr[i][j], str_add);	//3자리 확보후 오른쪽으로 채워줌 + str_add
			}
		}
		/*
		    10	 20	 30
 			40	 50
			70	 80	 90	100
			0	 0	 0

		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		int [][] numArr = { {10,20,30},
							{40,50},
							{70,80,90,10},
							{0,0,0}};		// 0이라도 0을 쓰지 않는다면 값이 나오지 않는다.
		
		for(int i = 0; i < numArr.length; i++)	//행 개수만큼 반복
		{
			for(int j = 0; j < numArr[i].length; j++)	//열 개수만큼 반복
			{
				String str_add = (j<numArr[i].length-1)?"\t":"\n";		//삼항연산자
				System.out.printf("%3d%s",numArr[i][j], str_add);	//3자리 확보후 오른쪽으로 채워줌 + str_add
			}
		}
		/*
	    10	 20	 30
			40	 50
		70	 80	 90	100
		0	 0	 0

	    */
		
		System.out.println("\n== 프로그램 종료 ==");
		
		

	} // end of main

}
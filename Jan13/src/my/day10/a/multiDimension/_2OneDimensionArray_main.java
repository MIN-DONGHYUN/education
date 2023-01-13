package my.day10.a.multiDimension;

public class _2OneDimensionArray_main {

	public static void main(String[] args) {
		
		Sungjuk[] sjArr = {new Sungjuk("이순신",90,80,70),	//성적에 대한 4개 인스턴스를 가짐 인스턴스 속에는 4개의 필드를가짐 
						   new Sungjuk("엄정화",80,85,76),
						   new Sungjuk("서강준",85,70,90),
						   new Sungjuk("이혜리",60,80,50)};	// Sungjuk 필드에 있는 것을 가져옴 
		// sjArr의 배열의 길이는 4이다.
		
		
		System.out.println("\n==== 학생별 점수 집계 ====");
		
		System.out.println("----------------------------------------------\n"
				+ "학생명\t국어\t영어\t수학\t총점\t평균\n"
			    + "----------------------------------------------");
		
		for(int i = 0; i < sjArr.length; i++)		// 행의 수만큼 반복
		{
			System.out.println(sjArr[i].showInfo());	//출력
			
		}// end of for 
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
		
		int sum_kor = 0, sum_eng = 0, sum_math = 0;  // 누적시키기위해 선언
		
		for(int i = 0; i < sjArr.length; i++)	//열의 개수만큼 반복, 시험을 본 사람 수
		{
			 
			sum_kor += sjArr[i].kor;  //각각의 총점을 나타낸다.
			sum_eng += sjArr[i].eng;
			sum_math += sjArr[i].math;
		}//end of for
		
		double avg_kor = Math.round((double)sum_kor/sjArr.length * 10)/10.0;	// double타입으로 평균값 하기
		double avg_eng = Math.round((double)sum_eng/sjArr.length * 10)/10.0;
		double avg_math = Math.round((double)sum_math/sjArr.length * 10)/10.0;
		
		System.out.println(avg_kor + "\t" + avg_eng + "\t" + avg_math);	// 출력
		/*
			==== 과목별 평균 ====
			
			------------------
			국어    영어    수학
			------------------
			78.8   78.8   71.5
		*/
		
		
	}

}

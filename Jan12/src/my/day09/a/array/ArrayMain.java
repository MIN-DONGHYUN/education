package my.day09.a.array;

public class ArrayMain {
	
	// === 메소드 파라미터 가변인수 사용하기 ===
	public int hapgae(int ... point) {  // ... 은 가변이라는 것으로 파라미터가 내가 준대로 나온다.
		
		int total = 0;
		for(int i = 0; i<point.length; i++ ) //point가 배열 비슷하게 쓰이기 때문에 가능하다.
		{
			total += point[i];
		}
		
		return total;
	}// end of public int hapgae(int ... point)
	

	public static void main(String[] args) {
		
		/*
		   ===배열(array)이란 ? ===
		   
		   자바의 배열은 동일한 데이터타입을 가지는 여러개의 데이터를 저장할 수 있는 데이터 타입을 말한다.(저장 장소)
		   그리고 배열 또한 객체라는 것을 꼭 기억하도록 하자 !!!!!!!!!!!!!!!!
		   
		*/
		
		// 1. == 배열의 선언 ==
		int [] subjectArr;
		//또는 
		// int subjectArr2 [];

		// 2 == 선언되어진 배열을 메모리에 할당을 해준다. ==
		subjectArr = new int [7];   // 7개의 배열이 저장된다.
		
		/*
		    ------------------------
		    |0||1||2||3||4||5||6||7|
		    ------------------------
		    위의 숫자는 배열의 인덱스(index)를 가리키는 번호로써 0부터 시작하여 1씩 증가한다.
		    배열의 인덱스(index)를 "배열의 방법호"라고 흔히 부른다.
		    
		    배열에 저장된 데이터를 표현할때는 아래와 같이 배열명[인덱스번호] 로 나타낸다.
		    
		    subjectArr[0]
		    subjectArr[1]
		    subjectArr[2]
		    subjectArr[3]
		    subjectArr[4]
		    subjectArr[5]
		    subjectArr[6]
		    
		    subjectArr[7]  ==> 존재하지 않으므로 오류!!
		    
		    배열로 선언된 변수에는 자동적으로 초기값이 들어간다.
		    정수는 0, 실수는 0.0, char는 ' ', String을 포함한 객체는 null로 초기화되어 들어간다.
		    
		 */
		
		
		// == 배열의 크기(길이)는 배열명.length 로 알아온다. == 
		System.out.println("배열 subjectArr 의 길이 : " + subjectArr.length);
		
		for(int i = 0; i < subjectArr.length; i++)   // 배열의 길이까지 반복한다.
		{
			System.out.println("subjectArr[" + i + "] = " + subjectArr[i]);   // 배열을 한번 출력해보자 
			/*
			 	subjectArr[0] = 0
				subjectArr[1] = 0
				subjectArr[2] = 0
				subjectArr[3] = 0
				subjectArr[4] = 0
				subjectArr[5] = 0
				subjectArr[6] = 0
			 */
		} // end of for 
		
		// 3. == 선언되어진 배열에 값을 넣어주기 ==
			subjectArr[0] = 100;  // 국어
			subjectArr[1] = 90;  // 영어
			subjectArr[2] = 95;  // 수학
			subjectArr[3] = 70;  // 과학
			subjectArr[4] = 98;  // 사회
			subjectArr[5] = 100;  // 음악
			subjectArr[6] = 90; // 체육
		// 점수를 하나씩 일일이 대입해보았다.
			
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
			
		System.out.println("배열 subjectArr 의 길이 : " + subjectArr.length);
			
		for(int i = 0; i < subjectArr.length; i++)   // 배열의 길이까지 반복한다.
		{
			System.out.println("subjectArr[" + i + "] = " + subjectArr[i]);   // 배열을 한번 출력해보자 	
		} // end of for 
		/*
		  	subjectArr[0] = 100
			subjectArr[1] = 90
			subjectArr[2] = 95
			subjectArr[3] = 70
			subjectArr[4] = 98
			subjectArr[5] = 100
			subjectArr[6] = 90
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		int sum = 0;  // 총점을 나타내기위해 변수 설정 
		
		for(int i = 0; i < subjectArr.length; i++)   // 배열의 길이까지 반복해라 
		{
			sum += subjectArr[i];     //sum에 배열 0부터 6까지 더한다.
		} // end of for 
		
		System.out.println("총점 : " + sum);
		//총점 : 643
		
		
		// 평균을 구해보자!!!!!!!!!!!!!!11//
		double avg = (double)sum/subjectArr.length;  // 평균을 실수로 나타내기 위해 실수로 선언 
		
		System.out.println("평균 : " + avg);
		//평균 : 91.85714285714286
		
		//소수부 첫째자리까지 반올림 하고 싶다면 반올림 할수있는 Math.round를 사용한다.
		avg = Math.round((double)sum/subjectArr.length * 10)/10.0;  // 평균을 소수 첫째자리까지 나타내기 위해 반올림을 사용한다.
		System.out.println("평균 : " + avg);
		// 평균 : 91.9

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		
		/*
		   위의 1. == 배열의 선언 == 과 
		   2 == 선언되어진 배열을 메모리에 할당을 해준다. == 을 
		   각각 따로 하지 않고 아래와 같이 동시에 할 수 있다.
     	*/
		int [] subjectArr2 = new int [7];   // 7개의 배열이 저장된다;
		
		// 3. == 선언되어진 배열에 값을 넣어주기 ==
					subjectArr2[0] = 100;  // 국어
					subjectArr2[1] = 90;  // 영어
					subjectArr2[2] = 95;  // 수학
					subjectArr2[3] = 70;  // 과학
					subjectArr2[4] = 98;  // 사회
					subjectArr2[5] = 100;  // 음악
					subjectArr2[6] = 90; // 체육
				// 점수를 하나씩 일일이 대입해보았다.
					
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
					
			System.out.println("배열 subjectArr 의 길이 : " + subjectArr.length);
					
			for(int i = 0; i < subjectArr2.length; i++)   // 배열의 길이까지 반복한다.
			{
				System.out.println("subjectArr2[" + i + "] = " + subjectArr2[i]);   // 배열을 한번 출력해보자 	
			} // end of for 
			/*
				 	subjectArr2[0] = 100
					subjectArr2[1] = 90
					subjectArr2[2] = 95
					subjectArr2[3] = 70
					subjectArr2[4] = 98
					subjectArr2[5] = 100
					subjectArr2[6] = 90
			*/
				
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
				
			sum = 0;  // 총점을 나타내기위해 변수 설정 
				
			for(int i = 0; i < subjectArr2.length; i++)   // 배열의 길이까지 반복해라 
			{
				sum += subjectArr2[i];     //sum에 배열 0부터 6까지 더한다.
			} // end of for 
				
			System.out.println("총점 : " + sum);
			//총점 : 643
				
				
			// 평균을 구해보자!!!!!!!!!!!!!!11//
			avg = (double)sum/subjectArr2.length;  // 평균을 실수로 나타내기 위해 실수로 선언 
				
			System.out.println("평균 : " + avg);
			//평균 : 91.85714285714286
				
			//소수부 첫째자리까지 반올림 하고 싶다면 반올림 할수있는 Math.round를 사용한다.
			avg = Math.round((double)sum/subjectArr2.length * 10)/10.0;  // 평균을 소수 첫째자리까지 나타내기 위해 반올림을 사용한다.
			System.out.println("평균 : " + avg);
			// 평균 : 91.9

			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
			
			
			
			/*
			   위의 1. == 배열의 선언 == 과 
			   2 == 선언되어진 배열을 메모리에 할당을 해준다. == 을 
			   3. == 선언되어진 배열에 값을 넣어주기 ==
			   각각 따로 하지 않고 아래와 같이 동시에 할 수 있다.
	     	*/
			
			int [] subjectArr3 = new int [] {100,90,95,70,98,100,90};   // 7개의 배열이 저장된다;
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
			
			sum = 0;  // 총점을 나타내기위해 변수 설정 
				
			for(int i = 0; i < subjectArr3.length; i++)   // 배열의 길이까지 반복해라 
			{
				sum += subjectArr3[i];     //sum에 배열 0부터 6까지 더한다.
			} // end of for 
				
			System.out.println("총점 : " + sum);
			//총점 : 643
				
				
			// 평균을 구해보자!!!!!!!!!!!!!!11//
			avg = (double)sum/subjectArr3.length;  // 평균을 실수로 나타내기 위해 실수로 선언 
				
			System.out.println("평균 : " + avg);
			//평균 : 91.85714285714286
				
			//소수부 첫째자리까지 반올림 하고 싶다면 반올림 할수있는 Math.round를 사용한다.
			avg = Math.round((double)sum/subjectArr3.length * 10)/10.0;  // 평균을 소수 첫째자리까지 나타내기 위해 반올림을 사용한다.
			System.out.println("평균 : " + avg);
			// 평균 : 91.9

			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
			
			
			/*
			   위의 1. == 배열의 선언 == 과 
			   2 == 선언되어진 배열을 메모리에 할당을 해준다. == 을 
			   3. == 선언되어진 배열에 값을 넣어주기 ==
			   각각 따로 하지 않고 아래와 같이 동시에 할 수 있다.
			   new int[] 은 생략 가능하다.!!!!!!!!!!!!!!!!!!!!!!!!!!
	     	*/
			
			int [] subjectArr4 = {100,90,95,70,98,100,90};   // 7개의 배열이 저장된다;
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
			
			sum = 0;  // 총점을 나타내기위해 변수 설정 
				
			for(int i = 0; i < subjectArr4.length; i++)   // 배열의 길이까지 반복해라 
			{
				sum += subjectArr4[i];     //sum에 배열 0부터 6까지 더한다.
			} // end of for 
				
			System.out.println("총점 : " + sum);
			//총점 : 643
				
				
			// 평균을 구해보자!!!!!!!!!!!!!!11//
			avg = (double)sum/subjectArr4.length;  // 평균을 실수로 나타내기 위해 실수로 선언 
				
			System.out.println("평균 : " + avg);
			//평균 : 91.85714285714286
				
			//소수부 첫째자리까지 반올림 하고 싶다면 반올림 할수있는 Math.round를 사용한다.
			avg = Math.round((double)sum/subjectArr4.length * 10)/10.0;  // 평균을 소수 첫째자리까지 나타내기 위해 반올림을 사용한다.
			System.out.println("평균 : " + avg);
			// 평균 : 91.9

			System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
			
			
			/// >>> 확장된 for문(== 개선된 for문, == for each문)
			
			int total = 0;
			for(int subj : subjectArr4) {
				// 확장된 for문에서 : 다음에는 배열명이 온다.
				// 확장된 for문에서 : 다음에는 collection명이 온다. (몇주뒤에 배움)
				
				// 반복의 회수는 subjectArr4 배열의 길이만큼 반복한다. (지금 이 코드는 7번)
				// int subj = subject4[0];
				// int subj = subject4[1];
				// int subj = subject4[2];
				// int subj = subject4[3];
				// int subj = subject4[4];
				// int subj = subject4[5];
				// int subj = subject4[6];
				System.out.println(subj);
				total += subj;
			}
			System.out.println("총점(total) : " + total);
			//총점(total) : 643
			
			
			
			//참고로 알아두기!!!!!!!!!!!!!!//
			System.out.println("\n ===== 메소드 피라미터 가변인수 사용하기 ===== \n");
			
			ArrayMain am1 = new ArrayMain();
			
			System.out.println("총점(100,90,95,70,98,100,90) : " + am1.hapgae(100,90,95,70,98,100,90));
			// 기대치 총점(100,90,95,70,98,100,90) : 643
			
			System.out.println("총점(90,95,70,98,90) : " + am1.hapgae(90,95,70,98,90));
			// 기대치 총점(90,95,70,98,90) : 443
			
			
			
			
	}

}

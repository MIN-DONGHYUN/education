package my.day11.a.string;

import java.text.DecimalFormat;

import my.util.MyUtil;

public class StringMain {

	public static void main(String[] args) {
		
		//      === 1. "문자열".charAt(int index) === 
		//          "안녕하세요".charAt(2) == > '하'
		// index =>   01234
		
		
		char ch = "안녕하세요".charAt(2);			// 2번째 단어를 뽑아내라
		System.out.println("ch => " + ch);		// ch를 출력
		//결과 : ch => 하;
		
		String str = "안녕하세요";					// 문자열 출력 위해 선언 
		
		String result ="";		
		
		for(int i=str.length()-1; i>=0; i--)		// 문자열 길이 -1 은 마지막 인덱스를 나타낸다.
		{
			result += str.charAt(i);			// 거꾸로 출력하기 위해 높은 숫자부터 낮은숫자까지로 반복 하여 단어 뽑아냄
		}
		
		System.out.println(result);			// 결과 출력 
		//결과 : 요세하녕안
		
		
		// === 2. "문자열".toCharArray() ===
		// "안녕하세요".toCharArray() ==> char 타입의 배열로 만들어준다.
		// -----------------------------------------
		// |'안'|'녕'|'하'|'세'|'요'|
		//   0   1    2   3    4   <== index
		
		char[] chArr = "안녕하세요".toCharArray();			// char타입의 배열을 선언 
		result = ""; 		// result 초기화
		
		for(int i=chArr.length-1; i>=0;i--)			// 문자열 길이 -1 은 마지막 인덱스를 나타낸다.
		{										// 거꾸로 출력하기 위해 높은 숫자부터 낮은숫자까지로 반복 하여 단어 뽑아냄
		
			result += chArr[i];				// 배열 하나씩 확인 
		}
		
		System.out.println(result);
		
		
		// === 3. "문자열".substring(int 시작인덱스, int 끝인덱스) ===
		//"안녕하세요".substring(1,4) ==> 1번 인덱스인 "녕" 부터 4번 인덱스 앞에까지인 "세" 까지만 뽑아온다.
		// 01234
		// 문자열의 일부분을 따올 수 있음
		
		str = "안녕하세요".substring(1,4);
		System.out.println(str);
		// 결과 : 녕하세
		
		
		str = "안녕하세요";
		System.out.println(str.substring(2,str.length()));		// '하'부터 5번인덱스 앞인 '요'까지 뽑아온다.
		// 결과 : 하세요 											// 끝은 안써도 무방 
		
		
		
		// === 4. "문자열".substring(int 시작인덱스) ===
		//"안녕하세요".substring(2) ==> 2번 인덱스인 "하"부터 끝까지 뽑아온다.
		// 01234
		// 문자열의 일부분을 따올 수 있음
				
		str = "안녕하세요".substring(2);
		System.out.println(str);
		// 결과 : 하세요 
		
		
		
		// === 5. "문자열".indexOf("찾을 문자열") === 
		//        "문자열" 에서 최초로 나오는 "찾을 문자열"의 인덱스(int)를 알려준다.!!!
		int index = "시작하라 안녕하세요 건강하세요".indexOf("하");			// '하'가 3개 중 첫번째 인덱스 값 나옴  
				//   0123 4 56789 10 1112131415
		System.out.println(index);
		// 결과값 : 2
		
		index = "시작하라 안녕하세요 건강하세요".indexOf("하세");			// '하세'중 1번째 인덱스 값 나옴
			//   0123 4 56789 10 1112131415
		System.out.println(index);
		//결과 : 7
		
		index = "시작하라 안녕하세요 건강하세요".indexOf("A");			// 'A'중 1번째 인덱스 값 나옴
			//   0123 4 56789 10 1112131415						// 찾고자하는 문자열이 없을시 -1이 나온다.	
		System.out.println(index);
		//결과 : -1 
		
		
		
		
		// === [퀴즈] === //
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("\n=== [퀴즈] ===");
		
		String[] fileNameArr = {"C:/mydocument/resume/나의이력서.hwp",
								"D:/mymusic.mp3",
								"C:/photo/내얼굴.jpg"};			// 3개의 배열 
		
		for(int i=0;i<fileNameArr.length; i++)
		{
			System.out.println(fileNameArr[i]);
		}	// end of for
		// 결과 : 
		//C:/mydocument/resume/나의이력서.hwp
		//D:/mymusic.mp3
		//C:/photo/내얼굴.jpg

		System.out.println("\n=== 파일명만 뽑아온 결과 ==="); 			// 방향을 거꾸로 보고 하면 /가 나오기 전까지만 출력하면 된다.
		
		for(int i=0; i < fileNameArr.length; i++ )
		{
			char[] chrArr = fileNameArr[i].toCharArray();		// char타입의 배열로 저장 
			
			String str_reverse = "";  	// 저장할 곳 선언 
			for(int j = chrArr.length-1; j >=0; j--)		// 모든 char의 배열 길이 만큼 반복
			{
				str_reverse += chrArr[j];			// 거꾸로 출력
			}
			
			//System.out.println(str_reverse);
			//pwh.서력이의나/emuser/tnemucodym/:C
			//3pm.cisumym/:D
			//gpj.굴얼내/otohp/:C
			
			str_reverse.substring(0, str_reverse.indexOf("/"));		// 인덱스 0부터 인덱스 최초의 "/" 앞까지 출력한다.
			
			//System.out.println(str_reverse.substring(0, str_reverse.indexOf("/")));
			
			chrArr = str_reverse.substring(0, str_reverse.indexOf("/")).toCharArray();		//char타입 배열로 다시 넣어준다.
			
			String output = "";  	// 저장할 곳 선언 
			for(int j = chrArr.length-1; j >=0; j--)		// 모든 char의 배열 길이 만큼 반복
			{
				output += chrArr[j];			// 거꾸로 출력
			}
			
			System.out.println(output);		
			//나의이력서.hwp
			//mymusic.mp3
			//내얼굴.jpg
			
			// 즉 거꾸로 돌리고 첫번째 "/"를 찾고 다시 거꾸로 돌리면 된다.	
			
		}	// end of for
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
		
		// === 6. "문자열".lastIndexOf("찾을 문자열") === 
		//        "문자열" 에서 마지막으로 나오는 "찾을 문자열"의 인덱스(int)를 알려준다.!!!
		
		index = "시작하라 안녕하세요 건강하세요".lastIndexOf("하");			// '하'가 3개 중 첫번째 인덱스 값 나옴  
			//   0123 4 56789 10 1112131415
		System.out.println(index);
		// 결과값 : 13

		index = "시작하라 안녕하세요 건강하세요".lastIndexOf("하세");			// '하세'중 1번째 인덱스 값 나옴
			//   0123 4 56789 10 1112131415
		System.out.println(index);
		//결과 : 13
		
		index = "시작하라 안녕하세요 건강하세요".lastIndexOf("A");			// 'A'중 1번째 인덱스 값 나옴
			//   0123 4 56789 10 1112131415						// 찾고자하는 문자열이 없을시 -1이 나온다.	
		System.out.println(index);
		//결과 : -1 
		
		
		System.out.println("\n=== [퀴즈] ===");
		// === [퀴즈] === //
		
		// 결과 : 
		//C:/mydocument/resume/나의이력서.hwp
		//D:/mymusic.mp3
		//C:/photo/내얼굴.jpg
		
		for(int i=0;i<fileNameArr.length; i++)		// fileNameArr 배열만큼 반복 
		{
			System.out.println(fileNameArr[i].substring(fileNameArr[i].lastIndexOf("/")+1));	// .substring은 어느 인덱스부터 시작하여 끝까지 출력하기위해
																					// .lastIndexof("/")는 마지막 /를 찾아 인덱스에 넣는다. 
																					// 그 다음 인덱스부터 출력하면 /가 안나옴 
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// === [퀴즈] ===
		System.out.println("\n=== [퀴즈] ===");
		
		String money = "2,000,000";
		
		/*	// ==============내가 풀어본 식 ================
		String money1 = "";
		
		//indexOf 와 substring 만 사용하여 구해보세요 
		
		for(int i = 0; i < money.length(); i++);
		{
			money1 += money.substring(money.indexOf(",")-1,money.indexOf(","));
			money1 += money.substring(money.indexOf(",")+1,money.lastIndexOf(","));
			money1 += money.substring(money.lastIndexOf(",")+1);
			
		}
		
		System.out.println(money1);
		// "2000000"
		*/
		
		
		
		// ========수업 풀이 ==============//
		//indexOf 와 substring 만 사용하여 구해보세요 
		// "2,000,000"에서 "2,000,000".index("," 를 하면 최초로 ","가 나타난다. 즉 1이 나온다.
		// "2" + "000,000" ==> "2000,000"
		// "2" => "2,000,000".substring(0,1) == "2"가 나온다.
		// "000,000" ==> "2,000,000".substring(1+1) => "000,000" 가 나온다.
		
		// 여기까지의 결과물은 "2000,000"
		
		// "2,000,000"에서 "2000,000".index("," 를 하면 최초로 ","가 나타난다. 즉 4이 나온다.
		// "2000" + "000" ==> "2000000"
		// "2000" => "2000,000".substring(0,4) == "2000"가 나온다.   index4번 위치 앞까지
		// "000" ==> "2,000,000".substring(5) => "000" 가 나온다.  index5부터 끝까지이면 결과가 나옴
				
		// "2000000" 에서 "2000000".index("," 를 하면 최초로 ","가 나타난다. 지금은 ","가 없으므로 즉 -1이 나온다.
		
		do
		{
			int index_comma = money.indexOf(",");	// ,의 index값을 찾는다.
			if(index_comma == -1)	// , 가 없으면 -1의 값을 가지게 되므로 반복문 탈출
			{
				break;		// while문 탈출
			}
			money = money.substring(0,index_comma) + money.substring(index_comma+1);		//, 한개씩 빠진 money를 출력하기위해			
			
		}while(true);
		
		
		System.out.println(money);
		// "2000000"
		
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		long sum = MyUtil.delComma("2,000,000") + MyUtil.delComma("5,000") + MyUtil.delComma("100");
		// 2000000 + 5000 + 100
		// 2005100
		
		
		// 이것은 콤마를 넣어주는 것이다.!!!!!!!!!!!!!!!!!!!!!!!!!!//
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format(sum));
		//2,005,100
		
		
		
		// === 7. "문자열".split("구분자") === 
		//        "문자열" 을 "구분자" 로 잘라서 string 타입의 배열로 돌려주는 것이다.
		
		System.out.println("\n 1. ==================== \n");
		String food = "파스타,국밥,볶음밥,고구마,계란말이";
		
		String[] foodArr = food.split(",");		// 문자열을 ,(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		System.out.println("\n 2. ==================== \n");
		food = "파스타	국밥	볶음밥	고구마	계란말이";
		
		foodArr = food.split("\t");		// 문자열을 \t(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)			// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);			// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		
		// 구분자 .은 구분을 하지 못하여 배열로 만들수 없다.
		System.out.println("\n 3. ==================== \n");
		food = "파스타.국밥.볶음밥.고구마.계란말이";
		
		foodArr = food.split(".");		// 문자열을 .(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 0
		// 즉 . 단독만으로는 구분자로 인식을 못한다.
		// split 사용시 구분자로 . | / 등 특수문자를 사용하려고 할 경우에는 구분자로 인식을 못할 경우가 많으므로 
		// 구분자 앞에 \\ 를 붙이거나 구분자를 [] 로 씌워주면 된다.
		// 즉 , \\구분자  이거나 [구분자] 로 사용하면 구분자를 나타낼 수 있다.
		
		
		foodArr = food.split("\\.");		// 문자열을 .(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		
		foodArr = food.split("[.]");		// 문자열을 .(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		
		System.out.println("\n 4. ==================== \n");
		food = "파스타|국밥|볶음밥|고구마|계란말이";
		
		foodArr = food.split("\\|");		// 문자열을 |(구분자)로 쪼개서 배열에 저장한다.
		//또는 
		//foodArr = food.split("[|]");
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		
		System.out.println("\n 5. ==================== \n");
		food = "파스타,국밥.볶음밥	고구마,계란말이";
		
		foodArr = food.split("\\,|\\.|\\t");		// 문자열을 , . \t(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		
		System.out.println("\n 6. ==================== \n");
		food = "파스타,국밥.볶음밥	고구마|계란말이";
		
		foodArr = food.split("\\,|\\.|\\t|\\|");		// 문자열을 , . \t, |(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		
		System.out.println("\n 7. ==================== \n");
		food = "파스타,국밥.볶음밥	고구마|계란말이";
		
		foodArr = food.split("[,.\t|]");		// 문자열을 , . \t, |(구분자)로 쪼개서 배열에 저장한다.
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		System.out.println("\n 8. ==================== \n");
		food = "파스타1국밥2볶음밥3고구마4계란말이";
		
		foodArr = food.split("\\d");		// 문자열을 숫자(구분자)로 쪼개서 배열에 저장한다.
		// \\d 에서 d는 정규표현식의 하나로써 숫자를 의미한다.
		// 즉 , 숫자가 구분자가 되는 것이다.
		
		// {"파스타", "국밥", "볶음밥", "고구마", "계란말이"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		   파스타
		   국밥
		   볶음밥
		   고구마
		   계란말이
		 */
		
		System.out.println("\n 9. ==================== \n");
		food = "파스타1국밥2볶음밥3고구마4계란말이";
		
		foodArr = food.split("\\D");		//소문자 d는 숫자를 구분하지만 대문자 D는 다르다
		// \\D 에서 D는 정규표현식의 하나로써 숫자부정을 의미한다.( 숫자가 아닌것을 의미한다.)
		// 즉 , 숫자가 아닌것이 구분자가 되는 것이다.
		
		// {"1", "2", "3", "4"}
		
		System.out.println("foodArr.length => " + foodArr.length);	// 배열의 길이 출력
		//foodArr.length => 5
		
		for(int i=0;i<foodArr.length; i++)		// 배열 길이만큼 반복 
		{
			System.out.println(foodArr[i]);		// 문자열을 출력 
		}
		/*
		 	1
		 	
		 	2
		 	
		 	
		 	3
		 	
		 	
		 	4
		 */
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		// == <참고>  \ 를 'escape 문자'라고 부른다.
		System.out.println("나의 이름은 \"이순신\" 입니다.");	// \"는 "를 출력할 수 있다.
		
		System.out.println("C:\\movie\\아바타2.mp4");		// \\를 사용하면 \를 출력할 수 있다.
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// === 8. String.join("구분자", 문자열타입의 배열명 ) === 
		//		  문자열타입의 배열을 "구분자"로 합쳐서 String 타입으로 돌려주는 것이다.
		
		String [] nameArr = {"한석규","두석규","세석규","네석규","오석규"};

		String names = String.join("-",  nameArr);
		System.out.println(names);
		//한석규-두석규-세석규-네석규-오석규
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		str = "시작하세요 안녕하세요 건강하세요";
		// 위의 str에 저장된 문자열에서 하세요만 삭제한 결과물을 나타내세요.
		
		//str.split("하세요"); ==> {"시작", " 안녕", " 건강")
		System.out.println(str+"\n");
		
		str = String.join("", str.split("하세요"));		//하세요를 빼고 공백을 넣어준다.
		
		System.out.println(str);
		// 시작 안녕 건강
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		str = "103-23-523-009";			// 통장번호라고 하자
		
		str = String.join("", str.split("[-]"));	// -를 ""으로 합친다.
		
		System.out.println(str);		// 출력
		// 10323523009
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// 공백을 없애보도록 하자 
		str = "   안녕    하세요   내일은  화   요   일  이네요    ";		
		
		str = String.join("", str.split(" "));	// 공백을 ""으로 합쳐서 공백을 없앤다.
		
		System.out.println(str);		// 출력
		// 안녕하세요내일은화요일이네요
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
			
		
		
		
		// === 9. "문자열".replaceAll("변경대상 문자열", "새로이 변경될 문자열"); === 
		//        "문자열" 에서 "변경대상문자열"을 모두 "새로이변경될 문자열" 로 교체해서 반환해주는 것이다.
		names = names.replaceAll("석규", "SK");
		System.out.println(names);
		//한SK-두SK-세SK-네SK-오SK
		
		
		// === 10. "문자열".replaceFirst("변경대상 문자열", "새로이 변경될 문자열"); === 
		//        "문자열" 에서 "변경대상문자열"을 첫번째만 "새로이변경될 문자열" 로 교체해서 반환해주는 것이다.
		names = names.replaceFirst("SK", "석규");
		System.out.println(names);
		//한석규-두SK-세SK-네SK-오SK
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		//////// === "문자열".replace() 와 "문자열".replaceAll() 의 차이점 === ////////
		//           "문자열".replace()는 정규표현식을 사용할 수 없다.
		//			  하지만 
		//			 "문자열".replacAll()은 정규표현식을 사용할 수 있다.
		
		
		str = "103-23-523-009";			// 통장번호라고 하자
		
		str = str.replaceAll("-", "");			// -가 있다면 모두 공백으로 교체해라 
		
		System.out.println(str);		// 출력
		// 10323523009
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		str = "103-23-523-009";			// 통장번호라고 하자
		
		str = str.replace("-", "");			// -가 있다면 모두 공백으로 교체해라 
		
		System.out.println(str);		// 출력
		// 10323523009
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// 공백을 없애보도록 하자 
		str = "   안녕    하세요   내일은  화   요   일  이네요    ";		
				
		str = str.replaceAll(" ", "");
		
		System.out.println(str);		// 출력
		// 안녕하세요내일은화요일이네요
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// 공백을 없애보도록 하자 
		str = "   안녕    하세요   내일은  화   요   일  이네요    ";		
				
		str = str.replace(" ", "");
		
		System.out.println(str);		// 출력
		// 안녕하세요내일은화요일이네요
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		str = "java abcd javascript";
		str = str.replace("abc", "");			// abc를 삭제시켜보자 (연속되어진 abc)
		System.out.println(str);
		// java d javascript
		
		
		//변수 str에서 a 또는 b 또는 C 라는 글자가 있으면 삭제하려고 한다.
		str = "java abcd javascript";
		str = str.replace("a", "").replace("b", "").replace("c", "");	// a먼저 없애고 b없애고, c를 마저 없앤다.
		// jv bcd jvscript   => jv cd jvscript   ==> jv d jvsript
		
		
		System.out.println(str);
		// jv d jvsript
		
		////////////////////////////////////////////////////////////////////////////////
		
		// 정규표현식은 []안에 넣으면 된다.
		str = "java abcd javascript";
		str = str.replaceAll("[abc]", "");			// replace일때는 abc가 안없어졌는데 replaceAll은 abc가 사라졌다.
													// replaceAll은 정규표현식도 사용이 가능하다.
		System.out.println(str);
		
		
		// 숫자를 제거해라
		str = "jav1a ab2cd ja3vas4cr6485i6p7t";		// 숫자를 넣어서 되어있는 것을 숫자를 제거해보자 
		str = str.replaceAll("[0123456789]", "");		//숫자인것만 제거해라 
		System.out.println(str);
		// java abcd javascript
		
		// 숫자를 제거해라
		str = "jav1a ab2cd ja3vas4cr6485i6p7t";		// 숫자를 넣어서 되어있는 것을 숫자를 제거해보자 
		str = str.replaceAll("[0-9]", "");		//숫자인것만 제거해라 
		System.out.println(str);
		// java abcd javascript
		
		// 5,7빼고 숫자를 제거해라
		str = "jav1a ab2cd ja3vas4cr6485i6p7t";		// 숫자를 넣어서 되어있는 것을 숫자를 제거해보자 
		str = str.replaceAll("[0-4689]", "");		//5,7 빼고 숫자인것만 제거해라 
		System.out.println(str);
		// java abcd javascr5ip7t
		
		// 숫자만 내비두고 나머지를 없애라 
		str = "jav1a ab2cd ja3vas4cr6485i6p7t";		// 숫자를 넣어서 되어있는 것을 숫자를 남기고 나머지를 제거하자
		str = str.replaceAll("[^0-9]", "");		//숫자 아닌것만 제거해라 ^를 사용하면 not이 된다.
		System.out.println(str);
		// 1234648567
		
		// 숫자인것만 제거 
		str = "jav1a ab2cd ja3vas4cr6485i6p7t";		// 숫자를 넣어서 되어있는 것을 숫자인것만 제거해보자 
		str = str.replaceAll("\\d", "");			// 숫자만 없애라 		
		System.out.println(str);
		// java abcd javascript
		
		
		// 숫자가 아닌 것을 제거
		str = "jav1a ab2cd ja3vas4cr6485i6p7t";		// 숫자를 넣어서 되어있는 것을 숫자 빼고 나머지를 제거해보자 
		str = str.replaceAll("\\D", "");		//숫자제외 나머지를 제거해라 
		System.out.println(str);
		// 1234648567
		
		// 소문자만 제거해라 
		str = "java KOREA 0070 @#$@!";
		str = str.replaceAll("[a-z]", "");			// 소문자 a-z까지를 공백으로 제거하라는 뜻이다.
		System.out.println(str);
		//  KOREA 0070 @#$@!
		
		
		// 특수기호만 남겨보자
		str = "ja88va_ KOREA NO1 MIN 0070 @#$@!";
		str = str.replaceAll("[a-zA-Z0-9_ ]", "");			// 소문자 및 대문자 및 숫자 및 _ 및 공백을 제거해서 공백으로 제거하라는 뜻이다.
		System.out.println(str);					// 즉 특수기호만 남겨보자
		//@#$@!
		
		
		// 특수기호만 남겨보자
		str = "ja#88va_ KOREA NO1 MIN 0070 @#$@!";
		str = str.replaceAll("[\\w]", "");	// \\w는 공백을 포함하지 않지만 소문자 및 대문자 및 숫자 및 _을 공백으로 제거하라는 뜻이다.
											//정규표현식에서 \\w은 word(단어)라는 뜻으로 대문자, 소문자, 숫자, _까지를 말한다.
		System.out.println(str);					// 즉 특수기호만 남겨보자
		//#     @#$@!
		
		
		// 특수기호만 남겨보자
		str = "ja#88va_ KOREA NO1 MIN 0070 @#$@!";
		str = str.replaceAll("[\\w ]", "");	// \\w는 공백을 포함하지 않지만 소문자 및 대문자 및 숫자 및 _ 및 골백을 공백으로 제거하라는 뜻이다.
													//정규표현식에서 \\w은 word(단어)라는 뜻으로 대문자, 소문자, 숫자, _까지를 말한다.
		System.out.println(str);					// 즉 특수기호만 남겨보자
		// #@#$@!
		
		
		// 특수기호만 제거하자 
		str = "ja#88va_ KOREA NO1 MIN 0070 @#$@!";
		str = str.replaceAll("[^a-zA-Z0-9_]", "");	// 단어가 아닌것만 없애라!!!( 소,대문자, 숫자, _ 를 제외한 나머지를 제거하라는 뜻이다.
		System.out.println(str);					// 즉 특수기호만 제거하자 
		// ja88va_KOREANO1MIN0070
		
		
		// 특수기호만 제거하자 
		str = "ja#88va_ KOREA NO1 MIN 0070 @#$@!";
		str = str.replaceAll("[\\W]", "");	// \\W는 단어가 아닌것이라는 뜻으로 대,소문자, 숫자, _ 를 제외한 나머지를 말한다.
		System.out.println(str);					// 즉 특수기호만 제거하자 
		// ja88va_KOREANO1MIN0070
		
		
		////////////////////////// =======[퀴즈] ======= 
		
		System.out.println("\n ======[퀴즈]======");
		String[] contents = {"호호안녕하세요", "건강하세요", "행복하세요 또 봐요", "즐겁고 건강한 하루 되세요"};
		
		
		for(int i=0; i<contents.length; i++)	// 배열길이만큼 반복
		{
			if(contents[i].indexOf("건강") != -1)		// 인덱스 값이 -1만 아니면 건강이라는 글자가 있다.
			{
				System.out.println(contents[i]);	//건강이 있는 단어 출력 
			}
		}
		//"건강"이라는 단어가 포함된것을 출력하세요 
		//결과물 1 :
		/*
		 	건강하세요 
		 	즐겁고 건강한 하루되세요
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i=0; i<contents.length; i++)	// 배열길이만큼 반복
		{
			if(contents[i].indexOf("건강") == 0)		// 건강이라는 인덱스가 0부터 시작하는 것만 실행 
			{
				System.out.println(contents[i]);		// 건강이라는 단어로 시작되는 문자열 출력 	
			}
		}
		//"건강" 이라는 단어로 시작하는 것만 출력하세요 
		//결과물 2 :
		/*
		   건강하세요
		*/
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
		// 또는 아래와 같이 할 수 도 있습니다.
		
		
		
		
		// === 11. "문자열".startsWith("찾고자하는 문자열"); === 
		//         "문자열"에서 "찾고자 하는 문자열"이 맨 첫번째에 나오면 true를 반환
		//         "문자열"에서 "찾고자 하는 문자열"이 맨 첫번째에 나오지 않으면 False를 반환
		
		for(int i=0; i<contents.length; i++)	// 배열길이만큼 반복
		{
			if(contents[i].startsWith("건강"))		// 건강으로 시작하면 
			{
				System.out.println(contents[i]);	// 출력 
			}
		}
		//건강하세요
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
	

		
		// === 12. "문자열".endsWith("찾고자하는 문자열"); === 
		//         "문자열"에서 "찾고자 하는 문자열"로 끝나면  true를 반환
		//         "문자열"에서 "찾고자 하는 문자열"로 끝나지 않으면 False를 반환
		
		for(int i=0; i<contents.length; i++)	// 배열길이만큼 반복
		{
			if(contents[i].endsWith("하세요"))		// 건강으로 시작하면 
			{
				System.out.println(contents[i]);	// 출력 
			}
		}
		//호호안녕하세요
		//건강하세요
		
		
		
		// === 13. "문자열".trim(); === 	//좌우의 공백을 없애주는 것 
		//         "문자열"의 좌, 우에 공백이 있다하면 공백을 모두 제거하고서 반환해준다.
		
		String insa = "           수고        많으셨습니다           ";
	    System.out.println("하하하"+insa+"내일 뵐께요~~");
	    // 하하하           수고        많으셨습니다           내일 뵐께요~~
	      
	    System.out.println("하하하"+insa.trim()+"내일 뵐께요~~");
	    // 하하하수고        많으셨습니다내일 뵐께요~~
		
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    // === 14. "문자열".isEmpty()  ===
	    //         "문자열" 이 아무것도 없으면 true 를 반환해주고,
	    //         "문자열" 이 뭔가 있으면 false 를 반환해준다.
	    String str1="", str2="abc", str3="          ";
	    
	    System.out.println(str1.isEmpty());  // true
	    System.out.println(str2.isEmpty());  // false
	    System.out.println(str3.isEmpty());  // false
	    System.out.println(str3.trim().isEmpty());  // true
	    
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    // === 15. "문자열".toUpperCase() ===
	    //         "문자열" 에서 소문자가 있으면 모두 대문자로 변경해서 반환해줌.
	    String words = "My Name is Tom 입니다.";
	    System.out.println(words.toUpperCase());
	    // MY NAME IS TOM 입니다.
	    
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    
	    // === 16. "문자열".toLowerCase() ===
	    //         "문자열" 에서 대문자가 있으면 모두 소문자로 변경해서 반환해줌.
	    words = "My Name is Tom 입니다.";
	    System.out.println(words.toLowerCase());
	    // my name is tom 입니다.
	    
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    // === 17. "문자열".equals("비교대상문자열")  ===
	    //     대문자와 소문자를 구분하면서
	    //     "문자열" 과 "비교대상문자열" 의 값이 일치하면  true 를 반환.
	    //      "문자열" 과 "비교대상문자열" 의 값이 일치하지 않으면  false 를 반환. 
	     
	    
	    // === 18. "문자열".equalsIgnoreCase("비교대상문자열")  ===
	    //     대문자와 소문자를 구분하지 않으면서 
	    //     "문자열" 과 "비교대상문자열" 의 값이 대,소문자와 관계없이 일치하면  true 를 반환.
	    //      "문자열" 과 "비교대상문자열" 의 값이 대,소문자와 관계없이 일치하지 않으면  false 를 반환.
	    
	    
	    String[] strArr = {"korea", "seoul", " KOREA seoul", "Korea 대한민국", "서울 kOrEA 만세", null}; 
	   

	    // 검색어를 "korea" 라는 글자가 들어있는 것만 출력하세요.
	    
	    for(int i =0; i < strArr.length; i++)
	    {
	    	//문자열 비교시 항상 상수가 먼저 나오게 하도록 하자 !!!!!!!!!!!!!!!!!!!
	    	
	    	if("korea".equals(strArr[i]))	// if("korea".equals("korea"))
	    	{								// if("korea".equals("seoul"))
	    									// if("korea".equals(" KOREA seoul"))
	    									// ...
	    									//  if("korea".equals("null"))
	    		System.out.println(strArr[i]);
	    	}
	    	
	    	
	    	// 아래 방식대로 하면 NullPointException이 유발될 수 있다.!!!!!!!!!!!!
	    	
	    	//if(strArr[i].equals("korea"))   // if(strArr[i].equals("korea"))
	    									// if(seoul.equals("korea"))
	    									// if( KOREA seoul.equals("korea"))
	    									// ...
	    									// if(null.equals("korea"))  
	    	
	    			// 오류발생!!!!!!!!!!!!!!!!!!!!!! null때문에 오류가 발생한다.
	    }
		
	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    
        //************************    중요한듯    *********************************//
    	//*********************************************************//
	    
	    
	    // 검색어를 "korea" 또는 "KOREA" 또는 "kOreA" 또는 "kOreA" 와 같이 했을때에
	    // 대,소문자를 구분치 않고 "korea" 라는 글자가 들어있는 것만 출력하세요.
	   
	    String search = "kOreA";  // "korea", "KOREA", "kOreA" 모두 가능 
	    
	    
	    for(String s : strArr) 	// 확장 for문이다.    //배열 strArr의 크기만큼 반복한다.
	    {										   // 즉 이 배열크기(6)만큼 반복한다. (6번 반복)
	    	
	    	search = search.toLowerCase();			// 소문자로 모두 변경 
	    	
	    	
	    	
	    	// 첫번째 반복일 경우 
	    	// String s = "korea";
	    	
	    	// 두번째 반복일 경우
	    	// String s = "seoul"
	    	
	    	// 세번째 반복일 경우
	    	// String s = " KOREA seoul"
	    	
	    	// 네번째 반복일 경우
	    	// String s = "Korea 대한민국"
	    	
	    	// 다섯번째 반복일 경우
	    	// String s = " KOREA seoul"
	    	
	    	// 여섯번째 반복일 경우
	    	// String s = "null"
	    	
	    	
	    	/////////////////////////////////////////////////////////////
	    	
	    	if(s != null && s.toLowerCase().indexOf(search) != -1)		// null을 제외한 것, 소문자로 모두 변경후 search와 비교
	    	{															// 글자를 대문자, 또는 소문자로 변경한다.
	    		// s.toLowerCase()은 "korea", "seoul", " kOREA seoul, Korea 대한민국. 서울 korea 만세
	    		// search는 "korea" 
	    		System.out.println(s);   // 원래 값이 나오게 된다.
	    		// korea 
	    		// korea seoul
	    		// Korea 대한민국
	    		// 서울 kOrEA 만세
	    	}
	    	
	    }// end of for
	    
	    
	}// end of main

}

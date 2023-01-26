package my.day17.b.excption;

public class Excption_test {

	public static void main(String[] args) {
		
		System.out.println("\n== 1. \"ArrayIndexOutOfBoundsException\" ==");
		
		// ArrayIndexOutOfBoundsException
		// ==> 배열의 크기가 오버가 되어지면 발생하는 익셉션
		
		String[] subjectArr = {"자바", "오라클", "JSP"};
		
		try{
			for(int i = 0; i <= subjectArr.length; i++)	//<=으로 하면 ArrayIndexOutOfBoundsException이 발생
			{											// 배열 크기가 넘쳤기 때문에 
				System.out.println(subjectArr[i]);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(">> 배열의 인덱스 범위가 초과되었습니다. <<");
			System.out.println(e.getMessage());				// e.getMessage()는 오류 메세지를 알려주는 것이다. 
															// 즉 이 예제에서는 3이 오류로 나온다.
			e.printStackTrace(); 				// 어디가 오류인지를 추적해서 알려준다.
												// 원래 try ,catch를 안했을때 오류처럼 나온다.			
		}
		
		
		
		System.out.println("\n== 2. \"ArithmeticException\" ==");
		
		//ArithmeticException 
		// ==> 분모에 0이 들어가는 경우에 발생하는 익셉션 
		
		try {
			int num = 10;
			for(int i=2;i>=0; i--)
			{
				System.out.println(num/i);
			}
		}
		catch(ArithmeticException e) {
			System.out.println(">> 분모에는 0이 올 수 없습니다. <<");
			System.out.println(e.getMessage());				// e.getMessage()는 오류 메세지를 알려주는 것이다. 
			// 즉 이 예제에서는 / by zero이 오류로 나온다.
			e.printStackTrace(); 				// 어디가 오류인지를 추적해서 알려준다.
			// 원래 try ,catch를 안했을때 오류처럼 나온다.	
		}
		
		
		
		System.out.println("\n== 3. ~~~~~~~~~~~~~~~~~~  ==");
		
		int[] numArr = {10,20,30};
		
		// 첫번째 빼고 안돌아감 
		try {
			for(int i=3; i>=0; i--)
			{
				int val = numArr[i]/i;	// numArr[3]/3 30/2, 20/1, 10/0	
				System.out.println(val);
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
			System.out.println(">> 배열의 인덱스 범위가 초과되었습니다. <<");
		}
		
		
		System.out.println("\n== 4. ~~~~~~~~~~~~~~~~~~  ==");
		
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		for(int i=3; i>=0; i--)
		{
			try {
				int val = numArr[i]/i;	// numArr[3]/3 30/2, 20/1, 10/0	
				System.out.println(val);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println(">> 배열의 인덱스 범위가 초과되었습니다. <<");
			}
			catch(ArithmeticException e) {
				
				System.out.println(">> 분모에는 0이 올 수 없습니다. <<");	
			}
		}
		
		
		System.out.println("\n== 5. ~~~~~~~~~~~~~~~~~~  ==");
		
		// 에러 메세지를 나타냄
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		for(int i=3; i>=0; i--)
		{
			try {
				int val = numArr[i]/i;	// numArr[3]/3 30/2, 20/1, 10/0	
				System.out.println(val);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println(">> 에러메세지 : " + e.getMessage() );
			}
			catch(ArithmeticException e) {
				
				System.out.println(">> 에러메세지 : " + e.getMessage());	
			}
		}
		
		
		System.out.println("\n== 6. ~~~~~~~~~~~~~~~~~~  ==");
		
		//어차피 catch는 같으므로 한개로 사용하자 
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		for(int i=3; i>=0; i--)
		{
			try {
				int val = numArr[i]/i;	// numArr[3]/3 30/2, 20/1, 10/0	
				System.out.println(val);
			}
			catch(ArrayIndexOutOfBoundsException | ArithmeticException e) {	// catch에서 두개의 오류를 한개의 catch로 잡는다.
				
				System.out.println(">> 에러메세지 : " + e.getMessage() );
			}
		}
		
		
		System.out.println("\n== 7. ~~~~~~~~~~~~~~~~~~  ==");
		
		//어차피 catch는 같으므로 한개로 사용하자, 또한 모든 오류를 잡기 위해서 Exception을 사용하면 된다. 
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		for(int i=3; i>=0; i--)
		{
			try {
				int val = numArr[i]/i;	// numArr[3]/3 30/2, 20/1, 10/0	
				System.out.println(val);
			}
			catch(Exception e) {	// catch에서 두개의 오류를 한개의 catch로 잡는다.
									//모 든 오류를 잡기 위해서 Exception을 사용하면 된다.
				
				System.out.println(">> 에러메세지 : " + e.getMessage() );
			}
		}
		
		
		System.out.println("\n== 8. ~~~~~~~~~~~~~~~~~~  ==");
		
		String[] strArr = {"10", "스몰", "30"};
		
		// 에러 메세지를 나타냄
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		for(int i=3; i>=0; i--)
		{
			try {
				int val = Integer.parseInt(strArr[i])/i;	// strArr[3]/3 30/2, Integer.parseInt(strArr["스몰"]/1, 10/0	
				System.out.println(val);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println(">> 배열의 인덱스 번호 : " + e.getMessage() + " 이 존재하지 않습니다.");
			}
			catch(ArithmeticException e) {
				
				System.out.println(">> 분모에 0을 넣을수 없습니다");	
			}
			catch(Exception e) {	//모든 오류를 잡기 위해서 Exception을 사용하면 된다..

				System.out.println(">> 에러메세지 : " + e.getMessage() );
			}
		}
		
		/*
		System.out.println("\n== 9. ~~~~~~~~~~~~~~~~~~  ==");
		
		String[] strArr = {"10", "스몰", "30"};
		
		// 에러 메세지를 나타냄
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		for(int i=3; i>=0; i--)
		{
			try {
				int val = Integer.parseInt(strArr[i])/i;	// strArr[3]/3 30/2, Integer.parseInt(strArr["스몰"]/1, 10/0	
				System.out.println(val);
			}
			catch(Exception e) {	//모든 오류를 잡기 위해서 Exception을 사용하면 된다..

				System.out.println(">> 에러메세지 : " + e.getMessage() );
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println(">> 배열의 인덱스 번호 : " + e.getMessage() + " 이 존재하지 않습니다.");
			}
			catch(ArithmeticException e) {
				
				System.out.println(">> 분모에 0을 넣을수 없습니다");	
			}
			
		}
		
		=== [!!! 중요 !!!] ===
		익셉션 처리시 부모클래스의 익셉션이 맨 아래에 나와야 한다.
		왜냐하면 익셉션 처리는 위에서 처리되면서 위의것이 처리가 안되면
		아래로 내려가라는 말인데 부모 클래스의 익셉션이 먼저 나오고 
		자식 클래스의 익셉션이 아래에 나오면 부모클래스 익셉션이 처리를 못한것을
		자식클래스 익셉션이 처리를 해라는 것은 모순이기 때문이다.
		*/
		
		System.out.println("\n== 10. ~~~~~~~~~~~~~~~~~~  ==");
		
		String[] strArr_2 = {"10", "스물", "30", "40"};
		
		int cnt = 0;
		/*
		for(int i=0; i<strArr_2.length; i++)
		{
			int val = Integer.parseInt(strArr_2[i]) +1;
			System.out.println(val);
			System.out.println(">> " + ++cnt + "번 반복함 <<");  		// 전위 연산자로 몇번 반복했는지 나타냄 
			
		}// end of for 
		*/
		/*
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		cnt = 0;
		for(int i=0; i<strArr_2.length; i++)
		{
			try {
				int val = Integer.parseInt(strArr_2[i]) +1;
				System.out.println(val);
			}
			finally		//finally 은 try 블럭부분에 오류가 발생하지 않더라도 finally 블럭부분을 실행하고 
			{			//try 블럭부분에 오류가 발생하면 finally 블럭부분을 반듯이 실행시키고 오류가 발생한다.
				System.out.println("== " + ++cnt + "번 반복함 ==");  		// 전위 연산자로 몇번 반복했는지 나타냄 
			}
			
			
		}// end of for 
		*/
		
		
		System.out.println("\n== 11. ~~~~~~~~~~~~~~~~~~  ==");
		
		String[] str_Arr = {"10", "스몰", "30"};
		
		// 에러 메세지를 나타냄
		//for문으로 인해 0까지 모두 돌아가면서 검사를 한다.
		int count = 0;
		
		for(int i=3; i>=0; i--)
		{
			try {
				int val = Integer.parseInt(str_Arr[i])/i;	// str_Arr[3]/3 30/2, Integer.parseInt(str_Arr["스몰"]/1, 10/0	
				System.out.println(val);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				
				System.out.println(">> 배열의 인덱스 번호 : " + e.getMessage() + " 이 존재하지 않습니다.");
			}
			catch(ArithmeticException e) {
				
				System.out.println(">> 분모에 0을 넣을수 없습니다");	
			}
			catch(Exception e) {	//모든 오류를 잡기 위해서 Exception을 사용하면 된다..

				System.out.println(">> 에러메세지 : " + e.getMessage() );
			}
			finally {		// finally는 오류가 발생하든 않든 관계없이 무조건 실행해야 하는 것들은 finally에 기술해주면 된다.
				System.out.println(++count + "번 반복!! \n");
			}
		}
		
		
	} //end of main

}

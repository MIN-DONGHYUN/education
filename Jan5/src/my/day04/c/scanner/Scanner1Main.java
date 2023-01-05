// 키보드로부터 입력받아 출력 
package my.day04.c.scanner;

import java.util.Scanner;

public class Scanner1Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  //system.out은 화면, system.in은 키보드라고 보면 된다.
		// scanner sc 은 키보드에서 입력된 문자열을 읽어들이는 객체이다 라고 보면 된다.
		
		// Sysstem.out 은 출력장치(모니터)를 말한다.
		// System.in 은 입력장치(키보드)라고 보면 된다.
		
		System.out.print("첫번째 문장을 입력하세요 => ");
		String inputStr = sc.nextLine();
		/*
		   sc.nextLine();은 키보드로부터 입력받는 문장을 읽어들이는 것인데 그것은 엔터이다.
		   엔터(종결신호)까지 모두 읽어들인 후 스케너 버퍼(저장소의 일종)에는 아무것도 남기지 않는다.
		    
		*/
		
		System.out.println("첫번째 입력한 문장 => " + inputStr + "\n" );
		
        // 정수를 입력하세요
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		
		System.out.print("정수를 입력하세요 => ");
		int inputNum = sc.nextInt();   // 2023엔터
		/*
		    sc.nextInt(); 은 정수(int)를 읽어들이는 것인데
		    종결자가 공백 또는 엔터이다.
		    종결자(공백 또는 엔터) 앞까지의 입력해준 정수를 읽어온다.
		    sc.nextInt(); 를 사용하면 스케너(sc)버퍼에는 종결자(공백 또는 엔터)가 삭제되는 것이 아니라 그대로 남아 있게 된다.
		    즉 뒤에 문장을 더 쓰고싶어도 이미 엔터 또는 공백이 남아있어서 입력x(안됨)
		    그래서 필요한것이 sc.nextLine();을 한번더 사용하여 버퍼를 초기화 시킨다.
		*/
		
		sc.nextLine();  // 스케너 버퍼에 남아있던 찌꺼기(엔터)를 싹 비우는 것이 목적이다.
		
		System.out.println("입력한 정수 : " + inputNum);
		
		
		// 두번째 문장 입력 
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		System.out.print("두번째 문장을 입력하세요 => ");
		inputStr = sc.nextLine();
		
		System.out.println("두번째 입력한 문장 => " + inputStr + "\n" );
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		// 실수 입력 
		System.out.print("실수를 입력하세요 => ");
		double inputDb1 = sc.nextDouble();   // 실수를 뜻한다.
		/*
	    sc.nextDouble(); 은 실수(Double)를 읽어들이는 것인데
	    종결자가 공백 또는 엔터이다.
	    종결자(공백 또는 엔터) 앞까지의 입력해준 정수를 읽어온다.
	    sc.nextDouble(); 를 사용하면 스케너(sc)버퍼에는 종결자(공백 또는 엔터)가 삭제되는 것이 아니라 그대로 남아 있게 된다.
	    즉 뒤에 문장을 더 쓰고싶어도 이미 엔터 또는 공백이 남아있어서 입력x(안됨)
	    그래서 필요한것이 sc.nextLine();을 한번더 사용하여 버퍼를 초기화 시킨다.
		*/
		
		sc.nextLine();  // 스케너 버퍼에 남아있던 찌꺼기(엔터)를 싹 비우는 것이 목적이다.
		
		System.out.println("입력한 실수 : " + inputDb1);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		
		
		// 단어 입력
		System.out.print("단어를 입력하세요 => ");
		String inputWord = sc.next();   // 단어를 입력한다. 안녕하세요 호호호
		/*
		    sc.next(); 는 단어를 읽어들이는 것인데 
		    종결자가 공백 또는 엔터이다.
		    종결자(공백 또는 엔터) 앞까지의 입력해준 문자열를 읽어온다.
		    sc.next(); 를 사용하면 스케너(sc)버퍼에는 종결자(공백 또는 엔터)가 삭제되는 것이 아니라 그대로 남아 있게 된다.
		    연녕 하세요 호호호 를 입력하면 안녕만 출력되고 하세요 호호호 는 남아있게 된다.
		    sc.nextLine(); 를 사용하여 제거하면 하세요 호호호는 없어진다
		*/
		sc.nextLine();  // 스케너 버퍼에 남아있던 찌꺼기(엔터)를 싹 비우는 것이 목적이다.
		
		System.out.println("입력한 단어 => " + inputWord + "\n" ); // 안녕 하세요 호호호이면 안녕만 출력
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		
		
		System.out.print("세번째 문장을 입력하세요 => ");
		inputStr = sc.nextLine();
		
		System.out.println("세번째 입력한 문장 => " + inputStr + "\n" );
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		
		
		//메모리 누수 방지하기 위해 스케너 닫기
		sc.close();   //꼭 필요한 것임
		
	}// end of public static void main(String[] args)

}// end of public class Scanner1Main 

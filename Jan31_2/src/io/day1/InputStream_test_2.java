// 명령 프롬프트 를 이용하여 Ctrl + C 를 이용해 종료 

package io.day1;

import java.io.IOException;

/*
    ※ Data Source(키보드, 파일, 내 컴퓨터) 
    : 데이터의 근원
    
    ※ Data Destination(모니터, 파일, 서버컴퓨터)  
    : 데이터가 최종적으로 도착하는 곳 
    
    
    Data Source o ====> 프로그램  ====>  o Data Destination
                ↑입력스트림              ↑출력스트림     
                InputStream           OutputStream


  >>>>> System.in :
             부모클래스가 추상클래스 InputStream(기본 입력 스트림) 타입인 것으로서 
             접속점(빨대)이 키보드인 입력 스트림이다.
             
    -- Node(접속점)가 키보드인 입력스트림이다.
    -- 1 byte 기반 스트림이다.
    -- 주요메소드 :
          public int read() throws IOException
          ==> 1byte 씩 데이터를 읽어서
              1byte 씩 반환하고
              입력받은 키보드가 Ctrl+C(윈도우), Ctrl+D(유닉스,리눅스) 이라면 -1 을 반환해주는 메소드이다.
              read() 메소드의 리턴타입은 byte 가 아니라 int 이다.
              데이터 입력의 끝을 나타내는 것으로 -1 을 사용하는데
              Ctrl+C(윈도우), Ctrl+D(유닉스,리눅스)을 사용하면 된다.
                          
              또한 IOException 이 발생할수도 있으므로 반드시 예외처리를 꼭 해주어야 한다.              
              그래서 현재 우리는 윈도우를 사용하고 있으므로 InputStream 작업을 
              강제로 종료하려면  Ctrl+C(윈도우) 하면 된다.
    
    
  >>>>> System.out :
              부모클래스가 추상클래스인 OutputStream(기본 출력 스트림) 타입인 것으로서
              접속점(빨대)이 콘솔화면(모니터)인 출력 스트림(PrintStream)이다.
                   
    -- Node(접속점)가 콘솔화면(모니터)인 출력스트림이다.
    -- 1byte 기반 스트림이다.
    -- 주요 메소드 : println(String str),
                  print(String str),
                  write(int b)
    
    
*/


public class InputStream_test_2 {

	//JVM으로 해결해라 
	public static void main(String[] args) throws IOException {
		
		int input = 0;
		
		while( (input = System.in.read()) != -1  ) { 		//입력한 값이 -1이 아니라면 계속 실행해라 
			// -1 은 키보드로 Ctrl + C (강제종료)를 입력한 것이다.
			// 키보드로 Ctrl + C(강제종료)를 하면 while 문을 빠져 나간다.
			// System.in.read() 는 1byte 씩 읽어온다.
			// 이클립스에서는 Ctrl + C 가 안먹으므로 명령 프롬프트를 띄워야 한다.
			
			System.out.println("\n === 키보드로 부터 데이터 입력받기 ===");   //\r\n은 엔터
			System.out.println("화면에 출력 [println (input) ] : " + input);
			System.out.print("화면에 출력 [write (input) ] : ");
			System.out.write(input);			//int형 변경없이 글자 그대로 출력 
			System.out.flush(); 		// flush란 write가 있으면 무조건 해줘야한다.
			/*
			 	flush 란 ? 출력버퍼에 임시로 보관되어 스트림으로 출력될 때까지 대기중인 데이터를 스트림으로 내보내는 것을 flush 라고 한다.
          		write() 메소드는 flush() 메소드와 함께 사용되어야만 출력버퍼에 들어가 있던 내용이 모니터(또는 파일)에 출력된다.
             	그런데  flush() 메소드를 사용하지 않아도 모니터(또는 파일)에 출력되는 경우이라면 auto flush 가 적용되어졌기 때문이다.
			*/
			
			System.out.println("");
			System.out.println("화면에 출력 [println (char)input ] : " + (char)input);
			
		}// end of while
		
		System.in.close();   // 입력노드(키보드)연결 닫기
		System.out.close();  // 출력노드(모니터)연결 닫기  
		
	}// end of main
	
}

/*
 
 실행은 아래와 같이 명령프롬프트를 띄워서 한다.
C:\NCS\workspace(java)\IO\bin>java io.day1.InputStream_test_2
ab

 === 키보드로 부터 데이터 입력받기 ===
화면에 출력 [println (input) ] : 97
화면에 출력 [write (input) ] : a
화면에 출력 [println (char)input ] : a

 === 키보드로 부터 데이터 입력받기 ===
화면에 출력 [println (input) ] : 98
화면에 출력 [write (input) ] : b
화면에 출력 [println (char)input ] : b

 === 키보드로 부터 데이터 입력받기 ===
화면에 출력 [println (input) ] : 13
화면에 출력 [write (input) ] :
화면에 출력 [println (char)input ] :

 === 키보드로 부터 데이터 입력받기 ===
화면에 출력 [println (input) ] : 10
화면에 출력 [write (input) ] :

화면에 출력 [println (char)input ] :

키보드로 Ctrl + C 함

C:\NCS\workspace(java)\IO\bin>
*/
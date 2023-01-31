package io.day1;

import java.io.*;
import java.util.Scanner;

public class FileInputStream_test_6 {


/*
    ※ Data Source(키보드, 파일, 내 컴퓨터) 
    : 데이터의 근원
    
    ※ Data Destination(모니터, 파일, 서버컴퓨터)  
    : 데이터가 최종적으로 도착하는 곳 
    
    
    Data Source o ====> 프로그램  ====>  o Data Destination
                ↑입력스트림              ↑출력스트림     
                InputStream           OutputStream

	1. 데이터소스 : 파일로 부터 읽어들임 (노드스트림 : FileInputStream)
	2. 데이터 목적지 : 결과물을 모니터에 출력 (노드스트림 : System.out)

  >>>>> FileInputStream  
           
    -- Node 스트림(접속점이 파일인 입력스트림)가 키보드인 입력스트림이다.
    -- 1 byte 기반 스트림이다.
    
    
  >>>>> System.out :
              부모클래스가 추상클래스인 OutputStream(기본 출력 스트림) 타입인 것으로서
              접속점(빨대)이 콘솔화면(모니터)인 출력 스트림(PrintStream)이다.
                   
    -- Node(접속점)가 콘솔화면(모니터)인 출력스트림이다.
    -- 1byte 기반 스트림이다.
    -- 주요 메소드 : println(String str),
                  print(String str),
                  write(int b)
    
    
*/
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		System.out.print(">> 읽을 파일의 이름(절대경로)을 입력 => ");
		
		String fileName = sc.nextLine();
		// 파일명 입력 => 데이터소스가 된다.
		// 명령 프롬프트 ==> C:\NCS\iotest_data\Korea.txt
		// 이클립스 ==> C:\NCS\iotest_data\대한민국.txt
		
		byte[] dataArr = new byte[100]; 		// 100byte씩 받아옴 
		int inputLength = 0;
		int cnt = 0;  // while문 반복회수
		int totalByte = 0;  //byte 수 누적용도 
		
		//파일을 읽어들일 객체가 필요한다.
		try {
			FileInputStream fist = new FileInputStream(fileName);
			
			while( (inputLength = fist.read(dataArr)) != -1)  // -1 이 아니면 계속 반복 
			{
				
				/*
		            fist.read(dataArr) 메소드는 해당 파일에서 
	                데이터를 배열 dataArr 크기인 100 byte 씩 잘라서 읽는데  
	                실제 읽어온 byte 크기(int 타입)를 inputLength 에 넣어준다.
	                이어서 읽어온 내용물은 배열 dataArr 에 저장시킨다.
	               
	                만약에 파일의 내용물에서 읽어들일 데이터가 없다라면  -1 을 리턴시켜준다.
	                즉, 파일속의 내용물이 끝이 아니라면 계속해서 while{} 부분을 실행해라는 말이다.
	             */
				//            저장한 곳,  인덱스 시작 번호, 길이  
				System.out.write(dataArr, 0, inputLength);;;// 모니터(콘솔화면)에 출력 
				System.out.flush();;
				
				totalByte += inputLength;
				cnt++;
				
			}// end of while
			fist.close(); //while문이 끝났으니까 같이 해줌 
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("총 : " + totalByte + "byte");
			System.out.println("반복회수 : " + cnt + "번 반복함 ");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		} 
		catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일은 없습니다.");
			//e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}// end of main

}

/*
>> 읽을 파일의 이름(절대경로)을 입력 => C:\NCS\iotest_data\대한민국.txt
동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 
무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세

동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 
무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 

동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 
무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 

동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 
무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 

동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 
무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 

동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세 
무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세 

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
총 : 1059byte
반복회수 : 11번 반복함 
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


*/
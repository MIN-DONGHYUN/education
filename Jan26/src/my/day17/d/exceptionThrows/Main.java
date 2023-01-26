package my.day17.d.exceptionThrows;

public class Main {

	public static void main(String[] args) {
		
		try{
				Member mbr = new Member();
				
				mbr.name = "이순신";
				mbr.kor = "90";
				mbr.eng = "80";
				mbr.math = "70";
				
				mbr.info();
				
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~\n");
				
				Member mbr2 = new Member();
				
				mbr2.name = "엄정화";
				mbr2.kor = "90";
				mbr2.eng = "팔십";
				mbr2.math = "70";
				mbr2.info();
			}
			catch (Exception e) {				//어떠한 오류든 오류가 발생했을때 
				System.out.println(" 오류 메시지 내용 : " + e.getMessage());
			}
		

	}// end of main

}

package my.day15.b.accessmodifier;

public class Other{
/*
    ---------------------------------------------------------------------------------------------------------------------------
   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스        그외의영역  
   --------------------------------------------------------------------------------------------------------------------------- 
   public                                    O                    O                         O                        O  
   protected                                 O                    O                         O                        X
   default                                   O                    O                         X                        X
   private                                   O                    X                         X                        X
*/  
	
	void viewInfo()
	{
		Parent pt = new Parent();		// parent 클래스에 있는 것을 사용하기 위해 설정한다.
	
		pt.id = "leess";		     // public 동그라미 (초록색) 점근 가능 
		pt.passwd = "Qwer1234$";  // protected   마름모(노란색)  접근 가능 
		pt.name = "이순신";		 //default는 삼각형 (파란색)   접근 가능
		//pt.jubun					 // private  사각형(빨강색) 접근 불가능(클래스가 다르므로)
		
	}
	
}

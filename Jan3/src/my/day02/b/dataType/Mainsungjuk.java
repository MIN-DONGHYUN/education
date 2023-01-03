package my.day02.b.dataType;

public class Mainsungjuk {

	public static void main(String[] args) {
		
		Sungjuk Mindh = new Sungjuk();   //Mindh
		// Mindh은 참조형 타입(Reference Type)
		
		System.out.println("Mindh => " + Mindh); 
		//Mindh => my.day02.b.dataType.Sungjuk@15db9742
		
		Mindh.hakbun = "1254847";     //1254847
		Mindh.name = "민동현";          //민동현
		Mindh.korPoint = 97;          //90
		Mindh.eng_point = 75;         //70
		Mindh.mathpoint = 100;        //100
		
		Mindh.showSungjuk();
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		
		Sungjuk Leess = new Sungjuk();   //Leess
		// Leess은 참조형 타입(Reference Type)
		
		System.out.println("Leess => " + Leess); 
		//Leess => my.day02.b.dataType.Sungjuk@6d06d69c
		
		Leess.hakbun = "184784";     //184784
		Leess.name = "이순신";          //이순신
		Leess.korPoint = 100;          //100
		Leess.eng_point = 0;         //0
		Leess.mathpoint = 100;        //100
		
		Leess.showSungjuk();
		
		
		
		
		
	}

}

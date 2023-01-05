package my.day02.a;

import my.util.MyUtil;

// === static 메소드에 대해서 알아봅니다. ===//

public class Main02 {

	public static void main(String[] args) {
		
		System.out.println(" >> 여기는 Main02 클래스 입니다. << \n");
		
		//MyUtil time = new MyUtil();    // 스테틱없이 인스턴트메소드 불러올때 사용
		//time.currentTime();                
		
		MyUtil.currentTime(); //스테틱일때 MyUtil 패키지에 있는것을 출력함
		

	}

}

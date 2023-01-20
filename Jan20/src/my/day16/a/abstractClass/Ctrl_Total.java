package my.day16.a.abstractClass;

public class Ctrl_Total {

	// === 메인 메뉴를 보여주는 메소드 생성하기 === //
	public void main_menu() {
		
		System.out.println("\n === 메인 메뉴 === \n"
						+ "1. 구직자 회원가입  2. 구인회사 회원가입  3.구직자 로그인\n4. 구인회사 로그인  5. 프로그램 종료 \n"		);
		
		System.out.print("▷ 메뉴 번호 선택 : ");
	}
	
	// == Gujikja 객체 및 company 객체를 Member[] mbr_arr 배열에 저장시키는 메소드 생성하기 ===//
	
	public void save_mbr_arr(Member mbr, Member[] mbr_arr)	// 구직자든 구인회사인든 모든것을 사용하기 위해서는 부모클래스인 Member을 사용하는 것이다. 
	{
		Gujikja gu = null;
		Company cp = null;
		
		if(mbr instanceof Gujikja)		//mbr에 들어온것이 구직자 인스턴스입니까?
		{
			gu = (Gujikja)mbr; 			// 캐스팅(형 변환)시켜서 저장시켜야 한다.
		}
		else					// mbr에 들어온것이 구인회사 인스턴스입니까?
		{
			cp = (Company)mbr;			// 캐스팅 (형 변환 시켜서 저장시켜야 한다.
		}
		
		
	} //end of public void save_mbr_arr() 
	
}

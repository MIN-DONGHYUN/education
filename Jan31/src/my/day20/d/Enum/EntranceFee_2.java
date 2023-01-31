package my.day20.d.Enum;

// 아래는 조금전 package my.day20.c.NoEnum.EntranceFee_2 클래스를 enum 을 사용하여 변경한 것이다.

// >> === enum(열거형)에 맴버(field, method) 추가하기 === << //
// 모든 enum(열거형)은 추상 클래스 Eunm의 자손이다. 그러므로 field 및 생성자와 method를 만들 수 있는 것이다.

public enum EntranceFee_2 {

	// 생성자로 본다. (객체로 보기 때문에 ;를 꼭 붙여야 한다.) 
	CHILD(0,"과자_2"), TEENAGER(150, "브로마이드_2"),  ADULT(300, "USB_2"),   OLD(100, "홍삼_2");
	// !!! 사실은 열거형 상수 CHILD, TEENAGER, ADULT, OLD 하나하나가 () 가 있는 생성자로 만들어진 EntranceFee_2 객체라는 것이다.!!!
	
	
	private final int FEE; 	// 바꿀수 없는 FEE값 
	// enum(열거형)의 인스턴스 변수는 반드시 final 이어야 한다는 규칙은 없지만 
	// FEE는 열거형 상수값을 저장하기 위한 용도이므로 final를 붙인 것이다.!!!!!!
	
	private final String GOODS; 	// 바꿀수 없는 GOODS값 
	// enum(열거형)의 인스턴스 변수는 반드시 final 이어야 한다는 규칙은 없지만 
	// FEE는 열거형 상수값을 저장하기 위한 용도이므로 final를 붙인 것이다.!!!!!!
	
	
	// 파라미터가 있는 생성자 기본생성자는 삭제되었음
	//private EntranceFee_2(int fee, String goods) {
	// 또는 
	EntranceFee_2(int fee, String goods) {
	// enum(열거형)의 생성자는 접근제한자가 private이 생략되어져 있는 것이다.	
	
		FEE = fee; 	// fee값을 final FEE에 넣어준다.
		GOODS = goods;
	}
	
	public int getFee() {
		// 외부에서 FEE 값을 읽을 수 있도록 접근제한자를 public으로 준다.
		return FEE; 	//final이였던 FEE값을 리턴 시킨다.
	}
	
	public String getGoods() {
		// 외부에서 GOODS 에 접근하지 못하도록 접근제한자 private을 준다.
		return GOODS;
	}
	
	
	
}

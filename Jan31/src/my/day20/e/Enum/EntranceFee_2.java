package my.day20.e.Enum;

public enum EntranceFee_2 {

	// 생성자로 본다. (객체로 보기 때문에 ;를 꼭 붙여야 한다.) 
	CHILD(0,"과자_2") {
		@Override
		int getRealFee(int inwonsu) {	
			return 0;   // 진짜 요금은 0 
		}
	}, 
	
	TEENAGER(150, "브로마이드_2") {
		@Override
		int getRealFee(int inwonsu) {
			
			if(inwonsu >= 20)
			{
				return (int)(DEFAULT_FEE*inwonsu*0.8);  // 할인된 가격
			}
			else
			{
				return DEFAULT_FEE*inwonsu; 	// 원래 가격
			}
			
			
		}
	},  
	
	ADULT(300, "USB_2") {
		@Override
		int getRealFee(int inwonsu) {
			if(inwonsu >= 20)
			{
				return (int)(DEFAULT_FEE*inwonsu*0.9);  // 할인된 가격
			}
			else
			{
				return DEFAULT_FEE*inwonsu; 	// 원래 가격
			}
		}
	},  
	
	OLD(100, "홍삼_2") {
		@Override
		int getRealFee(int inwonsu) {
			if(inwonsu >= 20)
			{
				return (int)(DEFAULT_FEE*inwonsu*0.7);  // 할인된 가격
			}
			else
			{
				return DEFAULT_FEE*inwonsu; 	// 원래 가격
			}
		}
	};
	// !!! 사실은 열거형 상수 CHILD, TEENAGER, ADULT, OLD 하나하나가 () 가 있는 생성자로 만들어진 EntranceFee_2 객체라는 것이다.!!!
	
	
	final int DEFAULT_FEE; 	
	// !!! private으로 하면 위의 열거형 상수에서 접근이 불가능해진다.!!!
	// !!! 접근제한자를 default로 주던지 아니면 protected로 주어야만 위의 열거형 상수에서 접근이 가능해진다.
	
	// enum(열거형)의 인스턴스 변수는 반드시 final 이어야 한다는 규칙은 없지만 
	// DEFAULT_FEE는 열거형 상수값을 저장하기 위한 용도이므로 final를 붙인 것이다.!!!!!!
	
	private final String GOODS; 	// 바꿀수 없는 GOODS값 
	// enum(열거형)의 인스턴스 변수는 반드시 final 이어야 한다는 규칙은 없지만 
	// GOODS는 열거형 상수값을 저장하기 위한 용도이므로 final를 붙인 것이다.!!!!!!
	
	
	// 파라미터가 있는 생성자 기본생성자는 삭제되었음
	//private EntranceFee_2(int default_fee, String goods) {
	// 또는 
	EntranceFee_2(int default_fee, String goods) {
	// enum(열거형)의 생성자는 접근제한자가 private이 생략되어져 있는 것이다.	
	
		DEFAULT_FEE = default_fee; 	// default_fee값을 final DEFAULT_FEE에 넣어준다.
		GOODS = goods;
	}
	
	public int getFee() {
		// 외부에서 DEFAULT_FEE 값을 읽을 수 있도록 접근제한자를 public으로 준다.
		return DEFAULT_FEE; 	//final이였던 DEFAULT_FEE값을 리턴 시킨다.
	}
	
	public String getGoods() {
		// 외부에서 GOODS 에 접근하지 못하도록 접근제한자 private을 준다.
		return GOODS;
	}
	
	
	/// !!! 입장 인원수에 따라 할인이 적용된 실제 입장료 금액을 알려주는 추상(미완성)메소드 !!! //
	
	// 접근제한자 default
	abstract int getRealFee(int inwonsu);  	// 미완성 메소드
	// 오버라이딩을 통해 객체를 만들수 있음 
	
	
	
	
	
	
}

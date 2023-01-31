package my.day20.c.NoEnum;

public class EntranceFee_2 {

	//4개의 객체를 만들어왔다.
	// 기본생성자가 없기 때문에 Static을 사용해야 한다.
	// 파라미터가 있는 생성자는 private으로 막았기 때문에 static 사용
	public static final EntranceFee_2 CHILD = new EntranceFee_2(0, "과자");
	public static final EntranceFee_2 TEENAGER = new EntranceFee_2(150, "브로마이드");
	public static final EntranceFee_2 ADULT = new EntranceFee_2(300, "USB");
	public static final EntranceFee_2 OLD = new EntranceFee_2(100, "홍삼");
	
	
	private final int FEE; 	// 바꿀수 없는 FEE값 
	// 외부에서 FEE 에 접근하지 못하도록 접근제한자 private을 준다.
	
	private final String GOODS; 	// 바꿀수 없는 GOODS값 
	// 외부에서 GOODS 에 접근하지 못하도록 접근제한자 private을 준다.
	
	
	// 파라미터가 있는 생성자 기본생성자는 삭제되었음
	private EntranceFee_2(int fee, String goods) {
	// 생성자의 접근제한제에 private을 주어서 외부에서 객체 생성을 못하도록 막아버린다.	
	
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

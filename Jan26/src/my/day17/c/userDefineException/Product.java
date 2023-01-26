package my.day17.c.userDefineException;

public class Product {

	//field
	private String prodName;	//제품명("새우깡", "감자깡", "양파링")
	private int jango;			//잔고(   100      50      150 )
	
	//method
	public String getProdName() {
		return prodName;
	}
	
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	
	public int getJango() {
		return jango;
	}
	
	public void setJango(int jango) {
		this.jango = jango;
	}
	
	//제품의 정보를 보여주는 메소드 생성 
	public void info() {
		String info = "1. 제품명 : " + prodName + "\n"
					+ "2. 잔고량 : " + jango + "개\n";
		
		System.out.println(info);
	}
	
	// 주문을 받는 메소드 생성 1
	public void order(int jumunSu) throws JangolackException{		//trows는 유발시킨다.를 뜻한다.
	// order(int jumunSu)은 피라미터로 돌아오는 jumunSu 의 값에 따라서
	// 사용자(개발자)가 만든 JangolackException 익셉션을 유발 할 수 있다는 말이다.
		
		if(jango < jumunSu)		// 주문수가 잔고량보다 많을 경우 JangolackException 익셉션을 유발 시켜야 한다.
		{
			throw new JangolackException();
		}
		else
		{
			jango -= jumunSu;		// 잔고는 주문수를 뺀 만큼 잔고가 남아야 한다.
			System.out.println(prodName + " 제품을 " + jumunSu + "개를 주문하셨습니다.");
		}
		
	}
	
	// 주문을 받는 메소드 생성 1
	public void jumun(int jumunSu) throws JangolackException{		//trows는 유발시킨다.를 뜻한다.
	// jumun(int jumunSu)은 피라미터로 돌아오는 jumunSu 의 값에 따라서
	// 사용자(개발자)가 만든 JangolackException 익셉션을 유발 할 수 있다는 말이다.

		if(jango < jumunSu)		// 주문수가 잔고량보다 많을 경우 JangolackException 익셉션을 유발 시켜야 한다.
		{
			throw new JangolackException(">> "+ prodName +"은 잔고가 "+ jango +"개인데 주문량이 "+ jumunSu +"개라서 잔고 부족으로 주문이 불가합니다. <<");
		}
		else
		{
			jango -= jumunSu;		// 잔고는 주문수를 뺀 만큼 잔고가 남아야 한다.
			System.out.println(prodName + " 제품을 " + jumunSu + "개를 주문하셨습니다.");
		}

	}
	
}

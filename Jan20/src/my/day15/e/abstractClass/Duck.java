package my.day15.e.abstractClass;

public class Duck extends Animal{	// Animal클래스를 부모클래스로 여긴다.

	
	//Duck만 가지는 field를 정의 (추상화)
	private int price;		// 가격
	
	
	//Duck만 가지는 method(메소드)(기능)를 정의 (추상화)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > 0)
		{
			this.price = price;
		}
		
	}
	
	//메소드 생성 
	public void swim()
	{
		System.out.println(">> 오리는 물가에서 헤엄을 칩니다. <<");
	}
	
	// cry 메소드 오버라이딩 (재정의) 
	@Override
	public void cry() 
	{
		System.out.println(">>> 오리는 '꾁~꾁~' 하며 소리를 냅니다. <<<");
	}
	
	
	
}

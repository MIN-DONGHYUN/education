package my.day15.e.abstractClass;

public class Dog extends Animal{	// Animal클래스를 부모클래스로 여긴다.
	
	
	//Dog만 가지는 field를 정의 (추상화)
	private int weight;		// 몸무게

	
	//Dog만 가지는 method(메소드)(기능)를 정의 (추상화)
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight > 0)
		{
			this.weight = weight;
		}	
	}
	
	//메소드 생성 
	public void run() 
	{
		System.out.println(">> 강아지(콩)가 빠르게 달립니다. << ");
	}
	
	// 메소드의 오버라이딩(재정의), 접근제한자 빼고는 다 같아야 한다. 접근제한자는 부모클래스보다 같거나 넓은 엄위를 포함해야 한다.
	@Override
	public void showInfo()
	{
		System.out.println("== 강아지 정보 ===\n"
						+ "1. 성명 : " + getName() + "\n"     // super는 부모 클래스있는 것, 자기것이면 생략가능 
						+ "2. 생년 : " + getBirthYear() + "년\n"
						+ "3. 몸무게 : "+ weight + "Kg");			
	}
	

	// cry 메소드 오버라이딩 (재정의) 
	// 메소드 오버라이딩(메소드 재정의)시 접근제한자는 부모클래스에서 정의해둔
	// 미완성(== 추상) 메소드의 접근제한자와 같은지 또는 접근 허용이 더 큰것으로 해주어야 한다.
	@Override
	public void cry() 
	{
		System.out.println(">>> 강아지(콩)는 '멍!멍!' 하며 짖습니다. <<<");
	}
	
	
	
	
	
	
}

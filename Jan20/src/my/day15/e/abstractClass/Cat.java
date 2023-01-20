package my.day15.e.abstractClass;

public class Cat extends Animal{	// Animal클래스를 부모클래스로 여긴다.

	
	//Cat만 가지는 field를 정의 (추상화)
	private String color;			// 색상
	
	
	//Cat만 가지는 method(메소드)(기능)를 정의 (추상화)
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color != null && !color.trim().isEmpty())
		{
			this.color = color;
		}
	}
	
	//메소드 생성 
	public void jump()
	{
		System.out.println(">> 고양이는 점프를 합니다. <<");
	}
	
	// 메소드의 오버라이딩(재정의), 접근제한자 빼고는 다 같아야 한다. 접근제한자는 부모클래스보다 같거나 넓은 엄위를 포함해야 한다.
	@Override
	public void showInfo()
	{
		System.out.println("== 고양이 정보 ===\n"
				+ "1. 성명 : " + getName() + "\n"     // super는 부모 클래스있는 것, 자기것이면 생략가능 
				+ "2. 생년 : " + getBirthYear() + "년\n"
				+ "3. 몸무게 : "+ color + "색상");
	}
	
	
	// cry 메소드 오버라이딩 (재정의) 
	@Override
	public void cry() 
	{
		System.out.println(">>> 고양이는 '야옹~야옹~' 하며 웁니다. <<<");
	}
	
	
}

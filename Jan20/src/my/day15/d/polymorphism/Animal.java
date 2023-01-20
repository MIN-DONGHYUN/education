package my.day15.d.polymorphism;

public class Animal {
	
	// Dog, Cat, Duck 의 공통 field(추상화)
	private String name;
	private int birthYear;
	
	// Dog, Cat, Duck 의 공통 method(메소드)(기능) (추상화)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if(name != null && !name.trim().isEmpty())		// 공백이나 null이 아니라면 
		{
			this.name = name;				//이름 넣어줌 
		}
		
	}
	
	public int getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(int birthYear) {
		if(birthYear > 0)
		{
			this.birthYear = birthYear;
		}
		
	}
	
	// === 동물들(강아지, 고양이, 오리)의 정보를 출력해주는 메소드 === //
	protected void showInfo()
	{
		System.out.println("=== 동물 정보 ===\n"
						+ "1. 셩명 : " + name + "\n"
						+ "2. 생년 : " + birthYear + "\n"	);
		
	}
	
	
	// cry 메소드 생성 
	protected void cry() 
	{
		System.out.println(">>> 동물들이 소리를 냅니다. <<<");
	}
	
}

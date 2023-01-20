package my.day15.e.abstractClass;

//abstract public class Animal	
// 또는
public abstract class Animal {   // 미완성 클래스(==>추상 클래스, abstract class)
	
/*	
	미완성 메소드(==추상 메소드, abstract method)가 있는 클래스는
	반드시 미완성 클래스(==추상 클래스, abstract class)로 만들어야 한다.
	
	왜 미완성 메소드(==추상 메소드, abstract method)를 만들까요?
	왜냐하면 자식클래스에서 메소드를 오버라이딩(==재정의)을 하기 때문에
	부모클래스에서는 메소드를 정의할 필요가 없으므로 미완성 메소드로 만들어 버린다.
	
	일반적으로 부모클래스를 미완성 클래스(==추상 클래스, abstract class)로 만든다.
	미완성 클래스(==추상 클래스, abstract class)를 사용하여 객체(인스턴스)를 생성할 수 없다!!!!!!.(오류)
	
*/	
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
	
	
	// cry 메소드 생성 각 클래스에서 오버라이딩을 꼭해줘야한다를 표시하는 방법은 다음과 같다.
	protected abstract void cry();  //미완성 메소드(==추상 메소드, abstract method)라고 부른다,) 
	// 또는
	//abstract protected void cry();  //public abstract class Animal { 에도 abstract를 써줘야함  
	
	
	//미완성 메소드(==추상 메소드, abstract method)라고 부른다,)는 자식 클래스에서 무조건 오버라이딩(재정의)을 꼭 해주어야만 한다.
	
	
}

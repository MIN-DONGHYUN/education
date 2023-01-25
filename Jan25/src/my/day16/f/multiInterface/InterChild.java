package my.day16.f.multiInterface;

public interface InterChild extends InterFather, InterMother{		
	// 클래스는 다중 상속이 안되어지지만 인터페이스는 다중상속이 가능하여 이렇게 사용이 가능하다.
	// 자바는 인터페이스에서는 여러개의 인터페이스를 상속받는 다중 상속이 가능하다.

	void play(); 
	// public abstract void play(); 와 같다.
	
	
}

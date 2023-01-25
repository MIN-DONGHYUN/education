package my.day16.f.multiInterface;

public class Child implements InterChild{
// InterChild를 받아오므로 부모와 자식이 가지고 있는 것을 모두 오버라이딩 해야한다.
	
	@Override
	public void work() {
		System.out.println("보람차게 일합니다.!!");
		
	}

	@Override
	public void cook() {
		System.out.println("맛있는 요리를 합니다.~~");
		
	}

	@Override
	public void play() {
		System.out.println("주현이는 재미있게 놀고있습니다.^^");
		
	}

	
}

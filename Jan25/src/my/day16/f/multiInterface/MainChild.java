package my.day16.f.multiInterface;

public class MainChild {

	public static void main(String[] args) {
		
		Child cd = new Child();	// Child를 불러온다.
		cd.work();
		cd.cook();
		cd.play();
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		//다형성이니까 이렇게도 받아올수있다 한곳에 있는것을 불러옴 
		InterFather infather = new Child();
		infather.work(); // work만 나옴 InterFather에는 work만 있기 때문 
		
		InterMother inmother = new Child();
		inmother.cook(); // cook만 나옴 InterMother에는 cook만 있기 때문 
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~\n");
		
		// 자식이 부모꺼를 가져왔기 때문에 모두 가능 
		InterChild inchild = new Child();
		inchild.work();
		inchild.cook();
		inchild.play();

	}

}

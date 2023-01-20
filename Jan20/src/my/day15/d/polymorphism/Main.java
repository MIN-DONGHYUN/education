package my.day15.d.polymorphism;

public class Main {

	// >> 다형성(Polymorphism) <<<
	// ==> 상속을 이용하여 여러 클래스 타입을 하나의 클래스 타입으로 다루는 기술이다. 
	// 자식클래스로 생성되어진 객체를 부모 클래스 타입으로 받을수 있다는 것이 바로 다형성(Polymorphism)이다.
	
	public static void main(String[] args) {

		Animal[] aniArr = new Animal[5]; 	//배열 5개 설정 
		
		Dog dog = new Dog();
		//Animal anil = new Dog();  		// 이게 바로 다형성이다 부모클래스에 있는 것이 자식 클래스꺼를 사용가능 
		//aniArr[0] = new Dog();			// 이것도 가능 
		
		dog.setName("콩");				// 이름 설정
		dog.setBirthYear(2014);			// 생년월일 설정 
		dog.setWeight(4);				// 몸무게 설정 
		
		aniArr[0] = dog;
		
		
		Cat cat = new Cat();		
		//Animal anil2 = new Cat();			// 가능 다형성 
		//aniArr[1] = new Cat();			// 가능 다형성 
			
		cat.setName("톰");					// 이름 설정
		cat.setBirthYear(2012);				// 생년월일 설정 
		cat.setColor("검정");					// 색상 설정
		
		aniArr[1] = cat;
		
		Duck duck = new Duck();
		//Animal anil3 = new Duck();		// 가능 다형성 
		//aniArr[2] = new Duck();			// 가능 다형성 
		
		duck.setName("도널드");				// 이름 설정
		duck.setBirthYear(2018);			// 생년월일 설정 
		duck.setPrice(5000);				// 가격 설정
		
		aniArr[2] = duck;
		
		for(int i=0; i<aniArr.length; i++)		//배열만큼 반복
		{
			if(aniArr[i] != null)				// null이 아니라면 실행 
			{
				aniArr[i].showInfo(); 			// 동물 정보 메소드를 불러온다.
			}
		}
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		for(int i=0; i<aniArr.length; i++)		//배열만큼 반복
		{
			if(aniArr[i] != null)				// null이 아니라면 실행 
			{
				aniArr[i].cry(); 			// 동물 소리 메소드를 불러온다.
			}
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		for(int i=0; i<aniArr.length; i++)		//배열만큼 반복
		{
			if(aniArr[i] != null)				// null이 아니라면 실행 
			{
				
				if(aniArr[i] instanceof Dog)	// aniArr[i]의 값이 Dog 클래스로 생성되어진 인스턴스 입니까?
				{								// aniArr[i] 이 new Dog(); 로 생성되어진 것이 맞다면 true
												// aniArr[i] 이 new Dog(); 로 생성되어진 것이 아니라면 false
					((Dog) aniArr[i]).run();  	// Dog 클래스에 있는것을 부모 클래스에서 형변환 시켜준것이다.
					
				}
			}
		} // end of for 
		
		for(int i=0; i<aniArr.length; i++)		//배열만큼 반복
		{
			if(aniArr[i] != null)				// null이 아니라면 실행 
			{
				
				if(aniArr[i] instanceof Cat)	// aniArr[i]의 값이 Cat 클래스로 생성되어진 인스턴스 입니까?
				{								// aniArr[i] 이 new Cat(); 로 생성되어진 것이 맞다면 true
												// aniArr[i] 이 new Cat(); 로 생성되어진 것이 아니라면 false
					((Cat) aniArr[i]).jump();  	// Cat 클래스에 있는것을 부모 클래스에서 형변환 시켜준것이다. 
					
				}
			}
		} // end of for 
		
		for(int i=0; i<aniArr.length; i++)		//배열만큼 반복
		{
			if(aniArr[i] != null)				// null이 아니라면 실행 
			{
				
				if(aniArr[i] instanceof Duck)	// aniArr[i]의 값이 Duck 클래스로 생성되어진 인스턴스 입니까?
				{								// aniArr[i] 이 new Duck(); 로 생성되어진 것이 맞다면 true
												// aniArr[i] 이 new Duck(); 로 생성되어진 것이 아니라면 false
					((Duck) aniArr[i]).swim();  	// Duck 클래스에 있는것을 부모 클래스에서 형변환 시켜준것이다. 
					
				}
			}
		} // end of for 
		
		
		
	}// end of public static void main(String[] args) {

}

package my.day19.d.generic;

import java.util.*;

// == 필드 생성시 타입에 제한이 있거나 == 
// 또는
// == 필드 생성시 제한이 없는 클래스 생성하기 == //

public class Box_wildCard_Employee {

	// 클래스가 아닌 field에 제네릭을 사용 가능 클래스는 T사용 가능, but field는 T가 안됨 
	
	//private List<Box_Anything<T>> anything_list = new ArrayList<Box_Anything<T>>();      //이 List에 Box_Anything<T>을 담아두겠다.
	// 또는    원래는 위에것을 써야하지만 jdk 8부터는 생략 가능 
	private List<Box_Anything<?>> anything_list = new ArrayList<>(); // 리스트로 담는다
	//						 <?> 는 아무거나 
	// 제네릭에서 <?> 의 뜻은 ? 는 아무거나를 뜻하는 것이므로 object와 같은 의미이다.
	
	
	//메소드 
	public void register_anything(Box_Anything<?> item) {  //Box_Anything<?>클래스의 인스턴스 , 리스트로 담는다
		
		anything_list.add(item); 		// item을 리스트에 추가한다.
		
	}
	
	//메소드
	public List<Box_Anything<?>> get_anything(){
		return anything_list;
	}
	
	///////////////////////////////////////////////////////////
	
	//  하한제한 
	//    ? super Employee_Child_Executive 은 
	//    Employee_Child_Executive 부터 Employee_Child_Executive 의 조상(부모의 부모의 부모....)클래스 까지만 타입으로 들어올 수 있다.
	private List<Box_Anything<? super Employee_Child_Executive>> executive_list = new ArrayList<>(); // 리스트로 담는다
	//	 <?> 는 아무거나 
	// 제네릭에서 <?> 의 뜻은 ? 는 아무거나를 뜻하는 것이므로 object와 같은 의미이다.
	
	
	//메소드 
	//                                                파라미터 부분 
	public void register_executive(Box_Anything<? super Employee_Child_Executive> item) {  
		
		executive_list.add(item); 		// item을 리스트에 추가한다.
		
	}
	
	//메소드
	public List<Box_Anything<? super Employee_Child_Executive>> get_executive(){
		return executive_list;
	}

	
	///////////////////////////////////////////////////////////	
	
	// 상한제한 
	// 이 클래스를 포함한 자식들을 호출이 가능하다.
	//    ? extends Employee_Child_Plain 은 
	//    Employee_Child_Plain 을 포함한  Employee_Child_Plain 의 자식(자식의 자식의 자식...)클래스 까지만 타입으로 들어올 수 있다.
	private List<Box_Anything<? extends Employee_Child_Plain>> plain_list = new ArrayList<>();
	
	
	//메소드 
	//                                                파라미터 부분 
	public void register_Plain(Box_Anything<? extends Employee_Child_Plain> item) {  
		
		plain_list.add(item); 		// item을 리스트에 추가한다.
		
	}
	
	//메소드
	public List<Box_Anything<? extends Employee_Child_Plain>> get_plain(){
		return plain_list;
	}

	
}

package my.day19.b.generic;

import java.util.*;

//=== 타입에 제한이 없는 제네릭 클래스 === //
public class Box_Anything<T> { 		// 클래스 이름 다음에 제네릭 타입 T를 선언한다.
									// T는 type이라는 뜻으로 쓴 것으로 T 대신에 아무 글자가 와도 괜찮다.
									// 제네릭 타입 T의 뜻은 Box_Anything 클래스에서 선언되어지는 필드의 타입과 메소드의 파라미터 및 리턴타입에서 
									// 어떤 클래스라도 타입으로 들어올 수 있다는 것이다.

	//field
	private List<T> list = new ArrayList<>();  // 초기치 new ArrayList를 준것이다.

	// get
	public List<T> getList() {
		return list;
	}

	//메소드 
	public void register(T item) {			// T 제네릭을 받아온것을 item으로 저장 
		list.add(item);						// 리스트필드에 item을 저장한다.
	}
}

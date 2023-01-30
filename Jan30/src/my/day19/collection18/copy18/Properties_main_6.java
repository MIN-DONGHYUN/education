package my.day19.collection18.copy18;

import java.util.*;

/*
Properties 는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로,
Hashtable 은 키와 값(Object, Object)의 형태로 저장하는데 비해서
Properties 는 (String 키, String 밸류값)의 형태로 저장하는 단순화된 컬렉션 클래스이다. (오로지 String 키, 벨류값이다.)
    키는 고유해야 한다. 즉, 중복을 허락하지 않는다. 중복된 값을 넣으면 마지막에 넣은 값으로 덮어씌운다.
    주로 어플리케이션의 환경설정과 관련된 속성(property)을 저장하는데 사용되며, 
    데이터를 파일로 부터 읽고 쓰는 편리한 기능을 제공한다.    
*/   

public class Properties_main_6 {

	public static void main(String[] args) {
		
		Properties prop = new Properties();		//prop를 properties로 사용한다.
		
		// 오로지 String타입으로 키와 벨류값을 받아야 한다.
		prop.setProperty("jdk", "http://www.oracle.com/technetwork/java/javase/downloads/index.html");
	    prop.setProperty("eclipse", "http://www.sist.co.kr");
	    prop.setProperty("eclipse", "http://www.eclipse.org/downloads/eclipse-packages/");
	    prop.setProperty("oracle", "http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html");
	    //뒤에 있는 벨류값 URL을 키 값으로 보겠다는 것이다.
	    // 두번째 키값과 세번째 키값이 eclipse로 같으므로 두번째 키값은 없어지고 세번째 키값으로 덮어씌워진다.
	    
	    String url = prop.getProperty("eclipse"); 	// 키값에 eclipse
	    System.out.println(url);    // 을 하면 eclipse는 세번째 url에 나올것이다.
	    // http://www.eclipse.org/downloads/eclipse-packages/

	    
	    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	    
	    // === prop 에 저장되어진 모든 Value(여기서는 url) 값들을 출력하고자 한다
	    // 먼저 prop에 저장되어진 키 목록을 받아와야 한다.
	    // 키 목록은 아래와 같이 하면 된다.
	    
	    // Enumeration<?> en= prop.propertyNames();  // return 타입은 Enumeration<?> (<>은 제네릭)
	    // 제네릭에서 <?> 의 뜻은 ? 는 아무거나를 뜻하는 것이므로 object와 같은 의미이다.
	    
	    @SuppressWarnings("unchecked")
		Enumeration<?> en= (Enumeration<String>) prop.propertyNames();
	    // Properties prop  에서 키목록은 Enumeration<String> 형태로 변환시켜 준다.
	    
	    while(en.hasMoreElements())		// iterator 에 has next와 같은 기능이다.
	    {
	    	String key = (String) en.nextElement();			// return 타입은 String이다.
	    	System.out.print(key);
	    	System.out.print("=");
	    	System.out.println(prop.getProperty(key)); 	// 해당 key에 일치하는 벨류값을 리턴시켜준다.
	    }
	    /*
	      oracle=http://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html
		  eclipse=http://www.eclipse.org/downloads/eclipse-packages/
		  jdk=http://www.oracle.com/technetwork/java/javase/downloads/index.html
	    */
	    
	}

}

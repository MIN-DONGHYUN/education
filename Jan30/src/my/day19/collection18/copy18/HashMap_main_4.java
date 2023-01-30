package my.day19.collection18.copy18;

import java.util.*;

/*
=== Map 계열 ===
1. HashMap 과 Hashtable 이 있다.
2. Map 계열은 List 계열(Vector, ArrayList, LinkedList)처럼 index 가 사용되어 저장되는 것이 아니라, 
   Map 계열은 key값과 value값을 쌍으로 사용하여 저장하는데  
      데이터 저장시 사용되는 메소드는 put(String key, Object value)메소드를 사용한다.
      이때 key값은 반드시 고유한 값을 가져야 하고, value값은 중복된 값이 와도 괜찮다.
3. Map 계열에 저장된 key값들은 순서와는 상관없이 저장된다.  
4. Map 계열에 저장된 value값을 추출하려면 key를 이용해서 가져오는데 
   value 값의 추출은 get(String key) 메소드를 사용한다. 
*/

public class HashMap_main_4 {

	public static void main(String[] args) {
		
		Map <String, Member> mbrMap = new HashMap<String, Member>(); //<타입값(Key), 저장할 곳(Value)>
		// 또는 
		//Map <String, Member> mbrMap = new HashMap<>(); 	//생략 가능 JDK 8 이상부터 
		//Map <> mbrMap = new HashMap<String, Member>(); 	//생략 불가능 오류
		//Map <K, V> 키와 벨류

		//map은 개수 제한이 없기에 계속 put가능 
		mbrMap.put("youjs", new Member("youjs", "qwer1234$", "유재석"));		//put은 데이터를 저장하는 것이다.

		// mbrMap 이라는 HashMap 저장소에 new Member("youjs","qwer1234$","유재석")을 저장하는데 
	    // 저장된  new Member("youjs","qwer1234$","유재석")을 찾고자 할때는 
	    // "youjs" 만 넣어주면 new Member("youjs","qwer1234$","유재석") 이 나오도록 저장하겠다는 말이다. 
		
		mbrMap.put("eom", new Member("eom","qwer1234$","엄정화"));
		mbrMap.put("kanghd", new Member("kanghd","qwer1234$","강호동"));
		mbrMap.put("leess", new Member("leess","qwer1234$","이순신"));
		mbrMap.put("kimth", new Member("kimth","qwer1234$","김태희"));
		mbrMap.put("kangkc", new Member("kangkc","qwer1234$","강감찬"));
		
		// 만약 key값만 같고 정보는 다르다면 
		mbrMap.put("kangkc", new Member("kangkc","abcd1234$","에이비시디"));
		
		
		
		System.out.println(mbrMap.get("youjs").name);  //get안에 key 값을 넣어준다. 그러면 저장되너진 value 값을 넘겨준다.
		// 유재석
		System.out.println(mbrMap.get("eom").name);  //get안에 key 값을 넣어준다. 그러면 저장되너진 value 값을 넘겨준다.
		// 엄정화
		
		System.out.println(mbrMap.get("kangkc").name);
		// 에이비시디 
		// 결국 key값이 중복되어지면 마지막에 쓴 정보로 덮어씌운다. 오버라이드
		// 이미 존재하는 key가 있는데 동일한 key로 put 해버리면 value에 해당하는 값을 새로운 value로 덮어씌운다.
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// === mbrMap에 저장되어진 모든 key들을 읽어오는 첫번째 방법 === //
		
		Set<String> keySets = mbrMap.keySet();			// 리턴타입은 우리가 String으로 했으므로 String이다/
									                    // 모든 Key를 가져온다.
		
		//저장 순서와는 상관없이 모든 key값이 나온다.
		for(String key : keySets)			//확장 for문
		{
			System.out.println(key);
		}
		/*
			eom
			youjs
			kimth
			kangkc
			kanghd
			leess
		*/
		
		System.out.println("\n########################\n");
		
		//String id = "leess";
		String id = "leesams";
		String passwd = "qwer1234$";
		String name = "이상순";
		
		Member mbr = new Member(id, passwd, name);		//인스턴스 만듬 
		
		Set<String> key_sets = mbrMap.keySet();   // 리턴타입은 우리가 String으로 했으므로 String이다/
		
		boolean isUsekey = true;				// 흔적남기기위해
		for(String key : key_sets)               //확장 for문
		{
			if(id.equals(key))				//만약 key값이 같다면 leess
			{
				isUsekey = false;			//흔적
				break;
			}
			
		}
		if(isUsekey)					//isUsekey가 true일때 
		{
			mbrMap.put(id, mbr);		// 값을 넣어준다.
			System.out.println(id + " 로 회원가입 성공함 ^^ \n");
		}
		else							//isUsekey가 false일때 
		{
			System.out.println(id + "은 이미 사용중이므로 다른것으로 바꾸세요!!");
		}
		
		
		//mbrMap.put(id, mbr);			//id가 key값이 된다.
		
		System.out.println(mbrMap.get("leess").name);
		// 이순신, 위에꺼 주석 처리 빼면 이상순 
		System.out.println(mbrMap.get("leesams").name);
		// 이상순
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		
		// mbrMap 에 저장되어진 id값(key)가 "eom", "leess", "hongkd" 으로 되어있는 회원들을 모두 출력해보세요
		
		List<String> searchList = new ArrayList<>();		//List사용하기 
		searchList.add("eom");
		searchList.add("leess");
		searchList.add("hongkd");
		
		for(int i=0; i<searchList.size(); i++)
		{
			Member membr = mbrMap.get(searchList.get(i));		//0번째 eom 1번째 leess 2번째 hongkd
			// hongkd은 없으므로 null값을 받아오게 된다.
			if(membr != null)					//membr가 null이 아니라면 
			{
				membr.infoPrint();    //출력
			}
			else								//membr가 null이라면 
			{
				System.out.println("id가 " + searchList.get(i) + " 인 회원은 존재하지 않습니다.\n ");
			}
		}
		/*
			== 엄정화님의 회원정보 == 
			1. 아이디 : eom
			2. 암호 : qwer1234$
			3. 성명 : 엄정화
			
			== 이순신님의 회원정보 == 
			1. 아이디 : leess
			2. 암호 : qwer1234$
			3. 성명 : 이순신
			
			id가 hongkd 인 회원은 존재하지 않습니다
		 */
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		
		// === mbrMap에 저장되어진 모든 key들을 읽어오는 두번째 방법 === //
		
		Set<String> keyset_2 = mbrMap.keySet();   //Map에서 키 뭉치를 호출 
		
		Iterator<String> itrator = keyset_2.iterator(); 		//리턴 타입은String 
		//Iterator는 저장소가 아니라 Collection에 저장되어진 요소(Element)를 읽어오는 용도로 사용한다.
		
		while(itrator.hasNext())
		{
			/*
			 	itrator.hasNext() 는
			 	itrator에서 현재 itrator 가 가지고 있는 여러 String 데이터 중 
			 	하나를 끄집어 내서 존재하는지를 알아보는 것이다.
			 	존재하면 true, 존재하지 않으면 false 를 리턴해준다.
			 	그러므로 현재는 키의 개수가 7개 이므로 7번 반복을 할 것이다.
			*/
			String key = itrator.next();		//키 값을 돌려준다.
			/*
			 	itrator.next()이 실제로 키값인 String 값을 itrator 에서 끄집어 낸다.
			 	이때 중요한 것은 끄집어 낸 키값인 String 값은 더 이상 itrator 에는 남아 있지 않게 된다.
			*/
			
			System.out.println(key);
			
			
		}// end of while
		/*
			eom
			youjs
			kimth
			kangkc
			kanghd
			leess
			leesams
		*/
		
		System.out.println("\n~~~~~~~~~~~또 한번더 ~~~~~~~~~~~\n");
		

		while(itrator.hasNext())	//값이 두번은 출력이 안되기 때문에 값이 false가 되어 더이상 실행이 안됨 
		{
			
			String key = itrator.next();		//키 값을 돌려준다.
			System.out.println(key);
		}// end of while
		// 결과값 없음!!!!!!!!!!!!!! 한번 잘라왔기 때문에 더이상 itrator에 존재하지 않기에 결과값X
		/*
		   itrator 에는 더 이상 String 데이터가 존재하지 않으므로 
		   처음부터 itrator.hasNext() 은 false가 되어진다.
		   그래서 아무것도 출력이 되지 않는다.
		*/
		
		
		System.out.println("\n~~~~~~~~~~~다시 처음부터 해본다 ~~~~~~~~~~~\n");
		
		itrator = keyset_2.iterator();   //키뭉치에서 다시 채워주자 !!

		while(itrator.hasNext())	//값이 두번은 출력이 안되기 때문에 값이 false가 되어 더이상 실행이 안됨 
		{
			
			String key = itrator.next();		//키 값을 돌려준다.
			System.out.println(key);
		}// end of while
		/*
			eom
			youjs
			kimth
			kangkc
			kanghd
			leess
			leesams
	    */
		
		
		System.out.println("\n~~~~ [퀴즈] mbrMap 에 저장되어진 모든 회원들의 정보를 출력하세요 ~~~ \n");
		Set<String> keyset = mbrMap.keySet(); // 키를 가져옴
		
		for(String key : keyset)
		{
			mbrMap.get(key).infoPrint();
		}
		
		System.out.println("\n~~~~~~~~~~~~또는~~~~~~~~~~~~~~\n");

		Iterator<String> it= keyset.iterator();
		
		while(it.hasNext())
		{
			String key = it.next();		//키 값을 뽑아오고 있음
			mbrMap.get(key).infoPrint();
		}
		
		System.out.println("\n ==== MbrMap에서 Key값이 kangkc 인 Member를 삭제하기 =====");
		
		mbrMap.remove("kangkc");		// kangkc를 제거하기 위해 
		
		keyset = mbrMap.keySet();
		
		for(String key : keyset)
		{
			mbrMap.get(key).infoPrint();				//kangkc를 확인하고 해당 키를 가져온후 출력을 해준다.
		}

		/*
			==== MbrMap에서 Key값이 kangkc 인 Member를 삭제하기 =====
			== 엄정화님의 회원정보 == 
			1. 아이디 : eom
			2. 암호 : qwer1234$
			3. 성명 : 엄정화

			== 유재석님의 회원정보 == 
			1. 아이디 : youjs
			2. 암호 : qwer1234$
			3. 성명 : 유재석

			== 김태희님의 회원정보 == 
			1. 아이디 : kimth
			2. 암호 : qwer1234$
			3. 성명 : 김태희

			== 강호동님의 회원정보 == 
			1. 아이디 : kanghd
			2. 암호 : qwer1234$
			3. 성명 : 강호동

			== 이순신님의 회원정보 == 
			1. 아이디 : leess
			2. 암호 : qwer1234$
			3. 성명 : 이순신

			== 이상순님의 회원정보 == 
			1. 아이디 : leesams
			2. 암호 : qwer1234$
			3. 성명 : 이상순
		 */
		
		System.out.println("\n ==== MbrMap에 저장되어진 모든 Member를 삭제하기 =====");
		
		mbrMap.clear(); 			// 모든 정보 삭제하기 
		
		keyset = mbrMap.keySet();
		
		for(String key : keyset)
		{
			mbrMap.get(key).infoPrint();				//kangkc를 확인하고 해당 키를 가져온후 출력을 해준다.
		}
		
		System.out.println("mbrMap.isEmpty() => " + mbrMap.isEmpty());
		//mbrMap.isEmpty() => true

		
		
	}// end of main

}

package my.day16.a.abstractClass;

import java.util.Scanner;

public class Ctrl_Gujikja extends Ctrl_Total{	// Ctrl_Totla에서 쓴 메소드를 부모 메소드로 해서 거기 있는 것을 사용할 수 있게함 

	// === 구직자(Ctrl_Gujikja) 신규 회원 가입시 ===//
	//     Gujikja 클래스의 field(필드)의 요구사항에 모두 맞으면 
	//     Gujikja[] guArr에 저장시켜주는 메소드 생성하기 //
	public void register(Scanner sc, Gujikja[] guArr) {
		
		// 지금까지 생성된 구직자 회원수가 guArr.length(배열크기, 정원)보다 적을경우에만 신규회원을 받아들인다.
		if(Gujikja.count < guArr.length)// 배열 크기보다 작을때만 실행하자
		{
			// 아이디는 필수 입력사항이면서 중복된 아이디로 입력하면 안된다!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			boolean isUseID = true;
			String id;			// 전역변수로 설정한다.
			
			do
			{
				System.out.print("1. 아이디 : ");
				id = sc.nextLine(); 			//"eomhj", "leess", "youks"
				
				// == 가입된 구직자 회원들에 대해 중복아이디 검사하기 == //
				for(int i = 0; i < Gujikja.count; i++)			//구직자의 카운트만큼 반복한다.
				{
					if(id.equals(guArr[i].getId()))		//입력한 아이디와 기존의 아이디가 같을 경우에는
					{
						isUseID = false;				// 흔적을 false로 남겨서 do-while문을 빠져나가지 못하도록 한다.
						System.out.println(">>[경고] 이미 사용중인 아이디 입니다. <<\n");
						break; 			// 그이후는 검사할 필요없이 다시 반복을 해야하므로 for문을 빠져나간다.
					}
					isUseID = true;
				}//end of for
			}while(!isUseID);		//isUseID가 true라면 탈출한다.
			
			System.out.print("2. 비밀번호 : ");
			String passwd = sc.nextLine();
			
			System.out.print("3. 성명 : ");
			String name = sc.nextLine();
			
			System.out.print("4. 주민번호 : ");
			String junun = sc.nextLine();
			
			System.out.print("5. 희망연봉 : ");
			String str_hope_money = sc.nextLine();
			
			Gujikja gu = new Gujikja(); 		//인스턴스 한개 생성한다.
			
			gu.setId(id);		//setID에 id 값을 넣어준다.
								// enter 나 공백으로만 넣어주면은 setID메소드에 있는 조건문에 걸려서 [경고]가 나오게 된다.
			gu.setPasswd(passwd); //setPasswd 에 passwd 값을 넣어줌 
			gu.setName(name);     //setName 에 name 값을 넣어줌
			gu.setJubun(junun);     //setJubun 에 jubun 값을 넣어줌
			
			int hopemoney = Integer.parseInt(str_hope_money);
			
			gu.setHope_money(hopemoney);
			
			if(gu.getId() != null && gu.getPasswd() != null && gu.getName() != null && gu.getJubun() != null && gu.getHope_money() != 0)
			{				// 아이디, 비밀번호, 성명, 주번이 null이 아니고 희망연봉이 0이 아니면  
				guArr[Gujikja.count++] = gu;	// gu를 배열에 대입하고 count를 1 증가시킨다.
				System.out.println("[구직자 회원으로 가입 성공함 ^^]\n");
			}
			else
			{
				System.out.println("[구직자 회원으로 가입 실패함 ㅠㅠ]\n");
			}
			
		}
		else				// 배열크기를 초과
		{
			// 지금까지 생성된 구직자 회원수가 guArr.length(배열크기, 정원)보다 같거나, 큰경우에만 신규회원으로 받아들일 수 없다.
			System.out.println(" >> [경고] 정원이 초과하여 구직자 회원가입이 불가합니다/11 << \n");
		}
			
		
		
	}	// end of public void register(Scanner sc, Gujikja[] guArr) {

	public Gujikja login(Scanner sc, Gujikja[] guArr) {
		
		System.out.print("▷ 구직자 ID : ");
		String id = sc.nextLine();
		
		System.out.print("▷ 비밀번호 passwd : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Gujikja.count;i++)	//구직자 만큼 반복
		{
			if( id.equals(guArr[i].getId()) && passwd.equals(guArr[i].getPasswd()))	//아이디,비번이 같다면
			{
				return guArr[i]; 			//아이디, 비번이 같으면 guArr[i]에 저장 
			}
		}//end of for
		
		return null;			//아이디, 비번이 같은것이 없으면 null로 값을 준다.
	}

	// === 구직자 전용메뉴 메소드 생성하기 ===
	public void gu_munu(Scanner sc, Gujikja login_gu, Company[] cpArr) {
		
		String str_menuno ;
		
		do
		{
			// 이름 나오게 구직자 전용메뉴 하기 
			System.out.println("=== 구직자 전용메뉴( " + login_gu.getName() + " 님 로그인중) --- \n"
							+ "1. 내정보 보기    2. 내정보 수정   3.모든구인회사 조회   4.로그아웃");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();		// 메뉴번호 받아오기 
			
			switch (str_menuno) {
			case "1":		// 내 정보 보기 
				show_myInfo(login_gu);		//같은 사람의 정보를 메소드 불러온다. 
				
				break;
			case "2":		// 내정보 수정 
				update_myInfo(sc, login_gu);	//스메너와 자기자신을 메소드로 넘기고 불러온다. 
				
				break;
	
			case "3":		// 모든 구인회사 조회
				show_all_companyInfo(cpArr);
				
				break;
	
			case "4":		//로그아웃 
				login_gu = null;			// 로그아웃하자!! null로 변경
				
				break;
	
	
			default:		// 그외들은 
				System.out.println("[경고] 메뉴에 있는 번호만 압력하세요!! \n");
				break;		
			}
		}while(!"4".equals(str_menuno));		// 4가 아니라면 무한 반복 
		
		System.out.println(">> 로그아웃 되었습니다 << \n");
		
		
	}// end of public void gu_munu(Scanner sc, Gujikja login_gu, Company[] cpArr) {

	// 내 정보 보기를 해주는 메소드 생성하기 === //
	private void show_myInfo(Gujikja login_gu)		// 내 정보를 나타내는 메소드 생성 
	{												// 자기 클래스에서 불러오는것은 가능한 private
		
		System.out.println("\n=== " + login_gu.getName() + " 님의 정보 ===");
		System.out.println(login_gu); 				// 객체만 적어와서 개인 정보를 보이자 
		// my.day14.a.inheritance.Gujikja@74a14482  //원래는 login_gu.toString을 사용해야하는데 생략해서 해도 값은 똑같다.
													//오버라이딩으로 결과값을 변경한다.
		/*
		   === 이순신 님의 정보 ===
			1. 아이디 : leess
			2. 비밀번호 : abCd123$B
			3. 성명 : 이순신
			4. 주민번호 : 0101173
			5. 희망연봉 : 6,000만원
		*/
		
		//System.out.println(login_gu.toString());
		// my.day14.a.inheritance.Gujikja@74a14482
		
		
	}// end of private void show_myInfo(Gujikja login_gu)
	
	// == 내 정보 수정 해주는 메소드 생성하기 ---//
	private void update_myInfo(Scanner sc, Gujikja login_gu)
	{
		
		show_myInfo(login_gu);			//같은 사람의 정보를 메소드 불러온다.
		
		System.out.println(">>[주의사항] 변경하지 않고 예전의 데이터값을 사용하시려면 그냥 enter 하세요!!\n");
		
		System.out.print("1.비밀번호 : ");
		String new_passwd = sc.nextLine();
		
		System.out.print("2.성명 : ");
		String new_name = sc.nextLine();
		
		System.out.print("3.주민번호 : ");
		String new_jubun = sc.nextLine();
		
		int new_hope_money=0;					//전역변수
		String str_new_hope_money; 
		do
		{
			System.out.print("4.희망연봉 : ");
			str_new_hope_money = sc.nextLine();	//"9000", "123456" ""(그냥 엔터)가능
														// "         " ,"강아지" --> 불가능 
			try			//오류잡기위해 시도 
			{	
				if("".equals(str_new_hope_money))		// 엔터만 친 경우
				{
					
					break;   // 반복문 탈출 
				}
				//숫자인지 아닌지 판별
				new_hope_money = Integer.parseInt(str_new_hope_money); 		//int 형으로 변경 
				break;		// 반복문 탈출 
			}
			catch(NumberFormatException e)		// 이 오류가 뜨면 실행 
			{
				System.out.println("[경고] 희망연봉은 정수로만 입력하세요!!\n");
			}
			
		} while(true);  // 무한 반복 
		
		// 새롭게 변경부분
		if(!new_passwd.trim().isEmpty())		// 새로운 비밀번호가 공백이 아닐경우에만 
		{
			login_gu.setPasswd(new_passwd);  // 새로운 암호를 넣어주겠다.
		}
		
		if(!new_name.trim().isEmpty())		// 새로운 이름이 공백이 아닐경우에만 
		{
			login_gu.setName(new_name);	 	 // 새로운 이름를 넣어주겠다.
		}
		
		if(!new_jubun.trim().isEmpty())		// 새로운 주민번호가 공백이 아닐경우에만 
		{
			login_gu.setJubun(new_jubun);    // 새로운 주번를 넣어주겠다.
		}
		if(!"".equals(str_new_hope_money))			// 그냥 엔터가 들어오지 않으면
		{
			login_gu.setHope_money(new_hope_money);   // 새로운 희망연봉을 넣어주겠다.
		}

	} //end of private void update_myInfo(Scanner sc, Gujikja login_gu)
		
	
	//  == 모든 구인회사 정보를 조회해주는 메소드 생성하기 ==///
	private void show_all_companyInfo(Company[] cpArr)
	{
		if(Company.count == 0)		// 회사 카운트가 0이면
		{
			System.out.println(">> 구인화사로 등록된 회사가 한개도 없습니다. << \n");
		}
		else					// 회사 카운트가 1이상이면 
		{
			System.out.println("===========================================\n"
					         + "회사명    업종    사업자등록번호        자본금\n"
							 + "===========================================");
			
			StringBuilder sb = new StringBuilder();		// 스트링 빌더 사용하기 위해 
			
			for(int i=0; i< Company.count; i++)
			{
				//sb.append(cpArr[i].tostring() + "\n");
				//또는 
				sb.append(cpArr[i]+"\n");
			}//end of for
			
			//System.out.println(sb.toString());
			//또는 
			System.out.println(sb); 			// 위에 꺼와 같은 toString생략 가능
		}
		
		
	}// end of private void show_all_companyInfo(Company cpArr)
}

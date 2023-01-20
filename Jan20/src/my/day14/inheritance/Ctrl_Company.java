package my.day14.inheritance;

import java.text.DecimalFormat;

import java.util.Scanner;


public class Ctrl_Company {

	// === 구인회사(Company) 신규 회원 가입시 ===//
	//     Company 클래스의 field(필드)의 요구사항에 모두 맞으면 
	//     Company[] cpArr에 저장시켜주는 메소드 생성하기 //
	public void register(Scanner sc, Company[] cpArr) {
		
		if(Company.count < cpArr.length)// 배열 크기보다 작을때만 실행하자
		{	// 지금까지 생성된 구인회사 회원수가 cpArr보다 작을때만 실헹
			
			// 아이디는 필수 입력사항이면서 중복된 아이디로 입력하면 안된다!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			boolean isUseID = true;
			String id;			// 전역변수로 설정한다.
			
			do
			{
				System.out.print("1. 아이디 : ");
				id = sc.nextLine(); 			//"lg"
				
				// == 가입된 구직자 회원들에 대해 중복아이디 검사하기 == //
				for(int i = 0; i < Company.count; i++)			//구직자의 카운트만큼 반복한다.
				{
					if(id.equals(cpArr[i].getId()))		//입력한 아이디와 기존의 아이디가 같을 경우에는
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
			
			System.out.print("3. 회사명 : ");
			String name = sc.nextLine();
			
			System.out.print("4. 사업자 등록번호 : ");
			String business_number = sc.nextLine();
			
			System.out.print("5. 회사직종타입 : ");
			String jobType = sc.nextLine();
			
			long seedMoney;
			do
			{
				System.out.print("6. 자본금 : ");
				String str_seedMoney = sc.nextLine();
				try											// 시도해보고 오류있으면 catch
				{
					seedMoney = Long.parseLong(str_seedMoney);		//롱 타입으로 seedMoney를 변경 
					break;				// do-while문 탈출 
				}
				catch(NumberFormatException e)				// 오류시 실행
				{
					System.out.println(">>[경고] 자본금은 정수로만 입력하세요!!<<\n");
				}
			}while(true);		//무한반복
			
			
			Company cp = new Company(); 		//인스턴스 한개 생성한다.
			
			cp.setId(id);		//setID에 id 값을 넣어준다.
								// enter 나 공백으로만 넣어주면은 setID메소드에 있는 조건문에 걸려서 [경고]가 나오게 된다.
			cp.setPasswd(passwd); //setPasswd 에 passwd 값을 넣어줌 
			cp.setName(name);     //setName 에 name 값을 넣어줌
			cp.setBusiness_number(business_number);     //setBusiness_number 에 business_number 값을 넣어줌
			cp.setJobType(jobType);			//setJobType 에 jobType 값을 넣어줌
			cp.setSeedMoney(seedMoney);		//setSeedMoney 에 seedMoney 값을 넣어줌
			
			
			if(cp.getId() != null 	
			   && cp.getPasswd() != null 
			   && cp.getName() != null 
			   && cp.getBusiness_number() != null 
			   && cp.getJobType() != null 
		       && cp.getSeedMoney()!= 0)
			{				// 아이디, 비밀번호, 회사명, 사업자등록번호, 직종 이 null이 아니고 seedMoney가 0이 아니라면
				cpArr[Company.count++] = cp;	// cp를 배열에 대입하고 count를 1 증가시킨다.
				System.out.println("[구인회사 회원으로 가입 성공함 ^^]\n");
			}
			else
			{
				System.out.println("[구인회사 회원으로 가입 실패함 ㅠㅠ]\n");
			}
			
		}
		else				// 배열크기를 초과
		{
			// 지금까지 생성된 구인회사 회원수가 cpArr.length(배열크기, 정원)보다 같거나, 큰경우에만 신규회원으로 받아들일 수 없다.
			System.out.println(" >> [경고] 정원이 초과하여 구인회사 회원가입이 불가합니다!! << \n");
		}
		
	}//end of public void register(Scanner sc, Company[] cpArr) {

	///=== 구인회사 로그인하기위한 메소드 생성 ===///
	public Company login(Scanner sc, Company[] cpArr) {
		
		System.out.print("▷ 구직회사 ID : ");
		String id = sc.nextLine();
		
		System.out.print("▷ 비밀번호 passwd : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Company.count;i++)	//구직자 만큼 반복
		{
			if( id.equals(cpArr[i].getId()) && passwd.equals(cpArr[i].getPasswd()))	//아이디,비번이 같다면
			{
				return cpArr[i]; 			//아이디, 비번이 같으면 guArr[i]에 저장 
			}
		}//end of for
		
		return null;			//아이디, 비번이 같은것이 없으면 null로 값을 준다.
		
	} // end of public Company login(Scanner sc, Company[] cpArr) {

	
	//// == 구인회사 전용메뉴 메소드 생성하기 ===//
	public void cp_munu(Scanner sc, Company login_cp, Gujikja[] guArr) {
		
		String str_menuno ;
		
		do
		{
			// 이름 나오게 구직자 전용메뉴 하기 
			System.out.println("=== 구인회사 전용메뉴( " + login_cp.getName() + " 님 로그인중) --- \n"
							+ "1. 회사정보 보기    2. 회사정보 수정   3.모든 구직자 조회   4. 성별검색 \n"
							+ "5. 연령대 검색     6.성별 및 연령대검색     7. 로그아웃 ");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();		// 메뉴번호 받아오기 
			
			switch (str_menuno) {
			case "1":		// 회사 정보 보기 
				show_mycompanyInfo(login_cp);		//같은 사람의 정보를 메소드 불러온다. 
				
				break;
			case "2":		// 회사정보 수정 
				update_mycompanyInfo(sc, login_cp);	//스메너와 자기자신을 메소드로 넘기고 불러온다. 
				
				break;
	
			case "3":		// 모든 구직자 조회
				show_all_gujikjaInfo(guArr);
				
				break;
	
			case "4":		// 성별 검색
				search_gender(sc, guArr);				//Scanner 사용을 위해 sc를 넘겨주고 저장소를 넘겨준다.
				
				break;
			case "5":		// 연령대 검색
				search_ageline(sc, guArr);					//Scanner 사용을 위해 sc를 넘겨주고 저장소를 넘겨준다.		
				
				break;
				
			case "6":		// 성별 및 연령대 검색
				search_gender_ageline(sc, guArr);				//Scanner 사용을 위해 sc를 넘겨주고 저장소를 넘겨준다.
				
				break;
				
			case "7":		//로그아웃 
				login_cp = null;			// 로그아웃하자!! null로 변경
				
				break;
	
			default:		// 그외들은 
				System.out.println("[경고] 메뉴에 있는 번호만 압력하세요!! \n");
				break;		
			}
		}while(!"7".equals(str_menuno));		// 4가 아니라면 무한 반복 
		
		System.out.println(">> 로그아웃 되었습니다 << \n");
		
		
	}// end of public void cp_munu(Scanner sc, Company login_cp, Gujikja[] guArr) {
	
	// === 내회사 정보를 보여주기 위한 메소드 생성 ===// 
	private void show_mycompanyInfo(Company login_cp)
	{
		Company_Info(login_cp);			// Company_Info 메소드를 호출한다.
	}
	
	// === 내회사 정보를 수정하기 위한 메소드 생성 ===//
	private void update_mycompanyInfo(Scanner sc, Company login_cp)
	{
		Company_Info(login_cp);			// Company_Info 메소드를 호출한다.
		
		
		System.out.println("\n>>[주의사항] 변경하지 않고 예전의 데이터값을 사용하시려면 그냥 enter 하세요!!\n");
		
		System.out.print(" 1. 비밀번호 : ");
		String new_passwd = sc.nextLine();
		
		System.out.print(" 2. 회사명 : ");
		String new_Name = sc.nextLine();
		
		System.out.print(" 3. 사업자 등록번호 : ");
		String new_business_number = sc.nextLine();
		
		System.out.print(" 4. 회사직종타입 : ");
		String new_jobType = sc.nextLine();

		long new_seedMoney;						// 전역 변수 설정 
		String new_str_seedMoney;				
		do										// do -while문 반복
		{
			System.out.print(" 5. 자본금 : ");
			new_str_seedMoney = sc.nextLine();		
			try											// 시도해보고 오류있으면 catch
			{
				new_seedMoney = Long.parseLong(new_str_seedMoney);		//롱 타입으로 seedMoney를 변경 
				break;				// do-while문 탈출 
			}
			catch(NumberFormatException e)				// 오류시 실행
			{
				System.out.println(">>[경고] 자본금은 정수로만 입력하세요!!<<\n");
			}
		}while(true);		//무한반복
		
		if(!new_passwd.trim().isEmpty())			// 비밀번호가 공백이 아니라면 
		{
			login_cp.setPasswd(new_passwd);			// 새롭게 받아온 값을 넣어준다.
		}
		if(!new_Name.trim().isEmpty())				// 이름이 공백이 아니라면 
		{
			login_cp.setName(new_Name);				// 새롭게 받아온 값을 넣어준다.
		}
		if(!new_business_number.trim().isEmpty())		// 사업자 등록번호가 공백이 아니라면 
		{
			login_cp.setBusiness_number(new_business_number);	// 새롭게 받아온 값을 넣어준다.
		}
		if(!new_jobType.trim().isEmpty())				// 회사 직종이 공백이 아니라면 
		{
			login_cp.setJobType(new_jobType);			// 새롭게 받아온 값을 넣어준다.
		}
		if(!new_str_seedMoney.trim().isEmpty())			// 자본금이 공백이 아니라면 
		{
			login_cp.setSeedMoney(new_seedMoney);		// 새롭게 받아온 값을 넣어준다.
		}
	}
	
	// === 모든 구직자를 보여주기 위한 메소드 생성 ===//
	private void show_all_gujikjaInfo(Gujikja[] guArr)		
	{
		if(Gujikja.count == 0)								// 구직자정보가 0이라면 
		{
			System.out.println(">> 등록된 구직자가 없습니다. <<\n");
		}
		else												// 구직자 정보가 1이라도 있다면 
		{
			title();										// 타이틀 메소드를 호출한다.
			
			StringBuilder sb = new StringBuilder();			// 스트링 빌더를 사용하기 위해서 설정 
			
			DecimalFormat df = new DecimalFormat("#,###");  // 3자리 마다 콤마를 찍어주는 것이다.
			
			for(int i =0; i< Gujikja.count; i++)			// 구직자 수 만큼 반복한다.
			{
				sb.append(guArr[i].getName()+"\t");			// 이름을 누적 
				sb.append(guArr[i].getGender()+"\t");		// 성별을 누적
				sb.append(guArr[i].getAge()+"\t");			// 나이를 누적 
				sb.append(guArr[i].getRegister_day()+"\t");	// 사업자 등록번호를 누적
				sb.append(df.format(guArr[i].getHope_money())+"만원"+"\n");	// 희망 연봉을 누적
			}
			System.out.println(sb.toString());			//String타입으로 출력 
			
		}
	}
	
	// === 구직자의 성별을 검색하기 위한 메소드 생성 ===//
	private void search_gender(Scanner sc, Gujikja[] guArr)
	{
		System.out.print("▷ 검색하고자 하는 성별[남/여] : ");		// 출력
		String str_gender = sc.nextLine();					//키보드로부터 남, 여를 받아옴 
		str_gender = str_gender.trim();						//키보드를 받아와서 공백을 지운다
		
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더로 출력해주기 위해 선언
		int cnt = 0;							// 반복한 횟수를 사용하기 위해 선언 
		
		if("남".equals(str_gender) || "여".equals(str_gender))
		{
			for(int i=0; i< Gujikja.count; i++)	// 저장소에 가서 찾는다.
			{	
				if(str_gender.equals(guArr[i].getGender()))
				{
					sb.append(guArr[i].getInfo()+"\n");	//스트링 빌더에 성별 사람을 쌓는다.
					cnt++;								// 입력받은 사람의 수를 나타내기위해 1씩 증가 
				}
			} // end of for
			if(cnt != 0 )			// cnt가 0이 아니라면 
			{
				title();	// 타이틀을 찍어주고 
				System.out.println(sb.toString()); 	//스트링 빌더 쌓아준것을 String 타입으로 변환해서 보여준다.
				System.out.println("[검색결과] " + str_gender +"자 구직자는 " + cnt + "명 입니다.");
			}
			else					// cnt가 0이라면 
			{
				System.out.println("[검색결과] " + str_gender + "자 구직자는 없습니다\n");
			}
			
		}
		else		// "남" 또는 "여" 가 아닌 "강아지"와 같은 것을 입력한 경우 
		{
			System.out.println("[경고] \"남\" 또는 \"여\" 만 입력하세요!! \n");
		}
		
		// 이렇게 써서 getinfo를 재활용가능하다.
		/*  for(int i=0;i<Gujikja.count; i++)
			{  
		 		String[] tempArr guArr[i].getInfo().split("[\t"];
		 		for( int j=2; j<tempArr.lenght; j++)
		 		{
		 			sb.append(tempArr[j]+"\t";
		 		}
		 		sb.append("\n");
		 	}
				
		 */
	}
	
	// === 구직자의 연령대를 검색하기 위한 메소드 생성 ===//
	private void search_ageline(Scanner sc, Gujikja[] guArr)	
	{
		System.out.print("▷ 검색하고자 하는 연령대 : ");
		String str_ageLine = sc.nextLine();	// 유저가 입력할 때  "20", "30", "40" 은 정상 "-30", "강아지" 는 오류 
		int search_ageLine;
		
		try 	// 오류 잡기위해 한번 시도해본다.
		{
			search_ageLine = Integer.parseInt(str_ageLine);		// String타입을 int로 변경한다.
			
			if(search_ageLine < 0)		// 음수라면 
			{
				System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! <<\n");
				return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
			}
		}
		catch(NumberFormatException e)	// 오류를 잡아준다.
		{
			System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! \n");
			return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
		}
		
		StringBuilder sb = new StringBuilder();	// 스트링 빌더로 출력해주기 위해 선언
		
		int cnt = 0;					// 출력받은 사람의 수가 몇명인지 보기 위해 cnt를 설정 
		
		for(int i=0; i< Gujikja.count; i++)	// 저장소에 가서 찾는다.
		{
			//guArr[i].getAge();		// 나이 	27		   22		  31		 39 
   							    // 연령대    27/10 *10   22/10*10   31/10*10   39/10*10
							    // 연령대		20		   20		  30		 30대로 변경하자 
			
			
			int ageLine = guArr[i].getAge()/10*10; 		// 연령대로 나타내게 해준다.
			
			if(search_ageLine == ageLine)
			{
				sb.append(guArr[i].getInfo()+"\n");	//스트링 빌더에 연령대별 사람을 쌓는다.
				cnt++;								// 입력받은 사람의 수를 나타내기위해 1씩 증가 
			}
		} // end of for
		
		if(cnt != 0 )			// cnt가 0이 아니라면 
		{
			title();
			System.out.println(sb.toString()); 	//스트링 빌더 쌓아준것을 String 타입으로 변환해서 보여준다.
			System.out.println("[검색결과] " + search_ageLine +"대 구직자는 " + cnt + "명 입니다.");
		}
		else					// cnt가 0이라면 
		{
			System.out.println("[검색결과] " + search_ageLine + "대 구직자는 없습니다\n");
		}
	}
	
	// === 구직자의 성별, 연령대를 검색하기 위한 메소드 생성 ===//
	private void search_gender_ageline(Scanner sc, Gujikja[] guArr)
	{
		//연령대 부분 
		System.out.print("▷ 검색하고자 하는 연령대 : ");
		String str_ageLine = sc.nextLine();	// 유저가 입력할 때  "20", "30", "40" 은 정상 "-30", "강아지" 는 오류 
		int search_ageLine;

		try 	// 오류 잡기위해 한번 시도해본다.
		{
			search_ageLine = Integer.parseInt(str_ageLine);		// String타입을 int로 변경한다.

			if(search_ageLine < 0)		// 음수라면 
			{
				System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! <<\n");
				return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
			}
		}
		catch(NumberFormatException e)	// 오류를 잡아준다.
		{
			System.out.println(">>[경고] 올바른 연령대 숫자만 입력하세요!! \n");
			return; 	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
		}

		// 성별 부분
		System.out.print("▷ 검색하고자 하는 성별[남/여] : ");		// 출력
		String str_gender = sc.nextLine();					//키보드로부터 남, 여를 받아옴 
		str_gender = str_gender.trim();						//키보드를 받아와서 공백을 지운다

		if( !("남".equals(str_gender) || "여".equals(str_gender)) )		// 남 또는 여 가 아니면은 
		{
			System.out.println("[경고]\"남\" 또는 \"여\" 만 입력하세요!!\n ");
			return;  	// return을 만나는 순간 현재 실행중인 메소드를 더이상 실행하지 않고 종료가 된다.
		}

		StringBuilder sb = new StringBuilder();	// 스트링 빌더로 출력해주기 위해 선언
		int cnt = 0;							// 반복한 횟수를 사용하기 위해 선언 

		for(int i=0; i< Gujikja.count; i++)		//구직자 수 만큼 반복
		{
			int ageLine = guArr[i].getAge()/10*10;	//연령대를 ageLine에 대입 

			if(search_ageLine == ageLine && str_gender.equals(guArr[i].getGender()))	// 찾고자하는 연령대와 성별이 같습니까?
			{
				sb.append(guArr[i].getInfo() + "\n");		// 누적한다.
				cnt++;										// 몇 명인지 확인하기 위해 1증가 
			}
		}	//end of for

		if(cnt != 0)		// cnt가 0이 아니라면 
		{
			title();		// 타이틀을 호출한다.
			System.out.println(sb.toString());	// 결과값을 보여준다.
			System.out.println("[검색결과] " + search_ageLine + "대 " + str_gender + "자는 " + cnt +"입니다.\n");
		}
		else		//cnt가 0이라면 
		{
			System.out.println("[검색결과] " + search_ageLine + "대 " + str_gender + "자 구직자는 없습니다.!! \n");
		}
	}
	
	private void title()
	{
		System.out.println("============================================================\n"
		         + "구직자명  성별      나이     가입일자                  희망연봉     \n"
				 + "============================================================");
	}
	
	private void Company_Info(Company login_cp)
	{
		DecimalFormat df = new DecimalFormat("#,###");  // 3자리 마다 콤마를 찍어주는 것이다.
		
		System.out.println("\n=== " + login_cp.getName() + " 님의 정보 ===");
		System.out.println("1. 회사명 : " + login_cp.getName()); 				// 객체만 적어와서 회사 정보를 보이자 
		System.out.println("2. 회사 직종 : " + login_cp.getJobType());
		System.out.println("3. 사업자 등록번호 : " + login_cp.getBusiness_number());
		System.out.println("4. 자본금 : " + df.format(login_cp.getSeedMoney())+"만원");
	}
	
}

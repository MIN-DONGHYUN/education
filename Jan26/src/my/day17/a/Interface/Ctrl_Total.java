package my.day17.a.Interface;

import java.util.Scanner;

public class Ctrl_Total implements Inter_Ctrl_Total {

	// === 메인 메뉴를 보여주는 메소드 생성하기 === //
	@Override
	public void main_menu() {
		
		System.out.println("\n === 메인 메뉴 === \n"
						+ "1. 구직자 회원가입  2. 구인회사 회원가입  3.구직자 로그인\n4. 구인회사 로그인  5. 프로그램 종료 \n"		);
		
		System.out.print("▷ 메뉴 번호 선택 : ");
	}
	
	// == Gujikja 객체 및 company 객체를 Member[] mbr_arr 배열에 저장시키는 메소드 생성하기 ===//
	@Override
	public void save_mbr_arr(Member mbr, Member[] mbr_arr)	// 구직자든 구인회사인든 모든것을 사용하기 위해서는 부모클래스인 Member을 사용하는 것이다. 
	{
		Gujikja gu = null;
		Company cp = null;
		
		if(mbr instanceof Gujikja)		//mbr에 들어온것이 구직자 인스턴스입니까?
		{
			gu = (Gujikja)mbr; 			// 캐스팅(형 변환)시켜서 저장시켜야 한다.
		}
		else					// mbr에 들어온것이 구인회사 인스턴스입니까?
		{
			cp = (Company)mbr;			// 캐스팅 (형 변환 시켜서 저장시켜야 한다.
		}
		
		//구직자 부분
		if( cp == null && gu != null && 			// cp,gu, 구직자의 아이디, 비밀번호, 이름, 주번이 null이 아니면 
				gu.getId() != null && 
				gu.getPasswd() != null &&
				gu.getName() != null && 
				gu.getJubun() != null )
		{
			mbr_arr[Member.count++] = gu;			// 구직자배열에 넣어준다.
			
			System.out.println("[구직자 회원으로 가입 성공함 !!]\n");
		}
		//구인회사부분
		else if( gu == null && cp != null && 			// cp,gu, 구직자의 아이디, 비밀번호, 이름, 주번이 null이 아니면 
				cp.getId() != null && 
				cp.getPasswd() != null &&
				cp.getName() != null && 
				cp.getBusiness_number() != null && 
				cp.getJobType() != null &&
				cp.getSeedMoney() > 0 )
		{
			mbr_arr[Member.count++] = cp;			// 구인회사배열에 넣어준다.
			
			System.out.println("[구인회사 회원으로 가입 성공함 !!]\n");
		}
		
		// 구직자 부분 실패
		else if( cp == null && gu != null)				// cp는 null이고 gu가 null이 아니면서 다른 것중 하나가 null이라면 
		{
			System.out.println("[구직자 회원으로 가입 실패함 !!]\n");
		}
		else
		{
			System.out.println("[구인회사 회원으로 가입 실패함 !!]\n");
		}

	} //end of public void save_mbr_arr() 
	
	
	// 구직자(Gujikja) 신규 회원가입시
	//     Gujikja 클래스의 field의 요구사항 모두 맞으면
	//     Member[] mbr_arr 에 저장시켜주는 메소드 생성하기 ===
	@Override
	public void register_gu(Scanner sc, Member[] mbr_arr) {
		
		if(Member.count < mbr_arr.length)	// 지금까지 생성된 구직자 및 구인회사 회원수가 mbr_arr.length(정원) 보다 적을 경우에만 신규회원으로 받아들인다.
		{
			// 아이디는 필수 입력사합이면서 중복된 아이디로 입력하면 안된다.!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			
			String id;
			boolean isUseId;
			
			do
			{
				isUseId = true;			// isUseID 초기값 true 
				System.out.println("1. 아이디 : ");
				id = sc.nextLine();		// "eomjh"  "leess"    "youks"
				
				// == 가입자 구직자 회원중 중복아이디 검사하기 == //
				if(!id.trim().isEmpty() )		// 공백제거하고 값이 비어있지 않는다면 
				{
					for(int i = 0; i < Member.count; i++)
					{
						if( mbr_arr[i] instanceof Gujikja && id.equals(mbr_arr[i].getId()))		// 실제로 저장되어진 것을 가져왔을때 구직자 일경우 와 아이디가 같다면 실행
						{
							System.out.println(">>이미 사용중인 아이디 입니다 << \n");
							isUseId = false;		// 무한 반복 다시 시작하기 위해 표식 남김 
							break;					// 아이디가 같으므로 더 검사할 필요가 없다.
						}
					}// end of for
				}
				else   // ""  또는 "          "
				{
					isUseId = false;				// 무한반복 다시 시작하기 위해 표식 남김 
				}
			}while(!isUseId);			//isUseID가 true이면 탈출한다!
			
			
			System.out.println("2. 비밀번호 : ");
			String passwd = sc.nextLine();
			
			
			System.out.println("3. 성명 : ");
			String name = sc.nextLine();
			
			
			System.out.println("4. 주번 : ");
			String jubun = sc.nextLine();
			
			
			Gujikja gu = new Gujikja();		// 새로운 인스턴스 생성
			gu.setId(id);					// set을 다 불러온다.
			gu.setPasswd(passwd);
			gu.setName(name);
			gu.setJubun(jubun);
			
			save_mbr_arr(gu, mbr_arr);	// 불러온다.(메소드 호출)
			
			
		}
		else   // 지금까지 생성된 구직자 및 구인회사 mbr_arr.length(정원) 과 같거나 큰 경우에는 신규회원을 받아들이면 안된다.		{
		{
			System.out.println(">> 정원을 초과하여 구직자 회원가입이 불가합니다 !! << \n");
		}
		
	}// end of public void register_gu(Scanner sc, Member[] mbr_arr) {
	
	
	// 구인회사(Company) 신규 회원가입시
	//     Company 클래스의 field의 요구사항 모두 맞으면
	//     Member[] mbr_arr 에 저장시켜주는 메소드 생성하기 ===
	@Override
	public void register_cp(Scanner sc, Member[] mbr_arr) {

		if(Member.count < mbr_arr.length)	// 지금까지 생성된 구직자 및 구인회사 회원수가 mbr_arr.length(정원) 보다 적을 경우에만 신규회원으로 받아들인다.
		{
			// 아이디는 필수 입력사합이면서 중복된 아이디로 입력하면 안된다.!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			
			String id;
			boolean isUseId;
			
			do
			{
				isUseId = true;			// isUseID 초기값 true 
				System.out.print("1. 아이디 : ");
				id = sc.nextLine();		// "lg"   "samsung
				
				// == 가입자 구인회사 회원중 중복아이디 검사하기 == //
				if(!id.trim().isEmpty() )		// 공백제거하고 값이 비어있지 않는다면 
				{
					for(int i = 0; i < Member.count; i++)
					{
						if( mbr_arr[i] instanceof Company && id.equals(mbr_arr[i].getId()))		// 실제로 저장되어진 것을 가져왔을때 구직자 일경우 와 아이디가 같다면 실행
						{
							System.out.println(">>이미 사용중인 아이디 입니다 << \n");
							isUseId = false;		// 무한 반복 다시 시작하기 위해 표식 남김 
							break;					// 아이디가 같으므로 더 검사할 필요가 없다.
						}
					}// end of for
				}
				else   // ""  또는 "          "
				{
					isUseId = false;				// 무한반복 다시 시작하기 위해 표식 남김 
				}
			}while(!isUseId);			//isUseID가 true이면 탈출한다!
			
			
			System.out.println("2. 비밀번호 : ");
			String passwd = sc.nextLine();
			
			
			System.out.println("3. 회사명 : ");
			String name = sc.nextLine();
			
			
			System.out.println("4. 사업자 등록번호 : ");
			String businees_number = sc.nextLine();
			
			System.out.println("5. 회사직종타입 : ");
			String jobType = sc.nextLine();
			
			System.out.println("6. 자본금 : ");
			String seedMoney = sc.nextLine();
			
			Company cp = new Company();		// 새로운 인스턴스 생성
			cp.setId(id);					// set을 다 불러온다.
			cp.setPasswd(passwd);
			cp.setName(name);
			cp.setBusiness_number(businees_number);
			cp.setJobType(jobType);
			cp.setSeedMoney(Long.parseLong(seedMoney));  // 롱타입으로 변경하여 나타낸다. 
			
			save_mbr_arr(cp, mbr_arr);	// 불러온다.(메소드 호출)
			
			
		}
		else   // 지금까지 생성된 구직자 및 구인회사 mbr_arr.length(정원) 과 같거나 큰 경우에는 신규회원을 받아들이면 안된다.		{
		{
			System.out.println(">> 정원을 초과하여 구인회사 회원가입이 불가합니다 !! << \n");
		}
	}// end of public void register_cp(Scanner sc, Member[] mbr_arr) {
	
	// ==구직자 로그인 메소드 생성하기 ==
	@Override
	public Gujikja login_gu(Scanner sc, Member[] mbr_arr) {
		
		System.out.print("▷ 구직자 ID : ");
		String id = sc.nextLine();
		
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Member.count; i++)					// 구직자 회원수만큼 반복 
		{
			if(mbr_arr[i] instanceof Gujikja && 			// 실제로 저장되어진 것을 가져왔을때 구직자 일경우
			   id.equals(mbr_arr[i].getId()) &&
			   passwd.equals(mbr_arr[i].getPasswd()))
			{
				return (Gujikja) mbr_arr[i];			// 구직자로 형변환후 리턴 
			}
		}
		return null;		//if문이 실행 안된다면 null값으로 리턴 
	}// end of public Gujikja login_gu(Scanner sc, Member[] mbr_arr) {
	
	
	// == 구직자 전용메뉴 메소드 생성하기 == 
	@Override
	public void gu_munu(Scanner sc, Gujikja login_gu, Member [] mbr_arr){
		
		String str_menuno = "";
		
		do {
			System.out.println("=== 구직자 전용메뉴(" + login_gu.getName() + "님 로그인중) ===\n"
					+ "1. 내 정보 보기    2. 내 정보 수정   3. 모든구인회사 조회   4. 로그아웃 \n");
			
			System.out.print("▷ 메뉴번호 선택 : ");
			
			switch (str_menuno) {
			case "1":					// 내 정보 보기 
				show_myInfo(login_gu);
				break;

			case "2":					// 내 정보 수정
				update_myInfo(sc, login_gu);
				break;

			case "3":					// 모든 구인회사 조회
				show_all_companyInfo(mbr_arr);
				break;

			case "4":					// 로그아웃
				login_gu = null;
				break;

			default:					// 나머지
				System.out.println("[경고] 메뉴에 있는 번호만 선택하세요!! \n");
				break;
			}
			
			
			
		}while(!("4".equals(str_menuno)));		// 4번이면 무한 반복 끝낸다.
		
		System.out.println(">> 로그아웃 되었습니다. << \n");
	}

	// == 내 정보 보기를 해주는 메소드 생성하기 == //
	private void show_myInfo(Gujikja login_gu) {
		
		System.out.println("\n=== " + login_gu.getName() + "님의 정보 ===");
		//System.out.println(login_gu.toString());
		// 또는 
		System.out.println(login_gu);
	}// end of private void show_myInfo(Gujikja login_gu) {
	
	// 내 정보 수정을 해주는 메소드 생성하기 == // 
	private void update_myInfo(Scanner sc, Gujikja login_gu) {
		
		show_myInfo(login_gu);
		System.out.println(">>[ 주의사항] 변경하지 않고 예전의 데이터값을 사용하시려면 그냥 엔터하세요!!<<");
		
		System.out.println("1. 비밀번호 : ");
		String passwd = sc.nextLine();
		
		System.out.println("2. 성명 : ");
		String name = sc.nextLine();
		
		System.out.println("3.주번 : ");
		String jubun = sc.nextLine();
		
		System.out.println("4. 희망연봉 : ");
		String hope_money = sc.nextLine();
		
		System.out.println("");
		
		if( !"".equals(passwd))				// passwd가 공백이 아니라면 
		{
			login_gu.setPasswd(passwd);		// set패스워드 가져옴 
		}
		if( !"".equals(name))				// name가 공백이 아니라면 
		{
			login_gu.setName(name);		// set name 가져옴 
		}
		if( !"".equals(jubun))				// jubun가 공백이 아니라면 
		{
			login_gu.setJubun(jubun);		// set jubun 가져옴 
		}
		if( !"".equals(hope_money))				// 희망연봉이 공백이 아니라면 
		{
			login_gu.setHope_money(Integer.parseInt(hope_money));		// sethope_money 가져옴 
		}
		
	}	// end of private void update_myInfo(Scanner sc, Gujikja login_gu) {

	// 모든 구인회사 조회 해주는 메소드 생성하기 
	private void show_all_companyInfo(Member[] mbr_arr) {
		
		int company_count = 0;
		
		for(int i=0; i<Member.count; i++)
		{
			if(mbr_arr[i] instanceof Company)// company에 있는 인스턴스 인가??
			{
				company_count++;		// 회사를 추가한다.
				break; 					// 더이상 반복을 안해도 되므로 break해서 탈출!
			}
		}
		
		if(company_count==0)				// 회사 카운트가 0이라면 
		{
			System.out.println(">> 구인회사로 등록된 회사가 한개도 없습니다. <<\n");
		}
		else								// 회사 카운트가 0이 아니라면 
		{
			System.out.println("==========================================\n"
						 + "회사명      업종     사업자등록번호        자본금  \n"
						 + "==========================================");
			
			StringBuilder sb = new StringBuilder(); 	// 스트링 빌더 사용하기 위해 
			
			for(int i = 0; i < Member.count; i++)
			{
				if(mbr_arr[i] instanceof Company) {
					sb.append(mbr_arr[i].view_info() + "\n");
				}
			}// end of for 
			
			//System.out.println(sb.toString());
			// 또는
			System.out.println(sb);
		}

	}//end of private void show_all_companyInfo(Member[] mbr_arr) {
	
	
	//== 구인회사 로그인 해주는 메소드 생성하기 ==
	@Override
	public Company login_cp(Scanner sc, Member [] mbr_arr) {
		
		System.out.print("▷ 구인회사 ID : ");
		String id = sc.nextLine();
		
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Member.count; i++)					// 구인회사 회원수만큼 반복 
		{
			if(mbr_arr[i] instanceof Company && 			// 실제로 저장되어진 것을 가져왔을때 구인회사 일경우
			   id.equals(mbr_arr[i].getId()) &&
			   passwd.equals(mbr_arr[i].getPasswd()))
			{
				return (Company) mbr_arr[i];			// 구인회사로 형변환후 리턴 
			}
		}
		return null;		//if문이 실행 안된다면 null값으로 리턴 
		
		
	} // end of public Company login_cp(Scanner sc, Member [] mbr_arr) {
	
	// == 구인회사 전용메뉴를 생성해주는 메소드 생성하기 == //
	@Override
	public void cp_munu(Scanner sc, Company login_cp, Member[] mbr_arr) {

		String str_menuno;

		do {
			System.out.println("=== 구인회사 전용메뉴("+ login_cp.getName() +"님 로그인중) ===\n"
					+ "1.회사정보 보기   2.회사정보 수정    3.모든구직자 조회   4.성별검색 \n"
					+ "5.연령대검색     6.성별 및 연령대검색  7.로그아웃 \n");

			System.out.print("▷ 메뉴번호 선택 : ");
			str_menuno = sc.nextLine();

			switch (str_menuno) {
			case "1": // 회사정보 보기
				show_mycompanyInfo(login_cp);	
				break;

			case "2": // 회사정보 수정
				update_mycompanyInfo(sc, login_cp);
				break;

			case "3": // 모든구직자 조회
				show_all_gujikja(mbr_arr);
				break;

			case "4": // 성별검색
				search_gender(sc, mbr_arr);
				break;	

			case "5": // 연령대검색
				search_ageline(sc, mbr_arr);
				break;	

			case "6": // 성별 및 연령대검색
				search_gender_ageline(sc, mbr_arr);
				break;	

			case "7": // 로그아웃
				login_cp = null;
				break;						

			default:
				System.out.println("[경고] 메뉴에 있는 번호만 선택하세요!!\n");
				break;
			}// end of switch (str_menuno)-------------------------

		} while(!"7".equals(str_menuno));

		System.out.println(">> 로그아웃 되었습니다. << \n");				

	}// end of public void cp_menu(Scanner sc, Company login_cp, Member[] mbr_arr)-------


	// 회사정보 보기 메소드 생성하기 
	private void show_mycompanyInfo(Company login_cp) {

		System.out.println("\n=== "+ login_cp.getName() +"님의 정보 ==="); 
		System.out.println(login_cp.view_info()+"\n");
	}// end of private void show_mycompanyInfo(Company login_cp)-------


	// 회사정보 수정 메소드 생성하기 
	private void update_mycompanyInfo(Scanner sc, Company login_cp) {

		show_mycompanyInfo(login_cp);

		System.out.println(">> [주의사항] 변경하지 않고 예전의 데이터값을 사용하시려면 그냥 엔터하세요!!");

		System.out.print("1.비밀번호 : ");
		String passwd = sc.nextLine();

		System.out.print("2.성명 : ");
		String name = sc.nextLine();

		System.out.print("3.사업자등록번호 : ");
		String business_number = sc.nextLine();

		System.out.print("4.회사직종타입 : ");
		String jobType = sc.nextLine();

		System.out.print("5.자본금 : ");
		String seedMoney = sc.nextLine();

		System.out.println("");

		if( !"".equals(passwd) ) {  
			login_cp.setPasswd(passwd);
		}

		if( !"".equals(name) ) {  
			login_cp.setName(name);
		}

		if( !"".equals(business_number) ) {  
			login_cp.setBusiness_number(business_number);
		}

		if( !"".equals(jobType) ) {  
			login_cp.setJobType(jobType);
		}

		if( !"".equals(seedMoney) ) {  
			login_cp.setSeedMoney(Long.parseLong(seedMoney));
		}

	}// end of private void update_mycompanyInfo(Scanner sc, Company login_cp)-------


	// 모든구직자 조회 메소드 생성하기 
	private void show_all_gujikja(Member[] mbr_arr) {

		int gujikja_count = 0;

		for(int i=0; i<Member.count; i++) {
			if(mbr_arr[i] instanceof Gujikja) {
				gujikja_count++;
				break;
			}
		}


		if(gujikja_count == 0) {
			System.out.println(">> 등록된 구직자가 한명도 없습니다. <<\n");
		}

		else {
			System.out.println("=========================================================\n"
					+ "구직자명  성별   나이         가입일자                 희망연봉 \n"
					+ "=========================================================");

			StringBuilder sb = new StringBuilder();

			for(int i=0; i<Member.count; i++) {
				if( mbr_arr[i] instanceof Gujikja ) {

					String temp_info = mbr_arr[i].view_info();
					//	temp_info ==> eomjh   qwer******    엄정화   여      29   2023-01-17 15:30:20   5,000만원 

					int index_tab = temp_info.indexOf("\t");
					temp_info = temp_info.substring(index_tab+1);

					index_tab = temp_info.indexOf("\t");
					temp_info = temp_info.substring(index_tab+1);

					sb.append(temp_info+"\n");
				}
			}// end of for---------------------

			//	System.out.println(sb.toString());
			//  또는	
			System.out.println(sb);
		}		

	}// end of private void show_all_gujikja(Member[] mbr_arr)-------


	// 성별검색 메소드 생성하기 
	private void search_gender(Scanner sc, Member[] mbr_arr) {

		do { 
			System.out.print("▷성별[남/여] : ");
			String gender = sc.nextLine();
			gender = gender.trim();

			if( "남".equals(gender) || "여".equals(gender) ) { 

				int gender_count = 0;

				for(int i=0; i<Member.count; i++) {				// 맴버수만큼 반복
					if(mbr_arr[i] instanceof Gujikja &&			// 구직자에 있는 것이며 성별이 구직자 성별과 같다면 
							gender.equals( ((Gujikja) mbr_arr[i]).getGender() ) ) {
						gender_count++;							// 성별 수를 증가시킨다.
						break;									// for문 탈출 
					}
				}

				if(gender_count == 0) {							// 성별 수가 0이면은 
					System.out.println(">> 등록된 구직자중 "+ gender +"자는 한명도 없습니다. <<\n");
				}

				else {											// 성별수가 0이 아닐경우에는 
					System.out.println("=========================================================\n"
							+ "구직자명  성별   나이         가입일자                 희망연봉 \n"
							+ "=========================================================");

					StringBuilder sb = new StringBuilder();			// 스트링빌더 사용한다.

					for(int i=0; i<Member.count; i++) {				// 맴버수만큼
						if( mbr_arr[i] instanceof Gujikja &&		// // 구직자에 있는 것이며 성별이 구직자 성별과 같다면
								gender.equals( ((Gujikja) mbr_arr[i]).getGender() ) ) {

							String temp_info = mbr_arr[i].view_info();	// 구직자를 보여줘라 
							int index_tab = temp_info.indexOf("\t");	// tab으로 구분한다. 
							temp_info = temp_info.substring(index_tab+1);	// 다시 시작은 tab +1 부터 출력한다.

							index_tab = temp_info.indexOf("\t");	// tab으로 구분한다. 
							temp_info = temp_info.substring(index_tab+1);	// 다시 시작은 tab +1 부터 출력한다.

							sb.append(temp_info+"\n");			//값을 쌓아둔다.
						}
					}// end of for---------------------

					//	System.out.println(sb.toString());
					//  또는	
					System.out.println(sb);						//출력
				}

				break;
			}

			else {
				System.out.println(">> [경고] 성별은 남 또는 여 만 가능합니다!!\n");
			}

		} while(true);

	}// end of private void search_gender(Scanner sc, Member[] mbr_arr)------


	// 연령대검색	
	private void search_ageline(Scanner sc, Member[] mbr_arr) {

		do { 
			System.out.print("▷연령대 : ");
			String str_ageline = sc.nextLine();

			try {
				int ageline = Integer.parseInt(str_ageline);		//문자열 int형변환

				if(ageline < 0) {									// 0보다 작다면 
					System.out.println(">> [경고] 연령대는 음수가 안됩니다!!\n");
				}

				else {												// 0보다 크다면 
					int ageline_count = 0;

					for(int i=0; i<Member.count; i++) {				//맴버수만큼 반복
						if(mbr_arr[i] instanceof Gujikja &&			// 구직자에 있으면서 나이가 검색할 연령대와 같다면 
								ageline == ((Gujikja) mbr_arr[i]).getAge()/10*10 ) {
							ageline_count++;						// 연령대 수를 증가시킨다.
							break;
						}
					}

					if(ageline_count == 0) {
						System.out.println(">> 등록된 구직자중 "+ ageline +"대는 한명도 없습니다. <<\n");
					}

					else {
						System.out.println("=========================================================\n"
								+ "구직자명  성별   나이         가입일자                 희망연봉 \n"
								+ "=========================================================");

						StringBuilder sb = new StringBuilder();

						for(int i=0; i<Member.count; i++) {			//맴버수만큼 반복
							if( mbr_arr[i] instanceof Gujikja &&	// 구직자에 있으면서 나이가 검색할 연령대와 같다면 
									ageline == ((Gujikja) mbr_arr[i]).getAge()/10*10 ) {

								String temp_info = mbr_arr[i].view_info();		// 구직자를 보여줘라 
								int index_tab = temp_info.indexOf("\t");	// tab으로 구분한다.
								temp_info = temp_info.substring(index_tab+1);		// 다시 시장은 tab +1 부터 출력한다.


								index_tab = temp_info.indexOf("\t");	// tab으로 구분한다.
								temp_info = temp_info.substring(index_tab+1);		// 다시 시장은 tab +1 부터 출력한다.


								sb.append(temp_info+"\n");			//값을 쌓아둔다.
							}
						}// end of for---------------------

						//	System.out.println(sb.toString());
						//  또는	
						System.out.println(sb);
					}

					break;
				}

			} catch(NumberFormatException e) {
				System.out.println(">> [경고] 연령대는 정수로만 입력하세요!!\n"); 
			}

		} while(true);

	}// end of private void search_ageline(Scanner sc, Member[] mbr_arr)-------


	// 성별 및 연령대검색 메소드 생성하기
	private void search_gender_ageline(Scanner sc, Member[] mbr_arr) {
/*
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
			int ageLine = ((Gujikja) mbr_arr[i]).getAge()/10*10;	//연령대를 ageLine에 대입 

			if(search_ageLine == ageLine && str_gender.equals(str_gender))	// 찾고자하는 연령대와 성별이 같습니까?
			{
				sb.append(((Gujikja)mbr_arr[i]).view_info() + "\n");		// 누적한다.
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
*/
	}
	/*
	private void title()
	{
		System.out.println("============================================================\n"
		         + "구직자명  성별      나이     가입일자                  희망연봉     \n"
				 + "============================================================");
	}
*/
	
}

package my.day14.a.inheritance;

import java.util.Scanner;

public class Ctrl_Company extends Ctrl_Total {

	// == 구인회사(Company) 신규 회원가입시
	//    Company 클래스의 field 의 요구사항에 모두 맞으면
	//    Company[] cpArr 에 저장시켜주는 메소드 생성하기 ==
	public void register(Scanner sc, Company[] cpArr) {
		
		if(Company.count < cpArr.length) {
			// 지금까지 생성된 구인회사 회원수가 cpArr.length(배열크기, 정원)보다 적을 경우에만 신규회원을 받아들인다.	
			
			// 아이디는 필수 입력사항이면서 중복된 아이디로 입력하면 안된다.!!
			// 입력받은 아이디가 중복된 아이디가 아닐때 까지 반복해야 한다.
			
			String id;
			boolean isUseID;
			
			do {
				isUseID = true;
				
				System.out.print("1.아이디 : ");
				id = sc.nextLine(); // "lg"  "samsung" 

				// == 가입된 구인회사 회원들에 대해 중복아이디 검사하기 == //
				for(int i=0; i<Company.count; i++) {
					if(id.equals(cpArr[i].getId())) {
						System.out.println(">> 이미 사용중인 아이디 입니다. <<\n");
						isUseID = false;
						break;
					}
				}// end of for-------------------------
				
			} while (!isUseID);
			// end of do~while-----------------------
			
			System.out.print("2.비밀번호 : ");
			String passwd = sc.nextLine();
			
			System.out.print("3.회사명 : ");
			String name = sc.nextLine();
			
			System.out.print("4.사업자등록번호 : ");
			String business_number = sc.nextLine();
			
			System.out.print("5.회사직종타입 : ");
			String jobType = sc.nextLine();
			
			long seedMoney;
			do {
				System.out.print("6.자본금 : ");
				String str_seedMoney = sc.nextLine(); 
				
				try {
					seedMoney = Long.parseLong(str_seedMoney);
					break;
				} catch(NumberFormatException e) {
					System.out.println(">>[경고] 자본금은 정수로만 입력하세요!!\n"); 
				}
				
			} while (true);
			
			
			Company cp = new Company();
			cp.setId(id);
			cp.setPasswd(passwd);
			cp.setName(name);
			cp.setBusiness_number(business_number);
			cp.setJobType(jobType);
			cp.setSeedMoney(seedMoney);
			
			
			if(cp.getId() != null &&
			   cp.getPasswd() != null &&
			   cp.getName() != null && 
			   cp.getBusiness_number() != null && 
			   cp.getJobType() != null &&
			   cp.getSeedMoney() != 0) {
				  cpArr[Company.count++] = cp;
			      System.out.println("[구인회사 회원으로 가입 성공함^^]\n");
			}
			
			else {
				System.out.println("[구인회사 회원으로 가입 실패함ㅜㅜ]\n");
			}
			
		}
		
		else {
			// 지금까지 생성된 구인회사 회원수가 cpArr.length(배열크기, 정원) 와 같거나 클 경우에는 신규회원으로 받아들일 수 없다. 
			System.out.println(">> 정원이 초과하여 구인회사 회원가입이 불가합니다.!! <<\n");
		}		
		
	}// end of public void register(Scanner sc, Company[] cpArr)------

	
	// == 구인회사 로그인 메소드 생성하기 == 
	public Company login(Scanner sc, Company[] cpArr) {
		
		System.out.print("▷ 구인회사 ID : ");
		String id = sc.nextLine();
		
		System.out.print("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<Company.count; i++) {
			
			if( id.equals(cpArr[i].getId()) &&
				passwd.equals(cpArr[i].getPasswd())	) {
				return cpArr[i];
			}
			
		}// end of for-------------------
		
		return null;
		
	}// end of public Company login(Scanner sc, Company[] cpArr)------


	// == 구인회사 전용메뉴 메소드 생성하기 ==
	public void cp_menu(Scanner sc, Company login_cp, Gujikja[] guArr) {
		
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
					show_all_gujikja(guArr);
					break;
					
				case "4": // 성별검색
					search_gender(sc, guArr);
					break;	
					
				case "5": // 연령대검색
					search_ageline(sc, guArr);
					break;	
					
				case "6": // 성별 및 연령대검색
					search_gender_ageline(sc, guArr);
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
		
	}// end of public void cp_menu(Scanner sc, Company login_cp, Gujikja[] guArr)--------------

	
	// == 회사정보 보기 메소드 생성하기 == 
	private void show_mycompanyInfo(Company login_cp) {
		
		System.out.println("\n=== "+ login_cp.getName() +"님의 정보 ==="); 
		
		System.out.println(login_cp.myinfo()+"\n");
		
	}// end of private void show_mycompanyInfo(Company login_cp)-----
	
	
	// == 회사정보 수정 메소드 생성하기 == 
	private void update_mycompanyInfo(Scanner sc, Company login_cp) {
		
		show_mycompanyInfo(login_cp);
		
		System.out.println(">> [주의사항] 변경하지 않고 예전의 데이터값을 사용하시려면 그냥 엔터하세요!!"); 
		
		System.out.print("1.비밀번호 : ");
		String new_passwd = sc.nextLine();
		
		System.out.print("2.회사명 : ");
		String new_name = sc.nextLine();
		
		System.out.print("3.직종 : ");
		String new_jobType = sc.nextLine();
		
		System.out.print("4.사업자등록번호 : ");
		String new_business_number = sc.nextLine();
		
		
		String str_seed_money;
		long new_seed_money = 0;
		
		do {
			System.out.print("5.자본금 : ");
			str_seed_money = sc.nextLine(); // "7000000"   ""(그냥엔터)
		                                    // "     "  "강아지" --> 불가 
			
			try {
				if("".equals(str_seed_money)) 
					break;
				
				new_seed_money = Long.parseLong(str_seed_money);
				break;
			} catch(NumberFormatException e) {
				System.out.println("[경고] 자본금은 정수로만 입력하세요!!\n");
			}
			
		} while(true);
		
		System.out.println("");
		
		
		if( !new_passwd.trim().isEmpty() ) {
			login_cp.setPasswd(new_passwd);
		}
		
		if( !new_name.trim().isEmpty() ) {
			login_cp.setName(new_name);
		}
		
		if( !new_jobType.trim().isEmpty() ) {
			login_cp.setJobType(new_jobType);
		}
		
		if( !new_business_number.trim().isEmpty() ) {
			login_cp.setBusiness_number(new_business_number);
		}
		
		if( !"".equals(str_seed_money)) {
			login_cp.setSeedMoney(new_seed_money);
		}		
			
	}// end of private void update_mycompanyInfo(Scanner sc, Company login_cp)-----
	

	// == 모든구직자 조회 메소드 생성하기 == 
	private void show_all_gujikja(Gujikja[] guArr) {
	
		if(Gujikja.count == 0) {
			System.out.println(">> 구직자로 등록된 구직자가 한명도 없습니다. << \n");
		}
		
		else {
			System.out.println("=======================================================\n"
					        + "구직자명  성별   나이         가입일자                 희망연봉 \n"
					        +  "=======================================================");
			
			// eomjh   qwer******    엄정화   여      29   2023-01-17 15:30:20   5,000만원
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<Gujikja.count; i++) {
				
				String[] tempArr = guArr[i].getInfo().split("[\t]");
				for(int j=2; j<tempArr.length; j++) {
					sb.append(tempArr[j]+"\t");
				}
				
				sb.append("\n");
			   // 엄정화   여      29   2023-01-17 15:30:20   5,000만원

			}// end of for------------------------
		
			System.out.println(sb);
		}		
		
	}// end of private void show_all_gujikja(Gujikja[] guArr)----------
	
	
	//////////////////////////////////////////////////
	
	private void search_result(Gujikja[] guArr) {
		
		if(guArr.length == 0) {
			System.out.println(">> 검색조건에 맞는 구직자가 한명도 없습니다. << \n");
		}
		
		else {
			System.out.println("=======================================================\n"
					        + "구직자명  성별   나이         가입일자                 희망연봉 \n"
					        +  "=======================================================");
			
			// eomjh   qwer******    엄정화   여      29   2023-01-17 15:30:20   5,000만원
			
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<guArr.length; i++) {
				
				String[] tempArr = guArr[i].getInfo().split("[\t]");
				for(int j=2; j<tempArr.length; j++) {
					sb.append(tempArr[j]+"\t");
				}
				
				sb.append("\n");
			   // 엄정화   여      29   2023-01-17 15:30:20   5,000만원

			}// end of for------------------------
		
			System.out.println(sb);
		}		
		
	}// end of private void search_result(Gujikja[] guArr)----------
	
	//////////////////////////////////////////////////
	
	
	// == 성별검색 메소드 생성하기 ==
	private void search_gender(Scanner sc, Gujikja[] guArr) {
		
		Gujikja[] tempArr;
		
		do {
			System.out.print("▷성별[남/여] : ");
			String gender = sc.nextLine();
			gender = gender.trim();
			
			if( "남".equals(gender) || "여".equals(gender) ) { 
				
				int count = 0;
				for(int i=0; i<Gujikja.count; i++) {
					if( gender.equals(guArr[i].getGender()) ) {
						count++;
					}
				}// end of for------------------------
				
				tempArr = new Gujikja[count];
				
				count = 0;
				for(int i=0; i<Gujikja.count; i++) {
					if( gender.equals(guArr[i].getGender()) ) {
						tempArr[count++] = guArr[i];
					}
				}// end of for------------------------
				
				break;
			}
			else {
				System.out.println(">> [경고] 성별은 남 또는 여 만 가능합니다!!\n");
			}
			
		} while(true);
		
		search_result(tempArr);
		
	}// end of private void search_gender(Scanner sc, Gujikja[] guArr)-----
		
	
	// == 연령대검색 메소드 생성하기 == 
	private void search_ageline(Scanner sc, Gujikja[] guArr) {
		
		Gujikja[] tempArr;
		
		do {
			System.out.print("▷연령대 : ");
			String str_ageline = sc.nextLine();
			
			try {
				int ageline = Integer.parseInt(str_ageline);
			
				if(ageline < 0) {
					System.out.println(">> [경고] 연령대는 음수가 안됩니다!!\n");
				}
				
				else {
					int count = 0;
					for(int i=0; i<Gujikja.count; i++) {
						if( ageline == guArr[i].getAge()/10*10 ) {
							count++;
						}
					}// end of for------------------------
					
					tempArr = new Gujikja[count];
					
					count = 0;
					for(int i=0; i<Gujikja.count; i++) {
						if( ageline == guArr[i].getAge()/10*10 ) {
							tempArr[count++] = guArr[i];
						}
					}// end of for------------------------
					
					break;
				}
			
			} catch(NumberFormatException e) {
				System.out.println(">> [경고] 연령대는 정수로만 입력하세요!!\n"); 
			}
			
		} while(true);
		
		search_result(tempArr);		
		
	}// end of private void search_ageline(Scanner sc, Gujikja[] guArr)------- 
	
	
	// == 성별 및 연령대검색 메소드 생성하기 == 
	private void search_gender_ageline(Scanner sc, Gujikja[] guArr) {
		
		
	}// end of private void search_gender_ageline(Scanner sc, Gujikja[] guArr)-------
		
	

}

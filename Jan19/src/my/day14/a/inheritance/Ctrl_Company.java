package my.day14.a.inheritance;

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

}

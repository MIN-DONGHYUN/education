package my.day17.a.Interface;

import java.util.Scanner;

public interface Inter_Ctrl_Total {

	// === 메인 메뉴를 보여주는 메소드 생성하기 === //
	void main_menu();
	
	// == Gujikja 객체 및 company 객체를 Member[] mbr_arr 배열에 저장시키기
	void save_mbr_arr(Member mbr, Member[] mbr_arr);
	
	// 구직자(Gujikja) 신규 회원가입시
	//     Gujikja 클래스의 field의 요구사항 모두 맞으면
	//     Member[] mbr_arr 에 저장시켜주는 메소드 저장시키기 ===
	void register_gu(Scanner sc, Member[] mbr_arr);
	
	// 구인회사(Company) 신규 회원가입시
	//     Company 클래스의 field의 요구사항 모두 맞으면
	//     Member[] mbr_arr 에 저장시켜주는 메소드 저장시키기 ===
	void register_cp(Scanner sc, Member[] mbr_arr);
	
	
	// ==구직자 로그인 메소드 저장시키기==
	Gujikja login_gu(Scanner sc, Member[] mbr_arr); 
	
	// == 구직자 전용메뉴 메소드 저장시키기 == 
	void gu_munu(Scanner sc, Gujikja login_gu, Member [] mbr_arr);
	
	//== 구인회사 로그인 해주는 메소드 생성하기 ==
	Company login_cp(Scanner sc, Member [] mbr_arr);
	
	
	// == 구인회사 전용메뉴를 생성해주는 메소드 생성하기 == //
	void cp_munu(Scanner sc, Company login_cp, Member[] mbr_arr) ;
	
	
	
}

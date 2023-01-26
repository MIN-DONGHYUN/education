package my.day17.c.userDefineException;

public class Main {

	public static void main(String[] args) {
		
		Product[] prodArr = new Product[3];	//3개의 배열 사용
		
		prodArr[0] = new Product();
		prodArr[0].setProdName("새우깡");
		prodArr[0].setJango(100);
		
		prodArr[1] = new Product();
		prodArr[1].setProdName("감자깡");
		prodArr[1].setJango(50);
		
		prodArr[2] = new Product();
		prodArr[2].setProdName("양파링");
		prodArr[2].setJango(150);
		
		
		for(Product prod : prodArr) {	//확장for문 
			
			try {
				prod.order(80);		// 주문 개수를 나타낸다.
			} 
			catch (JangolackException e) {		// 주문개수가 잔고량보다 많다면 내가 만들어낸 에러를 낸다.
				
				// e.printStackTrace();		// 기본적인 에러를 출력한다.
				
				/* 결과 
				my.day17.c.userDefineException.JangolackException: >> 잔고량이 주문량보다 적으므로 주문이 불가합니다. <<
				at my.day17.c.userDefineException.Product.order(Product.java:41)
				at my.day17.c.userDefineException.Main.main(Main.java:25)
				*/
				
				System.out.println("오류메시지 : " + e.getMessage() + "\n"); //오류메시지만 출력한다.
			}
			finally {
				prod.info();		// 주문 정보를 출력한다.
			}			
		}// end of for
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		prodArr[0].setJango(100);
		prodArr[1].setJango(50);
		prodArr[2].setJango(150);
		
		for(Product prod : prodArr) {	//확장for문 
			
			try {
				prod.jumun(80);		// 주문 개수를 나타낸다.
			} 
			catch (JangolackException e) {		// 주문개수가 잔고량보다 많다면 내가 만들어낸 에러를 낸다.
				
				// e.printStackTrace();		// 기본적인 에러를 출력한다.
				
				/* 결과 
				my.day17.c.userDefineException.JangolackException: >> 잔고량이 주문량보다 적으므로 주문이 불가합니다. <<
				at my.day17.c.userDefineException.Product.order(Product.java:41)
				at my.day17.c.userDefineException.Main.main(Main.java:25)
				*/
				
				System.out.println("오류메시지 : " + e.getMessage() + "\n"); //오류메시지만 출력한다.
			}
			finally {
				prod.info();		// 주문 정보를 출력한다.
			}	
			
		}// end of for
		
		
		
		
	}

}

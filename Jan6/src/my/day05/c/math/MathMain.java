// 반올림, 올림, 내림, 절대값
package my.day05.c.math;

public class MathMain {

	public static void main(String[] args) {
		
		// ========= Math 클래스에 대해서 알아봅니다. ========== //
		
		// 1. >>> 반올림에 대해서 알아봅니다. <<<
		
		double db1 = 93.45678, db2 = 86.87654;
		
		System.out.println("=== 반올림 하기 전 ===");
		System.out.println("db1 => " + db1 + " ,  db2 => " + db2);
		// db1 => 93.45678 ,  db2 => 86.87654
		
		System.out.println("\n=== 반올림 한 후 ===");
		System.out.println("db1 => " + Math.round(db1) + " ,  db2 => " + Math.round(db2));
		//db1 => 93 ,  db2 => 87
		// 반올림은 Math.round(실수)를 사용하면 된다!!!!! ==> 입력한 싱수의 정수 일의자리까지만 보여주고 나머지 소수부는 반올림하면서 삭제가 된다.
		//                                        ==> 93.45678 소수부 첫번째 자리는 4이므로 반올림이 안된다. 즉, 93이 된다.
		//                                        ==> 86.87654 소수부 첫번째 자리는 8이므로 반올림이 된다. 즉, 87이 된다.
		
		
		// === 특정 소수부 자리에서 반올림을 하고자 한다. ==
		// db1 => 93.45678 ==> (소수부 첫째 자리까지 나타내면서 반올림)하면 93.5가 된다.
		// db2 => 86.87654 ==> (소수부 둘째 자리까지 나타내면서 반올림)하면 86.88가 된다.
		
		System.out.println("\n=== 소수부 첫째 자리까지 나타내면서 반올림 한 후 ===");
		// db1 => 963.45678 ==> 93.45678 * 10 ==> 934.5678 ==> Math.round(934.5678) ==> 935 ==> 935/10.0 ==>  93.5
		
		System.out.println("db1 => " + Math.round(db1*10)/10.0 + " db2 => " + Math.round(db2*10)/10.0); 
		//db1 => 93.45678 ,  db2 => 86.87654
		
		
		System.out.println("\n=== 소수부 둘째 자리까지 나타내면서 반올림 한 후 ===");
		// db2 => 86.87654 ==> 86.87654 * 100 ==> 8687.654 ==> Math.round(8687.654)==> 8687 ==> 8687/100.0 ==> 86.87

		System.out.println("db1 => " + Math.round(db1*100)/100.0 + " db2 => " + Math.round(db2*100)/100.0); 
		//db1 => 93.46 db2 => 86.88
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// 2. >>> 올림에 대해서 알아봅니다. <<<  
		
		//Math.ceil(실수)
		// 54.0 ==> 54.0 ==> 54
		// 54.1 ==> 55.0 ==> 55
		// 54.9 ==> 55.0 ==> 55
		double db3 = 54.0, db4 = 54.1, db5 = 54.9;
		
		System.out.println("\n === 올림 하기 전");
		System.out.println("db3 => " + db3 +", db4 => " + db4 + ", db5 => " + db5);
		//db3 => 54.0, db4 => 54.1, db5 => 54.9
		
		System.out.println("\n === 올림 한 후");
		System.out.println("db3 => " + Math.ceil(db3) +", db4 => " + Math.ceil(db4) + ", db5 => " + Math.ceil(db5));
		//db3 => 54.0, db4 => 55.0, db5 => 55.0
		
		//소수부를 없애버림 
		System.out.println("소수부 제거 ");
		System.out.println("db3 => " + (int)Math.ceil(db3) +", db4 => " + (int)Math.ceil(db4) + ", db5 => " + (int)Math.ceil(db5));
		//db3 => 54, db4 => 55, db5 => 55
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		
		// 3. >>> 내림에 대해서 알아봅니다. <<<
		
		//Math.floor(실수)
		// 54.0 ==> 54.0 ==> 54
		// 54.1 ==> 54.0 ==> 54
		// 54.9 ==> 54.0 ==> 54
		System.out.println("\n === 내림 하기 전");
		System.out.println("db3 => " + db3 +", db4 => " + db4 + ", db5 => " + db5);
		//db3 => 54.0, db4 => 54.1, db5 => 54.9
		
		
		System.out.println("\n === 내림 한 후");
		System.out.println("db3 => " + Math.floor(db3) +", db4 => " + Math.floor(db4) + ", db5 => " + Math.floor(db5));
		//db3 => 54.0, db4 => 54.0, db5 => 54.0
		
		
		//소수부를 없애버림 
		System.out.println("소수부 제거 ");
		System.out.println("db3 => " + (int)Math.floor(db3) +", db4 => " + (int)Math.floor(db4) + ", db5 => " + (int)Math.floor(db5));
		//db3 => 54, db4 => 54, db5 => 54
		
		// 4. >>> 절대값에 대해서 알아봅니다. <<<
		// Math.abs(정수든 실수든 상관 X)
		
		System.out.println("\n === 절대값 ===");
		
		int a=20, b=-30;
		System.out.println("a => " + a + ", b => " + b );
		// a=> 20, b=>-30
		
		// -를 부호 변경 절대값은 모두 양수로 나온다. 
		System.out.println("a => " + Math.abs(a) + ", b => " + Math.abs(b) );
		// a=> 20, b=>30
		
	}

}

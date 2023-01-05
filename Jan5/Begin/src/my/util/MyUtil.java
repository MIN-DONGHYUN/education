package my.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtil {

	// == 현재시각을 출력해주는 static 메소드 생성하기 == //
	public static void currentTime() {  //static을 안쓰면 인스턴스로 사용해야함 
        
		Date now = new Date(); // 현재시간 
		
		SimpleDateFormat sdfmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today = sdfmt.format(now);
		
		System.out.println(">> 현재시각 : " + today );
		// >> 현재시각 : 2023-01-03 11:43:50 으로 바꾸려면
	}
	
}

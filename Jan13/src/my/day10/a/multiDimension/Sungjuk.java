package my.day10.a.multiDimension;

public class Sungjuk {

	String name;
	int kor;
	int eng;
	int math;
	
	public Sungjuk(String name, int kor, int eng, int math) {
		this.name = name;			// this는 여기에 있는 이름을 뜻함 
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String showInfo() {
		
		int sum = kor+eng+math;
		double avg = (Math.round(sum/3.0*10)/10.0); 			//반올림
		return name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+sum+"\t"+ avg;		
	}	
}

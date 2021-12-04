
public class TimeStamp {

	private int hour;
	private int minute;
	private int second;
	
	public TimeStamp(int h, int m, int s){
		hour =h;
		minute = m;
		second = s;
		
	}
	
	public void printTime(){
		System.out.println(hour + ":" + minute + ":" + second);
	}
	
	// Τηρώ τις αναλοίωτες
	public void incrementHour(){
		
		hour++;
		if(hour == 24)
			hour = 0;
	}
	
}

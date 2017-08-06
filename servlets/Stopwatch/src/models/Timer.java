package models;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer {
//	Date 
	String startTime;
	String stopTime;
	
	public String generateTimeNow() {
		Date now = Calendar.getInstance().getTime(); 
		Format formatter = new SimpleDateFormat("HH:mm:ss a");
		String nowString = formatter.format(now);
//		formatter.get
		return nowString;
	}

	
}

package models;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timer {
//	Date 
	String startTime;
	String stopTime;
	
	public Timer() {
		
	}
	
	// start time
	public void setStartTime() {
		this.startTime = generateTimeNow();
	}
	public String getstartTime() {
		return this.startTime;
	}
	
	// stop time
	public void setStopTime() {
		this.stopTime = generateTimeNow();
	}
	public String getStopTime() {
		return this.stopTime;
	}
	
	// generate time NOW in String
	public String generateTimeNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
		Date now = new Date();

		String dateAsString = sdf.format(now); //"23:27:43 PM"
		return dateAsString;
	}
	// parse string time to Date format
	public Date dateFromString(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
		Date dateFromString = null;
		try {
			dateFromString = sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dateFromString;
	}

	
}

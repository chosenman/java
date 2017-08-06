package models;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Timer {
//	Date 
	String startTime;
	String stopTime;
	
	ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
	
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
		
		ArrayList<String> newLine = new ArrayList<String>();
		if(this.startTime != null) {
			newLine.add(this.startTime);
			newLine.add(this.stopTime);
			newLine.add(totalTime());
			
			results.add(newLine);
		}
	}
	public String getStopTime() {
		return this.stopTime;
	}
	//get results table
	public ArrayList<ArrayList<String>> getResults() {
		return results;
	}
	
	// getTotal time stopwatch was run
	public String totalTime() {
		String output = null;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a");
		if(this.startTime != null && this.stopTime !=null) {
			Date starTimeDateFormat = dateFromString(this.startTime);
			Date stopTimeDateFormat = dateFromString(this.stopTime);
			
			long diff = stopTimeDateFormat.getTime() - starTimeDateFormat.getTime();
			long diffSeconds = diff / 1000 % 60;  
			long diffMinutes = diff / (60 * 1000) % 60; 
			long diffHours = diff / (60 * 60 * 1000);  
			
			output = Long.toString(diffHours) + "h " + Long.toString(diffMinutes) + "m " + Long.toString(diffSeconds) + "s";
		}
		return output;
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

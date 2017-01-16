package helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {
	public static String getMonth(int month){
		month=month+1;
		switch(month){
			case 1:
				return "Janvier";
			case 2:
				return "Fevrier";
			case 3:
				return "Mars";
			case 4:
				return "Avril";
			case 5:
				return "Mai";
			case 6:
				return "Juin";
			case 7:
				return "Juillet";
			case 8:
				return "Aout";
			case 9:
				return "Septembre";
			case 10:
				return "Octobre";
			case 11:
				return "Novembre";
			case 12:
				return "Decembre";
			default:
				return null;
		}
	}
	public static int getDay(String date) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d=format.parse(date);
		Calendar cal=new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	public static Calendar getCalendar(String date)throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d=format.parse(date);
		Calendar cal=new GregorianCalendar();
		cal.setTime(d);
		return cal;
	}
	public static boolean isBefore(String test,Date toCompare) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=format.parse(test);
		
		if(d1.compareTo(toCompare)<=0){
			return true;
		}
		return false;
	}
	public static boolean isAfter(String test,Date toCompare) throws ParseException{
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date d1=format.parse(test);
		if(d1.compareTo(toCompare)>=0)return true;
		return false;
	}
	
	
	
	public static Date getDate(String date) throws ParseException{
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    return format.parse(date);
	    
	}
	
}
 
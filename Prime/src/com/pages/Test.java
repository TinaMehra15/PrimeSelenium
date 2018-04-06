package com.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="Tuesday, 03rd April 2018";
		System.out.println(str);
		
		//str=str.replaceAll("(?<=\\d)(st|nd|rd|th)", "");
		str=str.replaceAll("(,|st|nd|rd|th)", "");
		
				System.out.println("new str"+str);
		 SimpleDateFormat format1 = new SimpleDateFormat("EEEE dd MMM yyyy");
		 //SimpleDateFormat formatter = new SimpleDateFormat("EEEE, MMM dd, yyyy HH:mm:ss a");
	       // String dateInString = "Friday, Jun 7, 2013 12:10:56 PM";
	        
		//Date obj = new Date(str);
		try {
			  Date date = format1.parse(str);
	            System.out.println(date);
	            System.out.println(format1.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("___________________");
String str2 ="Tue 3 Apr";
Calendar now = Calendar.getInstance();
str2 =str2+" "+ now.get(Calendar.YEAR);
System.out.println("hi str2"+str2);
SimpleDateFormat format2 = new SimpleDateFormat("EEEE dd MMM yyyy");
Date date1=null;
try {
	   date1 = format2.parse(str2);
      System.out.println(date1);
      System.out.println(format2.format(date1));
} catch (ParseException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//System.out.println((format2.format(date1)).equalsIgnoreCase(anotherString));

	}

}

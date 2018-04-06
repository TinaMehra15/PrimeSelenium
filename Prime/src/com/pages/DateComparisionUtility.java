package com.pages;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateComparisionUtility {
public static Boolean DateCompare(String str, String str2)
{
	str=str.replaceAll("(,|st|nd|rd|th)", "");
	SimpleDateFormat format1 = new SimpleDateFormat("EEEE dd MMM yyyy");
	
	 Date date=null;
	try {
		   date = format1.parse(str);
		} catch (ParseException e) {
		e.printStackTrace();
	}
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
e.printStackTrace();
}

Boolean DateResult = ((format2.format(date1)).equalsIgnoreCase((format1.format(date))));
return(DateResult);
}

}

package com.pages;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtility {

	
public static void write(String str)
{
	 // The name of the file to open.
    String fileName = "/Users/tina.mehra/Documents/order.txt";

    try {
        // Assume default encoding.
        FileWriter fileWriter =
            new FileWriter(fileName);

        // Always wrap FileWriter in BufferedWriter.
        BufferedWriter bufferedWriter =
            new BufferedWriter(fileWriter);

        // Note that write() does not automatically
        // append a newline character.
        bufferedWriter.write(str);
                // Always close files.
        bufferedWriter.close();
    }
    catch(IOException ex) {
        System.out.println(
            "Error writing to file '"
            + fileName + "'");
        // Or we could just do this:
        // ex.printStackTrace();
    }
}	
//public static void main(String arg[]) {
	//FileUtility.write("abcd");
//	FileUtility.read();
//	System.out.println("************");
//	String str ="Test12345, your order 170750-458359 has been reserved";
//	System.out.println(str.length());
//	System.out.println("170750-458359 has been reserved".length());
//	int i=str.length() -31;
//	System.out.println("i is"+i);
//System.out.println(str.substring(i,i+13));
//String ord="order";
//int position =str.indexOf(ord)+ord.length()+1;
//System.out.println(str.indexOf(ord));
//System.out.println(position);
//System.out.println(str.substring(position,position+13));
//String getOrderString ="Test, your order 170750-612368 has been reserved";
//int commaPosition =getOrderString.indexOf(",");
//String lastName =getOrderString.substring(0, commaPosition) ;
//System.out.println(lastName);
//}
public static String read()
{
	// The name of the file to open.
    String fileName = "/Users/tina.mehra/Documents/order.txt";

    // This will reference one line at a time
String line = null;
String returnString=null;
    try {
        // FileReader reads text files in the default encoding.
        FileReader fileReader = 
            new FileReader(fileName);

        // Always wrap FileReader in BufferedReader.
        BufferedReader bufferedReader = 
            new BufferedReader(fileReader);

        while((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
            returnString =line;
        }   

        // Always close files.
        bufferedReader.close();         
    }
    catch(FileNotFoundException ex) {
        System.out.println(
            "Unable to open file '" + 
            fileName + "'");                
    }
    catch(IOException ex) {
        System.out.println(
            "Error reading file '" 
            + fileName + "'");                  
        // Or we could just do this: 
        // ex.printStackTrace();
    }
	//System.out.println(returnString);
	return returnString;
}
}

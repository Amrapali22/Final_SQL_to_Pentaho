package pentahoe;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amrapali
 */
public class Input_Parser {
	
	   public Input_Parser() throws FileNotFoundException {
	        
	    }

String col1 = null;
String col2 = null;
String agg_col = null;
String tablename = null;
String agg_func_name = null;
   
/*public void AddLine() throws IOException {
        
    List<String> list = new ArrayList<String>();
    while((strLine = bufRead.readLine()) != null){
        list.add(strLine);
    }
    String[] stringArr = list.toArray(new String[0]);       
    //System.out.println(stringArr[1]);
    
    for (int i= 0; i < stringArr.length; i++)
    
        System.out.println(stringArr[i]);

    }*/

public String ReadColumn1() throws IOException {
	
	FileReader input = new FileReader("H:\\My Documents\\Amrapali\\Pentahoe Project\\Input_1.txt");;
	BufferedReader bufRead = new BufferedReader(input);
	String strLine = null;
	  
List<String> list = new ArrayList<String>();
    while((strLine = bufRead.readLine()) != null){
        list.add(strLine);
    }
    String[] col1Arr = list.toArray(new String[0]); 
            
    //System.out.println(col1Arr[3]);
    
    String delim = ",";
            
    for(int i =0; i<col1Arr.length; i++) {
            int charPos = col1Arr[i].indexOf(delim);
            
            if(charPos!=-1) {            	      	
            	            	            	
            	col1 = col1Arr[i].split("\\"+delim)[0].toUpperCase().trim();
            	
            	col2 = col1Arr[i].split("\\"+delim)[1].split("[\\(\\)]")[1].toUpperCase().trim(); 
            	
            	agg_col = col1Arr[i].split("\\"+delim)[1].split("\\ as ")[1].toUpperCase().trim();  
            	            	           	
            	agg_func_name = col1Arr[i].split("\\"+delim)[1].split("[\\(\\)]")[0].toUpperCase().trim(); 
            	            	 
            }           
    }    
    return col1;		          
  }

public String ReadColumn2() throws IOException {			
	    return col2;			          
	}

public String ReadAggCol() throws IOException {	  	   
		return agg_col;
	}

public String getAggregateFunction() throws IOException {	  	   
	return agg_func_name;
}

public String getTableName() throws IOException {
			
	  boolean isKeywordPresent = false;
 
		  FileReader input1 = new FileReader("H:\\My Documents\\Amrapali\\Pentahoe Project\\Input_1.txt");
	      BufferedReader reader = new BufferedReader(input1);
	  
	      String fileContent;
	      
	      while ((fileContent = reader.readLine()) != null) {
	         
	           if ( fileContent.equals("from")) {

	        	   isKeywordPresent = true;
	               
	        	   tablename=reader.readLine().toUpperCase().trim();
	        	   
	               }
	           }	                         
	  
	return tablename;
	
}

}


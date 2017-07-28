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
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amrapali
 */
public class MainClass {

    /**
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
    	
    	SQLParse_Impl();
    
    	Input_Parser_Impl();    
    	        
    	DbFldsTempl2_Updates();
    	
    	SortColumns();
    	        
        Group_By_Columns();
        
        Output_File();   
        
        FileMerger_Impl();
                           
    }
    
    private static void SQLParse_Impl() throws IOException{
    	
    	SQL_Parse sq = new SQL_Parse();
    	
    	System.out.println("Class : " + sq.getClass().getName());
		System.out.println("");
    	
    	sq.sqlparse();
    	
    	System.out.println("");
    }
    
	private static void Input_Parser_Impl() throws IOException {
		// TODO Auto-generated method stub
		
		Input_Parser ip = new Input_Parser();
		
		System.out.println("Class : " + ip.getClass().getName() + " elements are as follows :");
		System.out.println("");
                    
		System.out.println("Table Name : " + ip.getTableName().toUpperCase());
		
		System.out.println("First Column Name : " + ip.ReadColumn1());
        System.out.println("Second Column Name : " + ip.ReadColumn2());
        
        System.out.println("Aggegate Function Used : " + ip.getAggregateFunction());
        System.out.println("New Aggregate Column : " + ip.ReadAggCol());
        
        System.out.println("");
		
	}  
    
	private static void DbFldsTempl2_Updates() throws IOException {
		// TODO Auto-generated method stub
						
		DbFldsTempl2 dbfltmp = new DbFldsTempl2();
        
		System.out.println("Class : " + dbfltmp.getClass().getName() + " elements are as follows :");
		System.out.println("");
				
		dbfltmp.DbFldsTempl2_Updates();
                
        System.out.println("");
		
	}  

	private static void SortColumns() throws IOException {
		// TODO Auto-generated method stub
		
		Sort s = new Sort();
		
		System.out.println("Class : " + s.getClass().getName() + " elements are as follows :");
		System.out.println("");
		
        s.SortColumns();
        
        System.out.println("");
		
	}
	
	private static void Group_By_Columns() throws IOException {
		// TODO Auto-generated method stub
		
		Group_By grp  = new Group_By();
		
		System.out.println("Class : " + grp.getClass().getName() + " elements are as follows :");
		System.out.println("");
		
		grp.Group_By_Columns();
		
		System.out.println("");
	}
	
	private static void Output_File() throws IOException {
		// TODO Auto-generated method stub
		
		OutputFile out = new OutputFile();
		
		System.out.println("Class : " + out.getClass().getName() + " elements are as follows :");
		System.out.println("");
		
		out.Output_File();
		
		System.out.println("");
		
	}
	
    private static void FileMerger_Impl() throws Exception {
    	FileMerger fm = new FileMerger();
    	
    	System.out.println("Class : " + fm.getClass().getName());
		System.out.println("");
    	
    	fm.merge();
    	    	
    	fm.removeEncoding();    	
    	    	
	}
        
}

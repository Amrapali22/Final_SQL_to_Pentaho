package pentahoe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*
* @author Amrapali
*/

public class SQL_Parse {
	
	public static void sqlparse() throws IOException { 
		String st = null; 
		String strline = null; 
		
		BufferedReader br = new BufferedReader(new FileReader("H:/My Documents/Amrapali/Pentahoe Project/Input.sql")); 
		
		// Reading multiple lines from the file into a list 
		List<String> list = new ArrayList<String>(); 
		
		while((strline=br.readLine())!=null) { 
			list.add(strline);
		}
		
		// Converting the list to an array 
		String[] newarray = list.toArray(new String[0]); 
		
		for (int i = 0; i<newarray.length; i++){ 
			st += newarray[i].trim();
		}
		
		String fullsql=st.replace("null", ""); 
		
		StringBuffer fsql = new StringBuffer(fullsql); 
		
		//Starting with pattern match to find sql keywords 
		
		String[] myarray={"select","from","group by"}; 
		
		for (int i = 0; i<myarray.length; i++){ 
			Pattern p = Pattern.compile(myarray[i]);
			Matcher m = p.matcher(fsql);
			
			StringBuffer sb = new StringBuffer(); 
		
			//Formatting the sql output based on position of keywords 
			while(m.find()) { 
				m.appendReplacement(sb,"\n"+p+"\n"); 
			}
			m.appendTail(sb);
			fsql=sb;
		}
		
		//Replacing Null and blank characters if any. 
		String str = fsql.toString();
		str = str.replaceAll ("^[ |\t]*\n$", ""); 
		
		System.out.println(str); 
		
		//Writing output to a file. 
		PrintWriter writeText = new PrintWriter("H:/My Documents/Amrapali/Pentahoe Project/TempFile.txt", "UTF-8"); 
		writeText.println(str);
		writeText.close();
		br.close();
		
		//Remove blank lines from the file. 
		Scanner file = new Scanner(new File("H:/My Documents/Amrapali/Pentahoe Project/TempFile.txt")); 
		
		//System.out.println("Writing Input File in .txt...");
		
		PrintWriter writer = new PrintWriter("H:/My Documents/Amrapali/Pentahoe Project/Input_1.txt"); 
		
		while (file.hasNext()) { 
			String line = file.nextLine();
			if (!line.isEmpty()) { 
				writer.write(line);
				writer.write("\n"); 
			}
		}
		
		//Deleting Temp file. 
		File file1 = new File("H:/My Documents/Amrapali/Pentahoe Project/TempFile.txt"); 
		
		file.close();
		
		writer.close();
		
		//System.out.println("Done");
		
		file1.delete();
		}


}

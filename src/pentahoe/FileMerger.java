package pentahoe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*
* @author Amrapali
*/

public class FileMerger {
        
        public void merge() throws Exception {
                
                //Declare all input and output files.
                File file1 = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Input XMLs/Template1.xml");
                File file2 = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Template2_Database_Fields_OutputFile.xml");
                File file3 = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Template3_Sort_OutputFile.xml");
                File file4 = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Template4_Group_By_OutputFile.xml");
                File file5 = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Template5_Output_OutputFile.xml");
                File file6 = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Input XMLs/Template6_End.xml");
                
                File output_mergedxml = new File("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Final_Merged_File.ktr");
                
                
                //Delete output file if already exists.
                        if (output_mergedxml.exists()) {
                        	output_mergedxml.delete(); 
                    }
                    
                List<Path> inputs = Arrays.asList(
                    Paths.get(file1.getAbsolutePath()),
                    Paths.get(file2.getAbsolutePath()),
                    Paths.get(file3.getAbsolutePath()),
                    Paths.get(file4.getAbsolutePath()),
                    Paths.get(file5.getAbsolutePath()),
                    Paths.get(file6.getAbsolutePath())
            );
 
            // Output file
            Path output = Paths.get(output_mergedxml.getAbsolutePath());
 
            // Charset for read and write
            Charset charset = StandardCharsets.UTF_8;
 
            // Join files (lines)
            for (Path path : inputs) {
                List<String> lines = Files.readAllLines(path, charset);
                Files.write(output, lines, charset, StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            }
            
            System.out.println("Merging All Files...");
          
        }
        
        
        public void removeEncoding() throws IOException {
        	// Code to remove all lines with <xml> except first line.
        	BufferedReader br = new BufferedReader(new FileReader("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Final_Merged_File.ktr"));
        	String strline = null;
        	List<String> list = new ArrayList<String>();
        	while((strline=br.readLine())!=null) {
        	list.add(strline);
        	}
        	String[] newarray = list.toArray(new String[0]);
        	for(int i=1;i<newarray.length;i++){
        	if(newarray[i].contains("xml")){
        	newarray[i]="";
        	}
        	}
        	StringBuilder finalStringBuilder= new StringBuilder();
        	for(String s:newarray){
        	if(!s.equals("")){
        	finalStringBuilder.append(s).append(System.getProperty("line.separator"));
        	}
        	}
        	String finalString = finalStringBuilder.toString();
        	//System.out.println(finalString);
        	br.close();
        	PrintWriter writeText = new PrintWriter("H:/My Documents/Amrapali/Pentahoe Project/XMLs/Output XMLs/Final_Merged_File.ktr", "UTF-8"); 
        	writeText.println(finalString);
        	writeText.close();
        	
        	System.out.println("Removing Encoding..");
        	System.out.println("Done");

        }
}


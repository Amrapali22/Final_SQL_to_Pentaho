package pentahoe;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
*
* @author Amrapali
*/

public class OutputFile {
	
	   public OutputFile() throws FileNotFoundException {
	        
	   }
	
	public void Output_File() throws IOException {
		
		   Input_Parser ip = new Input_Parser();
		   		   	
	   try {
			String filepath = "H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Input XMLs\\Template5_Output.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node step = doc.getFirstChild();
					
			System.out.println("Root element :" + step.getNodeName());
			
			NodeList nList = step.getChildNodes();
								
			Node firstchild = doc.getElementsByTagName("field").item(0);
									
			Node secondchild = doc.getElementsByTagName("field").item(1);
						  			 		  
			  System.out.println("firstChild : " + firstchild.getNodeName());
			  
			  System.out.println("secondchild : " + secondchild.getNodeName());
			  		  
			  NodeList firstchildlist = firstchild.getChildNodes();
					  		  		  		  		                                                    
					// loop the childnode field node		
					for (int j = 0; j < firstchildlist.getLength(); j++) {
			
			                   Node firstchildnode = firstchildlist.item(j);
			
					   // get the salary element, and update the value
					   if ("name".equals(firstchildnode.getNodeName())) {
						   firstchildnode.setTextContent(ip.ReadColumn1());
					   } 
					   else if ("type".equals(firstchildnode.getNodeName())) {
						   firstchildnode.setTextContent("String");
	                   }
			                  
			         }   ///WORKING SET           
					
				 NodeList secondchildlist = secondchild.getChildNodes();
                             
						// loop the childnode field node		
						for (int k = 0; k < secondchildlist.getLength(); k++) {
				
				                   Node secondchildnode = secondchildlist.item(k);
				
						   // get the salary element, and update the value
						   if ("name".equals(secondchildnode.getNodeName())) {
							   secondchildnode.setTextContent(ip.ReadAggCol());
						   } 
						   else if ("type".equals(secondchildnode.getNodeName())) {
							   secondchildnode.setTextContent("Integer");
		                   }
				                  
				         }   ///WORKING SET   			  

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Output XMLs\\Template5_Output_OutputFile.xml"));
			transformer.transform(source, result);

			System.out.println("Done");

		   } catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		   } catch (TransformerException tfe) {
			tfe.printStackTrace();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
		   } catch (SAXException sae) {
			sae.printStackTrace();
		   }
		}


}

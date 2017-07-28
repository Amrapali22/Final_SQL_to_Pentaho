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

public class Sort {
	
	   public Sort() throws FileNotFoundException {
	        
	   }
	    	
		   public void SortColumns() throws IOException {
			   
			   Input_Parser ip = new Input_Parser();
			   
		   try {
			String filepath = "H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Input XMLs\\Template3_Sort.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node step = doc.getFirstChild();
					
			System.out.println("Root element :" + step.getNodeName());
			
			NodeList nList = step.getChildNodes();
			
			Node fields = doc.getElementsByTagName("fields").item(0);
			
			Node child = doc.getElementsByTagName("field").item(0);
								 	  		     
			  System.out.println("Fields : " + fields.getNodeName());
			 		  
			  System.out.println("Child : " + child.getNodeName());
			  		  
			  NodeList childlist = child.getChildNodes();
					  		  		  		  		                                                    
					// loop the childnode field node		
					for (int j = 0; j < childlist.getLength(); j++) {
			
			                   Node childnode = childlist.item(j);
			
					   // get the salary element, and update the value
					   if ("name".equals(childnode.getNodeName())) {
						   childnode.setTextContent(ip.ReadColumn1());
					   } 
			                  
			         }   ///WORKING SET           

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Output XMLs\\Template3_Sort_OutputFile.xml"));
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

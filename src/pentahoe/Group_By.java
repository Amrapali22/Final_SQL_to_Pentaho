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

public class Group_By {
	
	   public Group_By() throws FileNotFoundException {
	        
	   }
	
	public void Group_By_Columns() throws IOException {
		
		   Input_Parser ip = new Input_Parser();
		   
		   try {
			String filepath = "H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Input XMLs\\Template4_Group_By.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node step = doc.getFirstChild();
					
			System.out.println("Root element :" + step.getNodeName());
			
			NodeList nList = step.getChildNodes();
								
			Node group = doc.getElementsByTagName("group").item(0);
			
			Node firstchild = doc.getElementsByTagName("field").item(0);
			
			Node fields = doc.getElementsByTagName("fields").item(0);
			
			Node secondchild = doc.getElementsByTagName("field").item(1);
			
			  System.out.println("Fields : " + fields.getNodeName());
			 		  
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
			                  
			         }   ///WORKING SET           
					
				 NodeList secondchildlist = secondchild.getChildNodes();
                              
						// loop the childnode field node		
						for (int k = 0; k < secondchildlist.getLength(); k++) {
				
				                   Node secondchildnode = secondchildlist.item(k);
				
						   // get the salary element, and update the value
						   if ("aggregate".equals(secondchildnode.getNodeName())) {
							   secondchildnode.setTextContent(ip.ReadAggCol());
						   } 
						   else if ("subject".equals(secondchildnode.getNodeName())) {
							   secondchildnode.setTextContent(ip.ReadColumn2());
		                   }
						   else if ("type".equals(secondchildnode.getNodeName())) {
							   secondchildnode.setTextContent(ip.getAggregateFunction());
		                   }
				                  
				         }   ///WORKING SET   			  

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Output XMLs\\Template4_Group_By_OutputFile.xml"));
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

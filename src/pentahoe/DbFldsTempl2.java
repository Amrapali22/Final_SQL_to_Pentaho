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
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.dom.ChildNode;

/**
*
* @author Amrapali
*/

public class DbFldsTempl2 {
	
	public DbFldsTempl2() throws FileNotFoundException {
        
	   }

	public void DbFldsTempl2_Updates() throws IOException {
		
		   Input_Parser ip = new Input_Parser();

	   try {
		String filepath = "H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Input XMLs\\Template2_Database_Fields.xml";
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc = docBuilder.parse(filepath);

		// Get the root element
		Node step = doc.getFirstChild();
				
		System.out.println("Root element :" + step.getNodeName());
		
		NodeList nList = step.getChildNodes();
		
		Node fields = doc.getElementsByTagName("fields").item(0);
		
		Node firstChild = doc.getElementsByTagName("field").item(0);
		
		Node secondChild = doc.getElementsByTagName("field").item(5);
		
				 		
		//System.out.println ("To Update" + nList.getLength());
		
		for (int i = 0; i < nList.getLength(); i++) {

            Node node = nList.item(i);
                                             

	   // get the table_name element, and update the value
	   if ("table_name".equals(node.getNodeName())) {
		   System.out.println("Update field : " + node.getNodeName());
		node.setTextContent(ip.getTableName());
	   }
	   		
	   
	   else if ("fields".equals(node.getNodeName())){	
		 	  		     
		  System.out.println("Fields : " + fields.getNodeName());
		 		  
		  System.out.println("firstChild : " + firstChild.getNodeName());
		  		  
		  NodeList firstchildlist = firstChild.getChildNodes();
				  		  		  		  		                                                    
				// loop the childnode field node		
				for (int j = 0; j < firstchildlist.getLength(); j++) {
		
		                   Node childIInode = firstchildlist.item(j);
		
				   // get the salary element, and update the value
				   if ("name".equals(childIInode.getNodeName())) {
					   childIInode.setTextContent(ip.ReadColumn1());
				   } 
		           else if ("attribut".equals(childIInode.getNodeName())) {
		           		childIInode.setTextContent(ip.ReadColumn1());
		           }
		           else if ("type".equals(childIInode.getNodeName())) {
		           		childIInode.setTextContent("String");
		           }
				}   ///WORKING SET
		  
//		 Node secondChild = childlist.item(1);
		 
		 System.out.println("secondChild : " + secondChild.getNodeName());
		  
		 NodeList secondchildlist = secondChild.getChildNodes();
		 
					 for (int k = 0; k < secondchildlist.getLength(); k++) {
							
			             Node childIIInode = secondchildlist.item(k);
			
				   // get the salary element, and update the value
				   if ("name".equals(childIIInode.getNodeName())) {
					   childIIInode.setTextContent(ip.ReadColumn2());
				   } 
			             else if ("attribut".equals(childIIInode.getNodeName())) {
			            	 childIIInode.setTextContent(ip.ReadColumn2());
			             }
			             else if ("type".equals(childIIInode.getNodeName())) {
			            	 childIIInode.setTextContent("Integer");
			             }
			          }
		
	   
	   }       
		}               

		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("H:\\My Documents\\Amrapali\\Pentahoe Project\\XMLs\\Output XMLs\\Template2_Database_Fields_OutputFile.xml"));
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


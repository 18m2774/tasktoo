package sdp.task2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class XMLReader {
  public static void main(String[] args) {
    try {
      File inputFile = new File("input.xml");
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();
      System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
      NodeList nList = doc.getElementsByTagName("field");
      for (int temp = 0; temp < nList.getLength(); temp++) {
        Node nNode = nList.item(temp);
        System.out.println("\nCurrent Element: " + nNode.getNodeName());
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
          Element eElement = (Element) nNode;
          System.out.println("Field ID: " + eElement.getAttribute("id"));
          System.out.println("Field Value: " + eElement.getElementsByTagName("value").item(0).getTextContent());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


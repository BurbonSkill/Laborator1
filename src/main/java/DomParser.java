
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DomParser {
    public static void main(String[] args) {

        try {
            File inputFile = new File("planete.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
               NodeList nList = doc.getElementsByTagName("planeta");


            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);



                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("film id : "
                            + eElement.getAttribute("idPlaneta"));
                    System.out.println("Name : "
                            + eElement
                            .getElementsByTagName("Nume")
                            .item(0)
                            .getTextContent());
                    System.out.println("Regizor : "
                            + eElement
                            .getElementsByTagName("Stea")
                            .item(0)
                            .getTextContent());
                    System.out.println("Publication : "
                            + eElement
                            .getElementsByTagName("Descoperire")
                            .item(0)
                            .getTextContent());
                    System.out.println("Availability : "
                            + eElement
                            .getElementsByTagName("viata")
                            .item(0)
                            .getTextContent());
                    if(eElement.getElementsByTagName("sateliti").getLength()>0){
                        System.out.println("Casts : "
                                +eElement.getElementsByTagName("satelit")
                                .item(0)
                                .getTextContent());
                    }System.out.println();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

class XMLCreate {
    public static void main(String argv[]) {
        try {
            DocumentBuilderFactory dbFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();


            Element films = doc.createElement("planete");
            doc.appendChild(films);


            Element Category = doc.createElement("solarSystem");
            films.appendChild(Category);


            Attr idCategory = doc.createAttribute("idSystem");
            idCategory.setValue("001");
            Category.setAttributeNode(idCategory);


            Attr Categoryname = doc.createAttribute("systemName");
            Categoryname.setValue("Soare");
            Category.setAttributeNode(Categoryname);


            Element film1 = doc.createElement("planeta");
            Category.appendChild(film1);


            Attr filmid = doc.createAttribute("idPlaneta");
            filmid.setValue("0001");
            film1.setAttributeNode(filmid);


            Element Regizor = doc.createElement("Stea");
            Regizor.appendChild(doc.createTextNode("Soare"));
            film1.appendChild(Regizor);

            Element Name = doc.createElement("Nume");
            Name.appendChild(doc.createTextNode("Pamant"));
            film1.appendChild(Name);


            Element Publication = doc.createElement("Descoperire");
            Publication.appendChild(doc.createTextNode("-"));
            film1.appendChild(Publication);

            Element availability = doc.createElement("viata");
            availability.appendChild(doc.createTextNode("true"));
            film1.appendChild(availability);


            Element Casts = doc.createElement("sateliti");
            film1.appendChild(Casts);

            Element Cast1 = doc.createElement("satelit");
            Cast1.appendChild(doc.createTextNode("Luna"));
            Casts.appendChild(Cast1);


            Element film2 = doc.createElement("planeta");
            Category.appendChild(film2);


            Attr filmid2 = doc.createAttribute("idPlaneta");
            filmid2.setValue("0002");
            film2.setAttributeNode(filmid2);


            Element Regizor2 = doc.createElement("Stea");
            Regizor2.appendChild(doc.createTextNode("Soare"));
            film2.appendChild(Regizor2);


            Element Name2 = doc.createElement("Nume");
            Name2.appendChild(doc.createTextNode("Mercur"));
            film2.appendChild(Name2);


            Element Publication2 = doc.createElement("Descoperire");
            Publication2.appendChild(doc.createTextNode("-1000"));
            film2.appendChild(Publication2);

            Element availability2 = doc.createElement("viata");
            availability2.appendChild(doc.createTextNode("false"));
            film2.appendChild(availability2);


            Element Casts2 = doc.createElement("sateliti");
            film2.appendChild(Casts2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("planete.xml"));
            transformer.transform(source, result);


            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLReader {

    public List<String> readValues(String filePath) throws Exception {

        List<String> values = new ArrayList<>();

        File xmlfile = new File(filePath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        
        Document document = builder.parse(xmlfile);
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("mxCell");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                if (element.hasAttribute("value")) {
                    String value = element.getAttribute("value");

                    if (!value.isEmpty()) {
                        values.add(value);
                    }
                }
            }
        }

        return values;
    }
}

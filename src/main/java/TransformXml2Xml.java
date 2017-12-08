import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class TransformXml2Xml {
    public static void main(String[] args) {
        try {
            File stylesheet = new File(".//src//main//resources//MapSaldorentev3ToSkattemeldingv6.xslt");
            File xmlfile = new File(".///src//test//xmlfiler//saldorente1.xml");
            StreamSource stylesource = new StreamSource(stylesheet);
            StreamSource xmlsource = new StreamSource(xmlfile);
            Transformer transformer = TransformerFactory.newInstance()
                    .newTransformer(stylesource);

            // Transform the document and store it in a file
            transformer.transform(xmlsource, new StreamResult(new File(".///src//test//xmlfiler//skattemelding1.xml")));

            StreamResult consoleOut = new StreamResult(System.out);
            // Transform the document and print the content to console
            transformer.transform(xmlsource, consoleOut);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}

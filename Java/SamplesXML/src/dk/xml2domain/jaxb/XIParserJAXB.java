package xml2domain.jaxb;

import java.io.FileInputStream;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import xml2domain.jaxb.xi.XI;

public class XIParserJAXB {
    public XIParserJAXB() {
    }

    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     */
    public XI parse(String xiURI) throws Exception {

        //Parse
        XI xi = null; //new XI();
        try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance( "xml2domain.jaxb.xi" );

            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();

            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
            //JAXBElement<?> xiElement = (JAXBElement<?>)u.unmarshal( new FileInputStream( xiURI ) );
            xi = (XI)u.unmarshal( new FileInputStream( xiURI ) );
        } catch (Exception e) {
            //System.out.println("Error occurred! Incomplete XI model:");
            //xi.print(System.out, 0);
            throw e;
        }
        return xi;
    }

    /**
     * <p> Static entry point for running the viewer. </p>
     */
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: XIParserCastor <XML Document URI>");
                System.exit(0);
            }

            XIParserJAXB parser = new XIParserJAXB();
            //parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

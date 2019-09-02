package dk.xml2domain.castor;

import java.io.FileReader;

import org.exolab.castor.xml.Unmarshaller;

import dk.xml2domain.castor.xi.XI;


public class XIParserCastor {
    public XIParserCastor() {
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     */
    public XI parse(String xiURI) throws Exception {
        FileReader r = new FileReader(xiURI);
        
        //Parse
        XI xi = null; //new XI();
        try {
            Unmarshaller u = new Unmarshaller(XI.class);
            u.setIgnoreExtraElements(true);
            xi = (XI) u.unmarshal(r);
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
            
            XIParserCastor parser = new XIParserCastor();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

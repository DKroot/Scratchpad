package dk.xml2domain.digester;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.ExtendedBaseRules;
import org.apache.commons.digester.NodeCreateRule;
import org.apache.commons.digester.xmlrules.FromXmlRuleSet;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import dk.xml2domain.xi.XI;


public class XIParserDigester {
    private Digester d;
    
    public XIParserDigester(String digesterRuleFile) 
            throws ParserConfigurationException, SAXException {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.setNamespaceAware(true);
        //Assuming JDK 5.0 default parser factory (Xerces) 
        //The combination of the following 2 Xerces features will turn on XML Schema validation
        //only if schema is specified in the document
        saxFactory.setFeature("http://apache.org/xml/features/validation/dynamic", true);
        saxFactory.setFeature("http://apache.org/xml/features/validation/schema", true);
        
        d = new Digester(saxFactory.newSAXParser());
        
        d.setNamespaceAware(true);
        d.setRules(new ExtendedBaseRules());
        
        //This rule cannot be added from XML rules via the existing DTD
        d.addRule("XI/domain/artifacts/document/attribute/?", 
                new NodeCreateRule());
        
        //Get the rest of rules from XML rules
        d.addRuleSet(new FromXmlRuleSet(new InputSource(digesterRuleFile)));
        
        
/*      d.addObjectCreate("XI", XI.class);
        d.addSetProperties("XI");

//        d.addFactoryCreate("XI/domain", new AbstractObjectCreationFactory() {
//            public Object createObject(Attributes attributes) throws Exception {
//                return new XIDomain(null, attributes.getValue("name"), 
//                        attributes.getValue("version"));
//            }
//        });
      
        d.addObjectCreate("XI/domain", XIDomain.class);
        d.addSetTop("XI/domain", "setOwner");        
        d.addSetProperties("XI/domain");
        d.addSetNext("XI/domain", "add");
*/        
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     * @throws SAXException 
     * @throws IOException 
     * @throws IOException 
     */
    public XI parse(String xiURI) throws IOException, SAXException {
        // Process the input file.
        return (XI) d.parse(xiURI);
    }

    /**
     * <p> Static entry point for running the viewer. </p>
     * @throws SAXException 
     * @throws IOException 
     * @throws ParserConfigurationException 
     * @throws SAXException 
     * @throws IOException 
     * @throws ParserConfigurationException 
     */
    public static void main(String[] args) 
            throws IOException, SAXException, ParserConfigurationException {
        if (args.length < 2) {
            System.out.println("Usage: XIParserDigester <XML Document> <Digester Rule File>");
            System.exit(0);
        }
        
        XIParserDigester parser = new XIParserDigester(args[1]);
        parser.parse(args[0]).print(System.out, 0);
    }
}


package dk.xml2domain.xstream;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


import com.thoughtworks.xstream.XStream;

import dk.xml2domain.sax.XIParserSAX;
import dk.xml2domain.xi.*;


public class XIParserXStream {
    private XStream xstream = new XStream();
    
    public XIParserXStream() {
        xstream.alias("fp:XI", XI.class);
        xstream.addImplicitCollection(XI.class, "domains", XIDomain.class);
        
        xstream.alias("fp:domain", XIDomain.class);
        xstream.addImplicitCollection(XIDomain.class, "headers", XIHeader.class);
        xstream.aliasField("fp:artifacts", XIDomain.class, "types");
        xstream.aliasField("fp:processes", XIDomain.class, "processes");
        
        xstream.alias("fp:header", XIHeader.class);
        xstream.addImplicitCollection(XIHeader.class, "aliases", XIAlias.class);
        
        xstream.alias("fp:alias", XIAlias.class);
        xstream.alias("fp:event", XIEvent.class);
        
        xstream.alias("fp:document", XIDocument.class);
        xstream.addImplicitCollection(XIDocument.class, "attributes", XIAttribute.class);
        xstream.addImplicitCollection(XIDocument.class, "fields", XIField.class);
        xstream.addImplicitCollection(XIDocument.class, "functions", XIFunction.class);
        
        xstream.alias("fp:attribute", XIAttribute.class);
        
        xstream.alias("fp:field", XIField.class);
        xstream.addImplicitCollection(XIField.class, "fields", XIField.class);
        
        xstream.alias("fp:function", XIFunction.class);
        
        xstream.alias("fp:script", XIBlock.class);
        xstream.addImplicitCollection(XIBlock.class, "statements", XIStatement.class);
        
        xstream.alias("fp:set", XIStmSet.class);
        
        xstream.alias("fp:switch", XIStmSwitch.class);
        xstream.addImplicitCollection(XIStmSwitch.class, "branches", XIStmBranch.class);
        
        xstream.alias("fp:branch", XIStmBranch.class);
        xstream.alias("fp:failure", XIStmFailure.class);
        xstream.alias("fp:invoke", XIStmInvoke.class);
        
        xstream.alias("fp:parameters", LinkedList.class);
        xstream.omitField(XIStmInvoke.class, "fp:parameters");
        xstream.alias("fp:param", String.class);
        xstream.omitField(LinkedList.class, "fp:param");

        xstream.alias("fp:variant", String.class);
        //TODO Omission of variants/members does not work
        xstream.omitField(LinkedList.class, "fp:variant");
        xstream.omitField(XIDomain.class, "fp:variant");
        
        xstream.alias("fp:role", XIRole.class);
        xstream.addImplicitCollection(XIRole.class, "functions", XIFunction.class);
        
        xstream.alias("fp:exit", String.class);
        xstream.omitField(XIBlock.class, "fp:exit");
        
        xstream.alias("fp:produce", XIStmProduce.class);
        
        xstream.alias("fp:process", XIProcess.class);
        xstream.addImplicitCollection(XIProcess.class, "functions", XIFunction.class);
        xstream.addImplicitCollection(XIProcess.class, "tasks", XITask.class);
        
        xstream.alias("fp:task", XITask.class);
        xstream.alias("fp:allocate", XIStmAllocate.class);
        xstream.alias("fp:wait", XIStmWait.class);
        xstream.alias("fp:onevent", XIStmOnEvent.class);
        xstream.alias("fp:many", XIStmMany.class);
        xstream.alias("fp:start", XIStmStart.class);
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     * @throws IOException 
     */
    public XI parse(String xiURI) throws IOException {
        FileReader r = new FileReader(xiURI);
        
        //Parse
        XI xi = null;
        try {
            xi = (XI) xstream.fromXML(r);
        } finally {
            r.close();
        }
            
        return xi;
    }

    /**
     * <p> Static entry point for running the viewer. </p>
     * @throws ParserConfigurationException 
     * @throws SAXException 
     * @throws IOException 
     */
    public static void main(String[] args) 
            throws IOException, SAXException, ParserConfigurationException {
        if (args.length < 1) {
            System.out.println("Usage: XIParserDOM <XML Document URI>");
            System.exit(0);
        }
        
        XIParserXStream parser = new XIParserXStream();
        
        try {
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nSerializing model to XML:\n");
        XIParserSAX saxParser = new XIParserSAX();
        XI xi = saxParser.parse(args[0]);
        parser.xstream.toXML(xi, System.out);
    }
/*    
    class XSXI extends XI {
        private LinkedList artifacts;
    }
*/
}


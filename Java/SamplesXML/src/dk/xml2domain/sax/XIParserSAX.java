package dk.xml2domain.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import dk.xml2domain.xi.*;
import dk.xml2domain.xml.XIElement;


public class XIParserSAX extends DefaultHandler {
    private XI xi;
    private XIObject current;
    
    public XIParserSAX() {
    }
    
    public static String[] attributesToArray(Attributes atts) {
        String[] result = new String[atts.getLength()];
        for (int i = 0; i < atts.getLength(); i++) {
            result[i] = atts.getQName(i) + "=\"" + atts.getValue(i) + "\"";
        }
        return result;
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     * @throws ParserConfigurationException 
     * @throws <code>IOException</code> - when reading the XML URI fails.
     * @throws <code>SAXException</code> - when errors in parsing occur.
     */
    public XI parse(String xiURI)
            throws IOException, SAXException, ParserConfigurationException {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.setNamespaceAware(true);
        
/*      // Pre-compile a known schema
        SchemaFactory factory =
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new File("XI.xsd"));
*/      
        /* Validation as a separate step:
        Validator validator = schema.newValidator();
        validator.setErrorHandler(this);
        validator.validate(new SAXSource(new InputSource(xiURI)));
        */
        //Validate while parsing against the fixed pre-compiled schema
        //spf.setSchema(schema);

        //Assuming JDK 5.0 default parser factory (Xerces) 
        //The combination of the following 2 Xerces features will turn on XML Schema validation
        //only if schema is specified in the document
        saxFactory.setFeature("http://apache.org/xml/features/validation/dynamic", true);
        saxFactory.setFeature("http://apache.org/xml/features/validation/schema", true);
        
        // Parse
        try {
            saxFactory.newSAXParser().parse(xiURI, this);
            return getXI();
        } catch (RuntimeException e) {
            System.out.println("Error occurred! Incomplete XI model:");
            getXI().print(System.out, 0);
            throw e;
        }    
    }

    /**
     * <p> Static entry point for running the viewer. </p>
     */
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: XIParserSAX <XML Document URI>");
                System.exit(0);
            }
            
            XIParserSAX parser = new XIParserSAX();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public XI getXI() {
        return xi;
    }
    
    /**
     * <p>
     *  This indicates the start of a Document parse-this precedes
     *    all callbacks in all SAX Handlers with the sole exception
     *    of <code>{@link #setDocumentLocator}</code>.
     * </p>
     *
     * @throws <code>SAXException</code> when things go wrong
     */
    @Override
    public void startDocument() throws SAXException {
        xi = new XI();
    }

    /**
     * <p>
     *   This reports the occurrence of an actual element. It includes
     *     the element's attributes, with the exception of XML vocabulary
     *     specific attributes, such as
     *     <code>xmlns:[namespace prefix]</code> and
     *     <code>xsi:schemaLocation</code>.
     * </p>
     *
     * @param ns <code>String</code> namespace URI this element
     *               is associated with, or an empty <code>String</code>
     * @param localName <code>String</code> name of element (with no
     *               namespace prefix, if one is present)
     * @param qName <code>String</code> XML 1.0 version of element name:
     *                [namespace prefix]:[localName]
     * @param atts <code>Attributes</code> list for this element
     * @throws <code>SAXException</code> when things go wrong
     */
    @Override
    public void startElement(String ns, String localName,
                             String qName, Attributes atts)
        throws SAXException {

        if ( ns.equals(XIElement.XI_NS_URI) ) { 
            //Process only XI elements, assuming the namespace is defined
            
            XIElement element = null;
            try {
                element = XIElement.valueOf("_" + localName);
            } catch (IllegalArgumentException e) {
                System.out.println("Warning: found an unknown XI element under " + 
                        current + " : " + localName);
                return;
            }
            switch (element) {
            case _XI:
                xi.setVersion(atts.getValue("version"));
                current = xi;
                break;
            case _domain:
                current = new XIDomain(xi, atts.getValue("name"), atts.getValue("version"));
                xi.add((XIDomain) current);
                break;
            case _header:
                XIHeader header = new XIHeader(current);
                ((XIDomain) current).add(header);
                current = header;
                break;   
            case _alias:
                XIAlias alias = new XIAlias(current, atts.getValue("id"), atts.getValue("name"));
                ((XIHeader) current).add(alias);
                current = alias;
                break;
            case _event:
                XIEvent event = new XIEvent(current, atts.getValue("id"), 
                        atts.getValue("name"), atts.getValue("parent"));
                ((XIDomain) current).add(event);
                current = event;
                break;
            case _document:
                XIDocument doc = new XIDocument(current, atts.getValue("id"), 
                        atts.getValue("name"), atts.getValue("parent"));
                ((XIDomain) current).add(doc);
                current = doc;
                break; 
            case _attribute:
                XIAttribute attribute = new XIAttribute(current, atts.getValue("name"));
                ((XIDocument) current).add(attribute);
                current = attribute;
                break;
            case _field:
                XIField field = new XIField(current, atts.getValue("name"), 
                        atts.getValue("type"), atts.getValue("domain"));
                if (current instanceof XIDocument) {
                    ((XIDocument) current).add(field);
                } else if (current instanceof XIProcess) {
                    ((XIProcess) current).add(field);
                } else if (current instanceof XIField) {
                    ((XIField) current).add(field);
                }
                current = field;
                break;
            case _function:
                XIFunction function = new XIFunction(current, atts.getValue("name"));
                if (current instanceof XIDocument) {
                    ((XIDocument) current).add(function);
                } else if (current instanceof XIRole) {
                    ((XIRole) current).add(function);
                }
                current = function;
                break;
            case _role:
                XIRole role = new XIRole(current, atts.getValue("id"), 
                        atts.getValue("name"), atts.getValue("parent"));
                ((XIDomain) current).add(role);
                current = role;
                break;
            case _script:
                XIBlock block = new XIBlock(current, atts.getValue("type"));
                ((XIBlock) current).add(block);
                current = block;
                break;
            case _switch:
                XIStmSwitch stmSwitch = new XIStmSwitch(current, atts.getValue("name"));
                ((XIBlock) current).add(stmSwitch);
                current = stmSwitch;
                break;
            case _branch:
                XIStmBranch stmBranch = new XIStmBranch(current);
                ((XIStmSwitch) current).add(stmBranch);
                current = stmBranch;
                break;
            case _set:
                XIStmSet stmSet = new XIStmSet(current, atts.getValue("name"), 
                        atts.getValue("value"));
                ((XIBlock) current).add(stmSet);
                current = stmSet;
                break;
            case _failure:
                XIStmFailure stmFailure = new XIStmFailure(current, atts.getValue("name"));
                ((XIBlock) current).add(stmFailure);
                current = stmFailure;
                break;
            case _invoke:
                XIStmInvoke stmInvoke = new XIStmInvoke(current, atts.getValue("name"),
                        atts.getValue("obj"));
                ((XIBlock) current).add(stmInvoke);
                current = stmInvoke;
                break;
            case _process:
                XIProcess process = new XIProcess(current, atts.getValue("id"), 
                        atts.getValue("name"));
                ((XIDomain) current).add(process);
                current = process;
                break;
            case _task:
                XITask task = new XITask(current, atts.getValue("name"));
                ((XIProcess) current).add(task);
                current = task;
                break;
            case _wait:
                XIStmWait wait = new XIStmWait(current, atts.getValue("name"));
                ((XIBlock) current).add(wait);
                current = wait;
                break;
            case _onevent:
                XIStmOnEvent onEvent = new XIStmOnEvent(current, atts.getValue("name"));
                ((XIBlock) current).add(onEvent);
                current = onEvent;
                break;
            case _many:
                XIStmMany many = new XIStmMany(current);
                ((XIBlock) current).add(many);
                current = many;
                break;    
            default: //ignore the rest : _artifacts, _parameters, _processes
                ;
            }
        } else { //non-XI content
            if (current instanceof XIAttribute) {
                ((XIAttribute) current).startElement(qName, XIParserSAX.attributesToArray(atts));
            }
        }
    }

    /**
     * <p>
     *   Indicates the end of an element
     *     (<code>&lt;/[element name]&gt;</code>) is reached. Note that
     *     the parser does not distinguish between empty
     *     elements and non-empty elements, so this occurs uniformly.
     * </p>
     *
     * @param namespaceURI <code>String</code> URI of namespace this
     *                element is associated with
     * @param localName <code>String</code> name of element without prefix
     * @param qName <code>String</code> name of element in XML 1.0 form
     * @throws <code>SAXException</code> when things go wrong
     */
    @Override
    public void endElement(String ns, String localName,
                           String qName)
        throws SAXException {
        if ( ns.equals(XIElement.XI_NS_URI) ) { 
            //Process only XI elements, assuming the namespace is defined
            
            XIElement element = null;
            try {
                element = XIElement.valueOf("_" + localName);
            } catch (IllegalArgumentException e) {
                //ignore end of an unknown element: alreary warned in startElement() 
                return;
            }
            
            switch (element) {
            case _domain: 
                case _header: 
                case _alias: case _event: case _document: case _role: case _process:
                case _attribute: case _field: case _function: case _task:
                case _script: case _switch: case _branch: case _wait:
                case _set: case _failure: case _invoke: case _onevent: case _many:
                current = current.getOwner();
                break;
            default: //ignore the rest
                ;
            }
        } else { //non-XI content
            if (current instanceof XIAttribute) {
                ((XIAttribute) current).endElement(qName);
            }
        }        
    }

    /**
     * <p>
     *   This reports character data (within an element).
     * </p>
     *
     * @param ch <code>char[]</code> character array with character data
     * @param start <code>int</code> index in array where data starts.
     * @param length <code>int</code> index in array where data ends.
     * @throws <code>SAXException</code> when things go wrong
     */
    @Override
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (current instanceof XIAttribute) {
            String s = new String(ch, start, length);
            ((XIAttribute) current).add(s);
        }
    }

    /**
     * <p>
     * This will report a warning that has occurred; this indicates
     *   that while no XML rules were "broken", something appears
     *   to be incorrect or missing.
     * </p>
     *
     * @param exception <code>SAXParseException</code> that occurred.
     * @throws <code>SAXException</code> when things go wrong 
     */
    @Override
    public void warning(SAXParseException exception)
        throws SAXException {
            
        System.out.println("**Parsing Warning**\n" +
                           "  Line:    " + 
                              exception.getLineNumber() + "\n" +
                           "  URI:     " + 
                              exception.getSystemId() + "\n" +
                           "  Message: " + 
                              exception.getMessage());        
        throw new SAXException("Warning encountered");
    }

    /**
     * <p>
     * This will report an error that has occurred; this indicates
     *   that a rule was broken, typically in validation, but that
     *   parsing can reasonably continue.
     * </p>
     *
     * @param exception <code>SAXParseException</code> that occurred.
     * @throws <code>SAXException</code> when things go wrong 
     */
    @Override
    public void error(SAXParseException exception)
        throws SAXException {
        
        System.out.println("**Parsing Error**\n" +
                           "  Line:    " + 
                              exception.getLineNumber() + "\n" +
                           "  URI:     " + 
                              exception.getSystemId() + "\n" +
                           "  Message: " + 
                              exception.getMessage());
        throw new SAXException("Error encountered");
    }

    /**
     * <p>
     * This will report a fatal error that has occurred; this indicates
     *   that a rule has been broken that makes continued parsing either
     *   impossible or an almost certain waste of time.
     * </p>
     *
     * @param exception <code>SAXParseException</code> that occurred.
     * @throws <code>SAXException</code> when things go wrong 
     */
    @Override
    public void fatalError(SAXParseException exception)
        throws SAXException {
    
        System.out.println("**Parsing Fatal Error**\n" +
                           "  Line:    " + 
                              exception.getLineNumber() + "\n" +
                           "  URI:     " + 
                              exception.getSystemId() + "\n" +
                           "  Message: " + 
                              exception.getMessage());        
        throw new SAXException("Fatal Error encountered");
    }
}

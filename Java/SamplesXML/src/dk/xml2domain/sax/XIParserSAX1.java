package dk.xml2domain.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import dk.xml2domain.xi.*;
import dk.xml2domain.xml.XIElement;


public class XIParserSAX1 {

    public XIParserSAX1() {
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
     * @throws <code>IOException</code> - when reading the XML URI fails.
     * @throws <code>SAXException</code> - when errors in parsing occur.
     */
    public XI parse(String xiURI) 
        throws IOException, SAXException {
        InputSource inputSource = new InputSource(xiURI);

        // Validate
        SchemaFactory factory =
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            //SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
        Schema schema = factory.newSchema(new File("XI.xsd"));
        Validator validator = schema.newValidator();
        validator.validate(new SAXSource(inputSource));
        
        XMLReader reader = XMLReaderFactory.createXMLReader();

        // Register content handler
        XIContentHandler contentHandler = new XIContentHandler();
        reader.setContentHandler(contentHandler);
        
        // Register error handler
        reader.setErrorHandler(new XIErrorHandler());
        
        // Parse
        try {
            reader.parse(inputSource);
            return contentHandler.getXI();
        } catch (RuntimeException e) {
            System.out.println("Error occurred! Incomplete XI model:");
            contentHandler.getXI().print(System.out, 0);
            throw e;
        }    
    }

    /**
     * <p> Static entry point for running the viewer. </p>
     */
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: XIParserSAX [XML Document URI]");
                System.exit(0);
            }
            
            XIParserSAX1 parser = new XIParserSAX1();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * <b><code>XIContentHandler</code></b> implements the SAX
 *   <code>ContentHandler</code> interface and defines callback
 *   behavior for the SAX callbacks associated with an XML
 *   document's content, bulding up JTree nodes.
 */
class XIContentHandler implements ContentHandler {
    private XI xi;
    private XIObject current;
    
    /** Store URI to prefix mappings */
    //private Map namespaceMappings;

    //private XMLReader reader;

    public XIContentHandler() {
        //this.reader = reader;
        //this.namespaceMappings = new HashMap();
    }

    public XI getXI() {
        return xi;
    }
    
    /**
     * <p>
     *  Provide reference to <code>Locator</code> which provides
     *    information about where in a document callbacks occur.
     * </p>
     *
     * @param locator <code>Locator</code> object tied to callback
     *        process
     */
    public void setDocumentLocator(Locator locator) {
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
    public void startDocument() throws SAXException {
        xi = new XI();
    }

    /**
     * <p>
     *  This indicates the end of a Document parse-this occurs after
     *    all callbacks in all SAX Handlers.</code>.
     * </p>
     *
     * @throws <code>SAXException</code> when things go wrong
     */
    public void endDocument() throws SAXException {
    }

    /**
     * <p>
     *   This indicates that a processing instruction (other than
     *     the XML declaration) has been encountered.
     * </p>
     *
     * @param target <code>String</code> target of PI
     * @param data <code>String</code containing all data sent to the PI.
     *               This typically looks like one or more attribute value
     *               pairs.
     * @throws <code>SAXException</code> when things go wrong
     */
    public void processingInstruction(String target, String data)
        throws SAXException {
    }

    /**
     * <p>
     *   This indicates the beginning of an XML Namespace prefix
     *     mapping. Although this typically occurs within the root element
     *     of an XML document, it can occur at any point within the
     *     document. Note that a prefix mapping on an element triggers
     *     this callback <i>before</i> the callback for the actual element
     *     itself (<code>{@link #startElement}</code>) occurs.
     * </p>
     *
     * @param prefix <code>String</code> prefix used for the namespace
     *                being reported
     * @param uri <code>String</code> URI for the namespace
     *               being reported
     * @throws <code>SAXException</code> when things go wrong
     */
    public void startPrefixMapping(String prefix, String uri) {
        // No visual events occur here.
        //namespaceMappings.put(uri, prefix);
    }

    /**
     * <p>
     *   This indicates the end of a prefix mapping, when the namespace
     *     reported in a <code>{@link #startPrefixMapping}</code> callback
     *     is no longer available.
     * </p>
     *
     * @param prefix <code>String</code> of namespace being reported
     * @throws <code>SAXException</code> when things go wrong
     */
    public void endPrefixMapping(String prefix) {
        /*
        for (Iterator i = namespaceMappings.keySet().iterator(); 
             i.hasNext(); ) {

            String uri = (String)i.next();
            String thisPrefix = (String)namespaceMappings.get(prefix);
            if (prefix.equals(thisPrefix)) {
                namespaceMappings.remove(uri);
                break;
            }
        }
        */
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
    public void startElement(String ns, String localName,
                             String qName, Attributes atts)
        throws SAXException {

        if ( ns.equals(XIElement.XI_NS_URI) ) { 
            //Process only XI elements, assuming the namespace is defined
            
            XIElement element = null;
            try {
                element = XIElement.valueOf("_" + localName);
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown XI element: " + e.getMessage());
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
                ((XIAttribute) current).startElement(qName, XIParserSAX1.attributesToArray(atts));
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
    public void endElement(String ns, String localName,
                           String qName)
        throws SAXException {
        if ( ns.equals(XIElement.XI_NS_URI) ) { 
            //Process only XI elements, assuming the namespace is defined
            
            XIElement element = null;
            try {
                element = XIElement.valueOf("_" + localName);
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown XI element: " + e.getMessage());
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
    public void characters(char[] ch, int start, int length)
        throws SAXException {
        if (current instanceof XIAttribute) {
            String s = new String(ch, start, length);
            ((XIAttribute) current).add(s);
        }
    }

    /**
     * <p>
     * This reports whitespace that can be ignored in the
     * originating document. This is typically invoked only when
     * validation is ocurring in the parsing process.
     * </p>
     *
     * @param ch <code>char[]</code> character array with character data
     * @param start <code>int</code> index in array where data starts.
     * @param end <code>int</code> index in array where data ends.
     * @throws <code>SAXException</code> when things go wrong
     */
    public void ignorableWhitespace(char[] ch, int start, int length)
        throws SAXException {
    }

    /**
     * <p>
     *   This reports an entity that is skipped by the parser. This
     *     should only occur for non-validating parsers, and then is still
     *     implementation-dependent behavior.
     * </p>
     *
     * @param name <code>String</code> name of entity being skipped
     * @throws <code>SAXException</code> when things go wrong
     */
    public void skippedEntity(String name) throws SAXException {
    }
}

/**
 * <b><code>XIErrorHandler</code></b> implements the SAX
 *   <code>ErrorHandler</code> interface and defines callback
 *   behavior for the SAX callbacks associated with an XML
 *   document's warnings and errors.
 */
class XIErrorHandler implements ErrorHandler {

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

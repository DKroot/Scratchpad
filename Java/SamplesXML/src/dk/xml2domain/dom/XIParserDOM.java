package dk.xml2domain.dom;

import java.io.StringWriter;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import dk.xml2domain.xi.*;
import dk.xml2domain.xml.DOMWriter;
import dk.xml2domain.xml.XIElement;



public class XIParserDOM implements ErrorHandler {

    public XIParserDOM() {
    }
    
    public static Element getChildElem(Element parent, String childTagName) {
        return (Element) parent.getElementsByTagNameNS(XIElement.XI_NS_URI, childTagName).item(0); 
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     */
    public XI parse(String xiURI) throws Exception {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        domFactory.setNamespaceAware(true);

        //Validate while parsing against the fixed pre-compiled schema
        //spf.setSchema(schema);

        //The combination of the following 2 settings will turn on XML Schema validation
        domFactory.setValidating(true);
        domFactory.setAttribute( "http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
                XMLConstants.W3C_XML_SCHEMA_NS_URI);
        //Xerces is required on CLASSPATH for the following (not supported by default in JDK 5.0) 
        //Turns on validation only if schema is specified in the document
        //domFactory.setFeature("http://apache.org/xml/features/validation/dynamic", true);
        
        DocumentBuilder builder = domFactory.newDocumentBuilder();
        //Abort processing on schema validation errors
        //if not set, schema errors will be simply printed to stderr
        builder.setErrorHandler(this); 
        
        //Parse
        XI xi = new XI();
        try {
            Document doc = builder.parse(xiURI);
            //validator.validate(new DOMSource(doc));
            
            Element xiEl = doc.getDocumentElement();
            xi.setVersion(getXIAttr(xiEl, "version"));
            for (Element domainEl : new ChildrenElements(xiEl, "domain", XIElement.XI_NS_URI)) {
                XIDomain domain = new XIDomain(xi, getXIAttr(domainEl, "name"), 
                        getXIAttr(domainEl, "version"));
                xi.add(domain);
                
                Element headerEl = getChildElem(domainEl, "header");
                XIHeader header = new XIHeader(domain);
                domain.add(header);
                for (Element aliasEl : 
                    new ChildrenElements(headerEl, "alias", XIElement.XI_NS_URI)) {
                    XIAlias alias = new XIAlias(header, getXIAttr(aliasEl, "id"), 
                            getXIAttr(aliasEl, "name"));
                    header.add(alias);
                }
                
                Element artifactsEl = getChildElem(domainEl, "artifacts");
                for (Element eventEl : 
                    new ChildrenElements(artifactsEl, "event", XIElement.XI_NS_URI)) {
                    XIEvent event = new XIEvent(domain, getXIAttr(eventEl, "id"), 
                            getXIAttr(eventEl, "name"), getXIAttr(eventEl, "parent"));
                    domain.add(event);                    
                }
                for (Element docEl : 
                    new ChildrenElements(artifactsEl, "document", XIElement.XI_NS_URI)) {
                    XIDocument document = new XIDocument(domain, getXIAttr(docEl, "id"), 
                            getXIAttr(docEl, "name"), getXIAttr(docEl, "parent"));
                    domain.add(document);
                    
                    for (Element attrEl : 
                        new ChildrenElements(docEl, "attribute", XIElement.XI_NS_URI)) {
                        XIAttribute attribute = new XIAttribute(document, 
                                getXIAttr(attrEl, "name"));
                        document.add(attribute);

                        //Add all inner content of this attribute
                        StringWriter sw = new StringWriter();
                        DOMWriter w = new DOMWriter(0, "");
                        w.write(attrEl, sw, "", false, true);
                        attribute.add(sw.toString());
                    }
                    
                    addFields(document, docEl);
                    addFunctions(document, docEl);
                }
                
                for (Element roleEl : 
                    new ChildrenElements(artifactsEl, "role", XIElement.XI_NS_URI)) {
                    XIRole role = new XIRole(domain, getXIAttr(roleEl, "id"), 
                            getXIAttr(roleEl, "name"), getXIAttr(roleEl, "parent"));
                    domain.add(role);
                    
                    addFunctions(role, roleEl);
                }
                
                Element processesEl = getChildElem(domainEl, "processes");
                for (Element procEl : 
                    new ChildrenElements(processesEl, "process", XIElement.XI_NS_URI)) {
                    XIProcess process = new XIProcess(domain, getXIAttr(procEl, "id"), 
                            getXIAttr(procEl, "name"));
                    domain.add(process);
                    
                    addFields(process, procEl);
                    
                    for (Element taskEl : 
                        new ChildrenElements(procEl, "task", XIElement.XI_NS_URI)) {
                        XITask task = new XITask(process, getXIAttr(taskEl, "name"));
                        process.add(task);
                        
                        Element scriptEl = getChildElem(taskEl, "script");
                        addBlock(task, scriptEl, 
                                new XIBlock(task, getXIAttr(scriptEl, "type")));
                    }     
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred! Incomplete XI model:");
            xi.print(System.out, 0);
            throw e;
        }
        return xi;
    }

    /**
     * @param element
     * @param name attribute name
     * @return null if empty
     */
    private String getXIAttr(Element element, String name) {
        String result = element.getAttribute(name);
        return ( result.length() == 0 ? null : result );
    }

    /**
     * Recursively add fields of the current element
     * @param parent Parent object
     * @param parentEl Parent Element
     */
    private void addFields(XIObject parent, Element parentEl) {
        for (Element fieldEl : 
            new ChildrenElements(parentEl, "field", XIElement.XI_NS_URI)) {
            XIField field = new XIField(parent, getXIAttr(fieldEl, "name"),
                    getXIAttr(fieldEl, "type"), getXIAttr(fieldEl, "domain"));
            if (parent instanceof XIDocument) {
                ((XIDocument) parent).add(field);
            } else if (parent instanceof XIProcess) {
                ((XIProcess) parent).add(field);
            } else if (parent instanceof XIField) {
                ((XIField) parent).add(field);
            }
            
            addFields(field, fieldEl);
        }
    }
    
    /**
     * Add script
     * @param parent
     * @param parentEl Parent Element
     */
    private void addFunctions(XIObject parent, Element parentEl) {
        for (Element functionEl : 
            new ChildrenElements(parentEl, "function", XIElement.XI_NS_URI)) {
            XIFunction function = new XIFunction(parent, getXIAttr(functionEl, "name"));
            if (parent instanceof XIDocument) {
                ((XIDocument) parent).add(function);
            } else if (parent instanceof XIRole) {
                ((XIRole) parent).add(function);
            }
            
            Element scriptEl = getChildElem(functionEl, "script");
            addBlock(function, scriptEl, 
                    new XIBlock(function, getXIAttr(scriptEl, "type")));
        }
    }
    
    /**
     * Add script
     * 
     * @param blockEl Parent Element
     * @param parent
     */
    private void addBlock(XIStatement parent, Element blockEl, XIBlock block) {
        if (parent instanceof XIBlock) {
            ((XIBlock) parent).add(block);
        } else if (parent instanceof XIStmSwitch) {
            ((XIStmSwitch) parent).add((XIStmBranch) block);
        }
        for (Element statementEl : 
            new ChildrenElements(blockEl, XIElement.XI_NS_URI)) {
            
            XIElement element = null;
            try {
                element = XIElement.valueOf("_" + statementEl.getLocalName());
            } catch (IllegalArgumentException e) {
                System.out.println("Unknown XI element: " + e.getMessage());
                return;
            }
            switch (element) {
            case _set:
                block.add( new XIStmSet(block, getXIAttr(statementEl, "name"), 
                        getXIAttr(statementEl, "value")) );
                break;
            case _switch:
                XIStmSwitch stmSwitch = new XIStmSwitch(block, getXIAttr(statementEl, "name"));
                block.add(stmSwitch);
                
                for (Element branchEl : 
                    new ChildrenElements(statementEl, "branch", XIElement.XI_NS_URI)) {
                    addBlock(stmSwitch, branchEl, 
                            new XIStmBranch(stmSwitch)); 
                }
                break;
            case _failure:
                block.add(new XIStmFailure(block, getXIAttr(statementEl, "name")));
                break;
            case _invoke:
                block.add( new XIStmInvoke(block, getXIAttr(statementEl, "name"),
                        getXIAttr(statementEl, "obj")) );
                break;
            case _script:
                addBlock(block, statementEl, 
                        new XIBlock(block, getXIAttr(statementEl, "type")));
                break;
            case _wait:
                addBlock(block, statementEl, 
                        new XIStmWait(block, getXIAttr(statementEl, "name")));
                break;
            case _onevent:
                addBlock(block, statementEl, 
                        new XIStmOnEvent(block, getXIAttr(statementEl, "name")));
                break;
            case _many:
                addBlock(block, statementEl, 
                        new XIStmMany(block));
                break;    
            default: //ignore the rest
                ;
            }
        }    
    }
    
    /**
     * <p> Static entry point for running the viewer. </p>
     */
    public static void main(String[] args) {
        try {
            if (args.length < 1) {
                System.out.println("Usage: XIParserDOM <XML Document URI>");
                System.exit(0);
            }
            
            XIParserDOM parser = new XIParserDOM();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
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

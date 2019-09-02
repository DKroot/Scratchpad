package dk.xml2domain.stax;

import java.io.FileReader;
import java.io.StringWriter;

import javax.xml.namespace.QName;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.EventFilter;
import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLReporter;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;

import dk.xml2domain.xi.XI;
import dk.xml2domain.xi.XIAlias;
import dk.xml2domain.xi.XIAttribute;
import dk.xml2domain.xi.XIBlock;
import dk.xml2domain.xi.XIDocument;
import dk.xml2domain.xi.XIDomain;
import dk.xml2domain.xi.XIEvent;
import dk.xml2domain.xi.XIField;
import dk.xml2domain.xi.XIFunction;
import dk.xml2domain.xi.XIHeader;
import dk.xml2domain.xi.XIObject;
import dk.xml2domain.xi.XIProcess;
import dk.xml2domain.xi.XIRole;
import dk.xml2domain.xi.XIStatement;
import dk.xml2domain.xi.XIStmBranch;
import dk.xml2domain.xi.XIStmFailure;
import dk.xml2domain.xi.XIStmInvoke;
import dk.xml2domain.xi.XIStmMany;
import dk.xml2domain.xi.XIStmOnEvent;
import dk.xml2domain.xi.XIStmSet;
import dk.xml2domain.xi.XIStmSwitch;
import dk.xml2domain.xi.XIStmWait;
import dk.xml2domain.xi.XITask;
import dk.xml2domain.xml.XIElement;


/**
 * @author DK
 */
public class XIParserStAX {
    private XI xi = new XI();

    private XMLEventReader r;
    private XMLEvent event;

    //// Filtered readers
    private String targetElem, targetEndOfElem;
    private XMLEventReader xiElemReader, xiEndOfElemReader;
    private XMLEventWriter w;

    private XMLOutputFactory outputFactory;

    public XIParserStAX() {
    }

    /**
     * Accepts only XI start-of-elements
     * If targetElem != null, accepts only targetElem
     */
    class XIElemFilter implements EventFilter {
        public boolean accept(XMLEvent e) {
            if ( e.isStartElement() ) {
                QName element = e.asStartElement().getName();
                return element.getNamespaceURI().equals(XIElement.XI_NS_URI) &&
                        (targetElem == null || element.getLocalPart().equals(targetElem));
            }
            return false;
        }
    }

    /**
     * Accepts XI start-of-elements and the targetEndOfElem end-of-element
     * Intended for looping until the end-of-element of targetEndOfElem
     *
     * If w != null, writes all events until (not including) the end-of-element
     */
    class XIEndOfElemFilter implements EventFilter {
        public boolean accept(XMLEvent ev) {
            boolean theEnd = false;
            if ( ev.isEndElement() ) {
                QName element = ev.asEndElement().getName();
                theEnd = element.getNamespaceURI().equals(XIElement.XI_NS_URI) &&
                        element.getLocalPart().equals(targetEndOfElem);
            }

            if (w != null && !theEnd) {
                try {
                    if (!ev.isCharacters() || !ev.asCharacters().isWhiteSpace()) {
                    //compress whitespace
                        w.add(ev);
                    }
                } catch (XMLStreamException e) {
                    e.printStackTrace();
                }
            }

            if ( ev.isStartElement() ) {
                QName element = ev.asStartElement().getName();
                return element.getNamespaceURI().equals(XIElement.XI_NS_URI) &&
                        (targetElem == null || element.getLocalPart().equals(targetElem));
            }
            return theEnd;
        }
    }

/*
    public static String[] attributesToArray(Attributes atts) {
        String[] result = new String[atts.getLength()];
        for (int i = 0; i < atts.getLength(); i++) {
            result[i] = atts.getQName(i) + "=\"" + atts.getValue(i) + "\"";
        }
        return result;
    }
*/

    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     * @throws ParserConfigurationException
     * @throws <code>IOException</code> - when reading the XML URI fails.
     * @throws <code>SAXException</code> - when errors in parsing occur.
     */
    public XI parse(String xiURI)
            throws Exception {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        inputFactory.setProperty("javax.xml.stream.isCoalescing", Boolean.TRUE);
        inputFactory.setXMLReporter(new XMLReporter() {
            public void report(String message, String errorType,
              Object relatedInformation, Location location) throws XMLStreamException {
                throw new XMLStreamException(message, location);
            }
        });

        outputFactory = XMLOutputFactory.newInstance();

        r = inputFactory.createXMLEventReader(new FileReader(xiURI));
        xiElemReader = inputFactory.createFilteredReader(r, new XIElemFilter());
        xiEndOfElemReader = inputFactory.createFilteredReader(r, new XIEndOfElemFilter());

        // Parse
        try {
            gotoXIElem("XI");
            xi.setVersion(getXIAttr("version"));
            while (gotoXIElem("domain")) {
                XIDomain domain = new XIDomain(xi, getXIAttr("name"), getXIAttr("version"));
                xi.add(domain);
                if ( gotoXIElem("header") ) {
                    XIHeader header = new XIHeader(domain);
                    domain.add(header);

                    while (nextXIElem("alias")) {
                        XIAlias alias = new XIAlias(header, getXIAttr("id"), getXIAttr("name"));
                        header.add(alias);
                    }

                    //at <artifacts>
                    addArtifacts(domain);
//
                    //at <processes>
                    addProcesses(domain);
                }
            }

            return getXI();
        } catch (Exception e) {
            System.out.println("Error occurred! Incomplete XI model:");
            getXI().print(System.out, 0);
            throw e;
        } finally {
            xiElemReader.close();
            r.close();
        }
    }

    private XIElement getXIElement() {
        try {
            return XIElement.valueOf("_" + getElemName());
        } catch (IllegalArgumentException e) {
            System.out.println("Warning: found an unknown XI element : " + getElemName());
            return XIElement.UNKNOWN;
        }
    }

    /**
     * Get local name of the current element (assumes we are at start-of-element)
     *
     * @return local name
     */
    private String getElemName() {
        return event.asStartElement().getName().getLocalPart();
    }

    private void addArtifacts(XIDomain domain) throws XMLStreamException {
        while ( scanUntilTheEnd("artifacts") ) {
            switch (getXIElement()) {
            case _event:
                XIEvent event = new XIEvent(domain, getXIAttr("id"),
                        getXIAttr("name"), getXIAttr("parent"));
                domain.add(event);
                break;
            case _document:
                XIDocument document = new XIDocument(domain, getXIAttr("id"),
                        getXIAttr("name"), getXIAttr("parent"));
                domain.add(document);

                while ( scanUntilTheEnd("document") ) {
                    switch (getXIElement()) {
                    case _attribute:
                        addAttribute(document);
                        break;
                    case _field:
                        addField(document);
                        break;
                    case _function:
                        addFunction(document);
                        break;
                    default:
                        ;
                    }
                }
                break;
            case _role:
                XIRole role = new XIRole(domain, getXIAttr("id"),
                        getXIAttr("name"), getXIAttr("parent"));
                domain.add(role);

                while ( scanUntilTheEnd("role", "function") ) {
                    addFunction(role);
                }
                break;
            default: //ignore the rest
                ;
            }
        }
    }

    private void addProcesses(XIDomain domain) throws XMLStreamException {
        while (gotoXIElem("process")) {
            XIProcess process = new XIProcess(domain, getXIAttr("id"),
                    getXIAttr("name"));
            domain.add(process);

            while (nextXIElem("field")) {
                addField(process);
            }

            //at <task>
             do {
                XITask task = new XITask(process, getXIAttr("name"));
                process.add(task);

                if ( gotoXIElem("script") ) {
                    addBlock(task,
                            new XIBlock(task, getXIAttr("type")));
                }
            } while ( scanUntilTheEnd("process", "task") );
        }
    }

    private void addAttribute(XIDocument document) throws XMLStreamException {
        XIAttribute attribute = new XIAttribute(document, getXIAttr("name"));
        document.add(attribute);

        //Add all inner content of this attribute
        StringWriter sw = new StringWriter();
        w = outputFactory.createXMLEventWriter(sw);
        try {
            scanUntilTheEnd("attribute");
        } finally {
            w.flush();
            w.close();
            w = null;
        }

        attribute.add(sw.toString());
    }

    private void addField(XIObject parent) throws XMLStreamException {
        XIField field = new XIField(parent, getXIAttr("name"),
                getXIAttr("type"), getXIAttr("domain"));
        if (parent instanceof XIDocument) {
            ((XIDocument) parent).add(field);
        } else if (parent instanceof XIProcess) {
            ((XIProcess) parent).add(field);
        } else if (parent instanceof XIField) {
            ((XIField) parent).add(field);
        }

        while (scanUntilTheEnd("field")) {
            //inner fields
            addField(field);
        }
    }

    private void addFunction(XIObject parent) throws XMLStreamException {
        XIFunction function = new XIFunction(parent, getXIAttr("name"));
        if (parent instanceof XIDocument) {
            ((XIDocument) parent).add(function);
        } else if (parent instanceof XIRole) {
            ((XIRole) parent).add(function);
        }

        if ( gotoXIElem("script") ) {
            addBlock(function,
                    new XIBlock(function, getXIAttr("type")));
        }
    }

    /**
     * Add XI script
     * Assumes we at the start-of-element of block
     *
     * @param parent
     * @param block
     * @throws XMLStreamException
     */
    private void addBlock(XIStatement parent, XIBlock block) throws XMLStreamException {
        String blockElem = getElemName();
        if (parent instanceof XIBlock) {
            ((XIBlock) parent).add(block);
        } else if (parent instanceof XIStmSwitch) {
            ((XIStmSwitch) parent).add((XIStmBranch) block);
        }
        XIStmSwitch stmSwitch = null;
        while( scanUntilTheEnd(blockElem) ) {
            switch (getXIElement()) {
            case _set:
                block.add( new XIStmSet(block, getXIAttr("name"),
                        getXIAttr("value")) );
                break;
            case _switch:
                stmSwitch = new XIStmSwitch(block, getXIAttr("name"));
                block.add(stmSwitch);
                break;
            case _branch: //only possible within switch
                addBlock(stmSwitch,
                        new XIStmBranch(stmSwitch));
                break;
            case _failure:
                block.add(new XIStmFailure(block, getXIAttr("name")));
                break;
            case _invoke:
                block.add( new XIStmInvoke(block, getXIAttr("name"),
                        getXIAttr("obj")) );
                break;
            case _script:
                addBlock(block,
                        new XIBlock(block, getXIAttr("type")));
                break;
            case _wait:
                addBlock(block,
                        new XIStmWait(block, getXIAttr("name")));
                break;
            case _onevent:
                addBlock(block,
                        new XIStmOnEvent(block, getXIAttr("name")));
                break;
            case _many:
                addBlock(block,
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
                System.out.println("Usage: XIParserStAX <XML URI>");
                System.exit(0);
            }

            XIParserStAX parser = new XIParserStAX();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public XI getXI() {
        return xi;
    }

    /**
     * Moves to the next start-of-element
     *
     * @return true if found, false if end-of-doc
     * @throws XMLStreamException
    private boolean nextElem() throws XMLStreamException {
        while( r.hasNext() ) {
            r.next();
            if ( r.isStartElement() ) {
                return true;
            }
        }
        return false; //end-of-doc
    }
    */

    /**
     * Positions on any next start-of-element from the XI namespace
     *
     * @param element
     * @return true if found, false if end-of-doc or another XI element is found
     * @throws XMLStreamException
     */
    private boolean nextXIElem(String element) throws XMLStreamException {
        try {
            event = xiElemReader.nextEvent();
            return (event != null && getElemName().equals(element));
        } catch (RuntimeException e) {
            return false;
        }
    }

    /**
     * Moves to the next given start-of-element from the XI namespace
     *
     * @param element
     * @return true if found, false if end-of-doc
     * @throws XMLStreamException
     */
    private boolean gotoXIElem(String element) throws XMLStreamException {
        targetElem = element;
        try {
            event = xiElemReader.nextEvent();
            return event != null;
        } catch (RuntimeException e) {
            return false;
        } finally {
            targetElem = null;
        }
    }

    /**
     * Finds and returns XI start-of-elements until the given end-of-element
     *
     * @param element
     * @return true if found, false if end-of-doc or end-of-element
     * @throws XMLStreamException
     */
    private boolean scanUntilTheEnd(String element) throws XMLStreamException {
        targetEndOfElem = element;
        try {
            event = xiEndOfElemReader.nextEvent();
            return event != null && event.isStartElement();
        } catch (RuntimeException e) {
            return false;
        } finally {
            targetEndOfElem = null;
        }
    }

    /**
     * Finds and returns XI start-of-elements until the given end-of-element
     *
     * @param element
     * @return true if found, false if end-of-doc or end-of-element
     * @throws XMLStreamException
     */
    private boolean scanUntilTheEnd(String targetEndOfElem, String targetElem)
            throws XMLStreamException {
        this.targetEndOfElem = targetEndOfElem;
        this.targetElem = targetElem;
        try {
            event = xiEndOfElemReader.nextEvent();
            return event != null && event.isStartElement();
        } catch (RuntimeException e) {
            return false;
        } finally {
            this.targetEndOfElem = this.targetElem = null;
        }
    }
    /**
     * Returns an attribute value (no namespace check)
     *
     * @param name attribute name
     * @return null if empty
     */
    private String getXIAttr(String name) {
        Attribute attr = event.asStartElement().getAttributeByName(new QName(name));
        return ( attr == null ? null : attr.getValue());
    }
}

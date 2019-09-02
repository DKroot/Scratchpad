package dk.xml2domain.xom;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.parsers.SAXParserFactory;

import dk.xml2domain.xi.*;
import dk.xml2domain.xml.XIElement;

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Node;
import nu.xom.Serializer;
import nu.xom.Text;


public class XIParserXOM {
    public XIParserXOM() {
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     */
    public XI parse(String xiURI) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.setNamespaceAware(true);

        //Assuming JDK 5.0 default parser factory (Xerces) 
        //The combination of the following 2 Xerces features will turn on XML Schema validation
        //only if schema is specified in the document
        saxFactory.setFeature("http://apache.org/xml/features/validation/dynamic", true);
        saxFactory.setFeature("http://apache.org/xml/features/validation/schema", true);
        
        //Parse
        XI xi = new XI();
        try {
            Builder parser = new Builder(saxFactory.newSAXParser().getXMLReader(), true);
            Document doc = parser.build(xiURI);
            
            Element xiEl = doc.getRootElement();
            xi.setVersion(getXIAttr(xiEl, "version"));
            for (Element domainEl :
                    new ChildrenElements(xiEl, "domain", XIElement.XI_NS_URI)) {
                XIDomain domain = new XIDomain(xi, getXIAttr(domainEl, "name"), 
                        getXIAttr(domainEl, "version"));
                xi.add(domain);
                           
                Element headerEl = domainEl.getFirstChildElement("header", XIElement.XI_NS_URI);
                XIHeader header = new XIHeader(domain);
                domain.add(header);
                for (Element aliasEl : 
                        new ChildrenElements(headerEl, "alias", XIElement.XI_NS_URI)) {
                    XIAlias alias = new XIAlias(header, getXIAttr(aliasEl, "id"), 
                            getXIAttr(aliasEl, "name"));
                    header.add(alias);
                }
                
                Element artifactsEl = domainEl.getFirstChildElement("artifacts", XIElement.XI_NS_URI);
                for (Element eventEl : new ChildrenElements(artifactsEl, "event", XIElement.XI_NS_URI)) {
                    XIEvent event = new XIEvent(domain, getXIAttr(eventEl, "id"), 
                            getXIAttr(eventEl, "name"), getXIAttr(eventEl, "parent"));
                    domain.add(event);                    
                }
                for (Element docEl : new ChildrenElements(artifactsEl, "document", XIElement.XI_NS_URI)) {
                    XIDocument document = new XIDocument(domain, getXIAttr(docEl, "id"), 
                            getXIAttr(docEl, "name"), getXIAttr(docEl, "parent"));
                    domain.add(document);
                    
                    for (Element attrEl : 
                                new ChildrenElements(docEl,  "attribute", XIElement.XI_NS_URI)) {
                        XIAttribute attribute = new XIAttribute(document, 
                                getXIAttr(attrEl, "name"));
                        document.add(attribute);

                        //Add all inner content of this attribute
                        //Use custom serializer to condense whitespace 
                        //and write only contents of attrEl
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        CustomSerializer serializer = new CustomSerializer(out);
                        serializer.writeContents(attrEl);
                        serializer.flush(); out.close();
                        attribute.add(out.toString());
                        
                        //StringWriter sw = new StringWriter();
                        //sw.write(attrEl.toXML());
                        //attribute.add(sw.toString());
                    }
                    
                    addFields(document, docEl);
                    addFunctions(document, docEl);
                }
                
                for (Element roleEl : new ChildrenElements(artifactsEl, "role", XIElement.XI_NS_URI)) {
                    XIRole role = new XIRole(domain, getXIAttr(roleEl, "id"), 
                            getXIAttr(roleEl, "name"), getXIAttr(roleEl, "parent"));
                    domain.add(role);
                    
                    addFunctions(role, roleEl);
                }
                
                Element processesEl = domainEl.getFirstChildElement("processes", XIElement.XI_NS_URI);
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
                        
                        Element scriptEl = 
                                taskEl.getFirstChildElement("script", XIElement.XI_NS_URI);
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
        return element.getAttributeValue(name);
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
            
            Element scriptEl = functionEl.getFirstChildElement("script", XIElement.XI_NS_URI);
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
        for (Element oStatementEl : new ChildrenElements(blockEl, XIElement.XI_NS_URI)) {
            Element statementEl = (Element) oStatementEl;
                
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
                
                for (Element branchEl : new ChildrenElements(statementEl, "branch", XIElement.XI_NS_URI)) {
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
                System.out.println("Usage: XIParserXOM <XML Document URI>");
                System.exit(0);
            }
            
            XIParserXOM parser = new XIParserXOM();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    static class CustomSerializer extends Serializer {
        public CustomSerializer(OutputStream out) {
            super(out);
        }

        public void writeContents(Element element) throws IOException {
            for (int i = 0; i < element.getChildCount(); i++) {
                Node node = element.getChild(i);
                if (node instanceof Element) {
                    writeStartTag((Element) node);
                    writeContents((Element) node);
                    writeEndTag((Element) node);
                } else if (node instanceof Text) {
                    //condense whitespace
                    writeEscaped( node.getValue().replace('\n', ' ').trim() );
                }
            }
        }
    }
}

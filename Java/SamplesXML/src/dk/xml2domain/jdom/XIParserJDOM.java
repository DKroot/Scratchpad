package dk.xml2domain.jdom;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import dk.xml2domain.xi.*;
import dk.xml2domain.xml.XIElement;



public class XIParserJDOM {
    private Namespace XI_NS = Namespace.getNamespace(XIElement.XI_NS_URI);
        
    public XIParserJDOM() {
    }
    
    /**
     * <p>This handles building the XI tree.</p>
     *
     * @param xiURI URI to build XML document from.
     */
    public XI parse(String xiURI) throws Exception {
        SAXBuilder builder = new SAXBuilder(false);
        //Assuming JDK 5.0 default parser factory (Xerces) 
        //The combination of the following 2 Xerces features will turn on XML Schema validation
        //only if schema is specified in the document
        builder.setFeature("http://apache.org/xml/features/validation/dynamic", true);
        builder.setFeature("http://apache.org/xml/features/validation/schema", true);
        
        //Parse
        XI xi = new XI();
        try {
            Document doc = builder.build(xiURI);
            
            Element xiEl = doc.getRootElement();
            xi.setVersion(getXIAttr(xiEl, "version"));
            for (Object domainEl : xiEl.getChildren("domain", XI_NS)) {
                XIDomain domain = new XIDomain(xi, getXIAttr(domainEl, "name"), 
                        getXIAttr(domainEl, "version"));
                xi.add(domain);
                           
                Element headerEl = ((Element) domainEl).getChild("header", XI_NS);
                XIHeader header = new XIHeader(domain);
                domain.add(header);
                for (Object aliasEl : headerEl.getChildren("alias", XI_NS)) {
                    XIAlias alias = new XIAlias(header, getXIAttr(aliasEl, "id"), 
                            getXIAttr(aliasEl, "name"));
                    header.add(alias);
                }
                
                Element artifactsEl = ((Element) domainEl).getChild("artifacts", XI_NS);
                for (Object eventEl : artifactsEl.getChildren("event", XI_NS)) {
                    XIEvent event = new XIEvent(domain, getXIAttr(eventEl, "id"), 
                            getXIAttr(eventEl, "name"), getXIAttr(eventEl, "parent"));
                    domain.add(event);                    
                }
                for (Object docEl : artifactsEl.getChildren("document", XI_NS)) {
                    XIDocument document = new XIDocument(domain, getXIAttr(docEl, "id"), 
                            getXIAttr(docEl, "name"), getXIAttr(docEl, "parent"));
                    domain.add(document);
                    
                    for (Object attrEl : ((Element) docEl).getChildren("attribute", XI_NS)) {
                        XIAttribute attribute = new XIAttribute(document, 
                                getXIAttr(attrEl, "name"));
                        document.add(attribute);

                        //Add all inner content of this attribute
                        XMLOutputter outputter = new XMLOutputter(Format.getCompactFormat());
                        attribute.add(outputter.outputString( ((Element) attrEl).getContent() ));
                    }
                    
                    addFields(document, docEl);
                    addFunctions(document, docEl);
                }
                
                for (Object roleEl : artifactsEl.getChildren("role", XI_NS)) {
                    XIRole role = new XIRole(domain, getXIAttr(roleEl, "id"), 
                            getXIAttr(roleEl, "name"), getXIAttr(roleEl, "parent"));
                    domain.add(role);
                    
                    addFunctions(role, roleEl);
                }
                
                Element processesEl = ((Element) domainEl).getChild("processes", XI_NS);
                for (Object procEl : processesEl.getChildren("process", XI_NS)) {
                    XIProcess process = new XIProcess(domain, getXIAttr(procEl, "id"), 
                            getXIAttr(procEl, "name"));
                    domain.add(process);
                    
                    addFields(process, procEl);
                    
                    for (Object taskEl : ((Element) procEl).getChildren("task", XI_NS)) {
                        XITask task = new XITask(process, getXIAttr(taskEl, "name"));
                        process.add(task);
                        
                        Element scriptEl = ((Element) taskEl).getChild("script", XI_NS);
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
    private String getXIAttr(Object element, String name) {
        return ((Element) element).getAttributeValue(name, (String) null);
    }

    /**
     * Recursively add fields of the current element
     * @param parent Parent object
     * @param parentEl Parent Element
     */
    private void addFields(XIObject parent, Object parentEl) {
        for (Object fieldEl : ((Element) parentEl).getChildren("field", XI_NS)) {
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
    private void addFunctions(XIObject parent, Object parentEl) {
        for (Object functionEl : ((Element) parentEl).getChildren("function", XI_NS)) {
            XIFunction function = new XIFunction(parent, getXIAttr(functionEl, "name"));
            if (parent instanceof XIDocument) {
                ((XIDocument) parent).add(function);
            } else if (parent instanceof XIRole) {
                ((XIRole) parent).add(function);
            }
            
            Element scriptEl = ((Element) functionEl).getChild("script", XI_NS);
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
    private void addBlock(XIStatement parent, Object blockEl, XIBlock block) {
        if (parent instanceof XIBlock) {
            ((XIBlock) parent).add(block);
        } else if (parent instanceof XIStmSwitch) {
            ((XIStmSwitch) parent).add((XIStmBranch) block);
        }
        for (Object oStatementEl : ((Element) blockEl).getChildren()) {
            Element statementEl = (Element) oStatementEl;
                
            XIElement element = null;
            try {
                element = XIElement.valueOf("_" + statementEl.getName());
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
                
                for (Object branchEl : statementEl.getChildren("branch", XI_NS)) {
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
                System.out.println("Usage: XIParserJDOM <XML Document URI>");
                System.exit(0);
            }
            
            XIParserJDOM parser = new XIParserJDOM();
            parser.parse(args[0]).print(System.out, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

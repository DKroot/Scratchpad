package dk.xml2domain.xi;

import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

import org.w3c.dom.Node;

import dk.xml2domain.xml.DOMWriter;


public class XIAttribute extends XIObject {
    public static boolean IGNORE_WHITESPACE = true; //ignore whitespace in the XML content inside
    
    private String name;
    
    private StringBuffer body = new StringBuffer(); //arbitrary XML content

    public XIAttribute() {
    }

    public XIAttribute(XIObject owner, String name) {
        super(owner);
        this.name = name;
    }
    
    public void startElement(String qname, String[] attributes) {
        body.append("<" + qname);
        for (String attr : attributes) {
            body.append(" " + attr);
        }
        body.append(">");
    }
    
    public void endElement(String qname) {
        body.append("</" + qname + ">");
    }
    
    public void add(String text) {
        if (IGNORE_WHITESPACE) {
            body.append(text.trim());            
        } else {
            body.append(text);
        }
    }

    //Add the entire node - alternative to startElement/endElement/add text
    public void addNode(Node fragment) throws IOException {
        StringWriter sw = new StringWriter();
        DOMWriter w = new DOMWriter(0, "");
        w.write(fragment, sw, "", true, true);
        add(sw.toString());
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        if (body.length() > 0) {
            printIndent(out, indent+2);
            out.println(body);
        }    
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "attribute(@name = " + name + ")";
    }
}

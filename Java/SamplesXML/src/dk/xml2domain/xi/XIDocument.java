package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIDocument extends XIType {
    private LinkedList<XIAttribute> attributes = new LinkedList<XIAttribute>();
    private LinkedList<XIField> fields = new LinkedList<XIField>();
    private LinkedList<XIFunction> functions = new LinkedList<XIFunction>();

    public XIDocument() {
    }

    public XIDocument(XIObject owner, String id, String name, String parent) {
        super(owner, id, name, parent);
    }
    
    public void add(XIAttribute attribute) {
        attributes.add(attribute);
    }
    
    public void add(XIField field) {
        fields.add(field);
    }
    
    public void add(XIFunction function) {
        functions.add(function);
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIAttribute a : attributes) {
            a.print(out, indent + 2);
        }
        for (XIField f : fields) {
            f.print(out, indent + 2);
        }
        for (XIFunction f : functions) {
            f.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "document(@id = " + getId() + 
            "; @name = " + getName() + "; @parent = " + getParent() + ")";
    }
    
    //to support deserialization 
    protected Object readResolve() {
        if (attributes == null) 
            attributes = new LinkedList<XIAttribute>();
        if (fields == null) 
            fields = new LinkedList<XIField>();
        if (functions == null) 
            functions = new LinkedList<XIFunction>();
        
        return this;
    }
}

package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIField extends XIObject {
    private String name;
    private String type;
    private String domain;

    //Field can contain nested fields
    private LinkedList<XIField> fields = new LinkedList<XIField>();
    
    public XIField() {
    }

    public XIField(XIObject owner, String name, String type, String domain) {
        super(owner);
    
        this.domain = domain;
        this.name = name;
        this.type = type;
    }
    
    public void add(XIField field) {
        fields.add(field);
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIField f : fields) {
            f.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "field(@name = " + name + "; @domain = " + domain + "; @type = " + type + ")";
    }
    
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //to support deserialization 
    protected Object readResolve() {
        if (fields == null) 
            fields = new LinkedList<XIField>();

        return this;
    }
}

package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIDomain extends XIObject {
    private String name;
    private String version;
    
    private LinkedList<XIHeader> headers = new LinkedList<XIHeader>();
    private LinkedList<XIType> types = new LinkedList<XIType>();
    private LinkedList<XIProcess> processes = new LinkedList<XIProcess>();
    
    public XIDomain() {
    }

    public XIDomain(XIObject owner, String name, String version) {
        super(owner);
        this.name = name;
        this.version = version;
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIHeader h : headers) {
            h.print(out, indent + 2);
        }
        if (!types.isEmpty()) {
            printIndent(out, indent + 2);
            out.println("types");
/*            
            for (XIType t : types) {
                t.print(out, indent + 4);
            }
*/          //TODO Temporary hack to allow XStream to proceed  
            for (Object t : types) {
                if (t instanceof XIType)
                    ((XIType) t).print(out, indent + 4);
                else {
                    printIndent(out, indent + 4);
                    out.println("!" + t.toString() + "!");
                }
                    
            }
        }    
        for (XIProcess p : processes) {
            p.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "domain(@name = " + name + "; @version = " + version + ")";
    }

    public void add(XIHeader header) {
       headers.add(header);
    }
    
    public void add(XIType type) {
        types.add(type);
    }
    
    public void add(XIProcess process) {
        processes.add(process);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    //to support deserialization 
    protected Object readResolve() {
        if (headers == null) 
            headers = new LinkedList<XIHeader>();
        if (types == null) 
            types = new LinkedList<XIType>();
        if (processes == null) 
            processes = new LinkedList<XIProcess>();
        
        return this;
    }
}

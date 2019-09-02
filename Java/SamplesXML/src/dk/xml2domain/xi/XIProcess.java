package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIProcess extends XIObject {
    private String id;
    private String name;
    
    private LinkedList<XIField> fields = new LinkedList<XIField>();
    private LinkedList<XITask> tasks = new LinkedList<XITask>();
    
    public XIProcess() {
    }

    public XIProcess(XIObject owner, String id, String name) {
        super(owner);
        this.id = id;
        this.name = name;
    }

    public void add(XIField field) {
        fields.add(field);
    }    
    
    public void add(XITask task) {
        tasks.add(task);
    }
    
    @Override
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIField f : fields) {
            f.print(out, indent + 2);
        }
        for (XITask t : tasks) {
            t.print(out, indent + 2);
        }
    }

    @Override
    public String toString() {
        return "process(@name = " + name + "; @id = " + id + ")";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //to support deserialization 
    protected Object readResolve() {
        if (fields == null) 
            fields = new LinkedList<XIField>();
        if (tasks == null) 
            tasks = new LinkedList<XITask>();
        
        return this;
    }
}

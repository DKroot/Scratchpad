package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIRole extends XIType {
    private LinkedList<XIFunction> functions = new LinkedList<XIFunction>();

    public XIRole() {
    }

    public XIRole(XIObject owner, String id, String name, String parent) {
        super(owner, id, name, parent);
    }
   
    public void add(XIFunction function) {
        functions.add(function);
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIFunction f : functions) {
            f.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "role(@id = " + getId() + 
            "; @name = " + getName() + "; @parent = " + getParent() + ")";
    }

    //to support deserialization 
    protected Object readResolve() {
        if (functions == null) 
            functions = new LinkedList<XIFunction>();
        
        return this;
    }
    
}

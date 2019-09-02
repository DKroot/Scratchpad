package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIFunction extends XIBlock implements IStmWithParams {
    private LinkedList<XIParameter> parameters = new LinkedList<XIParameter>();

    public XIFunction() {
    }

    public XIFunction(XIObject owner, String name) {
        super(owner, null);
        setName(name);
    }
    
    public void add(XIParameter parameter) {
        parameters.add(parameter);
    }  
    
    public void print(PrintStream out, int indent) {
        printIndent(out, indent);
        out.println(toString());
        for (XIParameter p : parameters) {
            p.print(out, indent + 2);
        }
        for (XIStatement s : getStatements()) {
            s.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "function(@name = " + getName() + ")";
    }
    
    //to support deserialization 
    protected Object readResolve() {
        super.readResolve();
        if (parameters == null) 
            parameters = new LinkedList<XIParameter>();

        return this;
    }
}

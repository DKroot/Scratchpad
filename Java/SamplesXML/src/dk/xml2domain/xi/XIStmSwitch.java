package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIStmSwitch extends XIStatement {
    private LinkedList<XIStmBranch> branches = new LinkedList<XIStmBranch>();

    public XIStmSwitch() {
    }

    public XIStmSwitch(XIObject owner, String name) {
        super(owner, name);
    }

    public void add(XIStmBranch stmBranch) {
        branches.add(stmBranch);
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIStmBranch b : branches) {
            b.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "switch(@name = " + getName() + ")";
    }
    
    //to support deserialization 
    protected Object readResolve() {
        //super.readResolve();
        if (branches == null) 
            branches = new LinkedList<XIStmBranch>();

        return this;
    }
}

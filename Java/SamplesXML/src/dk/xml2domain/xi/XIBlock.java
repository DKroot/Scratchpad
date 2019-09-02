package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class XIBlock extends XIStatement {
    private String type; 
    
    private LinkedList<XIStatement> statements = new LinkedList<XIStatement>();
    
    public XIBlock() {
    }

    public XIBlock(XIObject owner, String type) {
       super(owner, null);
       this.type = type;
    }
    
    public void add(XIStatement statement) {
        statements.add(statement);
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIStatement s : statements) {
            s.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "block(@type = " + type + ")";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<XIStatement> getStatements() {
        return statements;
    }
    
    //to support deserialization 
    protected Object readResolve() {
        if (statements == null) 
            statements = new LinkedList<XIStatement>();
        
        return this;
    }
}

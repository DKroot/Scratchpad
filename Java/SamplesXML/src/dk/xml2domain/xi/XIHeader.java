package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XIHeader extends XIObject {
    private LinkedList<XIAlias> aliases = new LinkedList<XIAlias>();
    
    public XIHeader() {
    }

    public XIHeader(XIObject owner) {
        super(owner);
    }

    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIAlias a : aliases) {
            a.print(out, indent + 2);
        }
    }
    
    public void add(XIAlias alias) {
        aliases.add(alias);
    }
    
    @Override
    public String toString() {
        return "header";
    }
}

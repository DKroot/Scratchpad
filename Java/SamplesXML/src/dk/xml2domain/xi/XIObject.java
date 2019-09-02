package dk.xml2domain.xi;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.Arrays;

public class XIObject implements Serializable {
    private transient XIObject owner;

    public XIObject() {
    }

    public XIObject(XIObject owner) {
        this.owner = owner;
    }
    
    public void printIndent(PrintStream out, int indent) {
        char[] filler = new char[indent];
        Arrays.fill(filler, ' ');
        out.print(filler);
    }
    
    public void print(PrintStream out, int indent) {
        printIndent(out, indent);
        out.println(toString());
    }
    
    public XIObject getOwner() {
        return owner;
    }

    public void setOwner(XIObject owner) {
        this.owner = owner;
    }
}

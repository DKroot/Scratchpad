package dk.xml2domain.xi;

import java.io.PrintStream;
import java.util.LinkedList;

public class XI extends XIObject {
    private String version;
    
    private LinkedList<XIDomain> domains = new LinkedList<XIDomain>();

    public XI() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public void add(XIDomain domain) {
        domains.add(domain);
    }
    
    public void print(PrintStream out, int indent) {
        super.print(out, indent);
        for (XIDomain d : domains) {
            d.print(out, indent + 2);
        }
    }
    
    @Override
    public String toString() {
        return "XI(@version = " + version + ")";
    }
}

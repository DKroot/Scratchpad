package dk.xml2domain.xi;

public class XIParameter extends XIObject {
    private String name;
    private String dir;
    private String type;
    
    public XIParameter(XIObject owner, String name, String type, String dir) {
        super(owner);
        this.name = name;
        this.type = type;
        this.dir = dir;
    }
    
    @Override
    public String toString() {
        return "param(@name = " + name + "; @type = " + type + "; @dir = " + dir + ")";
    }
}

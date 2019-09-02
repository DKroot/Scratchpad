package dk.xml2domain.xi;

public class XIStmAllocate extends XIStatement {
    private String type;

    public XIStmAllocate(XIObject owner, String name, String type) {
        super(owner, name);
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "allocate(@name = " + getName() + "; @type = " + type + ")";
    }
}

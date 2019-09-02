package dk.xml2domain.xi;

public class XIStmWait extends XIBlock {

    public XIStmWait() {
    }

    public XIStmWait(XIObject owner, String name) {
        super(owner, null);
        setName(name);
    }
    
    @Override
    public String toString() {
        return "wait(@name = " + getName() + ")";
    }
}

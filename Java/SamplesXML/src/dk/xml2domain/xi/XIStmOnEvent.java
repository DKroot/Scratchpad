package dk.xml2domain.xi;

public class XIStmOnEvent extends XIBlock {

    public XIStmOnEvent() {
    }

    public XIStmOnEvent(XIObject owner, String name) {
        super(owner, null);
        setName(name);
    }
    
    @Override
    public String toString() {
        return "onevent(@name = " + getName() + ")";
    }
}

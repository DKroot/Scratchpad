package dk.xml2domain.xi;

public class XIStmSet extends XIStatement {
    private String value;

    public XIStmSet() {
    }

    public XIStmSet(XIObject owner, String name, String value) {
        super(owner, name);
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "set(@name = " + getName() + "; @value = " + value + ")";
    }
}

package dk.xml2domain.xi;

public class XIStmMany extends XIBlock {
    
    public XIStmMany() {
    }

    public XIStmMany(XIObject owner) {
        super(owner, null);
    }
    
    @Override
    public String toString() {
        return "many";
    }
}

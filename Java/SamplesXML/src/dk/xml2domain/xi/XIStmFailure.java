package dk.xml2domain.xi;


public class XIStmFailure extends XIStatement {

    public XIStmFailure() {
    }

    public XIStmFailure(XIObject owner, String name) {
        super(owner, name);
    }
    
    @Override
    public String toString() {
        return "failure(@name = " + getName() + ")";
    }
}

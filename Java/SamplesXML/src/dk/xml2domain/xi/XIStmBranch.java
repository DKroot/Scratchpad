package dk.xml2domain.xi;

public class XIStmBranch extends XIBlock {
    
    public XIStmBranch() {
    }

    public XIStmBranch(XIObject owner) {
        super(owner, null);
    }
    
    @Override
    public String toString() {
        return "branch";
    }
}

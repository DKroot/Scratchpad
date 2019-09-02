package dk.xml2domain.xi;

public abstract class XIStatement extends XIObject {
    private String name;
    
    public XIStatement() {
    }

    public XIStatement(XIObject owner, String name) {
        super(owner);
        this.name = name;
    }

    //some statements don't have a name
    public XIStatement(XIObject owner) {
        super(owner);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

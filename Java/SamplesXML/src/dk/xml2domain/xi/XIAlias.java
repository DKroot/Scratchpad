package dk.xml2domain.xi;


public class XIAlias extends XIObject {
    private String id;
    private String name;

    public XIAlias() {
    }

    public XIAlias(XIObject owner, String id, String name) {
        super(owner);
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "alias(@id = " + id + "; @name = " + name+ ")";
    }
}

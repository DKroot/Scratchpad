package dk.xml2domain.xi;

public abstract class XIType extends XIObject {
    private String id;
    private String name;
    private String parent;
    
    public XIType() {
    }

    public XIType(XIObject owner, String id, String name, String parent) {
        super(owner);
        this.id = id;
        this.name = name;
        this.parent = parent;
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

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}

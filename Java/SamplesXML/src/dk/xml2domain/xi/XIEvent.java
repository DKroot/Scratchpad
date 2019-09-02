package dk.xml2domain.xi;

public class XIEvent extends XIType {
    public XIEvent() {
    }

    public XIEvent(XIObject owner, String id, String name, String parent) {
        super(owner, id, name, parent);
    }
    
    @Override
    public String toString() {
        return "event(@id = " + getId() + 
            "; @name = " + getName() + "; @parent = " + getParent() + ")";
    }
}

package dk.xml2domain.xi;


public class XITask extends XIFunction {
    
    public XITask() {
    }

    public XITask(XIObject owner, String name) {
        super(owner, name);
    }
    
    @Override
    public String toString() {
        return "task(@name = " + getName() + ")";
    }
}

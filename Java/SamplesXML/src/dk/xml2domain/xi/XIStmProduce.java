package dk.xml2domain.xi;

import java.util.LinkedList;

public class XIStmProduce extends XIStatement implements IStmWithParams {
    private String type;
    private String domain;
    
    private LinkedList<XIParameter> parameters = new LinkedList<XIParameter>();
    
    public XIStmProduce(XIObject owner, String name, String type, String domain) {
        super(owner, name);
        this.type = type;
        this.domain = domain;
    }
    
    public void add(XIParameter parameter) {
        parameters.add(parameter);
    }
    
    @Override
    public String toString() {
        return "produce(@type = " + type + "; @domain = " + domain + ")";
    }
}

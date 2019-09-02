package dk.xml2domain.xi;

import java.util.LinkedList;


public class XIStmInvoke extends XIStatement implements IStmWithParams {
    private String obj;
    
    private LinkedList<XIParameter> parameters = new LinkedList<XIParameter>();

    public XIStmInvoke() {
    }

    public XIStmInvoke(XIObject owner, String name, String obj) {
        super(owner, name);
        this.obj = obj;
    }

    public void add(XIParameter parameter) {
        parameters.add(parameter);
    }
    
    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "invoke(@name = " + getName() + "; @obj = " + obj + ")";
    }
}

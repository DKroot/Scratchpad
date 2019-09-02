package dk.xml2domain.xi;

import java.util.LinkedList;


public class XIStmStart extends XIStatement implements IStmWithParams {
    private LinkedList<XIParameter> parameters = new LinkedList<XIParameter>();

    public XIStmStart(XIObject owner, String name) {
        super(owner, name);
    }

    public void add(XIParameter parameter) {
        parameters.add(parameter);
    }
}

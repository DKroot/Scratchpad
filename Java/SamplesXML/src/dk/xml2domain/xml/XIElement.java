package dk.xml2domain.xml;

//XI version 1.015 
public enum XIElement {
    //uses underscores to allow for Java keywords (i.e. switch)
    UNKNOWN,
    _XI, 
    _domain, 
    _header, _artifacts, _processes,
    _alias,  _event, _document, _variant, _role, _process,
    _attribute, _field, _function, _member, _task,
    _script, 
    _set, _switch, _branch, _invoke, _failure, _return, _produce, _allocate, _wait, _onevent, _exit, _many, _start,
    _parameters,
    _param;
    
    public static final String XI_NS_URI = "http://functionpro.com/schema/xi";
    
    private Object xiObject;

    public Object getXiObject() {
        return xiObject;
    }

    public XIElement setXiObject(Object xiObject) {
        this.xiObject = xiObject;
        return this;
    }
}

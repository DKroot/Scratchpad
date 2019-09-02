/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.9.1</a>, using an XML
 * Schema.
 * $Id$
 */

package dk.xml2domain.castor.xi.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ExitTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class ExitTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The scope type
     */
    public static final int SCOPE_TYPE = 0;

    /**
     * The instance of the scope type
     */
    public static final ExitTypeType SCOPE = new ExitTypeType(SCOPE_TYPE, "scope");

    /**
     * The method type
     */
    public static final int METHOD_TYPE = 1;

    /**
     * The instance of the method type
     */
    public static final ExitTypeType METHOD = new ExitTypeType(METHOD_TYPE, "method");

    /**
     * The process type
     */
    public static final int PROCESS_TYPE = 2;

    /**
     * The instance of the process type
     */
    public static final ExitTypeType PROCESS = new ExitTypeType(PROCESS_TYPE, "process");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private ExitTypeType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- dk.xml2domain.castor.xi.types.ExitTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * ExitTypeType
     * 
     * @return Enumeration
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getType
     * 
     * Returns the type of this ExitTypeType
     * 
     * @return int
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     * 
     * 
     * 
     * @return Hashtable
     */
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("scope", SCOPE);
        members.put("method", METHOD);
        members.put("process", PROCESS);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method readResolve
     * 
     *  will be called during deserialization to replace the
     * deserialized object with the correct constant instance.
     * <br/>
     * 
     * @return Object
     */
    private java.lang.Object readResolve()
    {
        return valueOf(this.stringValue);
    } //-- java.lang.Object readResolve() 

    /**
     * Method toString
     * 
     * Returns the String representation of this ExitTypeType
     * 
     * @return String
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOf
     * 
     * Returns a new ExitTypeType based on the given String value.
     * 
     * @param string
     * @return ExitTypeType
     */
    public static dk.xml2domain.castor.xi.types.ExitTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ExitTypeType";
            throw new IllegalArgumentException(err);
        }
        return (ExitTypeType) obj;
    } //-- dk.xml2domain.castor.xi.types.ExitTypeType valueOf(java.lang.String) 

}

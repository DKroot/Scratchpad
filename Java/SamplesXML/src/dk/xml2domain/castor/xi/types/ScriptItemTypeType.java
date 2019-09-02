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
 * Class ScriptItemTypeType.
 * 
 * @version $Revision$ $Date$
 */
public class ScriptItemTypeType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The private type
     */
    public static final int PRIVATE_TYPE = 0;

    /**
     * The instance of the private type
     */
    public static final ScriptItemTypeType PRIVATE = new ScriptItemTypeType(PRIVATE_TYPE, "private");

    /**
     * The public type
     */
    public static final int PUBLIC_TYPE = 1;

    /**
     * The instance of the public type
     */
    public static final ScriptItemTypeType PUBLIC = new ScriptItemTypeType(PUBLIC_TYPE, "public");

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

    private ScriptItemTypeType(int type, java.lang.String value) 
     {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- dk.xml2domain.castor.xi.types.ScriptItemTypeType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerate
     * 
     * Returns an enumeration of all possible instances of
     * ScriptItemTypeType
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
     * Returns the type of this ScriptItemTypeType
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
        members.put("private", PRIVATE);
        members.put("public", PUBLIC);
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
     * Returns the String representation of this ScriptItemTypeType
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
     * Returns a new ScriptItemTypeType based on the given String
     * value.
     * 
     * @param string
     * @return ScriptItemTypeType
     */
    public static dk.xml2domain.castor.xi.types.ScriptItemTypeType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ScriptItemTypeType";
            throw new IllegalArgumentException(err);
        }
        return (ScriptItemTypeType) obj;
    } //-- dk.xml2domain.castor.xi.types.ScriptItemTypeType valueOf(java.lang.String) 

}

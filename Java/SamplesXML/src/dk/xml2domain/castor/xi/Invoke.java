/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.9.1</a>, using an XML
 * Schema.
 * $Id$
 */

package dk.xml2domain.castor.xi;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Invoke.
 * 
 * @version $Revision$ $Date$
 */
public class Invoke implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _obj
     */
    private java.lang.String _obj;

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _parameters
     */
    private dk.xml2domain.castor.xi.Parameters _parameters;


      //----------------/
     //- Constructors -/
    //----------------/

    public Invoke() 
     {
        super();
    } //-- dk.xml2domain.castor.xi.Invoke()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'name'.
     * 
     * @return String
     * @return the value of field 'name'.
     */
    public java.lang.String getName()
    {
        return this._name;
    } //-- java.lang.String getName() 

    /**
     * Returns the value of field 'obj'.
     * 
     * @return String
     * @return the value of field 'obj'.
     */
    public java.lang.String getObj()
    {
        return this._obj;
    } //-- java.lang.String getObj() 

    /**
     * Returns the value of field 'parameters'.
     * 
     * @return Parameters
     * @return the value of field 'parameters'.
     */
    public dk.xml2domain.castor.xi.Parameters getParameters()
    {
        return this._parameters;
    } //-- dk.xml2domain.castor.xi.Parameters getParameters() 

    /**
     * Method isValid
     * 
     * 
     * 
     * @return boolean
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * 
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'name'.
     * 
     * @param name the value of field 'name'.
     */
    public void setName(java.lang.String name)
    {
        this._name = name;
    } //-- void setName(java.lang.String) 

    /**
     * Sets the value of field 'obj'.
     * 
     * @param obj the value of field 'obj'.
     */
    public void setObj(java.lang.String obj)
    {
        this._obj = obj;
    } //-- void setObj(java.lang.String) 

    /**
     * Sets the value of field 'parameters'.
     * 
     * @param parameters the value of field 'parameters'.
     */
    public void setParameters(dk.xml2domain.castor.xi.Parameters parameters)
    {
        this._parameters = parameters;
    } //-- void setParameters(dk.xml2domain.castor.xi.Parameters) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Invoke
     */
    public static dk.xml2domain.castor.xi.Invoke unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Invoke) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Invoke.class, reader);
    } //-- dk.xml2domain.castor.xi.Invoke unmarshal(java.io.Reader) 

    /**
     * Method validate
     * 
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}

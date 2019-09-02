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
 * Class Many.
 * 
 * @version $Revision$ $Date$
 */
public class Many implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * This is a placeholder for the process script elements
     */
    private dk.xml2domain.castor.xi.Script _script;


      //----------------/
     //- Constructors -/
    //----------------/

    public Many() 
     {
        super();
    } //-- dk.xml2domain.castor.xi.Many()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'script'. The field 'script' has
     * the following description: This is a placeholder for the
     * process script elements
     * 
     * @return Script
     * @return the value of field 'script'.
     */
    public dk.xml2domain.castor.xi.Script getScript()
    {
        return this._script;
    } //-- dk.xml2domain.castor.xi.Script getScript() 

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
     * Sets the value of field 'script'. The field 'script' has the
     * following description: This is a placeholder for the process
     * script elements
     * 
     * @param script the value of field 'script'.
     */
    public void setScript(dk.xml2domain.castor.xi.Script script)
    {
        this._script = script;
    } //-- void setScript(dk.xml2domain.castor.xi.Script) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Many
     */
    public static dk.xml2domain.castor.xi.Many unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Many) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Many.class, reader);
    } //-- dk.xml2domain.castor.xi.Many unmarshal(java.io.Reader) 

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

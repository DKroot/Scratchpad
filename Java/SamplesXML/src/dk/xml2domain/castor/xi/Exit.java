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

import dk.xml2domain.castor.xi.types.ExitTypeType;

/**
 * Class Exit.
 * 
 * @version $Revision$ $Date$
 */
public class Exit implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _type
     */
    private dk.xml2domain.castor.xi.types.ExitTypeType _type;


      //----------------/
     //- Constructors -/
    //----------------/

    public Exit() 
     {
        super();
    } //-- dk.xml2domain.castor.xi.Exit()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'type'.
     * 
     * @return ExitTypeType
     * @return the value of field 'type'.
     */
    public dk.xml2domain.castor.xi.types.ExitTypeType getType()
    {
        return this._type;
    } //-- dk.xml2domain.castor.xi.types.ExitTypeType getType() 

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
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(dk.xml2domain.castor.xi.types.ExitTypeType type)
    {
        this._type = type;
    } //-- void setType(dk.xml2domain.castor.xi.types.ExitTypeType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Exit
     */
    public static dk.xml2domain.castor.xi.Exit unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Exit) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Exit.class, reader);
    } //-- dk.xml2domain.castor.xi.Exit unmarshal(java.io.Reader) 

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

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
 * Class Domain.
 * 
 * @version $Revision$ $Date$
 */
public class Domain implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _version
     */
    private float _version;

    /**
     * keeps track of state for field: _version
     */
    private boolean _has_version;

    /**
     * Header of domain - 1st element
     */
    private dk.xml2domain.castor.xi.Header _header;

    /**
     * Artifacts of domain
     */
    private dk.xml2domain.castor.xi.Artifacts _artifacts;

    /**
     * Field _processes
     */
    private dk.xml2domain.castor.xi.Processes _processes;


      //----------------/
     //- Constructors -/
    //----------------/

    public Domain() 
     {
        super();
    } //-- dk.xml2domain.castor.xi.Domain()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteVersion
     * 
     */
    public void deleteVersion()
    {
        this._has_version= false;
    } //-- void deleteVersion() 

    /**
     * Returns the value of field 'artifacts'. The field
     * 'artifacts' has the following description: Artifacts of
     * domain
     * 
     * @return Artifacts
     * @return the value of field 'artifacts'.
     */
    public dk.xml2domain.castor.xi.Artifacts getArtifacts()
    {
        return this._artifacts;
    } //-- dk.xml2domain.castor.xi.Artifacts getArtifacts() 

    /**
     * Returns the value of field 'header'. The field 'header' has
     * the following description: Header of domain - 1st element
     * 
     * @return Header
     * @return the value of field 'header'.
     */
    public dk.xml2domain.castor.xi.Header getHeader()
    {
        return this._header;
    } //-- dk.xml2domain.castor.xi.Header getHeader() 

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
     * Returns the value of field 'processes'.
     * 
     * @return Processes
     * @return the value of field 'processes'.
     */
    public dk.xml2domain.castor.xi.Processes getProcesses()
    {
        return this._processes;
    } //-- dk.xml2domain.castor.xi.Processes getProcesses() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return float
     * @return the value of field 'version'.
     */
    public float getVersion()
    {
        return this._version;
    } //-- float getVersion() 

    /**
     * Method hasVersion
     * 
     * 
     * 
     * @return boolean
     */
    public boolean hasVersion()
    {
        return this._has_version;
    } //-- boolean hasVersion() 

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
     * Sets the value of field 'artifacts'. The field 'artifacts'
     * has the following description: Artifacts of domain
     * 
     * @param artifacts the value of field 'artifacts'.
     */
    public void setArtifacts(dk.xml2domain.castor.xi.Artifacts artifacts)
    {
        this._artifacts = artifacts;
    } //-- void setArtifacts(dk.xml2domain.castor.xi.Artifacts) 

    /**
     * Sets the value of field 'header'. The field 'header' has the
     * following description: Header of domain - 1st element
     * 
     * @param header the value of field 'header'.
     */
    public void setHeader(dk.xml2domain.castor.xi.Header header)
    {
        this._header = header;
    } //-- void setHeader(dk.xml2domain.castor.xi.Header) 

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
     * Sets the value of field 'processes'.
     * 
     * @param processes the value of field 'processes'.
     */
    public void setProcesses(dk.xml2domain.castor.xi.Processes processes)
    {
        this._processes = processes;
    } //-- void setProcesses(dk.xml2domain.castor.xi.Processes) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(float version)
    {
        this._version = version;
        this._has_version = true;
    } //-- void setVersion(float) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Domain
     */
    public static dk.xml2domain.castor.xi.Domain unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Domain) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Domain.class, reader);
    } //-- dk.xml2domain.castor.xi.Domain unmarshal(java.io.Reader) 

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

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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Branch.
 * 
 * @version $Revision$ $Date$
 */
public class Branch implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _switchList
     */
    private java.util.Vector _switchList;

    /**
     * This is a placeholder for the process script elements
     */
    private dk.xml2domain.castor.xi.Script _script;


      //----------------/
     //- Constructors -/
    //----------------/

    public Branch() 
     {
        super();
        _switchList = new Vector();
    } //-- dk.xml2domain.castor.xi.Branch()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSwitch
     * 
     * 
     * 
     * @param vSwitch
     */
    public void addSwitch(dk.xml2domain.castor.xi.Switch vSwitch)
        throws java.lang.IndexOutOfBoundsException
    {
        _switchList.addElement(vSwitch);
    } //-- void addSwitch(dk.xml2domain.castor.xi.Switch) 

    /**
     * Method addSwitch
     * 
     * 
     * 
     * @param index
     * @param vSwitch
     */
    public void addSwitch(int index, dk.xml2domain.castor.xi.Switch vSwitch)
        throws java.lang.IndexOutOfBoundsException
    {
        _switchList.insertElementAt(vSwitch, index);
    } //-- void addSwitch(int, dk.xml2domain.castor.xi.Switch) 

    /**
     * Method enumerateSwitch
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateSwitch()
    {
        return _switchList.elements();
    } //-- java.util.Enumeration enumerateSwitch() 

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
     * Method getSwitch
     * 
     * 
     * 
     * @param index
     * @return Switch
     */
    public dk.xml2domain.castor.xi.Switch getSwitch(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _switchList.size())) {
            throw new IndexOutOfBoundsException("getSwitch: Index value '"+index+"' not in range [0.."+_switchList.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.Switch) _switchList.elementAt(index);
    } //-- dk.xml2domain.castor.xi.Switch getSwitch(int) 

    /**
     * Method getSwitch
     * 
     * 
     * 
     * @return Switch
     */
    public dk.xml2domain.castor.xi.Switch[] getSwitch()
    {
        int size = _switchList.size();
        dk.xml2domain.castor.xi.Switch[] mArray = new dk.xml2domain.castor.xi.Switch[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.Switch) _switchList.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.Switch[] getSwitch() 

    /**
     * Method getSwitchCount
     * 
     * 
     * 
     * @return int
     */
    public int getSwitchCount()
    {
        return _switchList.size();
    } //-- int getSwitchCount() 

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
     * Method removeAllSwitch
     * 
     */
    public void removeAllSwitch()
    {
        _switchList.removeAllElements();
    } //-- void removeAllSwitch() 

    /**
     * Method removeSwitch
     * 
     * 
     * 
     * @param index
     * @return Switch
     */
    public dk.xml2domain.castor.xi.Switch removeSwitch(int index)
    {
        java.lang.Object obj = _switchList.elementAt(index);
        _switchList.removeElementAt(index);
        return (dk.xml2domain.castor.xi.Switch) obj;
    } //-- dk.xml2domain.castor.xi.Switch removeSwitch(int) 

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
     * Method setSwitch
     * 
     * 
     * 
     * @param index
     * @param vSwitch
     */
    public void setSwitch(int index, dk.xml2domain.castor.xi.Switch vSwitch)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _switchList.size())) {
            throw new IndexOutOfBoundsException("setSwitch: Index value '"+index+"' not in range [0.."+_switchList.size()+ "]");
        }
        _switchList.setElementAt(vSwitch, index);
    } //-- void setSwitch(int, dk.xml2domain.castor.xi.Switch) 

    /**
     * Method setSwitch
     * 
     * 
     * 
     * @param _switchArray
     */
    public void setSwitch(dk.xml2domain.castor.xi.Switch[] _switchArray)
    {
        //-- copy array
        _switchList.removeAllElements();
        for (int i = 0; i < _switchArray.length; i++) {
            _switchList.addElement(_switchArray[i]);
        }
    } //-- void setSwitch(dk.xml2domain.castor.xi.Switch) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Branch
     */
    public static dk.xml2domain.castor.xi.Branch unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Branch) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Branch.class, reader);
    } //-- dk.xml2domain.castor.xi.Branch unmarshal(java.io.Reader) 

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

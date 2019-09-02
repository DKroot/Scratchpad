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

import dk.xml2domain.castor.xi.types.ScriptItemTypeType;

/**
 * This is a placeholder for the process script elements
 * 
 * @version $Revision$ $Date$
 */
public class Script implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _type
     */
    private dk.xml2domain.castor.xi.types.ScriptItemTypeType _type;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Script() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Script()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addScriptItem
     * 
     * 
     * 
     * @param vScriptItem
     */
    public void addScriptItem(dk.xml2domain.castor.xi.ScriptItem vScriptItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vScriptItem);
    } //-- void addScriptItem(dk.xml2domain.castor.xi.ScriptItem) 

    /**
     * Method addScriptItem
     * 
     * 
     * 
     * @param index
     * @param vScriptItem
     */
    public void addScriptItem(int index, dk.xml2domain.castor.xi.ScriptItem vScriptItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vScriptItem, index);
    } //-- void addScriptItem(int, dk.xml2domain.castor.xi.ScriptItem) 

    /**
     * Method enumerateScriptItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateScriptItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateScriptItem() 

    /**
     * Method getScriptItem
     * 
     * 
     * 
     * @param index
     * @return ScriptItem
     */
    public dk.xml2domain.castor.xi.ScriptItem getScriptItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getScriptItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.ScriptItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.ScriptItem getScriptItem(int) 

    /**
     * Method getScriptItem
     * 
     * 
     * 
     * @return ScriptItem
     */
    public dk.xml2domain.castor.xi.ScriptItem[] getScriptItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.ScriptItem[] mArray = new dk.xml2domain.castor.xi.ScriptItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.ScriptItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.ScriptItem[] getScriptItem() 

    /**
     * Method getScriptItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getScriptItemCount()
    {
        return _items.size();
    } //-- int getScriptItemCount() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return ScriptItemTypeType
     * @return the value of field 'type'.
     */
    public dk.xml2domain.castor.xi.types.ScriptItemTypeType getType()
    {
        return this._type;
    } //-- dk.xml2domain.castor.xi.types.ScriptItemTypeType getType() 

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
     * Method removeAllScriptItem
     * 
     */
    public void removeAllScriptItem()
    {
        _items.removeAllElements();
    } //-- void removeAllScriptItem() 

    /**
     * Method removeScriptItem
     * 
     * 
     * 
     * @param index
     * @return ScriptItem
     */
    public dk.xml2domain.castor.xi.ScriptItem removeScriptItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.ScriptItem) obj;
    } //-- dk.xml2domain.castor.xi.ScriptItem removeScriptItem(int) 

    /**
     * Method setScriptItem
     * 
     * 
     * 
     * @param index
     * @param vScriptItem
     */
    public void setScriptItem(int index, dk.xml2domain.castor.xi.ScriptItem vScriptItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setScriptItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vScriptItem, index);
    } //-- void setScriptItem(int, dk.xml2domain.castor.xi.ScriptItem) 

    /**
     * Method setScriptItem
     * 
     * 
     * 
     * @param scriptItemArray
     */
    public void setScriptItem(dk.xml2domain.castor.xi.ScriptItem[] scriptItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < scriptItemArray.length; i++) {
            _items.addElement(scriptItemArray[i]);
        }
    } //-- void setScriptItem(dk.xml2domain.castor.xi.ScriptItem) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(dk.xml2domain.castor.xi.types.ScriptItemTypeType type)
    {
        this._type = type;
    } //-- void setType(dk.xml2domain.castor.xi.types.ScriptItemTypeType) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Script
     */
    public static dk.xml2domain.castor.xi.Script unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Script) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Script.class, reader);
    } //-- dk.xml2domain.castor.xi.Script unmarshal(java.io.Reader) 

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

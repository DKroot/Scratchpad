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
 * Class Field.
 * 
 * @version $Revision$ $Date$
 */
public class Field implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _domain
     */
    private java.lang.String _domain;

    /**
     * Field _type
     */
    private java.lang.String _type;

    /**
     * Field _scope
     */
    private java.lang.Object _scope;

    /**
     * Field _pm
     */
    private java.lang.Object _pm;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Field() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Field()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFieldItem
     * 
     * 
     * 
     * @param vFieldItem
     */
    public void addFieldItem(dk.xml2domain.castor.xi.FieldItem vFieldItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vFieldItem);
    } //-- void addFieldItem(dk.xml2domain.castor.xi.FieldItem) 

    /**
     * Method addFieldItem
     * 
     * 
     * 
     * @param index
     * @param vFieldItem
     */
    public void addFieldItem(int index, dk.xml2domain.castor.xi.FieldItem vFieldItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vFieldItem, index);
    } //-- void addFieldItem(int, dk.xml2domain.castor.xi.FieldItem) 

    /**
     * Method enumerateFieldItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateFieldItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateFieldItem() 

    /**
     * Returns the value of field 'domain'.
     * 
     * @return String
     * @return the value of field 'domain'.
     */
    public java.lang.String getDomain()
    {
        return this._domain;
    } //-- java.lang.String getDomain() 

    /**
     * Method getFieldItem
     * 
     * 
     * 
     * @param index
     * @return FieldItem
     */
    public dk.xml2domain.castor.xi.FieldItem getFieldItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getFieldItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.FieldItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.FieldItem getFieldItem(int) 

    /**
     * Method getFieldItem
     * 
     * 
     * 
     * @return FieldItem
     */
    public dk.xml2domain.castor.xi.FieldItem[] getFieldItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.FieldItem[] mArray = new dk.xml2domain.castor.xi.FieldItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.FieldItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.FieldItem[] getFieldItem() 

    /**
     * Method getFieldItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getFieldItemCount()
    {
        return _items.size();
    } //-- int getFieldItemCount() 

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
     * Returns the value of field 'pm'.
     * 
     * @return Object
     * @return the value of field 'pm'.
     */
    public java.lang.Object getPm()
    {
        return this._pm;
    } //-- java.lang.Object getPm() 

    /**
     * Returns the value of field 'scope'.
     * 
     * @return Object
     * @return the value of field 'scope'.
     */
    public java.lang.Object getScope()
    {
        return this._scope;
    } //-- java.lang.Object getScope() 

    /**
     * Returns the value of field 'type'.
     * 
     * @return String
     * @return the value of field 'type'.
     */
    public java.lang.String getType()
    {
        return this._type;
    } //-- java.lang.String getType() 

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
     * Method removeAllFieldItem
     * 
     */
    public void removeAllFieldItem()
    {
        _items.removeAllElements();
    } //-- void removeAllFieldItem() 

    /**
     * Method removeFieldItem
     * 
     * 
     * 
     * @param index
     * @return FieldItem
     */
    public dk.xml2domain.castor.xi.FieldItem removeFieldItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.FieldItem) obj;
    } //-- dk.xml2domain.castor.xi.FieldItem removeFieldItem(int) 

    /**
     * Sets the value of field 'domain'.
     * 
     * @param domain the value of field 'domain'.
     */
    public void setDomain(java.lang.String domain)
    {
        this._domain = domain;
    } //-- void setDomain(java.lang.String) 

    /**
     * Method setFieldItem
     * 
     * 
     * 
     * @param index
     * @param vFieldItem
     */
    public void setFieldItem(int index, dk.xml2domain.castor.xi.FieldItem vFieldItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setFieldItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vFieldItem, index);
    } //-- void setFieldItem(int, dk.xml2domain.castor.xi.FieldItem) 

    /**
     * Method setFieldItem
     * 
     * 
     * 
     * @param fieldItemArray
     */
    public void setFieldItem(dk.xml2domain.castor.xi.FieldItem[] fieldItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < fieldItemArray.length; i++) {
            _items.addElement(fieldItemArray[i]);
        }
    } //-- void setFieldItem(dk.xml2domain.castor.xi.FieldItem) 

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
     * Sets the value of field 'pm'.
     * 
     * @param pm the value of field 'pm'.
     */
    public void setPm(java.lang.Object pm)
    {
        this._pm = pm;
    } //-- void setPm(java.lang.Object) 

    /**
     * Sets the value of field 'scope'.
     * 
     * @param scope the value of field 'scope'.
     */
    public void setScope(java.lang.Object scope)
    {
        this._scope = scope;
    } //-- void setScope(java.lang.Object) 

    /**
     * Sets the value of field 'type'.
     * 
     * @param type the value of field 'type'.
     */
    public void setType(java.lang.String type)
    {
        this._type = type;
    } //-- void setType(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Field
     */
    public static dk.xml2domain.castor.xi.Field unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Field) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Field.class, reader);
    } //-- dk.xml2domain.castor.xi.Field unmarshal(java.io.Reader) 

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

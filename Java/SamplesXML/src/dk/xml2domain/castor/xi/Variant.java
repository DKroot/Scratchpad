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
 * Class Variant.
 * 
 * @version $Revision$ $Date$
 */
public class Variant implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Variant() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Variant()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addVariantItem
     * 
     * 
     * 
     * @param vVariantItem
     */
    public void addVariantItem(dk.xml2domain.castor.xi.VariantItem vVariantItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vVariantItem);
    } //-- void addVariantItem(dk.xml2domain.castor.xi.VariantItem) 

    /**
     * Method addVariantItem
     * 
     * 
     * 
     * @param index
     * @param vVariantItem
     */
    public void addVariantItem(int index, dk.xml2domain.castor.xi.VariantItem vVariantItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vVariantItem, index);
    } //-- void addVariantItem(int, dk.xml2domain.castor.xi.VariantItem) 

    /**
     * Method enumerateVariantItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateVariantItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateVariantItem() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return String
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

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
     * Method getVariantItem
     * 
     * 
     * 
     * @param index
     * @return VariantItem
     */
    public dk.xml2domain.castor.xi.VariantItem getVariantItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getVariantItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.VariantItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.VariantItem getVariantItem(int) 

    /**
     * Method getVariantItem
     * 
     * 
     * 
     * @return VariantItem
     */
    public dk.xml2domain.castor.xi.VariantItem[] getVariantItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.VariantItem[] mArray = new dk.xml2domain.castor.xi.VariantItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.VariantItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.VariantItem[] getVariantItem() 

    /**
     * Method getVariantItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getVariantItemCount()
    {
        return _items.size();
    } //-- int getVariantItemCount() 

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
     * Method removeAllVariantItem
     * 
     */
    public void removeAllVariantItem()
    {
        _items.removeAllElements();
    } //-- void removeAllVariantItem() 

    /**
     * Method removeVariantItem
     * 
     * 
     * 
     * @param index
     * @return VariantItem
     */
    public dk.xml2domain.castor.xi.VariantItem removeVariantItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.VariantItem) obj;
    } //-- dk.xml2domain.castor.xi.VariantItem removeVariantItem(int) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

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
     * Method setVariantItem
     * 
     * 
     * 
     * @param index
     * @param vVariantItem
     */
    public void setVariantItem(int index, dk.xml2domain.castor.xi.VariantItem vVariantItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setVariantItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vVariantItem, index);
    } //-- void setVariantItem(int, dk.xml2domain.castor.xi.VariantItem) 

    /**
     * Method setVariantItem
     * 
     * 
     * 
     * @param variantItemArray
     */
    public void setVariantItem(dk.xml2domain.castor.xi.VariantItem[] variantItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < variantItemArray.length; i++) {
            _items.addElement(variantItemArray[i]);
        }
    } //-- void setVariantItem(dk.xml2domain.castor.xi.VariantItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Variant
     */
    public static dk.xml2domain.castor.xi.Variant unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Variant) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Variant.class, reader);
    } //-- dk.xml2domain.castor.xi.Variant unmarshal(java.io.Reader) 

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

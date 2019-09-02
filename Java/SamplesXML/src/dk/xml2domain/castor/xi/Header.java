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
 * Header of domain - 1st element
 * 
 * @version $Revision$ $Date$
 */
public class Header implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Header() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Header()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addHeaderItem
     * 
     * 
     * 
     * @param vHeaderItem
     */
    public void addHeaderItem(dk.xml2domain.castor.xi.HeaderItem vHeaderItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vHeaderItem);
    } //-- void addHeaderItem(dk.xml2domain.castor.xi.HeaderItem) 

    /**
     * Method addHeaderItem
     * 
     * 
     * 
     * @param index
     * @param vHeaderItem
     */
    public void addHeaderItem(int index, dk.xml2domain.castor.xi.HeaderItem vHeaderItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vHeaderItem, index);
    } //-- void addHeaderItem(int, dk.xml2domain.castor.xi.HeaderItem) 

    /**
     * Method enumerateHeaderItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateHeaderItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateHeaderItem() 

    /**
     * Method getHeaderItem
     * 
     * 
     * 
     * @param index
     * @return HeaderItem
     */
    public dk.xml2domain.castor.xi.HeaderItem getHeaderItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getHeaderItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.HeaderItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.HeaderItem getHeaderItem(int) 

    /**
     * Method getHeaderItem
     * 
     * 
     * 
     * @return HeaderItem
     */
    public dk.xml2domain.castor.xi.HeaderItem[] getHeaderItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.HeaderItem[] mArray = new dk.xml2domain.castor.xi.HeaderItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.HeaderItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.HeaderItem[] getHeaderItem() 

    /**
     * Method getHeaderItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getHeaderItemCount()
    {
        return _items.size();
    } //-- int getHeaderItemCount() 

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
     * Method removeAllHeaderItem
     * 
     */
    public void removeAllHeaderItem()
    {
        _items.removeAllElements();
    } //-- void removeAllHeaderItem() 

    /**
     * Method removeHeaderItem
     * 
     * 
     * 
     * @param index
     * @return HeaderItem
     */
    public dk.xml2domain.castor.xi.HeaderItem removeHeaderItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.HeaderItem) obj;
    } //-- dk.xml2domain.castor.xi.HeaderItem removeHeaderItem(int) 

    /**
     * Method setHeaderItem
     * 
     * 
     * 
     * @param index
     * @param vHeaderItem
     */
    public void setHeaderItem(int index, dk.xml2domain.castor.xi.HeaderItem vHeaderItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setHeaderItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vHeaderItem, index);
    } //-- void setHeaderItem(int, dk.xml2domain.castor.xi.HeaderItem) 

    /**
     * Method setHeaderItem
     * 
     * 
     * 
     * @param headerItemArray
     */
    public void setHeaderItem(dk.xml2domain.castor.xi.HeaderItem[] headerItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < headerItemArray.length; i++) {
            _items.addElement(headerItemArray[i]);
        }
    } //-- void setHeaderItem(dk.xml2domain.castor.xi.HeaderItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Header
     */
    public static dk.xml2domain.castor.xi.Header unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Header) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Header.class, reader);
    } //-- dk.xml2domain.castor.xi.Header unmarshal(java.io.Reader) 

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

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
 * Class Parameters.
 * 
 * @version $Revision$ $Date$
 */
public class Parameters implements java.io.Serializable {


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

    public Parameters() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Parameters()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addParametersItem
     * 
     * 
     * 
     * @param vParametersItem
     */
    public void addParametersItem(dk.xml2domain.castor.xi.ParametersItem vParametersItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vParametersItem);
    } //-- void addParametersItem(dk.xml2domain.castor.xi.ParametersItem) 

    /**
     * Method addParametersItem
     * 
     * 
     * 
     * @param index
     * @param vParametersItem
     */
    public void addParametersItem(int index, dk.xml2domain.castor.xi.ParametersItem vParametersItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vParametersItem, index);
    } //-- void addParametersItem(int, dk.xml2domain.castor.xi.ParametersItem) 

    /**
     * Method enumerateParametersItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateParametersItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateParametersItem() 

    /**
     * Method getParametersItem
     * 
     * 
     * 
     * @param index
     * @return ParametersItem
     */
    public dk.xml2domain.castor.xi.ParametersItem getParametersItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getParametersItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.ParametersItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.ParametersItem getParametersItem(int) 

    /**
     * Method getParametersItem
     * 
     * 
     * 
     * @return ParametersItem
     */
    public dk.xml2domain.castor.xi.ParametersItem[] getParametersItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.ParametersItem[] mArray = new dk.xml2domain.castor.xi.ParametersItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.ParametersItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.ParametersItem[] getParametersItem() 

    /**
     * Method getParametersItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getParametersItemCount()
    {
        return _items.size();
    } //-- int getParametersItemCount() 

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
     * Method removeAllParametersItem
     * 
     */
    public void removeAllParametersItem()
    {
        _items.removeAllElements();
    } //-- void removeAllParametersItem() 

    /**
     * Method removeParametersItem
     * 
     * 
     * 
     * @param index
     * @return ParametersItem
     */
    public dk.xml2domain.castor.xi.ParametersItem removeParametersItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.ParametersItem) obj;
    } //-- dk.xml2domain.castor.xi.ParametersItem removeParametersItem(int) 

    /**
     * Method setParametersItem
     * 
     * 
     * 
     * @param index
     * @param vParametersItem
     */
    public void setParametersItem(int index, dk.xml2domain.castor.xi.ParametersItem vParametersItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setParametersItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vParametersItem, index);
    } //-- void setParametersItem(int, dk.xml2domain.castor.xi.ParametersItem) 

    /**
     * Method setParametersItem
     * 
     * 
     * 
     * @param parametersItemArray
     */
    public void setParametersItem(dk.xml2domain.castor.xi.ParametersItem[] parametersItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < parametersItemArray.length; i++) {
            _items.addElement(parametersItemArray[i]);
        }
    } //-- void setParametersItem(dk.xml2domain.castor.xi.ParametersItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Parameters
     */
    public static dk.xml2domain.castor.xi.Parameters unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Parameters) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Parameters.class, reader);
    } //-- dk.xml2domain.castor.xi.Parameters unmarshal(java.io.Reader) 

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

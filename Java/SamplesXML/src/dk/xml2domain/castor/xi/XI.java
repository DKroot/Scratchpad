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
import java.io.PrintStream;
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

import dk.xml2domain.xi.XIDomain;


/**
 * Class XI.
 * 
 * @version $Revision$ $Date$
 */
public class XI implements java.io.Serializable {
    public void print(PrintStream out, int indent) {
        out.println(toString());
    }

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _version
     */
    private float _version;

    /**
     * keeps track of state for field: _version
     */
    private boolean _has_version;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public XI() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.XI()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addXIItem
     * 
     * 
     * 
     * @param vXIItem
     */
    public void addXIItem(dk.xml2domain.castor.xi.XIItem vXIItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vXIItem);
    } //-- void addXIItem(dk.xml2domain.castor.xi.XIItem) 

    /**
     * Method addXIItem
     * 
     * 
     * 
     * @param index
     * @param vXIItem
     */
    public void addXIItem(int index, dk.xml2domain.castor.xi.XIItem vXIItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vXIItem, index);
    } //-- void addXIItem(int, dk.xml2domain.castor.xi.XIItem) 

    /**
     * Method deleteVersion
     * 
     */
    public void deleteVersion()
    {
        this._has_version= false;
    } //-- void deleteVersion() 

    /**
     * Method enumerateXIItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateXIItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateXIItem() 

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
     * Method getXIItem
     * 
     * 
     * 
     * @param index
     * @return XIItem
     */
    public dk.xml2domain.castor.xi.XIItem getXIItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getXIItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.XIItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.XIItem getXIItem(int) 

    /**
     * Method getXIItem
     * 
     * 
     * 
     * @return XIItem
     */
    public dk.xml2domain.castor.xi.XIItem[] getXIItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.XIItem[] mArray = new dk.xml2domain.castor.xi.XIItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.XIItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.XIItem[] getXIItem() 

    /**
     * Method getXIItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getXIItemCount()
    {
        return _items.size();
    } //-- int getXIItemCount() 

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
     * Method removeAllXIItem
     * 
     */
    public void removeAllXIItem()
    {
        _items.removeAllElements();
    } //-- void removeAllXIItem() 

    /**
     * Method removeXIItem
     * 
     * 
     * 
     * @param index
     * @return XIItem
     */
    public dk.xml2domain.castor.xi.XIItem removeXIItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.XIItem) obj;
    } //-- dk.xml2domain.castor.xi.XIItem removeXIItem(int) 

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
     * Method setXIItem
     * 
     * 
     * 
     * @param index
     * @param vXIItem
     */
    public void setXIItem(int index, dk.xml2domain.castor.xi.XIItem vXIItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setXIItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vXIItem, index);
    } //-- void setXIItem(int, dk.xml2domain.castor.xi.XIItem) 

    /**
     * Method setXIItem
     * 
     * 
     * 
     * @param XIItemArray
     */
    public void setXIItem(dk.xml2domain.castor.xi.XIItem[] XIItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < XIItemArray.length; i++) {
            _items.addElement(XIItemArray[i]);
        }
    } //-- void setXIItem(dk.xml2domain.castor.xi.XIItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return XI
     */
    public static dk.xml2domain.castor.xi.XI unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.XI) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.XI.class, reader);
    } //-- dk.xml2domain.castor.xi.XI unmarshal(java.io.Reader) 

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

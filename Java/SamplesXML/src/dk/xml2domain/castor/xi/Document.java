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
 * Class Document.
 * 
 * @version $Revision$ $Date$
 */
public class Document implements java.io.Serializable {


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
     * Field _parent
     */
    private java.lang.String _parent;

    /**
     * Field _scope
     */
    private java.lang.Object _scope;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Document() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Document()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDocumentItem
     * 
     * 
     * 
     * @param vDocumentItem
     */
    public void addDocumentItem(dk.xml2domain.castor.xi.DocumentItem vDocumentItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vDocumentItem);
    } //-- void addDocumentItem(dk.xml2domain.castor.xi.DocumentItem) 

    /**
     * Method addDocumentItem
     * 
     * 
     * 
     * @param index
     * @param vDocumentItem
     */
    public void addDocumentItem(int index, dk.xml2domain.castor.xi.DocumentItem vDocumentItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vDocumentItem, index);
    } //-- void addDocumentItem(int, dk.xml2domain.castor.xi.DocumentItem) 

    /**
     * Method enumerateDocumentItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateDocumentItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateDocumentItem() 

    /**
     * Method getDocumentItem
     * 
     * 
     * 
     * @param index
     * @return DocumentItem
     */
    public dk.xml2domain.castor.xi.DocumentItem getDocumentItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getDocumentItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.DocumentItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.DocumentItem getDocumentItem(int) 

    /**
     * Method getDocumentItem
     * 
     * 
     * 
     * @return DocumentItem
     */
    public dk.xml2domain.castor.xi.DocumentItem[] getDocumentItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.DocumentItem[] mArray = new dk.xml2domain.castor.xi.DocumentItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.DocumentItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.DocumentItem[] getDocumentItem() 

    /**
     * Method getDocumentItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getDocumentItemCount()
    {
        return _items.size();
    } //-- int getDocumentItemCount() 

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
     * Returns the value of field 'parent'.
     * 
     * @return String
     * @return the value of field 'parent'.
     */
    public java.lang.String getParent()
    {
        return this._parent;
    } //-- java.lang.String getParent() 

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
     * Method removeAllDocumentItem
     * 
     */
    public void removeAllDocumentItem()
    {
        _items.removeAllElements();
    } //-- void removeAllDocumentItem() 

    /**
     * Method removeDocumentItem
     * 
     * 
     * 
     * @param index
     * @return DocumentItem
     */
    public dk.xml2domain.castor.xi.DocumentItem removeDocumentItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.DocumentItem) obj;
    } //-- dk.xml2domain.castor.xi.DocumentItem removeDocumentItem(int) 

    /**
     * Method setDocumentItem
     * 
     * 
     * 
     * @param index
     * @param vDocumentItem
     */
    public void setDocumentItem(int index, dk.xml2domain.castor.xi.DocumentItem vDocumentItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setDocumentItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vDocumentItem, index);
    } //-- void setDocumentItem(int, dk.xml2domain.castor.xi.DocumentItem) 

    /**
     * Method setDocumentItem
     * 
     * 
     * 
     * @param documentItemArray
     */
    public void setDocumentItem(dk.xml2domain.castor.xi.DocumentItem[] documentItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < documentItemArray.length; i++) {
            _items.addElement(documentItemArray[i]);
        }
    } //-- void setDocumentItem(dk.xml2domain.castor.xi.DocumentItem) 

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
     * Sets the value of field 'parent'.
     * 
     * @param parent the value of field 'parent'.
     */
    public void setParent(java.lang.String parent)
    {
        this._parent = parent;
    } //-- void setParent(java.lang.String) 

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
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Document
     */
    public static dk.xml2domain.castor.xi.Document unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Document) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Document.class, reader);
    } //-- dk.xml2domain.castor.xi.Document unmarshal(java.io.Reader) 

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

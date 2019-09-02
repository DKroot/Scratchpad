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
 * Class Process.
 * 
 * @version $Revision$ $Date$
 */
public class Process implements java.io.Serializable {


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

    public Process() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Process()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProcessItem
     * 
     * 
     * 
     * @param vProcessItem
     */
    public void addProcessItem(dk.xml2domain.castor.xi.ProcessItem vProcessItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vProcessItem);
    } //-- void addProcessItem(dk.xml2domain.castor.xi.ProcessItem) 

    /**
     * Method addProcessItem
     * 
     * 
     * 
     * @param index
     * @param vProcessItem
     */
    public void addProcessItem(int index, dk.xml2domain.castor.xi.ProcessItem vProcessItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vProcessItem, index);
    } //-- void addProcessItem(int, dk.xml2domain.castor.xi.ProcessItem) 

    /**
     * Method enumerateProcessItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProcessItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateProcessItem() 

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
     * Method getProcessItem
     * 
     * 
     * 
     * @param index
     * @return ProcessItem
     */
    public dk.xml2domain.castor.xi.ProcessItem getProcessItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getProcessItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.ProcessItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.ProcessItem getProcessItem(int) 

    /**
     * Method getProcessItem
     * 
     * 
     * 
     * @return ProcessItem
     */
    public dk.xml2domain.castor.xi.ProcessItem[] getProcessItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.ProcessItem[] mArray = new dk.xml2domain.castor.xi.ProcessItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.ProcessItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.ProcessItem[] getProcessItem() 

    /**
     * Method getProcessItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getProcessItemCount()
    {
        return _items.size();
    } //-- int getProcessItemCount() 

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
     * Method removeAllProcessItem
     * 
     */
    public void removeAllProcessItem()
    {
        _items.removeAllElements();
    } //-- void removeAllProcessItem() 

    /**
     * Method removeProcessItem
     * 
     * 
     * 
     * @param index
     * @return ProcessItem
     */
    public dk.xml2domain.castor.xi.ProcessItem removeProcessItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.ProcessItem) obj;
    } //-- dk.xml2domain.castor.xi.ProcessItem removeProcessItem(int) 

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
     * Method setProcessItem
     * 
     * 
     * 
     * @param index
     * @param vProcessItem
     */
    public void setProcessItem(int index, dk.xml2domain.castor.xi.ProcessItem vProcessItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setProcessItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vProcessItem, index);
    } //-- void setProcessItem(int, dk.xml2domain.castor.xi.ProcessItem) 

    /**
     * Method setProcessItem
     * 
     * 
     * 
     * @param processItemArray
     */
    public void setProcessItem(dk.xml2domain.castor.xi.ProcessItem[] processItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < processItemArray.length; i++) {
            _items.addElement(processItemArray[i]);
        }
    } //-- void setProcessItem(dk.xml2domain.castor.xi.ProcessItem) 

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
     * @return Process
     */
    public static dk.xml2domain.castor.xi.Process unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Process) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Process.class, reader);
    } //-- dk.xml2domain.castor.xi.Process unmarshal(java.io.Reader) 

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

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
 * Class Processes.
 * 
 * @version $Revision$ $Date$
 */
public class Processes implements java.io.Serializable {


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

    public Processes() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Processes()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProcessesItem
     * 
     * 
     * 
     * @param vProcessesItem
     */
    public void addProcessesItem(dk.xml2domain.castor.xi.ProcessesItem vProcessesItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vProcessesItem);
    } //-- void addProcessesItem(dk.xml2domain.castor.xi.ProcessesItem) 

    /**
     * Method addProcessesItem
     * 
     * 
     * 
     * @param index
     * @param vProcessesItem
     */
    public void addProcessesItem(int index, dk.xml2domain.castor.xi.ProcessesItem vProcessesItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vProcessesItem, index);
    } //-- void addProcessesItem(int, dk.xml2domain.castor.xi.ProcessesItem) 

    /**
     * Method enumerateProcessesItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateProcessesItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateProcessesItem() 

    /**
     * Method getProcessesItem
     * 
     * 
     * 
     * @param index
     * @return ProcessesItem
     */
    public dk.xml2domain.castor.xi.ProcessesItem getProcessesItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getProcessesItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.ProcessesItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.ProcessesItem getProcessesItem(int) 

    /**
     * Method getProcessesItem
     * 
     * 
     * 
     * @return ProcessesItem
     */
    public dk.xml2domain.castor.xi.ProcessesItem[] getProcessesItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.ProcessesItem[] mArray = new dk.xml2domain.castor.xi.ProcessesItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.ProcessesItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.ProcessesItem[] getProcessesItem() 

    /**
     * Method getProcessesItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getProcessesItemCount()
    {
        return _items.size();
    } //-- int getProcessesItemCount() 

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
     * Method removeAllProcessesItem
     * 
     */
    public void removeAllProcessesItem()
    {
        _items.removeAllElements();
    } //-- void removeAllProcessesItem() 

    /**
     * Method removeProcessesItem
     * 
     * 
     * 
     * @param index
     * @return ProcessesItem
     */
    public dk.xml2domain.castor.xi.ProcessesItem removeProcessesItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.ProcessesItem) obj;
    } //-- dk.xml2domain.castor.xi.ProcessesItem removeProcessesItem(int) 

    /**
     * Method setProcessesItem
     * 
     * 
     * 
     * @param index
     * @param vProcessesItem
     */
    public void setProcessesItem(int index, dk.xml2domain.castor.xi.ProcessesItem vProcessesItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setProcessesItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vProcessesItem, index);
    } //-- void setProcessesItem(int, dk.xml2domain.castor.xi.ProcessesItem) 

    /**
     * Method setProcessesItem
     * 
     * 
     * 
     * @param processesItemArray
     */
    public void setProcessesItem(dk.xml2domain.castor.xi.ProcessesItem[] processesItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < processesItemArray.length; i++) {
            _items.addElement(processesItemArray[i]);
        }
    } //-- void setProcessesItem(dk.xml2domain.castor.xi.ProcessesItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Processes
     */
    public static dk.xml2domain.castor.xi.Processes unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Processes) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Processes.class, reader);
    } //-- dk.xml2domain.castor.xi.Processes unmarshal(java.io.Reader) 

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

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
 * Class Task.
 * 
 * @version $Revision$ $Date$
 */
public class Task implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _scope
     */
    private java.lang.Object _scope;

    /**
     * Field _pm
     */
    private java.lang.Object _pm;

    /**
     * Field _name
     */
    private java.lang.String _name;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Task() 
     {
        super();
        _items = new Vector();
    } //-- dk.xml2domain.castor.xi.Task()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addTaskItem
     * 
     * 
     * 
     * @param vTaskItem
     */
    public void addTaskItem(dk.xml2domain.castor.xi.TaskItem vTaskItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vTaskItem);
    } //-- void addTaskItem(dk.xml2domain.castor.xi.TaskItem) 

    /**
     * Method addTaskItem
     * 
     * 
     * 
     * @param index
     * @param vTaskItem
     */
    public void addTaskItem(int index, dk.xml2domain.castor.xi.TaskItem vTaskItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vTaskItem, index);
    } //-- void addTaskItem(int, dk.xml2domain.castor.xi.TaskItem) 

    /**
     * Method enumerateTaskItem
     * 
     * 
     * 
     * @return Enumeration
     */
    public java.util.Enumeration enumerateTaskItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateTaskItem() 

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
     * Method getTaskItem
     * 
     * 
     * 
     * @param index
     * @return TaskItem
     */
    public dk.xml2domain.castor.xi.TaskItem getTaskItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("getTaskItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        
        return (dk.xml2domain.castor.xi.TaskItem) _items.elementAt(index);
    } //-- dk.xml2domain.castor.xi.TaskItem getTaskItem(int) 

    /**
     * Method getTaskItem
     * 
     * 
     * 
     * @return TaskItem
     */
    public dk.xml2domain.castor.xi.TaskItem[] getTaskItem()
    {
        int size = _items.size();
        dk.xml2domain.castor.xi.TaskItem[] mArray = new dk.xml2domain.castor.xi.TaskItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (dk.xml2domain.castor.xi.TaskItem) _items.elementAt(index);
        }
        return mArray;
    } //-- dk.xml2domain.castor.xi.TaskItem[] getTaskItem() 

    /**
     * Method getTaskItemCount
     * 
     * 
     * 
     * @return int
     */
    public int getTaskItemCount()
    {
        return _items.size();
    } //-- int getTaskItemCount() 

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
     * Method removeAllTaskItem
     * 
     */
    public void removeAllTaskItem()
    {
        _items.removeAllElements();
    } //-- void removeAllTaskItem() 

    /**
     * Method removeTaskItem
     * 
     * 
     * 
     * @param index
     * @return TaskItem
     */
    public dk.xml2domain.castor.xi.TaskItem removeTaskItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (dk.xml2domain.castor.xi.TaskItem) obj;
    } //-- dk.xml2domain.castor.xi.TaskItem removeTaskItem(int) 

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
     * Method setTaskItem
     * 
     * 
     * 
     * @param index
     * @param vTaskItem
     */
    public void setTaskItem(int index, dk.xml2domain.castor.xi.TaskItem vTaskItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException("setTaskItem: Index value '"+index+"' not in range [0.."+_items.size()+ "]");
        }
        _items.setElementAt(vTaskItem, index);
    } //-- void setTaskItem(int, dk.xml2domain.castor.xi.TaskItem) 

    /**
     * Method setTaskItem
     * 
     * 
     * 
     * @param taskItemArray
     */
    public void setTaskItem(dk.xml2domain.castor.xi.TaskItem[] taskItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < taskItemArray.length; i++) {
            _items.addElement(taskItemArray[i]);
        }
    } //-- void setTaskItem(dk.xml2domain.castor.xi.TaskItem) 

    /**
     * Method unmarshal
     * 
     * 
     * 
     * @param reader
     * @return Task
     */
    public static dk.xml2domain.castor.xi.Task unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (dk.xml2domain.castor.xi.Task) Unmarshaller.unmarshal(dk.xml2domain.castor.xi.Task.class, reader);
    } //-- dk.xml2domain.castor.xi.Task unmarshal(java.io.Reader) 

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
